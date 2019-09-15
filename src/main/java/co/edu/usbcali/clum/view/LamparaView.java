package co.edu.usbcali.clum.view;

import co.edu.usbcali.clum.domain.*;
import co.edu.usbcali.clum.dto.LamparaDTO;
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
public class LamparaView implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(LamparaView.class);
    private InputText txtControlEncendido;
    private InputText txtFuncionamiento;
    private InputText txtLatitudLampara;
    private InputText txtLongitudLampara;
    private InputText txtNivelTension;
    private InputText txtPotencia;
    private InputText txtUrlImagen;
    private InputText txtValorPerdidas;
    private InputText txtIdEstado_Estado;
    private InputText txtRedAlimentacionId_RedAlimentacion;
    private InputText txtSoporteLamparaId_SoporteLampara;
    private InputText txtTipoBalastoId_TipoBalasto;
    private InputText txtTipoEspacioIluminadoId_TipoEspacioIluminado;
    private InputText txtTipoLamparaId_TipoLampara;
    private InputText txtTransformadorId_Transformador;
    private InputText txtLamparaId;
    private CommandButton btnSave;
    private CommandButton btnModify;
    private CommandButton btnDelete;
    private CommandButton btnClear;
    private List<LamparaDTO> data;
    private LamparaDTO selectedLampara;
    private Lampara entity;
    private boolean showDialog;
    @ManagedProperty(value = "#{businessDelegator}")
    private BusinessDelegator businessDelegatorView;

    public LamparaView() {
        super();
    }

    public String action_new() {
        action_clear();
        selectedLampara = null;
        setShowDialog(true);

        return "";
    }

    public String action_clear() {
        entity = null;
        selectedLampara = null;

        if (txtControlEncendido != null) {
            txtControlEncendido.setValue(null);
            txtControlEncendido.setDisabled(true);
        }

        if (txtFuncionamiento != null) {
            txtFuncionamiento.setValue(null);
            txtFuncionamiento.setDisabled(true);
        }

        if (txtLatitudLampara != null) {
            txtLatitudLampara.setValue(null);
            txtLatitudLampara.setDisabled(true);
        }

        if (txtLongitudLampara != null) {
            txtLongitudLampara.setValue(null);
            txtLongitudLampara.setDisabled(true);
        }

        if (txtNivelTension != null) {
            txtNivelTension.setValue(null);
            txtNivelTension.setDisabled(true);
        }

        if (txtPotencia != null) {
            txtPotencia.setValue(null);
            txtPotencia.setDisabled(true);
        }

        if (txtUrlImagen != null) {
            txtUrlImagen.setValue(null);
            txtUrlImagen.setDisabled(true);
        }

        if (txtValorPerdidas != null) {
            txtValorPerdidas.setValue(null);
            txtValorPerdidas.setDisabled(true);
        }

        if (txtIdEstado_Estado != null) {
            txtIdEstado_Estado.setValue(null);
            txtIdEstado_Estado.setDisabled(true);
        }

        if (txtRedAlimentacionId_RedAlimentacion != null) {
            txtRedAlimentacionId_RedAlimentacion.setValue(null);
            txtRedAlimentacionId_RedAlimentacion.setDisabled(true);
        }

        if (txtSoporteLamparaId_SoporteLampara != null) {
            txtSoporteLamparaId_SoporteLampara.setValue(null);
            txtSoporteLamparaId_SoporteLampara.setDisabled(true);
        }

        if (txtTipoBalastoId_TipoBalasto != null) {
            txtTipoBalastoId_TipoBalasto.setValue(null);
            txtTipoBalastoId_TipoBalasto.setDisabled(true);
        }

        if (txtTipoEspacioIluminadoId_TipoEspacioIluminado != null) {
            txtTipoEspacioIluminadoId_TipoEspacioIluminado.setValue(null);
            txtTipoEspacioIluminadoId_TipoEspacioIluminado.setDisabled(true);
        }

        if (txtTipoLamparaId_TipoLampara != null) {
            txtTipoLamparaId_TipoLampara.setValue(null);
            txtTipoLamparaId_TipoLampara.setDisabled(true);
        }

        if (txtTransformadorId_Transformador != null) {
            txtTransformadorId_Transformador.setValue(null);
            txtTransformadorId_Transformador.setDisabled(true);
        }

        if (txtLamparaId != null) {
            txtLamparaId.setValue(null);
            txtLamparaId.setDisabled(false);
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
            Integer lamparaId = FacesUtils.checkInteger(txtLamparaId);
            entity = (lamparaId != null)
                ? businessDelegatorView.getLampara(lamparaId) : null;
        } catch (Exception e) {
            entity = null;
        }

        if (entity == null) {
            txtControlEncendido.setDisabled(false);
            txtFuncionamiento.setDisabled(false);
            txtLatitudLampara.setDisabled(false);
            txtLongitudLampara.setDisabled(false);
            txtNivelTension.setDisabled(false);
            txtPotencia.setDisabled(false);
            txtUrlImagen.setDisabled(false);
            txtValorPerdidas.setDisabled(false);
            txtIdEstado_Estado.setDisabled(false);
            txtRedAlimentacionId_RedAlimentacion.setDisabled(false);
            txtSoporteLamparaId_SoporteLampara.setDisabled(false);
            txtTipoBalastoId_TipoBalasto.setDisabled(false);
            txtTipoEspacioIluminadoId_TipoEspacioIluminado.setDisabled(false);
            txtTipoLamparaId_TipoLampara.setDisabled(false);
            txtTransformadorId_Transformador.setDisabled(false);
            txtLamparaId.setDisabled(false);
            btnSave.setDisabled(false);
        } else {
            txtControlEncendido.setValue(entity.getControlEncendido());
            txtControlEncendido.setDisabled(false);
            txtFuncionamiento.setValue(entity.getFuncionamiento());
            txtFuncionamiento.setDisabled(false);
            txtLatitudLampara.setValue(entity.getLatitudLampara());
            txtLatitudLampara.setDisabled(false);
            txtLongitudLampara.setValue(entity.getLongitudLampara());
            txtLongitudLampara.setDisabled(false);
            txtNivelTension.setValue(entity.getNivelTension());
            txtNivelTension.setDisabled(false);
            txtPotencia.setValue(entity.getPotencia());
            txtPotencia.setDisabled(false);
            txtUrlImagen.setValue(entity.getUrlImagen());
            txtUrlImagen.setDisabled(false);
            txtValorPerdidas.setValue(entity.getValorPerdidas());
            txtValorPerdidas.setDisabled(false);
            txtIdEstado_Estado.setValue(entity.getEstado().getIdEstado());
            txtIdEstado_Estado.setDisabled(false);
            txtRedAlimentacionId_RedAlimentacion.setValue(entity.getRedAlimentacion()
                                                                .getRedAlimentacionId());
            txtRedAlimentacionId_RedAlimentacion.setDisabled(false);
            txtSoporteLamparaId_SoporteLampara.setValue(entity.getSoporteLampara()
                                                              .getSoporteLamparaId());
            txtSoporteLamparaId_SoporteLampara.setDisabled(false);
            txtTipoBalastoId_TipoBalasto.setValue(entity.getTipoBalasto()
                                                        .getTipoBalastoId());
            txtTipoBalastoId_TipoBalasto.setDisabled(false);
            txtTipoEspacioIluminadoId_TipoEspacioIluminado.setValue(entity.getTipoEspacioIluminado()
                                                                          .getTipoEspacioIluminadoId());
            txtTipoEspacioIluminadoId_TipoEspacioIluminado.setDisabled(false);
            txtTipoLamparaId_TipoLampara.setValue(entity.getTipoLampara()
                                                        .getTipoLamparaId());
            txtTipoLamparaId_TipoLampara.setDisabled(false);
            txtTransformadorId_Transformador.setValue(entity.getTransformador()
                                                            .getTransformadorId());
            txtTransformadorId_Transformador.setDisabled(false);
            txtLamparaId.setValue(entity.getLamparaId());
            txtLamparaId.setDisabled(true);
            btnSave.setDisabled(false);

            if (btnDelete != null) {
                btnDelete.setDisabled(false);
            }
        }
    }

    public String action_edit(ActionEvent evt) {
        selectedLampara = (LamparaDTO) (evt.getComponent().getAttributes()
                                           .get("selectedLampara"));
        txtControlEncendido.setValue(selectedLampara.getControlEncendido());
        txtControlEncendido.setDisabled(false);
        txtFuncionamiento.setValue(selectedLampara.getFuncionamiento());
        txtFuncionamiento.setDisabled(false);
        txtLatitudLampara.setValue(selectedLampara.getLatitudLampara());
        txtLatitudLampara.setDisabled(false);
        txtLongitudLampara.setValue(selectedLampara.getLongitudLampara());
        txtLongitudLampara.setDisabled(false);
        txtNivelTension.setValue(selectedLampara.getNivelTension());
        txtNivelTension.setDisabled(false);
        txtPotencia.setValue(selectedLampara.getPotencia());
        txtPotencia.setDisabled(false);
        txtUrlImagen.setValue(selectedLampara.getUrlImagen());
        txtUrlImagen.setDisabled(false);
        txtValorPerdidas.setValue(selectedLampara.getValorPerdidas());
        txtValorPerdidas.setDisabled(false);
        txtIdEstado_Estado.setValue(selectedLampara.getIdEstado_Estado());
        txtIdEstado_Estado.setDisabled(false);
        txtRedAlimentacionId_RedAlimentacion.setValue(selectedLampara.getRedAlimentacionId_RedAlimentacion());
        txtRedAlimentacionId_RedAlimentacion.setDisabled(false);
        txtSoporteLamparaId_SoporteLampara.setValue(selectedLampara.getSoporteLamparaId_SoporteLampara());
        txtSoporteLamparaId_SoporteLampara.setDisabled(false);
        txtTipoBalastoId_TipoBalasto.setValue(selectedLampara.getTipoBalastoId_TipoBalasto());
        txtTipoBalastoId_TipoBalasto.setDisabled(false);
        txtTipoEspacioIluminadoId_TipoEspacioIluminado.setValue(selectedLampara.getTipoEspacioIluminadoId_TipoEspacioIluminado());
        txtTipoEspacioIluminadoId_TipoEspacioIluminado.setDisabled(false);
        txtTipoLamparaId_TipoLampara.setValue(selectedLampara.getTipoLamparaId_TipoLampara());
        txtTipoLamparaId_TipoLampara.setDisabled(false);
        txtTransformadorId_Transformador.setValue(selectedLampara.getTransformadorId_Transformador());
        txtTransformadorId_Transformador.setDisabled(false);
        txtLamparaId.setValue(selectedLampara.getLamparaId());
        txtLamparaId.setDisabled(true);
        btnSave.setDisabled(false);
        setShowDialog(true);

        return "";
    }

    public String action_save() {
        try {
            if ((selectedLampara == null) && (entity == null)) {
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
            entity = new Lampara();

            Integer lamparaId = FacesUtils.checkInteger(txtLamparaId);

            entity.setControlEncendido(FacesUtils.checkString(
                    txtControlEncendido));
            entity.setFuncionamiento(FacesUtils.checkString(txtFuncionamiento));
            entity.setLamparaId(lamparaId);
            entity.setLatitudLampara(FacesUtils.checkDouble(txtLatitudLampara));
            entity.setLongitudLampara(FacesUtils.checkDouble(txtLongitudLampara));
            entity.setNivelTension(FacesUtils.checkInteger(txtNivelTension));
            entity.setPotencia(FacesUtils.checkInteger(txtPotencia));
            entity.setUrlImagen(FacesUtils.checkString(txtUrlImagen));
            entity.setValorPerdidas(FacesUtils.checkLong(txtValorPerdidas));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setRedAlimentacion((FacesUtils.checkInteger(
                    txtRedAlimentacionId_RedAlimentacion) != null)
                ? businessDelegatorView.getRedAlimentacion(
                    FacesUtils.checkInteger(
                        txtRedAlimentacionId_RedAlimentacion)) : null);
            entity.setSoporteLampara((FacesUtils.checkInteger(
                    txtSoporteLamparaId_SoporteLampara) != null)
                ? businessDelegatorView.getSoporteLampara(
                    FacesUtils.checkInteger(txtSoporteLamparaId_SoporteLampara))
                : null);
            entity.setTipoBalasto((FacesUtils.checkInteger(
                    txtTipoBalastoId_TipoBalasto) != null)
                ? businessDelegatorView.getTipoBalasto(FacesUtils.checkInteger(
                        txtTipoBalastoId_TipoBalasto)) : null);
            entity.setTipoEspacioIluminado((FacesUtils.checkInteger(
                    txtTipoEspacioIluminadoId_TipoEspacioIluminado) != null)
                ? businessDelegatorView.getTipoEspacioIluminado(
                    FacesUtils.checkInteger(
                        txtTipoEspacioIluminadoId_TipoEspacioIluminado)) : null);
            entity.setTipoLampara((FacesUtils.checkInteger(
                    txtTipoLamparaId_TipoLampara) != null)
                ? businessDelegatorView.getTipoLampara(FacesUtils.checkInteger(
                        txtTipoLamparaId_TipoLampara)) : null);
            entity.setTransformador((FacesUtils.checkInteger(
                    txtTransformadorId_Transformador) != null)
                ? businessDelegatorView.getTransformador(
                    FacesUtils.checkInteger(txtTransformadorId_Transformador))
                : null);
            businessDelegatorView.saveLampara(entity);
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
                Integer lamparaId = new Integer(selectedLampara.getLamparaId());
                entity = businessDelegatorView.getLampara(lamparaId);
            }

            entity.setControlEncendido(FacesUtils.checkString(
                    txtControlEncendido));
            entity.setFuncionamiento(FacesUtils.checkString(txtFuncionamiento));
            entity.setLatitudLampara(FacesUtils.checkDouble(txtLatitudLampara));
            entity.setLongitudLampara(FacesUtils.checkDouble(txtLongitudLampara));
            entity.setNivelTension(FacesUtils.checkInteger(txtNivelTension));
            entity.setPotencia(FacesUtils.checkInteger(txtPotencia));
            entity.setUrlImagen(FacesUtils.checkString(txtUrlImagen));
            entity.setValorPerdidas(FacesUtils.checkLong(txtValorPerdidas));
            entity.setEstado((FacesUtils.checkInteger(txtIdEstado_Estado) != null)
                ? businessDelegatorView.getEstado(FacesUtils.checkInteger(
                        txtIdEstado_Estado)) : null);
            entity.setRedAlimentacion((FacesUtils.checkInteger(
                    txtRedAlimentacionId_RedAlimentacion) != null)
                ? businessDelegatorView.getRedAlimentacion(
                    FacesUtils.checkInteger(
                        txtRedAlimentacionId_RedAlimentacion)) : null);
            entity.setSoporteLampara((FacesUtils.checkInteger(
                    txtSoporteLamparaId_SoporteLampara) != null)
                ? businessDelegatorView.getSoporteLampara(
                    FacesUtils.checkInteger(txtSoporteLamparaId_SoporteLampara))
                : null);
            entity.setTipoBalasto((FacesUtils.checkInteger(
                    txtTipoBalastoId_TipoBalasto) != null)
                ? businessDelegatorView.getTipoBalasto(FacesUtils.checkInteger(
                        txtTipoBalastoId_TipoBalasto)) : null);
            entity.setTipoEspacioIluminado((FacesUtils.checkInteger(
                    txtTipoEspacioIluminadoId_TipoEspacioIluminado) != null)
                ? businessDelegatorView.getTipoEspacioIluminado(
                    FacesUtils.checkInteger(
                        txtTipoEspacioIluminadoId_TipoEspacioIluminado)) : null);
            entity.setTipoLampara((FacesUtils.checkInteger(
                    txtTipoLamparaId_TipoLampara) != null)
                ? businessDelegatorView.getTipoLampara(FacesUtils.checkInteger(
                        txtTipoLamparaId_TipoLampara)) : null);
            entity.setTransformador((FacesUtils.checkInteger(
                    txtTransformadorId_Transformador) != null)
                ? businessDelegatorView.getTransformador(
                    FacesUtils.checkInteger(txtTransformadorId_Transformador))
                : null);
            businessDelegatorView.updateLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            data = null;
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_datatable(ActionEvent evt) {
        try {
            selectedLampara = (LamparaDTO) (evt.getComponent().getAttributes()
                                               .get("selectedLampara"));

            Integer lamparaId = new Integer(selectedLampara.getLamparaId());
            entity = businessDelegatorView.getLampara(lamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public String action_delete_master() {
        try {
            Integer lamparaId = FacesUtils.checkInteger(txtLamparaId);
            entity = businessDelegatorView.getLampara(lamparaId);
            action_delete();
        } catch (Exception e) {
            FacesUtils.addErrorMessage(e.getMessage());
        }

        return "";
    }

    public void action_delete() throws Exception {
        try {
            businessDelegatorView.deleteLampara(entity);
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

    public String action_modifyWitDTO(String controlEncendido,
        String funcionamiento, Integer lamparaId, Double latitudLampara,
        Double longitudLampara, Integer nivelTension, Integer potencia,
        String urlImagen, Long valorPerdidas, Integer idEstado_Estado,
        Integer redAlimentacionId_RedAlimentacion,
        Integer soporteLamparaId_SoporteLampara,
        Integer tipoBalastoId_TipoBalasto,
        Integer tipoEspacioIluminadoId_TipoEspacioIluminado,
        Integer tipoLamparaId_TipoLampara, Integer transformadorId_Transformador)
        throws Exception {
        try {
            entity.setControlEncendido(FacesUtils.checkString(controlEncendido));
            entity.setFuncionamiento(FacesUtils.checkString(funcionamiento));
            entity.setLatitudLampara(FacesUtils.checkDouble(latitudLampara));
            entity.setLongitudLampara(FacesUtils.checkDouble(longitudLampara));
            entity.setNivelTension(FacesUtils.checkInteger(nivelTension));
            entity.setPotencia(FacesUtils.checkInteger(potencia));
            entity.setUrlImagen(FacesUtils.checkString(urlImagen));
            entity.setValorPerdidas(FacesUtils.checkLong(valorPerdidas));
            businessDelegatorView.updateLampara(entity);
            FacesUtils.addInfoMessage(ZMessManager.ENTITY_SUCCESFULLYMODIFIED);
        } catch (Exception e) {
            //renderManager.getOnDemandRenderer("LamparaView").requestRender();
            FacesUtils.addErrorMessage(e.getMessage());
            throw e;
        }

        return "";
    }

    public InputText getTxtControlEncendido() {
        return txtControlEncendido;
    }

    public void setTxtControlEncendido(InputText txtControlEncendido) {
        this.txtControlEncendido = txtControlEncendido;
    }

    public InputText getTxtFuncionamiento() {
        return txtFuncionamiento;
    }

    public void setTxtFuncionamiento(InputText txtFuncionamiento) {
        this.txtFuncionamiento = txtFuncionamiento;
    }

    public InputText getTxtLatitudLampara() {
        return txtLatitudLampara;
    }

    public void setTxtLatitudLampara(InputText txtLatitudLampara) {
        this.txtLatitudLampara = txtLatitudLampara;
    }

    public InputText getTxtLongitudLampara() {
        return txtLongitudLampara;
    }

    public void setTxtLongitudLampara(InputText txtLongitudLampara) {
        this.txtLongitudLampara = txtLongitudLampara;
    }

    public InputText getTxtNivelTension() {
        return txtNivelTension;
    }

    public void setTxtNivelTension(InputText txtNivelTension) {
        this.txtNivelTension = txtNivelTension;
    }

    public InputText getTxtPotencia() {
        return txtPotencia;
    }

    public void setTxtPotencia(InputText txtPotencia) {
        this.txtPotencia = txtPotencia;
    }

    public InputText getTxtUrlImagen() {
        return txtUrlImagen;
    }

    public void setTxtUrlImagen(InputText txtUrlImagen) {
        this.txtUrlImagen = txtUrlImagen;
    }

    public InputText getTxtValorPerdidas() {
        return txtValorPerdidas;
    }

    public void setTxtValorPerdidas(InputText txtValorPerdidas) {
        this.txtValorPerdidas = txtValorPerdidas;
    }

    public InputText getTxtIdEstado_Estado() {
        return txtIdEstado_Estado;
    }

    public void setTxtIdEstado_Estado(InputText txtIdEstado_Estado) {
        this.txtIdEstado_Estado = txtIdEstado_Estado;
    }

    public InputText getTxtRedAlimentacionId_RedAlimentacion() {
        return txtRedAlimentacionId_RedAlimentacion;
    }

    public void setTxtRedAlimentacionId_RedAlimentacion(
        InputText txtRedAlimentacionId_RedAlimentacion) {
        this.txtRedAlimentacionId_RedAlimentacion = txtRedAlimentacionId_RedAlimentacion;
    }

    public InputText getTxtSoporteLamparaId_SoporteLampara() {
        return txtSoporteLamparaId_SoporteLampara;
    }

    public void setTxtSoporteLamparaId_SoporteLampara(
        InputText txtSoporteLamparaId_SoporteLampara) {
        this.txtSoporteLamparaId_SoporteLampara = txtSoporteLamparaId_SoporteLampara;
    }

    public InputText getTxtTipoBalastoId_TipoBalasto() {
        return txtTipoBalastoId_TipoBalasto;
    }

    public void setTxtTipoBalastoId_TipoBalasto(
        InputText txtTipoBalastoId_TipoBalasto) {
        this.txtTipoBalastoId_TipoBalasto = txtTipoBalastoId_TipoBalasto;
    }

    public InputText getTxtTipoEspacioIluminadoId_TipoEspacioIluminado() {
        return txtTipoEspacioIluminadoId_TipoEspacioIluminado;
    }

    public void setTxtTipoEspacioIluminadoId_TipoEspacioIluminado(
        InputText txtTipoEspacioIluminadoId_TipoEspacioIluminado) {
        this.txtTipoEspacioIluminadoId_TipoEspacioIluminado = txtTipoEspacioIluminadoId_TipoEspacioIluminado;
    }

    public InputText getTxtTipoLamparaId_TipoLampara() {
        return txtTipoLamparaId_TipoLampara;
    }

    public void setTxtTipoLamparaId_TipoLampara(
        InputText txtTipoLamparaId_TipoLampara) {
        this.txtTipoLamparaId_TipoLampara = txtTipoLamparaId_TipoLampara;
    }

    public InputText getTxtTransformadorId_Transformador() {
        return txtTransformadorId_Transformador;
    }

    public void setTxtTransformadorId_Transformador(
        InputText txtTransformadorId_Transformador) {
        this.txtTransformadorId_Transformador = txtTransformadorId_Transformador;
    }

    public InputText getTxtLamparaId() {
        return txtLamparaId;
    }

    public void setTxtLamparaId(InputText txtLamparaId) {
        this.txtLamparaId = txtLamparaId;
    }

    public List<LamparaDTO> getData() {
        try {
            if (data == null) {
                data = businessDelegatorView.getDataLampara();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public void setData(List<LamparaDTO> lamparaDTO) {
        this.data = lamparaDTO;
    }

    public LamparaDTO getSelectedLampara() {
        return selectedLampara;
    }

    public void setSelectedLampara(LamparaDTO lampara) {
        this.selectedLampara = lampara;
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
