package pom_pattern.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pom_pattern.steps.KudosSteps;

public class EnviarKudoStepDefinition {

    @Steps
    private KudosSteps kudosSteps;

    @Given("que el empleado se encuentra en la pantalla de {string}")
    public void queElEmpleadoSeEncuentraEnLaPantallaDe(String pantalla) {
        kudosSteps.goToCreatePage();
    }

    @When("el empleado selecciona como remitente a {string}")
    public void elEmpleadoSeleccionaComoRemitenteA(String nombre) {
        kudosSteps.selectRemitente(nombre);
    }

    @And("busca y selecciona al destinatario {string}")
    public void buscaYSeleccionaAlDestinatario(String nombre) {
        kudosSteps.selectDestinatario(nombre);
    }

    @And("elige la categoría de reconocimiento {string}")
    public void eligeLaCategoríaDeReconocimiento(String categoria) {
        kudosSteps.selectCategoria(categoria);
    }

    @And("escribe un mensaje de agradecimiento: {string}")
    public void escribeUnMensajeDeAgradecimiento(String mensaje) {
        kudosSteps.writeMensaje(mensaje);
    }

    @And("desliza el control de confirmación hasta el final")
    public void deslizaElControlDeConfirmacionHastaElFinal() {
        kudosSteps.slideToSend();
    }

    @Then("el sistema debe mostrar una notificación de envío exitoso")
    public void elSistemaDebeMostrarUnaNotificacionDeEnvioExitoso() {
        kudosSteps.verifySuccessMessage();
    }

    @And("los campos del formulario deben quedar vacíos para un nuevo registro")
    public void losCamposDelFormularioDebenQuedarVaciosParaUnNuevoRegistro() {
        kudosSteps.verifyFormCleaned();
    }
}
