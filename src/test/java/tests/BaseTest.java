package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HerokuAppAutoTests;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    HerokuAppAutoTests contextMenu;
    HerokuAppAutoTests dynamicControls;
    HerokuAppAutoTests fileUploader;
    HerokuAppAutoTests iframe;
    private WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        contextMenu = new HerokuAppAutoTests(driver);
        dynamicControls = new HerokuAppAutoTests(driver);
        fileUploader = new HerokuAppAutoTests(driver);
        iframe = new HerokuAppAutoTests(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}