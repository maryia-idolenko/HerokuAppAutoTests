package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static org.testng.Assert.assertEquals;

public class HerokuAppAutoTests extends BasePage {
    private final static By CONTEXT_MENU = By.id("hot-spot");
    private final static By REMOVE_BUTTON = By.xpath("//*[@id=\"checkbox-example\"]/button");
    private final static By MESSAGE = By.xpath("//*[@id=\"message\"]");
    private final static By CHECKBOX = By.xpath("//*[@id=\"checkbox\"]/input");
    private final static By INPUT_FIELD = By.xpath("//*[@id=\"input-example\"]/input");
    private final static By ENABLE_DISABLE_BUTTON = By.xpath("//*[@id=\"input-example\"]/button");
    private final static By CHOOSE_FILE_BUTTON = By.id("file-upload");
    private final static By UPLOAD_BUTTON = By.id("file-submit");
    private final static By FILE_NAME = By.id("uploaded-files");
    private final static By IFRAME_LINK = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/a");
    private final static By IFRAME_TEXT = By.xpath("//*[@id=\"mce_0_ifr\"]");

    public HerokuAppAutoTests(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    public void rightClick() {
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(CONTEXT_MENU)).build().perform();
    }

    public void alertShouldExist() {
        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("You selected a context menu", textOnAlert);
    }

    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void openPageCheckbox() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    public void clickRemoveButton() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public void messageShouldExist() {
        String element = driver.findElement(MESSAGE).getText();
        assertEquals("It's gone!", element);
    }

    public boolean checkboxShouldNotExist() {
        return !driver.findElements(CHECKBOX).isEmpty();
    }

    public void inputField() {
        driver.findElement(INPUT_FIELD);
        String elementButton = driver.findElement(ENABLE_DISABLE_BUTTON).getText();
        assertEquals("Enable", elementButton);
    }

    public void clickEnableButton() {
        driver.findElement(ENABLE_DISABLE_BUTTON).click();
    }

    public void messageEnabledShouldExist() {
        String messageEnabled = driver.findElement(MESSAGE).getText();
        assertEquals("It's enabled!", messageEnabled);
    }

    public void inputFieldEnabled() {
        String inputField = driver.findElement(ENABLE_DISABLE_BUTTON).getText();
        assertEquals("Disable", inputField);
    }

    public void openPageFileUploader() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    public void fileUpload() {
        driver.findElement(CHOOSE_FILE_BUTTON).sendKeys(System.getProperty("user.dir") + "/src/main/resources/photo.jpg");
        driver.findElement(UPLOAD_BUTTON).click();
    }

    public void fileName() {
        String fileName = driver.findElement(FILE_NAME).getText();
        assertEquals("photo.jpg", fileName);
    }

    public void openPageIframes() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }

    public void clickIframe() {
        driver.findElement(IFRAME_LINK).click();
    }

    public void textIframeShouldExist() {
        String textIframe = driver.findElement(IFRAME_TEXT).getText();
        assertEquals("Your content goes here.", textIframe);
    }
}