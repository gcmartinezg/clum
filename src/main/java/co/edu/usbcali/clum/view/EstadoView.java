package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.EstadoDTO;
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
public class EstadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EstadoView.class);
    private InputText txtEstado;
    private InputText txtIdEstado;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<EstadoDTO> data;
    private EstadoDTO selectedEstado;
    private Estado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public EstadoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedEstado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedEstado = null;

        if (txtEstado != null) {
            txtEstado.setValue(null);
            txtEstado.setDisabled(true);
        }

        if (txtIdEstado != null) {
            txtIdEstado.setValue(null);
            txtIdEstado.setDisabled(false);
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
            Integer idEstado = FacesUtils.checkInteger(txtIdEstado);
            entity = (idEstado != null)
                ? businessDelegatorView.getEstado(idEstado) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtEstado.setDisabled(false);
            txtIdEstado.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtEstado.setValue(entity.getEstado());
            txtEstado.setDisabled(false);
            txtIdEstado.setValue(entity.getIdEstado());
            txtIdEstado.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedEstado = (EstadoDTO) (evt.getComponent().getAttributes()
                                         .get("selectedEstado"));
        txtEstado.setValue(selectedEstado.getEstado());
        txtEstado.setDisabled(false);
        txtIdEstado.setValue(selectedEstado.getIdEstado());
        txtIdEstado.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedEstado == null) && (entity == null)) {
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
            entity = new Estado();

            Integer idEstado = FacesUtils.checkInteger(txtIdEstado);

            entity.setEstado(FacesUtils.checkString(txtEstado));
            entity.setIdEstado(idEstado);
            businessDelegatorView.saveEstado(entity);
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
                Integer idEstado = new Integer(selectedEstado.getIdEstado());
                entity = businessDelegatorView.getEstado(idEstado);
            }

            entity.setEstado(FacesUtils.checkString(txtEstado));
            businessDelegatorView.updateEstado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedEstado = (EstadoDTO) (evt.getComponent().getAttributes()
                                             .get("selectedEstado"));

            Integer idEstado = new Integer(selectedEstado.getIdEstado());
            entity = businessDelegatorView.getEstado(idEstado);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer idEstado = FacesUtils.checkInteger(txtIdEstado);
            entity = businessDelegatorView.getEstado(idEstado);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteEstado(entity);
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

    public String action_modifyWitDTO(String estado, Integer idEstado)
        throws Exception {
        try {
            entity.setEstado(FacesUtils.checkString(estado));
            businessDelegatorView.updateEstado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("EstadoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtEstado() {
        return txtEstado;
    }

    public void setTxtEstado(InputText txtEstado) {
        this.txtEstado = txtEstado;
    }

    public InputText getTxtIdEstado() {
        return txtIdEstado;
    }

    public void setTxtIdEstado(InputText txtIdEstado) {
        this.txtIdEstado = txtIdEstado;
    }

    public List<EstadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataEstado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<EstadoDTO> estadoDTO) {
        this.data = estadoDTO;
    }

    public EstadoDTO getSelectedEstado() {
        return selectedEstado;
    }

    public void setSelectedEstado(EstadoDTO estado) {
        this.selectedEstado = estado;
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
