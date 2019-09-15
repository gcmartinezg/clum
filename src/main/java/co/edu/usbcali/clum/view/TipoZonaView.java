package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoZonaDTO;
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
public class TipoZonaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoZonaView.class);
    private InputText txtNombreTipoZona;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoZonaId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoZonaDTO> data;
    private TipoZonaDTO selectedTipoZona;
    private TipoZona entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoZonaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoZona = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoZona = null;

        if (txtNombreTipoZona != null) {
            txtNombreTipoZona.setValue(null);
            txtNombreTipoZona.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoZonaId != null) {
            txtTipoZonaId.setValue(null);
            txtTipoZonaId.setDisabled(false);
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
            Integer tipoZonaId = FacesUtils.checkInteger(txtTipoZonaId);
            entity = (tipoZonaId != null)
                ? businessDelegatorView.getTipoZona(tipoZonaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoZona.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoZonaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoZona.setValue(entity.getNombreTipoZona());
            txtNombreTipoZona.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoZonaId.setValue(entity.getTipoZonaId());
            txtTipoZonaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoZona = (TipoZonaDTO) (evt.getComponent().getAttributes()
                                             .get("selectedTipoZona"));
        txtNombreTipoZona.setValue(selectedTipoZona.getNombreTipoZona());
        txtNombreTipoZona.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoZona.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoZonaId.setValue(selectedTipoZona.getTipoZonaId());
        txtTipoZonaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoZona == null) && (entity == null)) {
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
            entity = new TipoZona();

            Integer tipoZonaId = FacesUtils.checkInteger(txtTipoZonaId);

            entity.setNombreTipoZona(FacesUtils.checkString(txtNombreTipoZona));
            entity.setTipoZonaId(tipoZonaId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoZona(entity);
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
                Integer tipoZonaId = new Integer(selectedTipoZona.getTipoZonaId());
                entity = businessDelegatorView.getTipoZona(tipoZonaId);
            }

            entity.setNombreTipoZona(FacesUtils.checkString(txtNombreTipoZona));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoZona(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoZona = (TipoZonaDTO) (evt.getComponent().getAttributes()
                                                 .get("selectedTipoZona"));

            Integer tipoZonaId = new Integer(selectedTipoZona.getTipoZonaId());
            entity = businessDelegatorView.getTipoZona(tipoZonaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoZonaId = FacesUtils.checkInteger(txtTipoZonaId);
            entity = businessDelegatorView.getTipoZona(tipoZonaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoZona(entity);
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

    public String action_modifyWitDTO(String nombreTipoZona,
        Integer tipoZonaId, Integer idEstado_Estado) throws Exception {
        try {
            entity.setNombreTipoZona(FacesUtils.checkString(nombreTipoZona));
            businessDelegatorView.updateTipoZona(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoZonaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoZona() {
        return txtNombreTipoZona;
    }

    public void setTxtNombreTipoZona(InputText txtNombreTipoZona) {
        this.txtNombreTipoZona = txtNombreTipoZona;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoZonaId() {
        return txtTipoZonaId;
    }

    public void setTxtTipoZonaId(InputText txtTipoZonaId) {
        this.txtTipoZonaId = txtTipoZonaId;
    }

    public List<TipoZonaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoZona();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoZonaDTO> tipoZonaDTO) {
        this.data = tipoZonaDTO;
    }

    public TipoZonaDTO getSelectedTipoZona() {
        return selectedTipoZona;
    }

    public void setSelectedTipoZona(TipoZonaDTO tipoZona) {
        this.selectedTipoZona = tipoZona;
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
