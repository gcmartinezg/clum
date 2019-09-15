package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoSoporteDTO;
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
public class TipoSoporteView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoSoporteView.class);
    private InputText txtNombreTipoSoporte;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoSoporteId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoSoporteDTO> data;
    private TipoSoporteDTO selectedTipoSoporte;
    private TipoSoporte entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoSoporteView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoSoporte = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoSoporte = null;

        if (txtNombreTipoSoporte != null) {
            txtNombreTipoSoporte.setValue(null);
            txtNombreTipoSoporte.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoSoporteId != null) {
            txtTipoSoporteId.setValue(null);
            txtTipoSoporteId.setDisabled(false);
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
            Integer tipoSoporteId = FacesUtils.checkInteger(txtTipoSoporteId);
            entity = (tipoSoporteId != null)
                ? businessDelegatorView.getTipoSoporte(tipoSoporteId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoSoporte.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoSoporteId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoSoporte.setValue(entity.getNombreTipoSoporte());
            txtNombreTipoSoporte.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoSoporteId.setValue(entity.getTipoSoporteId());
            txtTipoSoporteId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoSoporte = (TipoSoporteDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipoSoporte"));
        txtNombreTipoSoporte.setValue(selectedTipoSoporte.getNombreTipoSoporte());
        txtNombreTipoSoporte.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoSoporte.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoSoporteId.setValue(selectedTipoSoporte.getTipoSoporteId());
        txtTipoSoporteId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoSoporte == null) && (entity == null)) {
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
            entity = new TipoSoporte();

            Integer tipoSoporteId = FacesUtils.checkInteger(txtTipoSoporteId);

            entity.setNombreTipoSoporte(FacesUtils.checkString(
                    txtNombreTipoSoporte));
            entity.setTipoSoporteId(tipoSoporteId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoSoporte(entity);
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
                Integer tipoSoporteId = new Integer(selectedTipoSoporte.getTipoSoporteId());
                entity = businessDelegatorView.getTipoSoporte(tipoSoporteId);
            }

            entity.setNombreTipoSoporte(FacesUtils.checkString(
                    txtNombreTipoSoporte));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoSoporte(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoSoporte = (TipoSoporteDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoSoporte"));

            Integer tipoSoporteId = new Integer(selectedTipoSoporte.getTipoSoporteId());
            entity = businessDelegatorView.getTipoSoporte(tipoSoporteId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoSoporteId = FacesUtils.checkInteger(txtTipoSoporteId);
            entity = businessDelegatorView.getTipoSoporte(tipoSoporteId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoSoporte(entity);
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

    public String action_modifyWitDTO(String nombreTipoSoporte,
        Integer tipoSoporteId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoSoporte(FacesUtils.checkString(
                    nombreTipoSoporte));
            businessDelegatorView.updateTipoSoporte(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoSoporteView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoSoporte() {
        return txtNombreTipoSoporte;
    }

    public void setTxtNombreTipoSoporte(InputText txtNombreTipoSoporte) {
        this.txtNombreTipoSoporte = txtNombreTipoSoporte;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoSoporteId() {
        return txtTipoSoporteId;
    }

    public void setTxtTipoSoporteId(InputText txtTipoSoporteId) {
        this.txtTipoSoporteId = txtTipoSoporteId;
    }

    public List<TipoSoporteDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoSoporte();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoSoporteDTO> tipoSoporteDTO) {
        this.data = tipoSoporteDTO;
    }

    public TipoSoporteDTO getSelectedTipoSoporte() {
        return selectedTipoSoporte;
    }

    public void setSelectedTipoSoporte(TipoSoporteDTO tipoSoporte) {
        this.selectedTipoSoporte = tipoSoporte;
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
