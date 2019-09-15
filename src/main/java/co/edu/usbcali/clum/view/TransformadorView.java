package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TransformadorDTO;
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
public class TransformadorView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TransformadorView.class);
    private InputText txtIdEstado_Estado;
    private InputText txtTipoSoporteId_TipoSoporte;
    private InputText txtTipoTransformadorId_TipoTransformador;
    private InputText txtTransformadorId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TransformadorDTO> data;
    private TransformadorDTO selectedTransformador;
    private Transformador entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TransformadorView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTransformador = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTransformador = null;

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoSoporteId_TipoSoporte != null) {
            txtTipoSoporteId_TipoSoporte.setValue(null);
            txtTipoSoporteId_TipoSoporte.setDisabled(true);
        }

        if (txtTipoTransformadorId_TipoTransformador != null) {
            txtTipoTransformadorId_TipoTransformador.setValue(null);
            txtTipoTransformadorId_TipoTransformador.setDisabled(true);
        }

        if (txtTransformadorId != null) {
            txtTransformadorId.setValue(null);
            txtTransformadorId.setDisabled(false);
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
            Integer transformadorId = FacesUtils.checkInteger(txtTransformadorId);
            entity = (transformadorId != null)
                ? businessDelegatorView.getTransformador(transformadorId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtIdEstado_Estado.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtTipoTransformadorId_TipoTransformador.setDisabled(false);
            txtTransformadorId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoSoporteId_TipoSoporte.setValue(entity.getTipoSoporte()
                                                        .getTipoSoporteId());
            txtTipoSoporteId_TipoSoporte.setDisabled(false);
            txtTipoTransformadorId_TipoTransformador.setValue(entity.getTipoTransformador()
                                                                    .getTipoTransformadorId());
            txtTipoTransformadorId_TipoTransformador.setDisabled(false);
            txtTransformadorId.setValue(entity.getTransformadorId());
            txtTransformadorId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTransformador = (TransformadorDTO) (evt.getComponent()
                                                       .getAttributes()
                                                       .get("selectedTransformador"));
        txtIdEstado_Estado.setValue(selectedTransformador.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoSoporteId_TipoSoporte.setValue(selectedTransformador.getTipoSoporteId_TipoSoporte());
        txtTipoSoporteId_TipoSoporte.setDisabled(false);
        txtTipoTransformadorId_TipoTransformador.setValue(selectedTransformador.getTipoTransformadorId_TipoTransformador());
        txtTipoTransformadorId_TipoTransformador.setDisabled(false);
        txtTransformadorId.setValue(selectedTransformador.getTransformadorId());
        txtTransformadorId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTransformador == null) && (entity == null)) {
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
            entity = new Transformador();

            Integer transformadorId = FacesUtils.checkInteger(txtTransformadorId);

            entity.setTransformadorId(transformadorId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            entity.setTipoTransformador((FacesUtils.checkInteger(
                    txtTipoTransformadorId_TipoTransformador) != null)
                ? businessDelegatorView.getTipoTransformador(
                    FacesUtils.checkInteger(
                        txtTipoTransformadorId_TipoTransformador)) : null);
            businessDelegatorView.saveTransformador(entity);
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
                Integer transformadorId = new Integer(selectedTransformador.getTransformadorId());
                entity = businessDelegatorView.getTransformador(transformadorId);
            }

            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setTipoSoporte((FacesUtils.checkInteger(
                    txtTipoSoporteId_TipoSoporte) != null)
                ? businessDelegatorView.getTipoSoporte(FacesUtils.checkInteger(
                        txtTipoSoporteId_TipoSoporte)) : null);
            entity.setTipoTransformador((FacesUtils.checkInteger(
                    txtTipoTransformadorId_TipoTransformador) != null)
                ? businessDelegatorView.getTipoTransformador(
                    FacesUtils.checkInteger(
                        txtTipoTransformadorId_TipoTransformador)) : null);
            businessDelegatorView.updateTransformador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTransformador = (TransformadorDTO) (evt.getComponent()
                                                           .getAttributes()
                                                           .get("selectedTransformador"));

            Integer transformadorId = new Integer(selectedTransformador.getTransformadorId());
            entity = businessDelegatorView.getTransformador(transformadorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer transformadorId = FacesUtils.checkInteger(txtTransformadorId);
            entity = businessDelegatorView.getTransformador(transformadorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTransformador(entity);
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

    public String action_modifyWitDTO(Integer transformadorId,
        Integer idEstado_Estado, Integer tipoSoporteId_TipoSoporte,
        Integer tipoTransformadorId_TipoTransformador)
        throws Exception {
        try {
            businessDelegatorView.updateTransformador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TransformadorView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoSoporteId_TipoSoporte() {
        return txtTipoSoporteId_TipoSoporte;
    }

    public void setTxtTipoSoporteId_TipoSoporte(
        InputText txtTipoSoporteId_TipoSoporte) {
        this.txtTipoSoporteId_TipoSoporte = txtTipoSoporteId_TipoSoporte;
    }

    public InputText getTxtTipoTransformadorId_TipoTransformador() {
        return txtTipoTransformadorId_TipoTransformador;
    }

    public void setTxtTipoTransformadorId_TipoTransformador(
        InputText txtTipoTransformadorId_TipoTransformador) {
        this.txtTipoTransformadorId_TipoTransformador = txtTipoTransformadorId_TipoTransformador;
    }

    public InputText getTxtTransformadorId() {
        return txtTransformadorId;
    }

    public void setTxtTransformadorId(InputText txtTransformadorId) {
        this.txtTransformadorId = txtTransformadorId;
    }

    public List<TransformadorDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTransformador();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TransformadorDTO> transformadorDTO) {
        this.data = transformadorDTO;
    }

    public TransformadorDTO getSelectedTransformador() {
        return selectedTransformador;
    }

    public void setSelectedTransformador(TransformadorDTO transformador) {
        this.selectedTransformador = transformador;
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
