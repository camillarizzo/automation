package player.classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import player.common.BrowsersDrivers;
import player.common.Screenshot;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;


public class PlayerCases {

    static WebDriver driver;
    protected static StringBuffer verificationErrors = new StringBuffer();
    protected static String env;
    protected static String language;
    protected static String browserName;

    @Rule
    public Screenshot screenshotRule = new Screenshot();

    @BeforeClass
    public static void setUp() throws Exception {
        env = System.getenv("ENV");
        language = System.getenv("language");
        driver = BrowsersDrivers.getDriver();
        driver.navigate().to(BrowsersDrivers.baseURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        player.Helpers.doLogin(driver);
        new WebDriverWait(driver,60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/header/div/div/div[2]/div[3]/select")));
        player.Helpers.selectEnv(env, driver);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();

        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
