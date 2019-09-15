package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.CanalizacionDTO;
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
public class CanalizacionView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(CanalizacionView.class);
    private InputText txtCajaInspeccion;
    private InputText txtDucteria;
    private InputText txtIdEstado_Estado;
    private InputText txtLamparaId_Lampara;
    private InputText txtTipoSoporteId_TipoSoporte;
    private InputText txtTipoZonaId_TipoZona;
    private InputText txtCanalizacionId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<CanalizacionDTO> data;
    private CanalizacionDTO selectedCanalizacion;
    private Canalizacion entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public CanalizacionView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedCanalizacion = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedCanalizacion = null;

        if (txtCajaInspeccion != null) {
            txtCajaInspeccion.setValue(null);
            txtCajaInspeccion.setDisabled(true);
        }

        if (txtDucteria != null) {
            txtDucteria.setValue(null);
            txtDucteria.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtLamparaId_Lampara != null) {
            txtLamparaId_Lampara.setValue(null);
            txtLamparaId_Lampara.setDisabled(true);
        }

        if (txtTipoSoporteId_TipoSoporte != null) {
            txtTipoSoporteId_TipoSoporte.setValue(null);
            txtTipoSoporteId_TipoSoporte.setDisabled(true);
        }

        if (txtTipoZonaId_TipoZona != null) {
            txtTipoZonaId_TipoZona.setValue(null);
            txtTipoZonaId_TipoZona.setDisabled(true);
        }

        if (txtCanalizacionId != null) {
            txtCanalizacionId.setValue(null);
            txtCanalizacionId.setDisabled(false);
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
            Integer canalizacionId = FacesUtils.checkInteger(txtCanalizacionId);
            entity = (canalizacionId != null)
                ? businessDelegatorView.getCanalizacion(canalizacionId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtCajaInspeccion.setDisabled(false);
            txtDucteria.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtLamparaId_Lampara.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtTipoZonaId_TipoZona.setDisabled(false);
            txtCanalizacionId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtCajaInspeccion.setValue(entity.getCajaInspeccion());
            txtCajaInspeccion.setDisabled(false);
            txtDucteria.setValue(entity.getDucteria());
            txtDucteria.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtLamparaId_Lampara.setValue(entity.getLampara().getLamparaId());
            txtLamparaId_Lampara.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setValue(entity.getTipoSoporte()
                                                        .getTipoSoporteId());
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtTipoZonaId_TipoZona.setValue(entity.getTipoZona().getTipoZonaId());
            txtTipoZonaId_TipoZona.setDisabled(false);
            txtCanalizacionId.setValue(entity.getCanalizacionId());
            txtCanalizacionId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedCanalizacion = (CanalizacionDTO) (evt.getComponent()
                                                     .getAttributes()
                                                     .get("selectedCanalizacion"));
        txtCajaInspeccion.setValue(selectedCanalizacion.getCajaInspeccion());
        txtCajaInspeccion.setDisabled(false);
        txtDucteria.setValue(selectedCanalizacion.getDucteria());
        txtDucteria.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedCanalizacion.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtLamparaId_Lampara.setValue(selectedCanalizacion.getLamparaId_Lampara());
        txtLamparaId_Lampara.setDisabled(false);
        txtTipoSoporteId_TipoSoporte.setValue(selectedCanalizacion.getTipoSoporteId_TipoSoporte());
        txtTipoSoporteId_TipoSoporte.setDisabled(false);
        txtTipoZonaId_TipoZona.setValue(selectedCanalizacion.getTipoZonaId_TipoZona());
        txtTipoZonaId_TipoZona.setDisabled(false);
        txtCanalizacionId.setValue(selectedCanalizacion.getCanalizacionId());
        txtCanalizacionId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedCanalizacion == null) && (entity == null)) {
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
            entity = new Canalizacion();

            Integer canalizacionId = FacesUtils.checkInteger(txtCanalizacionId);

            entity.setCajaInspeccion(FacesUtils.checkString(txtCajaInspeccion));
            entity.setCanalizacionId(canalizacionId);
            entity.setDucteria(FacesUtils.checkString(txtDucteria));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setLampara((FacesUtils.checkInteger(txtLamparaId_Lampara) != null)
                ? businessDelegatorView.getLampara(FacesUtils.checkInteger(
                        txtLamparaId_Lampara)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            entity.setTipoZona((FacesUtils.checkInteger(txtTipoZonaId_TipoZona) != null)
                ? businessDelegatorView.getTipoZona(FacesUtils.checkInteger(
                        txtTipoZonaId_TipoZona)) : null);
            businessDelegatorView.saveCanalizacion(entity);
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
                Integer canalizacionId = new Integer(selectedCanalizacion.getCanalizacionId());
                entity = businessDelegatorView.getCanalizacion(canalizacionId);
            }

            entity.setCajaInspeccion(FacesUtils.checkString(txtCajaInspeccion));
            entity.setDucteria(FacesUtils.checkString(txtDucteria));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setLampara((FacesUtils.checkInteger(txtLamparaId_Lampara) != null)
                ? businessDelegatorView.getLampara(FacesUtils.checkInteger(
                        txtLamparaId_Lampara)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            entity.setTipoZona((FacesUtils.checkInteger(txtTipoZonaId_TipoZona) != null)
                ? businessDelegatorView.getTipoZona(FacesUtils.checkInteger(
                        txtTipoZonaId_TipoZona)) : null);
            businessDelegatorView.updateCanalizacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedCanalizacion = (CanalizacionDTO) (evt.getComponent()
                                                         .getAttributes()
                                                         .get("selectedCanalizacion"));

            Integer canalizacionId = new Integer(selectedCanalizacion.getCanalizacionId());
            entity = businessDelegatorView.getCanalizacion(canalizacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer canalizacionId = FacesUtils.checkInteger(txtCanalizacionId);
            entity = businessDelegatorView.getCanalizacion(canalizacionId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteCanalizacion(entity);
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

    public String action_modifyWitDTO(String cajaInspeccion,
        Integer canalizacionId, String ducteria, Integer idEstado_Estado,
        Integer lamparaId_Lampara, Integer tipoSoporteId_TipoSoporte,
        Integer tipoZonaId_TipoZona) throws Exception {
        try {
            entity.setCajaInspeccion(FacesUtils.checkString(cajaInspeccion));
            entity.setDucteria(FacesUtils.checkString(ducteria));
            businessDelegatorView.updateCanalizacion(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("CanalizacionView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtCajaInspeccion() {
        return txtCajaInspeccion;
    }

    public void setTxtCajaInspeccion(InputText txtCajaInspeccion) {
        this.txtCajaInspeccion = txtCajaInspeccion;
    }

    public InputText getTxtDucteria() {
        return txtDucteria;
    }

    public void setTxtDucteria(InputText txtDucteria) {
        this.txtDucteria = txtDucteria;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtLamparaId_Lampara() {
        return txtLamparaId_Lampara;
    }

    public void setTxtLamparaId_Lampara(InputText txtLamparaId_Lampara) {
        this.txtLamparaId_Lampara = txtLamparaId_Lampara;
    }

    public InputText getTxtTipoSoporteId_TipoSoporte() {
        return txtTipoSoporteId_TipoSoporte;
    }

    public void setTxtTipoSoporteId_TipoSoporte(
        InputText txtTipoSoporteId_TipoSoporte) {
        this.txtTipoSoporteId_TipoSoporte = txtTipoSoporteId_TipoSoporte;
    }

    public InputText getTxtTipoZonaId_TipoZona() {
        return txtTipoZonaId_TipoZona;
    }

    public void setTxtTipoZonaId_TipoZona(InputText txtTipoZonaId_TipoZona) {
        this.txtTipoZonaId_TipoZona = txtTipoZonaId_TipoZona;
    }

    public InputText getTxtCanalizacionId() {
        return txtCanalizacionId;
    }

    public void setTxtCanalizacionId(InputText txtCanalizacionId) {
        this.txtCanalizacionId = txtCanalizacionId;
    }

    public List<CanalizacionDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataCanalizacion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<CanalizacionDTO> canalizacionDTO) {
        this.data = canalizacionDTO;
    }

    public CanalizacionDTO getSelectedCanalizacion() {
        return selectedCanalizacion;
    }

    public void setSelectedCanalizacion(CanalizacionDTO canalizacion) {
        this.selectedCanalizacion = canalizacion;
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
