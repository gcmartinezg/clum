package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.TipoEspacioIluminadoDTO;
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
public class TipoEspacioIluminadoView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TipoEspacioIluminadoView.class);
    private InputText txtNombreTipoEspacioIluminado;
    private InputText txtIdEstado_Estado;
    private InputText txtTipoEspacioIluminadoId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<TipoEspacioIluminadoDTO> data;
    private TipoEspacioIluminadoDTO selectedTipoEspacioIluminado;
    private TipoEspacioIluminado entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public TipoEspacioIluminadoView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedTipoEspacioIluminado = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedTipoEspacioIluminado = null;

        if (txtNombreTipoEspacioIluminado != null) {
            txtNombreTipoEspacioIluminado.setValue(null);
            txtNombreTipoEspacioIluminado.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtTipoEspacioIluminadoId != null) {
            txtTipoEspacioIluminadoId.setValue(null);
            txtTipoEspacioIluminadoId.setDisabled(false);
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
            Integer tipoEspacioIluminadoId = FacesUtils.checkInteger(txtTipoEspacioIluminadoId);
            entity = (tipoEspacioIluminadoId != null)
                ? businessDelegatorView.getTipoEspacioIluminado(tipoEspacioIluminadoId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtNombreTipoEspacioIluminado.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtTipoEspacioIluminadoId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtNombreTipoEspacioIluminado.setValue(entity.getNombreTipoEspacioIluminado());
            txtNombreTipoEspacioIluminado.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtTipoEspacioIluminadoId.setValue(entity.getTipoEspacioIluminadoId());
            txtTipoEspacioIluminadoId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedTipoEspacioIluminado = (TipoEspacioIluminadoDTO) (evt.getComponent()
                                                                     .getAttributes()
                                                                     .get("selectedTipoEspacioIluminado"));
        txtNombreTipoEspacioIluminado.setValue(selectedTipoEspacioIluminado.getNombreTipoEspacioIluminado());
        txtNombreTipoEspacioIluminado.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedTipoEspacioIluminado.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtTipoEspacioIluminadoId.setValue(selectedTipoEspacioIluminado.getTipoEspacioIluminadoId());
        txtTipoEspacioIluminadoId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedTipoEspacioIluminado == null) && (entity == null)) {
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
            entity = new TipoEspacioIluminado();

            Integer tipoEspacioIluminadoId = FacesUtils.checkInteger(txtTipoEspacioIluminadoId);

            entity.setNombreTipoEspacioIluminado(FacesUtils.checkString(
                    txtNombreTipoEspacioIluminado));
            entity.setTipoEspacioIluminadoId(tipoEspacioIluminadoId);
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.saveTipoEspacioIluminado(entity);
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
                Integer tipoEspacioIluminadoId = new Integer(selectedTipoEspacioIluminado.getTipoEspacioIluminadoId());
                entity = businessDelegatorView.getTipoEspacioIluminado(tipoEspacioIluminadoId);
            }

            entity.setNombreTipoEspacioIluminado(FacesUtils.checkString(
                    txtNombreTipoEspacioIluminado));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            businessDelegatorView.updateTipoEspacioIluminado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedTipoEspacioIluminado = (TipoEspacioIluminadoDTO) (evt.getComponent()
                                                                         .getAttributes()
                                                                         .get("selectedTipoEspacioIluminado"));

            Integer tipoEspacioIluminadoId = new Integer(selectedTipoEspacioIluminado.getTipoEspacioIluminadoId());
            entity = businessDelegatorView.getTipoEspacioIluminado(tipoEspacioIluminadoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer tipoEspacioIluminadoId = FacesUtils.checkInteger(txtTipoEspacioIluminadoId);
            entity = businessDelegatorView.getTipoEspacioIluminado(tipoEspacioIluminadoId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteTipoEspacioIluminado(entity);
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

    public String action_modifyWitDTO(String nombreTipoEspacioIluminado,
        Integer tipoEspacioIluminadoId, Integer idEstado_Estado)
        throws Exception {
        try {
            entity.setNombreTipoEspacioIluminado(FacesUtils.checkString(
                    nombreTipoEspacioIluminado));
            businessDelegatorView.updateTipoEspacioIluminado(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("TipoEspacioIluminadoView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtNombreTipoEspacioIluminado() {
        return txtNombreTipoEspacioIluminado;
    }

    public void setTxtNombreTipoEspacioIluminado(
        InputText txtNombreTipoEspacioIluminado) {
        this.txtNombreTipoEspacioIluminado = txtNombreTipoEspacioIluminado;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtTipoEspacioIluminadoId() {
        return txtTipoEspacioIluminadoId;
    }

    public void setTxtTipoEspacioIluminadoId(
        InputText txtTipoEspacioIluminadoId) {
        this.txtTipoEspacioIluminadoId = txtTipoEspacioIluminadoId;
    }

    public List<TipoEspacioIluminadoDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataTipoEspacioIluminado();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<TipoEspacioIluminadoDTO> tipoEspacioIluminadoDTO) {
        this.data = tipoEspacioIluminadoDTO;
    }

    public TipoEspacioIluminadoDTO getSelectedTipoEspacioIluminado() {
        return selectedTipoEspacioIluminado;
    }

    public void setSelectedTipoEspacioIluminado(
        TipoEspacioIluminadoDTO tipoEspacioIluminado) {
        this.selectedTipoEspacioIluminado = tipoEspacioIluminado;
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
