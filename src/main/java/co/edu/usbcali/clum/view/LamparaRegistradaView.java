package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.LamparaRegistradaDTO;
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
public class LamparaRegistradaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LamparaRegistradaView.class);
    private InputText txtLatitudPosActualTecnico;
    private InputText txtLongitudPosActualTecnico;
    private InputText txtLamparaId_Lampara;
    private InputText txtUsuarioId_Usuario;
    private InputText txtLamparaRegistradaId;
    private Calendar txtFechaHora;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LamparaRegistradaDTO> data;
    private LamparaRegistradaDTO selectedLamparaRegistrada;
    private LamparaRegistrada entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public LamparaRegistradaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedLamparaRegistrada = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLamparaRegistrada = null;

        if (txtLatitudPosActualTecnico != null) {
            txtLatitudPosActualTecnico.setValue(null);
            txtLatitudPosActualTecnico.setDisabled(true);
        }

        if (txtLongitudPosActualTecnico != null) {
            txtLongitudPosActualTecnico.setValue(null);
            txtLongitudPosActualTecnico.setDisabled(true);
        }

        if (txtLamparaId_Lampara != null) {
            txtLamparaId_Lampara.setValue(null);
            txtLamparaId_Lampara.setDisabled(true);
        }

        if (txtUsuarioId_Usuario != null) {
            txtUsuarioId_Usuario.setValue(null);
            txtUsuarioId_Usuario.setDisabled(true);
        }

        if (txtFechaHora != null) {
            txtFechaHora.setValue(null);
            txtFechaHora.setDisabled(true);
        }

        if (txtLamparaRegistradaId != null) {
            txtLamparaRegistradaId.setValue(null);
            txtLamparaRegistradaId.setDisabled(false);
        }

        if (btnSave != null) {
            btnSave.setDisabled(true);
        }

        if (btnDelete != null) {
            btnDelete.setDisabled(true);
        }

        return "";
    }

    public void listener_txtFechaHora() {
        Date inputDate = (Date) txtFechaHora.getValue();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        FacesContext.getCurrentInstance()
                    .addMessage("",
            new FacesMessage("Selected Date " + dateFormat.format(inputDate)));
    }

    public void listener_txtId() {
        try {
            Integer lamparaRegistradaId = FacesUtils.checkInteger(txtLamparaRegistradaId);
            entity = (lamparaRegistradaId != null)
                ? businessDelegatorView.getLamparaRegistrada(lamparaRegistradaId)
                : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtLatitudPosActualTecnico.setDisabled(false);
            txtLongitudPosActualTecnico.setDisabled(false);
            txtLamparaId_Lampara.setDisabled(false);
            txtUsuarioId_Usuario.setDisabled(false);
            txtFechaHora.setDisabled(false);
            txtLamparaRegistradaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtFechaHora.setValue(entity.getFechaHora());
            txtFechaHora.setDisabled(false);
            txtLatitudPosActualTecnico.setValue(entity.getLatitudPosActualTecnico());
            txtLatitudPosActualTecnico.setDisabled(false);
            txtLongitudPosActualTecnico.setValue(entity.getLongitudPosActualTecnico());
            txtLongitudPosActualTecnico.setDisabled(false);
            txtLamparaId_Lampara.setValue(entity.getLampara().getLamparaId());
            txtLamparaId_Lampara.setDisabled(false);
            txtUsuarioId_Usuario.setValue(entity.getUsuario().getUsuarioId());
            txtUsuarioId_Usuario.setDisabled(false);
            txtLamparaRegistradaId.setValue(entity.getLamparaRegistradaId());
            txtLamparaRegistradaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLamparaRegistrada = (LamparaRegistradaDTO) (evt.getComponent()
                                                               .getAttributes()
                                                               .get("selectedLamparaRegistrada"));
        txtFechaHora.setValue(selectedLamparaRegistrada.getFechaHora());
        txtFechaHora.setDisabled(false);
        txtLatitudPosActualTecnico.setValue(selectedLamparaRegistrada.getLatitudPosActualTecnico());
        txtLatitudPosActualTecnico.setDisabled(false);
        txtLongitudPosActualTecnico.setValue(selectedLamparaRegistrada.getLongitudPosActualTecnico());
        txtLongitudPosActualTecnico.setDisabled(false);
        txtLamparaId_Lampara.setValue(selectedLamparaRegistrada.getLamparaId_Lampara());
        txtLamparaId_Lampara.setDisabled(false);
        txtUsuarioId_Usuario.setValue(selectedLamparaRegistrada.getUsuarioId_Usuario());
        txtUsuarioId_Usuario.setDisabled(false);
        txtLamparaRegistradaId.setValue(selectedLamparaRegistrada.getLamparaRegistradaId());
        txtLamparaRegistradaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLamparaRegistrada == null) && (entity == null)) {
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
            entity = new LamparaRegistrada();

            Integer lamparaRegistradaId = FacesUtils.checkInteger(txtLamparaRegistradaId);

            entity.setFechaHora(FacesUtils.checkDate(txtFechaHora));
            entity.setLamparaRegistradaId(lamparaRegistradaId);
            entity.setLatitudPosActualTecnico(FacesUtils.checkDouble(
                    txtLatitudPosActualTecnico));
            entity.setLongitudPosActualTecnico(FacesUtils.checkDouble(
                    txtLongitudPosActualTecnico));
            entity.setLampara((FacesUtils.checkInteger(txtLamparaId_Lampara) != null)
                ? businessDelegatorView.getLampara(FacesUtils.checkInteger(
                        txtLamparaId_Lampara)) : null);
            entity.setUsuario((FacesUtils.checkString(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkString(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.saveLamparaRegistrada(entity);
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
                Integer lamparaRegistradaId = new Integer(selectedLamparaRegistrada.getLamparaRegistradaId());
                entity = businessDelegatorView.getLamparaRegistrada(lamparaRegistradaId);
            }

            entity.setFechaHora(FacesUtils.checkDate(txtFechaHora));
            entity.setLatitudPosActualTecnico(FacesUtils.checkDouble(
                    txtLatitudPosActualTecnico));
            entity.setLongitudPosActualTecnico(FacesUtils.checkDouble(
                    txtLongitudPosActualTecnico));
            entity.setLampara((FacesUtils.checkInteger(txtLamparaId_Lampara) != null)
                ? businessDelegatorView.getLampara(FacesUtils.checkInteger(
                        txtLamparaId_Lampara)) : null);
            entity.setUsuario((FacesUtils.checkString(txtUsuarioId_Usuario) != null)
                ? businessDelegatorView.getUsuario(FacesUtils.checkString(
                        txtUsuarioId_Usuario)) : null);
            businessDelegatorView.updateLamparaRegistrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLamparaRegistrada = (LamparaRegistradaDTO) (evt.getComponent()
                                                                   .getAttributes()
                                                                   .get("selectedLamparaRegistrada"));

            Integer lamparaRegistradaId = new Integer(selectedLamparaRegistrada.getLamparaRegistradaId());
            entity = businessDelegatorView.getLamparaRegistrada(lamparaRegistradaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer lamparaRegistradaId = FacesUtils.checkInteger(txtLamparaRegistradaId);
            entity = businessDelegatorView.getLamparaRegistrada(lamparaRegistradaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLamparaRegistrada(entity);
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

    public String action_modifyWitDTO(Date fechaHora,
        Integer lamparaRegistradaId, Double latitudPosActualTecnico,
        Double longitudPosActualTecnico, Integer lamparaId_Lampara,
        String usuarioId_Usuario) throws Exception {
        try {
            entity.setFechaHora(FacesUtils.checkDate(fechaHora));
            entity.setLatitudPosActualTecnico(FacesUtils.checkDouble(
                    latitudPosActualTecnico));
            entity.setLongitudPosActualTecnico(FacesUtils.checkDouble(
                    longitudPosActualTecnico));
            businessDelegatorView.updateLamparaRegistrada(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LamparaRegistradaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtLatitudPosActualTecnico() {
        return txtLatitudPosActualTecnico;
    }

    public void setTxtLatitudPosActualTecnico(
        InputText txtLatitudPosActualTecnico) {
        this.txtLatitudPosActualTecnico = txtLatitudPosActualTecnico;
    }

    public InputText getTxtLongitudPosActualTecnico() {
        return txtLongitudPosActualTecnico;
    }

    public void setTxtLongitudPosActualTecnico(
        InputText txtLongitudPosActualTecnico) {
        this.txtLongitudPosActualTecnico = txtLongitudPosActualTecnico;
    }

    public InputText getTxtLamparaId_Lampara() {
        return txtLamparaId_Lampara;
    }

    public void setTxtLamparaId_Lampara(InputText txtLamparaId_Lampara) {
        this.txtLamparaId_Lampara = txtLamparaId_Lampara;
    }

    public InputText getTxtUsuarioId_Usuario() {
        return txtUsuarioId_Usuario;
    }

    public void setTxtUsuarioId_Usuario(InputText txtUsuarioId_Usuario) {
        this.txtUsuarioId_Usuario = txtUsuarioId_Usuario;
    }

    public Calendar getTxtFechaHora() {
        return txtFechaHora;
    }

    public void setTxtFechaHora(Calendar txtFechaHora) {
        this.txtFechaHora = txtFechaHora;
    }

    public InputText getTxtLamparaRegistradaId() {
        return txtLamparaRegistradaId;
    }

    public void setTxtLamparaRegistradaId(InputText txtLamparaRegistradaId) {
        this.txtLamparaRegistradaId = txtLamparaRegistradaId;
    }

    public List<LamparaRegistradaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLamparaRegistrada();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LamparaRegistradaDTO> lamparaRegistradaDTO) {
        this.data = lamparaRegistradaDTO;
    }

    public LamparaRegistradaDTO getSelectedLamparaRegistrada() {
        return selectedLamparaRegistrada;
    }

    public void setSelectedLamparaRegistrada(
        LamparaRegistradaDTO lamparaRegistrada) {
        this.selectedLamparaRegistrada = lamparaRegistrada;
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
