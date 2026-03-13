package pom_pattern.stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.annotations.Steps;
import pom_pattern.steps.KudosSteps;

public class ListarKudosStepDefinition {

    @Steps
    private KudosSteps kudosSteps;

    @Dado("que el sistema SofkianOS se encuentra operativo")
    public void queElSistemaSofkianOSSeEncuentraOperativo() {
        // No necesita acción
    }

    @Dado("el usuario accede a la página de listado de kudos")
    public void elUsuarioAccedeALaPaginaDeListadoDeKudos() {
        kudosSteps.openKudosList();
    }

    @Cuando("el empleado visualiza el listado de kudos")
    public void elEmpleadoVisualizaElListadoDeKudos() {
        kudosSteps.openKudosList();
    }

    @Entonces("el sistema debe mostrar kudos en la tabla")
    public void elSistemaDebeMostrarKudosEnLaTabla() {
        kudosSteps.verifyTableIsNotEmpty();
    }

    @Cuando("el empleado filtra la lista por la categoría {string}")
    public void elEmpleadoFiltraLaListaPorLaCategoria(String categoria) {
        kudosSteps.filterByCategory(categoria);
    }

    @Y("presiona el botón de aplicar filtros")
    public void presionaElBotonDeAplicarFiltros() {
        kudosSteps.pressApplyFilters();
    }

    @Entonces("el sistema debe mostrar solo kudos de la categoría {string}")
    public void elSistemaDebeMostrarSoloKudosDeLaCategoria(String categoria) {
        kudosSteps.verifyVisibleRowsMatchCategory(categoria);
    }
}
