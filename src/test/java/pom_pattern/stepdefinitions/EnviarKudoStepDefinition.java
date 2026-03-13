package pom_pattern.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import pom_pattern.steps.KudosSteps;

public class EnviarKudoStepDefinition {

    @Steps
    private KudosSteps kudosSteps;

    @Dado("que el empleado se encuentra en la pantalla de {string}")
    public void queElEmpleadoSeEncuentraEnLaPantallaDe(String pantalla) {
        kudosSteps.goToCreatePage();
    }

    @Cuando("el empleado selecciona como remitente a {string}")
    public void elEmpleadoSeleccionaComoRemitenteA(String nombre) {
        kudosSteps.selectRemitente(nombre);
    }

    @Y("busca y selecciona al destinatario {string}")
    public void buscaYSeleccionaAlDestinatario(String nombre) {
        kudosSteps.selectDestinatario(nombre);
    }

    @Y("elige la categoría de reconocimiento {string}")
    public void eligeLaCategoríaDeReconocimiento(String categoria) {
        kudosSteps.selectCategoria(categoria);
    }

    @Y("escribe un mensaje de agradecimiento: {string}")
    public void escribeUnMensajeDeAgradecimiento(String mensaje) {
        kudosSteps.writeMensaje(mensaje);
    }

    @Y("desliza el control de confirmación hasta el final")
    public void deslizaElControlDeConfirmacionHastaElFinal() {
        kudosSteps.slideToSend();
    }

    @Entonces("el sistema debe mostrar una notificación de envío exitoso")
    public void elSistemaDebeMostrarUnaNotificacionDeEnvioExitoso() {
        kudosSteps.verifySuccessMessage();
    }

    @Y("los campos del formulario deben quedar vacíos para un nuevo registro")
    public void losCamposDelFormularioDebenQuedarVaciosParaUnNuevoRegistro() {
        kudosSteps.verifyFormCleaned();
    }
}
