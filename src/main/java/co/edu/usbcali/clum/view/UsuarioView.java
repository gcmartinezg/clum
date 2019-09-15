package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.UsuarioDTO;
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
public class UsuarioView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(UsuarioView.class);
    private InputText txtContrasenia;
    private InputText txtIdEstado_Estado;
    private InputText txtTerceroId_Tercero;
    private InputText txtTipoUsuarioId_TipoUsuario;
    private InputText txtUsuarioId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<UsuarioDTO> data;
    private UsuarioDTO selectedUsuario;
    private Usuario entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public UsuarioView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedUsuario = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedUsuario = null;

        if (txtContrasenia != null) {
            txtContrasenia.setValue(null);
            txtContrasenia.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTerceroId_Tercero != null) {
            txtTerceroId_Tercero.setValue(null);
            txtTerceroId_Tercero.setDisabled(true);
        }

        if (txtTipoUsuarioId_TipoUsuario != null) {
            txtTipoUsuarioId_TipoUsuario.setValue(null);
            txtTipoUsuarioId_TipoUsuario.setDisabled(true);
        }

        if (txtUsuarioId != null) {
            txtUsuarioId.setValue(null);
            txtUsuarioId.setDisabled(false);
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
            String usuarioId = FacesUtils.checkString(txtUsuarioId);
            entity = (usuarioId != null)
                ? businessDelegatorView.getUsuario(usuarioId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtContrasenia.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTerceroId_Tercero.setDisabled(false);
            txtTipoUsuarioId_TipoUsuario.setDisabled(false);
            txtUsuarioId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtContrasenia.setValue(entity.getContrasenia());
            txtContrasenia.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTerceroId_Tercero.setValue(entity.getTercero().getTerceroId());
            txtTerceroId_Tercero.setDisabled(false);
            txtTipoUsuarioId_TipoUsuario.setValue(entity.getTipoUsuario()
                                                        .getTipoUsuarioId());
            txtTipoUsuarioId_TipoUsuario.setDisabled(false);
            txtUsuarioId.setValue(entity.getUsuarioId());
            txtUsuarioId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                           .get("selectedUsuario"));
        txtContrasenia.setValue(selectedUsuario.getContrasenia());
        txtContrasenia.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedUsuario.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTerceroId_Tercero.setValue(selectedUsuario.getTerceroId_Tercero());
        txtTerceroId_Tercero.setDisabled(false);
        txtTipoUsuarioId_TipoUsuario.setValue(selectedUsuario.getTipoUsuarioId_TipoUsuario());
        txtTipoUsuarioId_TipoUsuario.setDisabled(false);
        txtUsuarioId.setValue(selectedUsuario.getUsuarioId());
        txtUsuarioId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedUsuario == null) && (entity == null)) {
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
            entity = new Usuario();

            String usuarioId = FacesUtils.checkString(txtUsuarioId);

            entity.setContrasenia(FacesUtils.checkString(txtContrasenia));
            entity.setUsuarioId(usuarioId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTercero((FacesUtils.checkInteger(txtTerceroId_Tercero) != null)
                ? businessDelegatorView.getTercero(FacesUtils.checkInteger(
                        txtTerceroId_Tercero)) : null);
            entity.setTipoUsuario((FacesUtils.checkInteger(
                    txtTipoUsuarioId_TipoUsuario) != null)
                ? businessDelegatorView.getTipoUsuario(FacesUtils.checkInteger(
                        txtTipoUsuarioId_TipoUsuario)) : null);
            businessDelegatorView.saveUsuario(entity);
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
                String usuarioId = new String(selectedUsuario.getUsuarioId());
                entity = businessDelegatorView.getUsuario(usuarioId);
            }

            entity.setContrasenia(FacesUtils.checkString(txtContrasenia));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTercero((FacesUtils.checkInteger(txtTerceroId_Tercero) != null)
                ? businessDelegatorView.getTercero(FacesUtils.checkInteger(
                        txtTerceroId_Tercero)) : null);
            entity.setTipoUsuario((FacesUtils.checkInteger(
                    txtTipoUsuarioId_TipoUsuario) != null)
                ? businessDelegatorView.getTipoUsuario(FacesUtils.checkInteger(
                        txtTipoUsuarioId_TipoUsuario)) : null);
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedUsuario = (UsuarioDTO) (evt.getComponent().getAttributes()
                                               .get("selectedUsuario"));

            String usuarioId = new String(selectedUsuario.getUsuarioId());
            entity = businessDelegatorView.getUsuario(usuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            String usuarioId = FacesUtils.checkString(txtUsuarioId);
            entity = businessDelegatorView.getUsuario(usuarioId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteUsuario(entity);
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

    public String action_modifyWitDTO(String contrasenia, String usuarioId,
        Integer idEstado_Estado, Integer terceroId_Tercero,
        Integer tipoUsuarioId_TipoUsuario) throws Exception {
        try {
            entity.setContrasenia(FacesUtils.checkString(contrasenia));
            businessDelegatorView.updateUsuario(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("UsuarioView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtContrasenia() {
        return txtContrasenia;
    }

    public void setTxtContrasenia(InputText txtContrasenia) {
        this.txtContrasenia = txtContrasenia;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTerceroId_Tercero() {
        return txtTerceroId_Tercero;
    }

    public void setTxtTerceroId_Tercero(InputText txtTerceroId_Tercero) {
        this.txtTerceroId_Tercero = txtTerceroId_Tercero;
    }

    public InputText getTxtTipoUsuarioId_TipoUsuario() {
        return txtTipoUsuarioId_TipoUsuario;
    }

    public void setTxtTipoUsuarioId_TipoUsuario(
        InputText txtTipoUsuarioId_TipoUsuario) {
        this.txtTipoUsuarioId_TipoUsuario = txtTipoUsuarioId_TipoUsuario;
    }

    public InputText getTxtUsuarioId() {
        return txtUsuarioId;
    }

    public void setTxtUsuarioId(InputText txtUsuarioId) {
        this.txtUsuarioId = txtUsuarioId;
    }

    public List<UsuarioDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataUsuario();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<UsuarioDTO> usuarioDTO) {
        this.data = usuarioDTO;
    }

    public UsuarioDTO getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(UsuarioDTO usuario) {
        this.selectedUsuario = usuario;
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
