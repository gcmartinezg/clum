package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoDocumentoDTO;
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
public class TipoDocumentoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoDocumentoView.class);
    private InputText txtNombreTipoDocumento;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoDocumentoId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoDocumentoDTO> data;
    private TipoDocumentoDTO selectedTipoDocumento;
    private TipoDocumento entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoDocumentoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoDocumento = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoDocumento = null;

        if (txtNombreTipoDocumento != null) {
            txtNombreTipoDocumento.setValue(null);
            txtNombreTipoDocumento.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoDocumentoId != null) {
            txtTipoDocumentoId.setValue(null);
            txtTipoDocumentoId.setDisabled(false);
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
            Integer tipoDocumentoId = FacesUtils.checkInteger(txtTipoDocumentoId);
            entity = (tipoDocumentoId != null)
                ? businessDelegatorView.getTipoDocumento(tipoDocumentoId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoDocumento.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoDocumentoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoDocumento.setValue(entity.getNombreTipoDocumento());
            txtNombreTipoDocumento.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoDocumentoId.setValue(entity.getTipoDocumentoId());
            txtTipoDocumentoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoDocumento"));
        txtNombreTipoDocumento.setValue(selectedTipoDocumento.getNombreTipoDocumento());
        txtNombreTipoDocumento.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoDocumento.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoDocumentoId.setValue(selectedTipoDocumento.getTipoDocumentoId());
        txtTipoDocumentoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoDocumento == null) && (entity == null)) {
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
            entity = new TipoDocumento();

            Integer tipoDocumentoId = FacesUtils.checkInteger(txtTipoDocumentoId);

            entity.setNombreTipoDocumento(FacesUtils.checkString(
                    txtNombreTipoDocumento));
            entity.setTipoDocumentoId(tipoDocumentoId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoDocumento(entity);
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
                Integer tipoDocumentoId = new Integer(selectedTipoDocumento.getTipoDocumentoId());
                entity = businessDelegatorView.getTipoDocumento(tipoDocumentoId);
            }

            entity.setNombreTipoDocumento(FacesUtils.checkString(
                    txtNombreTipoDocumento));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoDocumento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoDocumento = (TipoDocumentoDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTipoDocumento"));

            Integer tipoDocumentoId = new Integer(selectedTipoDocumento.getTipoDocumentoId());
            entity = businessDelegatorView.getTipoDocumento(tipoDocumentoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoDocumentoId = FacesUtils.checkInteger(txtTipoDocumentoId);
            entity = businessDelegatorView.getTipoDocumento(tipoDocumentoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoDocumento(entity);
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

    public String action_modifyWitDTO(String nombreTipoDocumento,
        Integer tipoDocumentoId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoDocumento(FacesUtils.checkString(
                    nombreTipoDocumento));
            businessDelegatorView.updateTipoDocumento(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoDocumentoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoDocumento() {
        return txtNombreTipoDocumento;
    }

    public void setTxtNombreTipoDocumento(InputText txtNombreTipoDocumento) {
        this.txtNombreTipoDocumento = txtNombreTipoDocumento;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoDocumentoId() {
        return txtTipoDocumentoId;
    }

    public void setTxtTipoDocumentoId(InputText txtTipoDocumentoId) {
        this.txtTipoDocumentoId = txtTipoDocumentoId;
    }

    public List<TipoDocumentoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoDocumento();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoDocumentoDTO> tipoDocumentoDTO) {
        this.data = tipoDocumentoDTO;
    }

    public TipoDocumentoDTO getSelectedTipoDocumento() {
        return selectedTipoDocumento;
    }

    public void setSelectedTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.selectedTipoDocumento = tipoDocumento;
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
