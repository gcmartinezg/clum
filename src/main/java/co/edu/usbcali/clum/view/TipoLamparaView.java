package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoLamparaDTO;
import co.edu.usbcali.clum.exception.*;
import co.edu.usbcali.clum.utility.*;

import org.primefaces.component.calendar.*;
import org.primefaces.component.commandbutton.CommandButton;
import org.primefaces.component.inputtext.InputText;

import org.primefaces.event.RowEditEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

import java.sql.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


/**
 * @author Zathura Code Generator http://zathuracode.org/
 * www.zathuracode.org
 *
 */
@ManagedBean
@ViewScoped
public class TipoLamparaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoLamparaView.class);
    private InputText txtNombreTipoLampara;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoLamparaId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoLamparaDTO> data;
    private TipoLamparaDTO selectedTipoLampara;
    private TipoLampara entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoLamparaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoLampara = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoLampara = null;

        if (txtNombreTipoLampara != null) {
            txtNombreTipoLampara.setValue(null);
            txtNombreTipoLampara.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoLamparaId != null) {
            txtTipoLamparaId.setValue(null);
            txtTipoLamparaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtId() {
        try {
            Integer tipoLamparaId = FacesUtils.checkInteger(txtTipoLamparaId);
            entity = (tipoLamparaId != null)
                ? businessDelegatorView.getTipoLampara(tipoLamparaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoLampara.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoLamparaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoLampara.setValue(entity.getNombreTipoLampara());
            txtNombreTipoLampara.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoLamparaId.setValue(entity.getTipoLamparaId());
            txtTipoLamparaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoLampara = (TipoLamparaDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipoLampara"));
        txtNombreTipoLampara.setValue(selectedTipoLampara.getNombreTipoLampara());
        txtNombreTipoLampara.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoLampara.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoLamparaId.setValue(selectedTipoLampara.getTipoLamparaId());
        txtTipoLamparaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoLampara == null) && (entity == null)) {
                action_create();
            } else {
                action_modify();
            }

            data = null;
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_create() {
        try {
            entity = new TipoLampara();

            Integer tipoLamparaId = FacesUtils.checkInteger(txtTipoLamparaId);

            entity.setNombreTipoLampara(FacesUtils.checkString(
                    txtNombreTipoLampara));
            entity.setTipoLamparaId(tipoLamparaId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYSAVED);
            action_clear();
        } catch (Exception e) {
            entity = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_modify() {
        try {
            if (entity == null) {
                Integer tipoLamparaId = new Integer(selectedTipoLampara.getTipoLamparaId());
                entity = businessDelegatorView.getTipoLampara(tipoLamparaId);
            }

            entity.setNombreTipoLampara(FacesUtils.checkString(
                    txtNombreTipoLampara));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoLampara = (TipoLamparaDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoLampara"));

            Integer tipoLamparaId = new Integer(selectedTipoLampara.getTipoLamparaId());
            entity = businessDelegatorView.getTipoLampara(tipoLamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoLamparaId = FacesUtils.checkInteger(txtTipoLamparaId);
            entity = businessDelegatorView.getTipoLampara(tipoLamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYDELETED);
            action_clear();
            data = null;
        } catch (Exception e) {
            throw e;
        }
    }

    public String action_closeDialog() {
        setShowDialog(false);
        action_clear();

        return "";
    }

    public String action_modifyWitDTO(String nombreTipoLampara,
        Integer tipoLamparaId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoLampara(FacesUtils.checkString(
                    nombreTipoLampara));
            businessDelegatorView.updateTipoLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoLamparaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoLampara() {
        return txtNombreTipoLampara;
    }

    public void setTxtNombreTipoLampara(InputText txtNombreTipoLampara) {
        this.txtNombreTipoLampara = txtNombreTipoLampara;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoLamparaId() {
        return txtTipoLamparaId;
    }

    public void setTxtTipoLamparaId(InputText txtTipoLamparaId) {
        this.txtTipoLamparaId = txtTipoLamparaId;
    }

    public List<TipoLamparaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoLampara();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoLamparaDTO> tipoLamparaDTO) {
        this.data = tipoLamparaDTO;
    }

    public TipoLamparaDTO getSelectedTipoLampara() {
        return selectedTipoLampara;
    }

    public void setSelectedTipoLampara(TipoLamparaDTO tipoLampara) {
        this.selectedTipoLampara = tipoLampara;
    }

    public CommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(CommandButton btnSave) {
        this.btnSave = btnSave;
    }

    public CommandButton getBtnModify() {
        return btnModify;
    }

    public void setBtnModify(CommandButton btnModify) {
        this.btnModify = btnModify;
    }

    public CommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(CommandButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    public CommandButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(CommandButton btnClear) {
        this.btnClear = btnClear;
    }

    public TimeZone getTimeZone() {
        return java.util.TimeZone.getDefault();
    }

    public BusinessDelegator getBusinessDelegatorView() {
        return businessDelegatorView;
    }

    public void setBusinessDelegatorView(
        BusinessDelegator businessDelegatorView) {
        this.businessDelegatorView = businessDelegatorView;
    }

    public boolean isShowDialog() {
        return showDialog;
    }

    public void setShowDialog(boolean showDialog) {
        this.showDialog = showDialog;
    }
}
