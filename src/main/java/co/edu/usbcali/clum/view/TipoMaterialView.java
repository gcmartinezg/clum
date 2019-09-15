package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoMaterialDTO;
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
public class TipoMaterialView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoMaterialView.class);
    private InputText txtNombreTipoMaterial;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoMaterialId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoMaterialDTO> data;
    private TipoMaterialDTO selectedTipoMaterial;
    private TipoMaterial entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoMaterialView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoMaterial = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoMaterial = null;

        if (txtNombreTipoMaterial != null) {
            txtNombreTipoMaterial.setValue(null);
            txtNombreTipoMaterial.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoMaterialId != null) {
            txtTipoMaterialId.setValue(null);
            txtTipoMaterialId.setDisabled(false);
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
            Integer tipoMaterialId = FacesUtils.checkInteger(txtTipoMaterialId);
            entity = (tipoMaterialId != null)
                ? businessDelegatorView.getTipoMaterial(tipoMaterialId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoMaterial.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoMaterialId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoMaterial.setValue(entity.getNombreTipoMaterial());
            txtNombreTipoMaterial.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoMaterialId.setValue(entity.getTipoMaterialId());
            txtTipoMaterialId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoMaterial = (TipoMaterialDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedTipoMaterial"));
        txtNombreTipoMaterial.setValue(selectedTipoMaterial.getNombreTipoMaterial());
        txtNombreTipoMaterial.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoMaterial.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoMaterialId.setValue(selectedTipoMaterial.getTipoMaterialId());
        txtTipoMaterialId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoMaterial == null) && (entity == null)) {
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
            entity = new TipoMaterial();

            Integer tipoMaterialId = FacesUtils.checkInteger(txtTipoMaterialId);

            entity.setNombreTipoMaterial(FacesUtils.checkString(
                    txtNombreTipoMaterial));
            entity.setTipoMaterialId(tipoMaterialId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoMaterial(entity);
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
                Integer tipoMaterialId = new Integer(selectedTipoMaterial.getTipoMaterialId());
                entity = businessDelegatorView.getTipoMaterial(tipoMaterialId);
            }

            entity.setNombreTipoMaterial(FacesUtils.checkString(
                    txtNombreTipoMaterial));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoMaterial(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoMaterial = (TipoMaterialDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedTipoMaterial"));

            Integer tipoMaterialId = new Integer(selectedTipoMaterial.getTipoMaterialId());
            entity = businessDelegatorView.getTipoMaterial(tipoMaterialId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoMaterialId = FacesUtils.checkInteger(txtTipoMaterialId);
            entity = businessDelegatorView.getTipoMaterial(tipoMaterialId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoMaterial(entity);
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

    public String action_modifyWitDTO(String nombreTipoMaterial,
        Integer tipoMaterialId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoMaterial(FacesUtils.checkString(
                    nombreTipoMaterial));
            businessDelegatorView.updateTipoMaterial(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoMaterialView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoMaterial() {
        return txtNombreTipoMaterial;
    }

    public void setTxtNombreTipoMaterial(InputText txtNombreTipoMaterial) {
        this.txtNombreTipoMaterial = txtNombreTipoMaterial;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoMaterialId() {
        return txtTipoMaterialId;
    }

    public void setTxtTipoMaterialId(InputText txtTipoMaterialId) {
        this.txtTipoMaterialId = txtTipoMaterialId;
    }

    public List<TipoMaterialDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoMaterial();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoMaterialDTO> tipoMaterialDTO) {
        this.data = tipoMaterialDTO;
    }

    public TipoMaterialDTO getSelectedTipoMaterial() {
        return selectedTipoMaterial;
    }

    public void setSelectedTipoMaterial(TipoMaterialDTO tipoMaterial) {
        this.selectedTipoMaterial = tipoMaterial;
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
