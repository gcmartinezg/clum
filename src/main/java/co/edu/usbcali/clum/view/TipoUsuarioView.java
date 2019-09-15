package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoUsuarioDTO;
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
public class TipoUsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoUsuarioView.class);
    private InputText txtNombreTipoUsuario;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoUsuarioId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoUsuarioDTO> data;
    private TipoUsuarioDTO selectedTipoUsuario;
    private TipoUsuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoUsuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoUsuario = null;

        if (txtNombreTipoUsuario != null) {
            txtNombreTipoUsuario.setValue(null);
            txtNombreTipoUsuario.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoUsuarioId != null) {
            txtTipoUsuarioId.setValue(null);
            txtTipoUsuarioId.setDisabled(false);
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
            Integer tipoUsuarioId = FacesUtils.checkInteger(txtTipoUsuarioId);
            entity = (tipoUsuarioId != null)
                ? businessDelegatorView.getTipoUsuario(tipoUsuarioId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoUsuario.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoUsuarioId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoUsuario.setValue(entity.getNombreTipoUsuario());
            txtNombreTipoUsuario.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoUsuarioId.setValue(entity.getTipoUsuarioId());
            txtTipoUsuarioId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoUsuario = (TipoUsuarioDTO) (evt.getComponent()
                                                   .getAttributes()
                                                   .get("selectedTipoUsuario"));
        txtNombreTipoUsuario.setValue(selectedTipoUsuario.getNombreTipoUsuario());
        txtNombreTipoUsuario.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoUsuario.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoUsuarioId.setValue(selectedTipoUsuario.getTipoUsuarioId());
        txtTipoUsuarioId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoUsuario == null) && (entity == null)) {
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
            entity = new TipoUsuario();

            Integer tipoUsuarioId = FacesUtils.checkInteger(txtTipoUsuarioId);

            entity.setNombreTipoUsuario(FacesUtils.checkString(
                    txtNombreTipoUsuario));
            entity.setTipoUsuarioId(tipoUsuarioId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoUsuario(entity);
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
                Integer tipoUsuarioId = new Integer(selectedTipoUsuario.getTipoUsuarioId());
                entity = businessDelegatorView.getTipoUsuario(tipoUsuarioId);
            }

            entity.setNombreTipoUsuario(FacesUtils.checkString(
                    txtNombreTipoUsuario));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoUsuario = (TipoUsuarioDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTipoUsuario"));

            Integer tipoUsuarioId = new Integer(selectedTipoUsuario.getTipoUsuarioId());
            entity = businessDelegatorView.getTipoUsuario(tipoUsuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoUsuarioId = FacesUtils.checkInteger(txtTipoUsuarioId);
            entity = businessDelegatorView.getTipoUsuario(tipoUsuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoUsuario(entity);
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

    public String action_modifyWitDTO(String nombreTipoUsuario,
        Integer tipoUsuarioId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoUsuario(FacesUtils.checkString(
                    nombreTipoUsuario));
            businessDelegatorView.updateTipoUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoUsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoUsuario() {
        return txtNombreTipoUsuario;
    }

    public void setTxtNombreTipoUsuario(InputText txtNombreTipoUsuario) {
        this.txtNombreTipoUsuario = txtNombreTipoUsuario;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoUsuarioId() {
        return txtTipoUsuarioId;
    }

    public void setTxtTipoUsuarioId(InputText txtTipoUsuarioId) {
        this.txtTipoUsuarioId = txtTipoUsuarioId;
    }

    public List<TipoUsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoUsuarioDTO> tipoUsuarioDTO) {
        this.data = tipoUsuarioDTO;
    }

    public TipoUsuarioDTO getSelectedTipoUsuario() {
        return selectedTipoUsuario;
    }

    public void setSelectedTipoUsuario(TipoUsuarioDTO tipoUsuario) {
        this.selectedTipoUsuario = tipoUsuario;
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
