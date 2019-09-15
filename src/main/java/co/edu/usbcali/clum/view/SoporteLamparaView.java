package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.SoporteLamparaDTO;
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
public class SoporteLamparaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SoporteLamparaView.class);
    private InputText txtLongitud;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoMaterialId_TipoMaterial;
    private InputText txtTipoSoporteId_TipoSoporte;
    private InputText txtSoporteLamparaId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<SoporteLamparaDTO> data;
    private SoporteLamparaDTO selectedSoporteLampara;
    private SoporteLampara entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public SoporteLamparaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedSoporteLampara = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedSoporteLampara = null;

        if (txtLongitud != null) {
            txtLongitud.setValue(null);
            txtLongitud.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoMaterialId_TipoMaterial != null) {
            txtTipoMaterialId_TipoMaterial.setValue(null);
            txtTipoMaterialId_TipoMaterial.setDisabled(true);
        }

        if (txtTipoSoporteId_TipoSoporte != null) {
            txtTipoSoporteId_TipoSoporte.setValue(null);
            txtTipoSoporteId_TipoSoporte.setDisabled(true);
        }

        if (txtSoporteLamparaId != null) {
            txtSoporteLamparaId.setValue(null);
            txtSoporteLamparaId.setDisabled(false);
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
            Integer soporteLamparaId = FacesUtils.checkInteger(txtSoporteLamparaId);
            entity = (soporteLamparaId != null)
                ? businessDelegatorView.getSoporteLampara(soporteLamparaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtLongitud.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoMaterialId_TipoMaterial.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtSoporteLamparaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtLongitud.setValue(entity.getLongitud());
            txtLongitud.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoMaterialId_TipoMaterial.setValue(entity.getTipoMaterial()
                                                          .getTipoMaterialId());
            txtTipoMaterialId_TipoMaterial.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setValue(entity.getTipoSoporte()
                                                        .getTipoSoporteId());
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtSoporteLamparaId.setValue(entity.getSoporteLamparaId());
            txtSoporteLamparaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedSoporteLampara = (SoporteLamparaDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedSoporteLampara"));
        txtLongitud.setValue(selectedSoporteLampara.getLongitud());
        txtLongitud.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedSoporteLampara.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoMaterialId_TipoMaterial.setValue(selectedSoporteLampara.getTipoMaterialId_TipoMaterial());
        txtTipoMaterialId_TipoMaterial.setDisabled(false);
        txtTipoSoporteId_TipoSoporte.setValue(selectedSoporteLampara.getTipoSoporteId_TipoSoporte());
        txtTipoSoporteId_TipoSoporte.setDisabled(false);
        txtSoporteLamparaId.setValue(selectedSoporteLampara.getSoporteLamparaId());
        txtSoporteLamparaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedSoporteLampara == null) && (entity == null)) {
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
            entity = new SoporteLampara();

            Integer soporteLamparaId = FacesUtils.checkInteger(txtSoporteLamparaId);

            entity.setLongitud(FacesUtils.checkInteger(txtLongitud));
            entity.setSoporteLamparaId(soporteLamparaId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoMaterial((FacesUtils.checkInteger(
                    txtTipoMaterialId_TipoMaterial) != null)
                ? businessDelegatorView.getTipoMaterial(FacesUtils.checkInteger(
                        txtTipoMaterialId_TipoMaterial)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            businessDelegatorView.saveSoporteLampara(entity);
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
                Integer soporteLamparaId = new Integer(selectedSoporteLampara.getSoporteLamparaId());
                entity = businessDelegatorView.getSoporteLampara(soporteLamparaId);
            }

            entity.setLongitud(FacesUtils.checkInteger(txtLongitud));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoMaterial((FacesUtils.checkInteger(
                    txtTipoMaterialId_TipoMaterial) != null)
                ? businessDelegatorView.getTipoMaterial(FacesUtils.checkInteger(
                        txtTipoMaterialId_TipoMaterial)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            businessDelegatorView.updateSoporteLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedSoporteLampara = (SoporteLamparaDTO) (evt.getComponent()
                                                             .getAttributes()
                                                             .get("selectedSoporteLampara"));

            Integer soporteLamparaId = new Integer(selectedSoporteLampara.getSoporteLamparaId());
            entity = businessDelegatorView.getSoporteLampara(soporteLamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer soporteLamparaId = FacesUtils.checkInteger(txtSoporteLamparaId);
            entity = businessDelegatorView.getSoporteLampara(soporteLamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteSoporteLampara(entity);
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

    public String action_modifyWitDTO(Integer longitud,
        Integer soporteLamparaId, Integer idEstado_Estado,
        Integer tipoMaterialId_TipoMaterial, Integer tipoSoporteId_TipoSoporte)
        throws Exception {
        try {
            entity.setLongitud(FacesUtils.checkInteger(longitud));
            businessDelegatorView.updateSoporteLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("SoporteLamparaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtLongitud() {
        return txtLongitud;
    }

    public void setTxtLongitud(InputText txtLongitud) {
        this.txtLongitud = txtLongitud;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoMaterialId_TipoMaterial() {
        return txtTipoMaterialId_TipoMaterial;
    }

    public void setTxtTipoMaterialId_TipoMaterial(
        InputText txtTipoMaterialId_TipoMaterial) {
        this.txtTipoMaterialId_TipoMaterial = txtTipoMaterialId_TipoMaterial;
    }

    public InputText getTxtTipoSoporteId_TipoSoporte() {
        return txtTipoSoporteId_TipoSoporte;
    }

    public void setTxtTipoSoporteId_TipoSoporte(
        InputText txtTipoSoporteId_TipoSoporte) {
        this.txtTipoSoporteId_TipoSoporte = txtTipoSoporteId_TipoSoporte;
    }

    public InputText getTxtSoporteLamparaId() {
        return txtSoporteLamparaId;
    }

    public void setTxtSoporteLamparaId(InputText txtSoporteLamparaId) {
        this.txtSoporteLamparaId = txtSoporteLamparaId;
    }

    public List<SoporteLamparaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataSoporteLampara();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<SoporteLamparaDTO> soporteLamparaDTO) {
        this.data = soporteLamparaDTO;
    }

    public SoporteLamparaDTO getSelectedSoporteLampara() {
        return selectedSoporteLampara;
    }

    public void setSelectedSoporteLampara(SoporteLamparaDTO soporteLampara) {
        this.selectedSoporteLampara = soporteLampara;
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
