package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoBalastoDTO;
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
public class TipoBalastoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoBalastoView.class);
    private InputText txtNombreTipoBalasto;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoBalastoId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoBalastoDTO> data;
    private TipoBalastoDTO selectedTipoBalasto;
    private TipoBalasto entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoBalastoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoBalasto = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoBalasto = null;

        if (txtNombreTipoBalasto != null) {
            txtNombreTipoBalasto.setValue(null);
            txtNombreTipoBalasto.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoBalastoId != null) {
            txtTipoBalastoId.setValue(null);
            txtTipoBalastoId.setDisabled(false);
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
            Integer tipoBalastoId = FacesUtils.checkInteger(txtTipoBalastoId);
            entity = (tipoBalastoId != null)
                ? businessDelegatorView.getTipoBalasto(tipoBalastoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoBalasto.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoBalastoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoBalasto.setValue(entity.getNombreTipoBalasto());
            txtNombreTipoBalasto.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoBalastoId.setValue(entity.getTipoBalastoId());
            txtTipoBalastoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoBalasto = (TipoBalastoDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipoBalasto"));
        txtNombreTipoBalasto.setValue(selectedTipoBalasto.getNombreTipoBalasto());
        txtNombreTipoBalasto.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoBalasto.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoBalastoId.setValue(selectedTipoBalasto.getTipoBalastoId());
        txtTipoBalastoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoBalasto == null) && (entity == null)) {
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
            entity = new TipoBalasto();

            Integer tipoBalastoId = FacesUtils.checkInteger(txtTipoBalastoId);

            entity.setNombreTipoBalasto(FacesUtils.checkString(
                    txtNombreTipoBalasto));
            entity.setTipoBalastoId(tipoBalastoId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoBalasto(entity);
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
                Integer tipoBalastoId = new Integer(selectedTipoBalasto.getTipoBalastoId());
                entity = businessDelegatorView.getTipoBalasto(tipoBalastoId);
            }

            entity.setNombreTipoBalasto(FacesUtils.checkString(
                    txtNombreTipoBalasto));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoBalasto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoBalasto = (TipoBalastoDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoBalasto"));

            Integer tipoBalastoId = new Integer(selectedTipoBalasto.getTipoBalastoId());
            entity = businessDelegatorView.getTipoBalasto(tipoBalastoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoBalastoId = FacesUtils.checkInteger(txtTipoBalastoId);
            entity = businessDelegatorView.getTipoBalasto(tipoBalastoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoBalasto(entity);
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

    public String action_modifyWitDTO(String nombreTipoBalasto,
        Integer tipoBalastoId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoBalasto(FacesUtils.checkString(
                    nombreTipoBalasto));
            businessDelegatorView.updateTipoBalasto(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoBalastoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoBalasto() {
        return txtNombreTipoBalasto;
    }

    public void setTxtNombreTipoBalasto(InputText txtNombreTipoBalasto) {
        this.txtNombreTipoBalasto = txtNombreTipoBalasto;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoBalastoId() {
        return txtTipoBalastoId;
    }

    public void setTxtTipoBalastoId(InputText txtTipoBalastoId) {
        this.txtTipoBalastoId = txtTipoBalastoId;
    }

    public List<TipoBalastoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoBalasto();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoBalastoDTO> tipoBalastoDTO) {
        this.data = tipoBalastoDTO;
    }

    public TipoBalastoDTO getSelectedTipoBalasto() {
        return selectedTipoBalasto;
    }

    public void setSelectedTipoBalasto(TipoBalastoDTO tipoBalasto) {
        this.selectedTipoBalasto = tipoBalasto;
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
