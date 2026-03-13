package pom_pattern.steps;

import net.serenitybdd.annotations.Step;
import pom_pattern.pages.KudosCreatePageElements;
import pom_pattern.pages.KudosListPageElements;
import pom_pattern.utils.KudoApiService;
import pom_pattern.utils.KudoDataGateway;

import java.time.Duration;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class KudosSteps {

    private static final Duration PERSISTENCE_TIMEOUT = Duration.ofSeconds(15);
    private static final Duration PERSISTENCE_POLL_INTERVAL = Duration.ofMillis(300);

    KudosListPageElements kudosListPage;
    KudosCreatePageElements kudosCreatePage;

    private final KudoDataGateway kudoDataGateway;

    private long totalElementsBeforeSeed;
    private int seededRowsCount;
    private final Map<String, String> seededMessages = new HashMap<>();
    private String selectedCategory;
    private String searchedMessage;

    public KudosSteps() {
        this(new KudoApiService());
    }

    KudosSteps(KudoApiService apiService) {
        this.kudoDataGateway = new KudoDataGateway();
    }

    @Step("Navegar a la página de listado de Kudos")
    public void openKudosList() {
        kudosListPage.open();
        kudosListPage.waitForTableRows();
    }

    @Step("Hacer clic en explorar kudos")
    public void clickExplorarKudos() {
        kudosListPage.clickExplorarKudos();
    }

    @Step("Crear un Kudo vía API")
    public void createKudoViaApi(Map<String, String> kudoData) {
        kudoDataGateway.seedKudos(kudoData.get("from"), List.of(kudoData));
    }

    @Step("Filtrar por categoría: {0}")
    public void filterByCategory(String category) {
        selectedCategory = category;
        kudosListPage.getCategoryFilterSelect().selectByVisibleText(category);
    }

    @Step("Buscar por mensaje: {0}")
    public void searchByMessage(String message) {
        String uniqueMessage = seededMessages.getOrDefault(message, message);
        searchedMessage = uniqueMessage;
        kudosListPage.getMessageSearchInput().type(uniqueMessage);
    }

    @Step("Presionar el botón de aplicar filtros")
    public void pressApplyFilters() {
        kudosListPage.getApplyFiltersButton().click();
    }

    @Step("Verificar que la tabla no está vacía")
    public void verifyTableIsNotEmpty() {
        var rows = kudosListPage.getKudosTableRows();
        assertThat(rows)
                .as("La tabla de kudos no debe estar vacía")
                .isNotEmpty();
    }

    @Step("Verificar que la categoría es {0}")
    public void verifyVisibleRowsMatchCategory(String expectedCategory) {
        kudosListPage.waitForTableRows();
        var badges = kudosListPage.getCategoryCells();
        assertThat(badges)
                .as("No hay registros visibles de la categoría '%s'", expectedCategory)
                .isNotEmpty();
        badges.forEach(badge ->
                assertThat(badge.getText().trim())
                        .as("Se encontró una fila con categoría inesperada")
                        .isEqualToIgnoringCase(expectedCategory)
        );
    }

    @Step("Verificar mensaje del kudo: {0}")
    public void verifyMessage(String expectedMessage) {
        kudosListPage.waitForTableRows();
        String message = kudosListPage.getMensajeKudo().getText();
        assertThat(message)
                .as("El mensaje del kudo debe contener: %s", expectedMessage)
                .contains(expectedMessage);
    }

    @Step("Verificar autor del kudo: {0}")
    public void verifyAuthor(String expectedAuthor) {
        kudosListPage.waitForTableRows();
        String author = kudosListPage.getRemitenteKudo().getText();
        assertThat(author)
                .as("El autor del kudo debe ser: %s", expectedAuthor)
                .contains(expectedAuthor);
    }

    @Step("Verificar timestamp del año actual")
    public void verifyTimestamp() {
        kudosListPage.waitForTableRows();
        String currentYear = String.valueOf(LocalDate.now().getYear());
        String date = kudosListPage.getFechaKudo().getText();
        assertThat(date)
                .as("El timestamp debe contener el año actual")
                .contains(currentYear);
    }

    // Steps para Create Kudos
    @Step("Ir a la página de creación de Kudos")
    public void goToCreatePage() {
        kudosCreatePage.goToCreatePage();
        kudosCreatePage.slideHomepage();
    }

    @Step("Seleccionar remitente: {0}")
    public void selectRemitente(String nombre) {
        kudosCreatePage.selectRemitente(nombre);
    }

    @Step("Seleccionar destinatario: {0}")
    public void selectDestinatario(String nombre) {
        kudosCreatePage.selectDestinatario(nombre);
    }

    @Step("Seleccionar categoría: {0}")
    public void selectCategoria(String categoria) {
        kudosCreatePage.selectCategoria(categoria);
    }

    @Step("Escribir mensaje: {0}")
    public void writeMensaje(String mensaje) {
        kudosCreatePage.escribirMensaje(mensaje);
    }

    @Step("Enviar el Kudo deslizando")
    public void slideToSend() {
        kudosCreatePage.slideEnvio();
    }

    @Step("Verificar mensaje de éxito")
    public void verifySuccessMessage() {
        assertThat(kudosCreatePage.isToastSuccessVisible())
                .as("El toast de éxito debe ser visible")
                .isTrue();
    }

    @Step("Verificar que el formulario esté vacío")
    public void verifyFormCleaned() {
        assertThat(kudosCreatePage.isFormCleaned())
                .as("El formulario debe estar vacío después del envío")
                .isTrue();
    }
}
