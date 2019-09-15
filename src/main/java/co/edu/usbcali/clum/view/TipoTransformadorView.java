package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoTransformadorDTO;
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
public class TipoTransformadorView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoTransformadorView.class);
    private InputText txtNombreTipoTransformador;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoTransformadorId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoTransformadorDTO> data;
    private TipoTransformadorDTO selectedTipoTransformador;
    private TipoTransformador entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoTransformadorView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoTransformador = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoTransformador = null;

        if (txtNombreTipoTransformador != null) {
            txtNombreTipoTransformador.setValue(null);
            txtNombreTipoTransformador.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoTransformadorId != null) {
            txtTipoTransformadorId.setValue(null);
            txtTipoTransformadorId.setDisabled(false);
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
            Integer tipoTransformadorId = FacesUtils.checkInteger(txtTipoTransformadorId);
            entity = (tipoTransformadorId != null)
                ? businessDelegatorView.getTipoTransformador(tipoTransformadorId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoTransformador.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoTransformadorId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoTransformador.setValue(entity.getNombreTipoTransformador());
            txtNombreTipoTransformador.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoTransformadorId.setValue(entity.getTipoTransformadorId());
            txtTipoTransformadorId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoTransformador = (TipoTransformadorDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedTipoTransformador"));
        txtNombreTipoTransformador.setValue(selectedTipoTransformador.getNombreTipoTransformador());
        txtNombreTipoTransformador.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoTransformador.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoTransformadorId.setValue(selectedTipoTransformador.getTipoTransformadorId());
        txtTipoTransformadorId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoTransformador == null) && (entity == null)) {
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
            entity = new TipoTransformador();

            Integer tipoTransformadorId = FacesUtils.checkInteger(txtTipoTransformadorId);

            entity.setNombreTipoTransformador(FacesUtils.checkString(
                    txtNombreTipoTransformador));
            entity.setTipoTransformadorId(tipoTransformadorId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoTransformador(entity);
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
                Integer tipoTransformadorId = new Integer(selectedTipoTransformador.getTipoTransformadorId());
                entity = businessDelegatorView.getTipoTransformador(tipoTransformadorId);
            }

            entity.setNombreTipoTransformador(FacesUtils.checkString(
                    txtNombreTipoTransformador));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoTransformador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoTransformador = (TipoTransformadorDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedTipoTransformador"));

            Integer tipoTransformadorId = new Integer(selectedTipoTransformador.getTipoTransformadorId());
            entity = businessDelegatorView.getTipoTransformador(tipoTransformadorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoTransformadorId = FacesUtils.checkInteger(txtTipoTransformadorId);
            entity = businessDelegatorView.getTipoTransformador(tipoTransformadorId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoTransformador(entity);
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

    public String action_modifyWitDTO(String nombreTipoTransformador,
        Integer tipoTransformadorId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoTransformador(FacesUtils.checkString(
                    nombreTipoTransformador));
            businessDelegatorView.updateTipoTransformador(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoTransformadorView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoTransformador() {
        return txtNombreTipoTransformador;
    }

    public void setTxtNombreTipoTransformador(
        InputText txtNombreTipoTransformador) {
        this.txtNombreTipoTransformador = txtNombreTipoTransformador;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoTransformadorId() {
        return txtTipoTransformadorId;
    }

    public void setTxtTipoTransformadorId(InputText txtTipoTransformadorId) {
        this.txtTipoTransformadorId = txtTipoTransformadorId;
    }

    public List<TipoTransformadorDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoTransformador();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoTransformadorDTO> tipoTransformadorDTO) {
        this.data = tipoTransformadorDTO;
    }

    public TipoTransformadorDTO getSelectedTipoTransformador() {
        return selectedTipoTransformador;
    }

    public void setSelectedTipoTransformador(
        TipoTransformadorDTO tipoTransformador) {
        this.selectedTipoTransformador = tipoTransformador;
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
