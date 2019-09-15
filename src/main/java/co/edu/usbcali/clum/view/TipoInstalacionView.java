package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoInstalacionDTO;
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
public class TipoInstalacionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoInstalacionView.class);
    private InputText txtNombreTipoInstalacion;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoInstalacionId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoInstalacionDTO> data;
    private TipoInstalacionDTO selectedTipoInstalacion;
    private TipoInstalacion entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoInstalacionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoInstalacion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoInstalacion = null;

        if (txtNombreTipoInstalacion != null) {
            txtNombreTipoInstalacion.setValue(null);
            txtNombreTipoInstalacion.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoInstalacionId != null) {
            txtTipoInstalacionId.setValue(null);
            txtTipoInstalacionId.setDisabled(false);
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
            Integer tipoInstalacionId = FacesUtils.checkInteger(txtTipoInstalacionId);
            entity = (tipoInstalacionId != null)
                ? businessDelegatorView.getTipoInstalacion(tipoInstalacionId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoInstalacion.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoInstalacionId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoInstalacion.setValue(entity.getNombreTipoInstalacion());
            txtNombreTipoInstalacion.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoInstalacionId.setValue(entity.getTipoInstalacionId());
            txtTipoInstalacionId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoInstalacion = (TipoInstalacionDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTipoInstalacion"));
        txtNombreTipoInstalacion.setValue(selectedTipoInstalacion.getNombreTipoInstalacion());
        txtNombreTipoInstalacion.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoInstalacion.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoInstalacionId.setValue(selectedTipoInstalacion.getTipoInstalacionId());
        txtTipoInstalacionId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoInstalacion == null) && (entity == null)) {
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
            entity = new TipoInstalacion();

            Integer tipoInstalacionId = FacesUtils.checkInteger(txtTipoInstalacionId);

            entity.setNombreTipoInstalacion(FacesUtils.checkString(
                    txtNombreTipoInstalacion));
            entity.setTipoInstalacionId(tipoInstalacionId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoInstalacion(entity);
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
                Integer tipoInstalacionId = new Integer(selectedTipoInstalacion.getTipoInstalacionId());
                entity = businessDelegatorView.getTipoInstalacion(tipoInstalacionId);
            }

            entity.setNombreTipoInstalacion(FacesUtils.checkString(
                    txtNombreTipoInstalacion));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoInstalacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoInstalacion = (TipoInstalacionDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedTipoInstalacion"));

            Integer tipoInstalacionId = new Integer(selectedTipoInstalacion.getTipoInstalacionId());
            entity = businessDelegatorView.getTipoInstalacion(tipoInstalacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoInstalacionId = FacesUtils.checkInteger(txtTipoInstalacionId);
            entity = businessDelegatorView.getTipoInstalacion(tipoInstalacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoInstalacion(entity);
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

    public String action_modifyWitDTO(String nombreTipoInstalacion,
        Integer tipoInstalacionId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoInstalacion(FacesUtils.checkString(
                    nombreTipoInstalacion));
            businessDelegatorView.updateTipoInstalacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoInstalacionView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoInstalacion() {
        return txtNombreTipoInstalacion;
    }

    public void setTxtNombreTipoInstalacion(InputText txtNombreTipoInstalacion) {
        this.txtNombreTipoInstalacion = txtNombreTipoInstalacion;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoInstalacionId() {
        return txtTipoInstalacionId;
    }

    public void setTxtTipoInstalacionId(InputText txtTipoInstalacionId) {
        this.txtTipoInstalacionId = txtTipoInstalacionId;
    }

    public List<TipoInstalacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoInstalacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoInstalacionDTO> tipoInstalacionDTO) {
        this.data = tipoInstalacionDTO;
    }

    public TipoInstalacionDTO getSelectedTipoInstalacion() {
        return selectedTipoInstalacion;
    }

    public void setSelectedTipoInstalacion(TipoInstalacionDTO tipoInstalacion) {
        this.selectedTipoInstalacion = tipoInstalacion;
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
