package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TerceroDTO;
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
public class TerceroView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TerceroView.class);
    private InputText txtDireccion;
    private InputText txtEmail;
    private InputText txtNombreTercero;
    private InputText txtNumeroDocumento;
    private InputText txtTelefono;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoDocumentoId_TipoDocumento;
    private InputText txtTerceroId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TerceroDTO> data;
    private TerceroDTO selectedTercero;
    private Tercero entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TerceroView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTercero = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTercero = null;

        if (txtDireccion != null) {
            txtDireccion.setValue(null);
            txtDireccion.setDisabled(true);
        }

        if (txtEmail != null) {
            txtEmail.setValue(null);
            txtEmail.setDisabled(true);
        }

        if (txtNombreTercero != null) {
            txtNombreTercero.setValue(null);
            txtNombreTercero.setDisabled(true);
        }

        if (txtNumeroDocumento != null) {
            txtNumeroDocumento.setValue(null);
            txtNumeroDocumento.setDisabled(true);
        }

        if (txtTelefono != null) {
            txtTelefono.setValue(null);
            txtTelefono.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoDocumentoId_TipoDocumento != null) {
            txtTipoDocumentoId_TipoDocumento.setValue(null);
            txtTipoDocumentoId_TipoDocumento.setDisabled(true);
        }

        if (txtTerceroId != null) {
            txtTerceroId.setValue(null);
            txtTerceroId.setDisabled(false);
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
            Integer terceroId = FacesUtils.checkInteger(txtTerceroId);
            entity = (terceroId != null)
                ? businessDelegatorView.getTercero(terceroId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtDireccion.setDisabled(false);
            txtEmail.setDisabled(false);
            txtNombreTercero.setDisabled(false);
            txtNumeroDocumento.setDisabled(false);
            txtTelefono.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoDocumentoId_TipoDocumento.setDisabled(false);
            txtTerceroId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtDireccion.setValue(entity.getDireccion());
            txtDireccion.setDisabled(false);
            txtEmail.setValue(entity.getEmail());
            txtEmail.setDisabled(false);
            txtNombreTercero.setValue(entity.getNombreTercero());
            txtNombreTercero.setDisabled(false);
            txtNumeroDocumento.setValue(entity.getNumeroDocumento());
            txtNumeroDocumento.setDisabled(false);
            txtTelefono.setValue(entity.getTelefono());
            txtTelefono.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoDocumentoId_TipoDocumento.setValue(entity.getTipoDocumento()
                                                            .getTipoDocumentoId());
            txtTipoDocumentoId_TipoDocumento.setDisabled(false);
            txtTerceroId.setValue(entity.getTerceroId());
            txtTerceroId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTercero = (TerceroDTO) (evt.getComponent().getAttributes()
                                           .get("selectedTercero"));
        txtDireccion.setValue(selectedTercero.getDireccion());
        txtDireccion.setDisabled(false);
        txtEmail.setValue(selectedTercero.getEmail());
        txtEmail.setDisabled(false);
        txtNombreTercero.setValue(selectedTercero.getNombreTercero());
        txtNombreTercero.setDisabled(false);
        txtNumeroDocumento.setValue(selectedTercero.getNumeroDocumento());
        txtNumeroDocumento.setDisabled(false);
        txtTelefono.setValue(selectedTercero.getTelefono());
        txtTelefono.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTercero.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoDocumentoId_TipoDocumento.setValue(selectedTercero.getTipoDocumentoId_TipoDocumento());
        txtTipoDocumentoId_TipoDocumento.setDisabled(false);
        txtTerceroId.setValue(selectedTercero.getTerceroId());
        txtTerceroId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTercero == null) && (entity == null)) {
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
            entity = new Tercero();

            Integer terceroId = FacesUtils.checkInteger(txtTerceroId);

            entity.setDireccion(FacesUtils.checkString(txtDireccion));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setNombreTercero(FacesUtils.checkString(txtNombreTercero));
            entity.setNumeroDocumento(FacesUtils.checkLong(txtNumeroDocumento));
            entity.setTelefono(FacesUtils.checkLong(txtTelefono));
            entity.setTerceroId(terceroId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoDocumento((FacesUtils.checkInteger(
                    txtTipoDocumentoId_TipoDocumento) != null)
                ? businessDelegatorView.getTipoDocumento(
                    FacesUtils.checkInteger(txtTipoDocumentoId_TipoDocumento))
                : null);
            businessDelegatorView.saveTercero(entity);
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
                Integer terceroId = new Integer(selectedTercero.getTerceroId());
                entity = businessDelegatorView.getTercero(terceroId);
            }

            entity.setDireccion(FacesUtils.checkString(txtDireccion));
            entity.setEmail(FacesUtils.checkString(txtEmail));
            entity.setNombreTercero(FacesUtils.checkString(txtNombreTercero));
            entity.setNumeroDocumento(FacesUtils.checkLong(txtNumeroDocumento));
            entity.setTelefono(FacesUtils.checkLong(txtTelefono));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoDocumento((FacesUtils.checkInteger(
                    txtTipoDocumentoId_TipoDocumento) != null)
                ? businessDelegatorView.getTipoDocumento(
                    FacesUtils.checkInteger(txtTipoDocumentoId_TipoDocumento))
                : null);
            businessDelegatorView.updateTercero(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTercero = (TerceroDTO) (evt.getComponent().getAttributes()
                                               .get("selectedTercero"));

            Integer terceroId = new Integer(selectedTercero.getTerceroId());
            entity = businessDelegatorView.getTercero(terceroId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer terceroId = FacesUtils.checkInteger(txtTerceroId);
            entity = businessDelegatorView.getTercero(terceroId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTercero(entity);
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

    public String action_modifyWitDTO(String direccion, String email,
        String nombreTercero, Long numeroDocumento, Long telefono,
        Integer terceroId, Integer idEstado_Estado,
        Integer tipoDocumentoId_TipoDocumento) throws Exception {
        try {
            entity.setDireccion(FacesUtils.checkString(direccion));
            entity.setEmail(FacesUtils.checkString(email));
            entity.setNombreTercero(FacesUtils.checkString(nombreTercero));
            entity.setNumeroDocumento(FacesUtils.checkLong(numeroDocumento));
            entity.setTelefono(FacesUtils.checkLong(telefono));
            businessDelegatorView.updateTercero(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TerceroView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(InputText txtDireccion) {
        this.txtDireccion = txtDireccion;
    }

    public InputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(InputText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public InputText getTxtNombreTercero() {
        return txtNombreTercero;
    }

    public void setTxtNombreTercero(InputText txtNombreTercero) {
        this.txtNombreTercero = txtNombreTercero;
    }

    public InputText getTxtNumeroDocumento() {
        return txtNumeroDocumento;
    }

    public void setTxtNumeroDocumento(InputText txtNumeroDocumento) {
        this.txtNumeroDocumento = txtNumeroDocumento;
    }

    public InputText getTxtTelefono() {
        return txtTelefono;
    }

    public void setTxtTelefono(InputText txtTelefono) {
        this.txtTelefono = txtTelefono;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoDocumentoId_TipoDocumento() {
        return txtTipoDocumentoId_TipoDocumento;
    }

    public void setTxtTipoDocumentoId_TipoDocumento(
        InputText txtTipoDocumentoId_TipoDocumento) {
        this.txtTipoDocumentoId_TipoDocumento = txtTipoDocumentoId_TipoDocumento;
    }

    public InputText getTxtTerceroId() {
        return txtTerceroId;
    }

    public void setTxtTerceroId(InputText txtTerceroId) {
        this.txtTerceroId = txtTerceroId;
    }

    public List<TerceroDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTercero();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TerceroDTO> terceroDTO) {
        this.data = terceroDTO;
    }

    public TerceroDTO getSelectedTercero() {
        return selectedTercero;
    }

    public void setSelectedTercero(TerceroDTO tercero) {
        this.selectedTercero = tercero;
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
