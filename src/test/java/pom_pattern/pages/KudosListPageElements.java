package pom_pattern.pages;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

@DefaultUrl("/kudos/list")
public class KudosListPageElements extends PageObject {

    @FindBy(xpath = "//button[contains(normalize-space(.), 'Explorar Kudos')]")
    private WebElementFacade explorarKudosButton;

    @FindBy(xpath = "//select[@aria-label='Filtrar por categoría']")
    private WebElementFacade categoryFilterSelect;

    @FindBy(xpath = "//input[@aria-label='Buscar kudos']")
    private WebElementFacade messageSearchInput;

    @FindBy(xpath = "//button[contains(., 'Aplicar Filtros')]")
    private WebElementFacade applyFiltersButton;

    @FindBy(xpath = "//tbody/tr[1]/td[4]")
    private WebElementFacade labelMensajeKudo;

    @FindBy(xpath = "//tbody/tr[1]/td[1]")
    private WebElementFacade labelRemitenteKudo;

    @FindBy(xpath = "//tbody/tr[1]/td[5]")
    private WebElementFacade labelFechaKudo;

    private static final By TABLE_ROWS = By.cssSelector("tbody tr");
    private static final By CATEGORY_CELLS = By.cssSelector("tbody tr td:nth-child(3) span");

    public WebElementFacade getExplorarKudosButton() {
        return waitForElement(explorarKudosButton);
    }

    public WebElementFacade getCategoryFilterSelect() {
        return waitForElement(categoryFilterSelect);
    }

    public WebElementFacade getMessageSearchInput() {
        return waitForElement(messageSearchInput);
    }

    public WebElementFacade getApplyFiltersButton() {
        return waitForElement(applyFiltersButton);
    }

    public List<WebElementFacade> getKudosTableRows() {
        waitForTableRows();
        return findAll(TABLE_ROWS);
    }

    public List<WebElementFacade> getCategoryCells() {
        waitForTableRows();
        return findAll(CATEGORY_CELLS);
    }

    public WebElementFacade getMensajeKudo() {
        return waitForElement(labelMensajeKudo);
    }

    public WebElementFacade getRemitenteKudo() {
        return waitForElement(labelRemitenteKudo);
    }

    public WebElementFacade getFechaKudo() {
        return waitForElement(labelFechaKudo);
    }

    public void clickExplorarKudos() {
        getExplorarKudosButton().click();
    }

    private WebElementFacade waitForElement(WebElementFacade element) {
        FluentWait<org.openqa.selenium.WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500));
        wait.until(driver -> element.isPresent());
        return element;
    }

    public void waitForTableRows() {
        FluentWait<org.openqa.selenium.WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofMillis(500));
        wait.until(driver -> !findAll(TABLE_ROWS).isEmpty());
    }
}
