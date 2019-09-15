package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.RedAlimentacionDTO;
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
public class RedAlimentacionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RedAlimentacionView.class);
    private InputText txtCalibreConductorAwg;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoInstalacionId_TipoInstalacion;
    private InputText txtTipoMaterialId_TipoMaterial;
    private InputText txtTipoSoporteId_TipoSoporte;
    private InputText txtRedAlimentacionId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<RedAlimentacionDTO> data;
    private RedAlimentacionDTO selectedRedAlimentacion;
    private RedAlimentacion entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public RedAlimentacionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedRedAlimentacion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedRedAlimentacion = null;

        if (txtCalibreConductorAwg != null) {
            txtCalibreConductorAwg.setValue(null);
            txtCalibreConductorAwg.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoInstalacionId_TipoInstalacion != null) {
            txtTipoInstalacionId_TipoInstalacion.setValue(null);
            txtTipoInstalacionId_TipoInstalacion.setDisabled(true);
        }

        if (txtTipoMaterialId_TipoMaterial != null) {
            txtTipoMaterialId_TipoMaterial.setValue(null);
            txtTipoMaterialId_TipoMaterial.setDisabled(true);
        }

        if (txtTipoSoporteId_TipoSoporte != null) {
            txtTipoSoporteId_TipoSoporte.setValue(null);
            txtTipoSoporteId_TipoSoporte.setDisabled(true);
        }

        if (txtRedAlimentacionId != null) {
            txtRedAlimentacionId.setValue(null);
            txtRedAlimentacionId.setDisabled(false);
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
            Integer redAlimentacionId = FacesUtils.checkInteger(txtRedAlimentacionId);
            entity = (redAlimentacionId != null)
                ? businessDelegatorView.getRedAlimentacion(redAlimentacionId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCalibreConductorAwg.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoInstalacionId_TipoInstalacion.setDisabled(false);
            txtTipoMaterialId_TipoMaterial.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtRedAlimentacionId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCalibreConductorAwg.setValue(entity.getCalibreConductorAwg());
            txtCalibreConductorAwg.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoInstalacionId_TipoInstalacion.setValue(entity.getTipoInstalacion()
                                                                .getTipoInstalacionId());
            txtTipoInstalacionId_TipoInstalacion.setDisabled(false);
            txtTipoMaterialId_TipoMaterial.setValue(entity.getTipoMaterial()
                                                          .getTipoMaterialId());
            txtTipoMaterialId_TipoMaterial.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setValue(entity.getTipoSoporte()
                                                        .getTipoSoporteId());
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtRedAlimentacionId.setValue(entity.getRedAlimentacionId());
            txtRedAlimentacionId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedRedAlimentacion = (RedAlimentacionDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedRedAlimentacion"));
        txtCalibreConductorAwg.setValue(selectedRedAlimentacion.getCalibreConductorAwg());
        txtCalibreConductorAwg.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedRedAlimentacion.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoInstalacionId_TipoInstalacion.setValue(selectedRedAlimentacion.getTipoInstalacionId_TipoInstalacion());
        txtTipoInstalacionId_TipoInstalacion.setDisabled(false);
        txtTipoMaterialId_TipoMaterial.setValue(selectedRedAlimentacion.getTipoMaterialId_TipoMaterial());
        txtTipoMaterialId_TipoMaterial.setDisabled(false);
        txtTipoSoporteId_TipoSoporte.setValue(selectedRedAlimentacion.getTipoSoporteId_TipoSoporte());
        txtTipoSoporteId_TipoSoporte.setDisabled(false);
        txtRedAlimentacionId.setValue(selectedRedAlimentacion.getRedAlimentacionId());
        txtRedAlimentacionId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedRedAlimentacion == null) && (entity == null)) {
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
            entity = new RedAlimentacion();

            Integer redAlimentacionId = FacesUtils.checkInteger(txtRedAlimentacionId);

            entity.setCalibreConductorAwg(FacesUtils.checkString(
                    txtCalibreConductorAwg));
            entity.setRedAlimentacionId(redAlimentacionId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoInstalacion((FacesUtils.checkInteger(
                    txtTipoInstalacionId_TipoInstalacion) != null)
                ? businessDelegatorView.getTipoInstalacion(
                    FacesUtils.checkInteger(
                        txtTipoInstalacionId_TipoInstalacion)) : null);
            entity.setTipoMaterial((FacesUtils.checkInteger(
                    txtTipoMaterialId_TipoMaterial) != null)
                ? businessDelegatorView.getTipoMaterial(FacesUtils.checkInteger(
                        txtTipoMaterialId_TipoMaterial)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            businessDelegatorView.saveRedAlimentacion(entity);
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
                Integer redAlimentacionId = new Integer(selectedRedAlimentacion.getRedAlimentacionId());
                entity = businessDelegatorView.getRedAlimentacion(redAlimentacionId);
            }

            entity.setCalibreConductorAwg(FacesUtils.checkString(
                    txtCalibreConductorAwg));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoInstalacion((FacesUtils.checkInteger(
                    txtTipoInstalacionId_TipoInstalacion) != null)
                ? businessDelegatorView.getTipoInstalacion(
                    FacesUtils.checkInteger(
                        txtTipoInstalacionId_TipoInstalacion)) : null);
            entity.setTipoMaterial((FacesUtils.checkInteger(
                    txtTipoMaterialId_TipoMaterial) != null)
                ? businessDelegatorView.getTipoMaterial(FacesUtils.checkInteger(
                        txtTipoMaterialId_TipoMaterial)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            businessDelegatorView.updateRedAlimentacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedRedAlimentacion = (RedAlimentacionDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedRedAlimentacion"));

            Integer redAlimentacionId = new Integer(selectedRedAlimentacion.getRedAlimentacionId());
            entity = businessDelegatorView.getRedAlimentacion(redAlimentacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer redAlimentacionId = FacesUtils.checkInteger(txtRedAlimentacionId);
            entity = businessDelegatorView.getRedAlimentacion(redAlimentacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteRedAlimentacion(entity);
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

    public String action_modifyWitDTO(String calibreConductorAwg,
        Integer redAlimentacionId, Integer idEstado_Estado,
        Integer tipoInstalacionId_TipoInstalacion,
        Integer tipoMaterialId_TipoMaterial, Integer tipoSoporteId_TipoSoporte)
        throws Exception {
        try {
            entity.setCalibreConductorAwg(FacesUtils.checkString(
                    calibreConductorAwg));
            businessDelegatorView.updateRedAlimentacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("RedAlimentacionView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCalibreConductorAwg() {
        return txtCalibreConductorAwg;
    }

    public void setTxtCalibreConductorAwg(InputText txtCalibreConductorAwg) {
        this.txtCalibreConductorAwg = txtCalibreConductorAwg;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoInstalacionId_TipoInstalacion() {
        return txtTipoInstalacionId_TipoInstalacion;
    }

    public void setTxtTipoInstalacionId_TipoInstalacion(
        InputText txtTipoInstalacionId_TipoInstalacion) {
        this.txtTipoInstalacionId_TipoInstalacion = txtTipoInstalacionId_TipoInstalacion;
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

    public InputText getTxtRedAlimentacionId() {
        return txtRedAlimentacionId;
    }

    public void setTxtRedAlimentacionId(InputText txtRedAlimentacionId) {
        this.txtRedAlimentacionId = txtRedAlimentacionId;
    }

    public List<RedAlimentacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataRedAlimentacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<RedAlimentacionDTO> redAlimentacionDTO) {
        this.data = redAlimentacionDTO;
    }

    public RedAlimentacionDTO getSelectedRedAlimentacion() {
        return selectedRedAlimentacion;
    }

    public void setSelectedRedAlimentacion(RedAlimentacionDTO redAlimentacion) {
        this.selectedRedAlimentacion = redAlimentacion;
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
