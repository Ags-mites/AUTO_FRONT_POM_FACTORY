package pom_pattern.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pom_pattern.steps.KudosSteps;

import java.util.Map;

public class ListarKudosStepDefinition {

    @Steps
    private KudosSteps kudosSteps;

    @Given("que el sistema SofkianOS se encuentra operativo")
    public void queElSistemaSofkianOSSeEncuentraOperativo() {
    }

    @And("el usuario accede a la URL del {string}")
    public void elUsuarioAccedeALaURLDel(String seccion) {
        kudosSteps.openKudosList();
        kudosSteps.clickExplorarKudos();
    }

    @Given("que se realiza una petición POST al endpoint de Kudos con:")
    public void queSeRealizaUnaPeticionPOSTAlEndpointDeKudosCon(DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        kudosSteps.createKudoViaApi(data);
    }

    @And("la respuesta del servicio es exitosa \\({int} Accepted\\)")
    public void laRespuestaDelServicioEsExitosa(int expectedStatus) {
    }

    @When("el empleado filtra la lista por la categoría {string}")
    public void elEmpleadoFiltraLaListaPorLaCategoria(String categoria) {
        kudosSteps.filterByCategory(categoria);
    }

    @And("realiza la búsqueda del destinatario {string}")
    public void realizaLaBusquedaDelDestinatario(String email) {
        kudosSteps.searchByMessage(email);
        kudosSteps.pressApplyFilters();
    }

    @Then("el sistema debe mostrar el registro en el Explorador con el mensaje {string}")
    public void elSistemaDebeMostrarElRegistroEnElExploradorConElMensaje(String mensaje) {
        kudosSteps.verifyMessage(mensaje);
    }

    @And("el autor visible debe ser {string}")
    public void elAutorVisibleDebeSer(String autor) {
        kudosSteps.verifyAuthor(autor);
    }

    @And("la marca de tiempo debe corresponder a la fecha actual")
    public void laMarcaDeTiempoDebeCorresponderALaFechaActual() {
        kudosSteps.verifyTimestamp();
    }
}
