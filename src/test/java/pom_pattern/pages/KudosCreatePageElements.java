package pom_pattern.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class KudosCreatePageElements extends PageObject {
    
    @FindBy(xpath = "//span[contains(.,'Desliza para conectar')]/ancestor::div[contains(@class,'cursor-pointer')]//div[contains(@class,'bg-brand')]")
    private WebElementFacade sliderHomepage;
    
    @FindBy(xpath = "//select[@name='from']")
    private WebElementFacade selectRemitente;
    
    @FindBy(xpath = "//select[@name='to']")
    private WebElementFacade selectDestinatario;
    
    @FindBy(xpath = "//select[@name='category']")
    private WebElementFacade selectCategoria;
    
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElementFacade textareaMensaje;
    
    @FindBy(xpath = "//span[contains(.,'Desliza para enviar')]/ancestor::div[contains(@class,'cursor-pointer')]//div[contains(@class,'bg-brand')]")
    private WebElementFacade sliderEnvio;
    
    @FindBy(xpath = "//li[@data-sonner-toast and @data-type='success']")
    private WebElementFacade toastSuccess;

    public void slideHomepage() {
        Actions action = new Actions(getDriver());
        action.clickAndHold(sliderHomepage)
                .moveByOffset(600, 0)
                .release()
                .perform();
    }

    public void goToCreatePage() {
        open();
    }

    public void selectRemitente(String nombre) {
        selectRemitente.selectByVisibleText(nombre);
    }

    public void selectDestinatario(String nombre) {
        selectDestinatario.selectByVisibleText(nombre);
    }

    public void selectCategoria(String categoria) {
        selectCategoria.selectByVisibleText(categoria);
    }

    public void escribirMensaje(String mensaje) {
        textareaMensaje.type(mensaje);
    }

    public void slideEnvio() {
        Actions action = new Actions(getDriver());
        action.clickAndHold(sliderEnvio)
                .moveByOffset(420, 0)
                .release()
                .perform();
    }

    public boolean isToastSuccessVisible() {
        return toastSuccess.isVisible();
    }

    public boolean isFormCleaned() {
        return textareaMensaje.getValue().isEmpty();
    }
}
