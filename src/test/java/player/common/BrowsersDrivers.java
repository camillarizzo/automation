package player.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowsersDrivers  extends AbstractBrowser{

    static WebDriver driver = null;
    public static String baseURL = "http://playerground.sambatech.com";

    public static WebDriver getDriver(){
        return getDriver(getBrowser());
    }

    public static WebDriver getDriver(Browser browserName){

        switch (browserName) {
            case FIREFOX:
                return getFirefox();

            case IE:
                return getIE();
            default:
                return getChrome();
        }

    }

        public static Browser getBrowser() {
            return getBrowser(System.getenv("browserName"));
        }


        public static Browser getBrowser(String browserName) {
        switch (browserName) {
            case "FIREFOX":
                return Browser.FIREFOX;
            case "IE":
                return Browser.IE;
            default:
                return Browser.CHROME;
        }
    }


    public static WebDriver getChrome() {
        System.getProperty("webdriver.chrome.driver", "https://s3.amazonaws.com/samba.qa/drivers/mac/chrome/chromedriver");
        //System.setProperty("webdriver.chrome.driver","/Users/admin/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        driver = new ChromeDriver(options);
        return driver;
    }
    private static WebDriver getFirefox() {
        //System.setProperty("webdriver.gecko.driver", "/Users/admin/Documents/Drivers/geckodriver");
        System.getProperty("webdriver.gecko.driver", "https://s3.amazonaws.com/samba.qa/drivers/mac/firefox/geckodriver.exe");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("intl.accept_languages", "en");
        return new FirefoxDriver(profile);
    }

    private static  WebDriver getIE(){
        System.getProperty("webdriver.ie.driver", "https://s3.amazonaws.com/samba.qa/drivers/windows/IE/IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        return new InternetExplorerDriver();
    }


}
