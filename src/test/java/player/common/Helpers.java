package player;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;

import java.util.List;

/**
 * Created by Camilla Rizzo on 8/28/17.
 */

public class Helpers {

    /**
     * Plataform login
     */
    public static void doLogin(WebDriver driver){
        /*
         Utilizando xpath enquando os elementos da pagina ainda nao estao estruturados em classes.
         */
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/form/div[1]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/form/div[1]/input")).sendKeys("camilla.rizzo@sambatech.com.br");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/form/div[2]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/form/div[2]/input")).sendKeys("samba123");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[3]/form/button")).click();
    }

    /**
     * Select test environment - Staging or QA
     */

    public static void selectEnv(String env, WebDriver driver) {
       if ("STAGING".equals(env))
           selectStaging(driver);
       else
           selectQA(driver);
    }

    public static void selectQA(WebDriver driver){
    driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div/div/div[2]/div[3]/select")).click();
    driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div/div/div[2]/div[3]/select/option[1]")).click();
    }

    public static void selectStaging(WebDriver driver){
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div/div/div[2]/div[3]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/header/div/div/div[2]/div[3]/select/option[3]")).click();
    }

    /**
     * Actions Player - Play
     */
    public static void actionPlay(WebDriver driver){
        driver.switchTo().frame(0);
        driver.findElement(By.cssSelector("#player > div.fp-ui")).click();
    }

    /**
     * Actions Player - Pause
     */
    public static void actionPause(WebDriver driver){

        driver.findElement(By.className("fp-play")).click();
    }

    /**
     * Actions Player - Fullcreen
     */
    public static void actionFullscreen(WebDriver driver){
        driver.findElement(By.className("fp-fullscreen")).click();
        driver.findElement(By.className("fp-fullscreen")).click();
    }

    /**
     * Actions Player - Set output
     */
    public static void actionOutput(WebDriver driver) throws Exception {
        driver.findElement(By.className("box-output")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("triggerSubMenu")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"stQuality_1\"]")).click();
    }

    /**
     * Actions Player - Caption
     */
    public static void actionCaption(WebDriver driver) throws Exception {
        driver.findElement(By.className("box-output")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"player\"]/div[5]/div[4]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"player\"]/div[5]/div[4]/ul/li[3]/a/ul/li[8]")).click();
    }

    /**
     * Actions Player - Back to Live
     */
    public static void actionBacktoLive(WebDriver driver) throws Exception {
        driver.findElement(By.className("fp-btn-return-live")).click();
    }

    /**
     * Actions Player - Seek video
     */
    public static void actionSeek(WebDriver driver) throws Exception {
        driver.findElement(By.className("fp-progress")).isDisplayed();
        ((JavascriptExecutor) driver).executeScript("window.sambaPlayer.seek(100);");
    }

    /**
     * Actions Player - Seek volume
     */
   public static void actionSeekVolume(WebDriver driver) throws Exception {
        driver.findElement(By.className("fp-controls")).isDisplayed();
        driver.findElement(By.className("fp-volume")).click();
       ((JavascriptExecutor) driver).executeScript("window.sambaPlayer.setVolume(10)");
   }

    /**
     * Actions Player - Chrome Cast
     */
    public static void actionChromeCast(WebDriver driver) throws Exception {
        driver.findElement(By.className("fp-controls")).isDisplayed();
        driver.findElement(By.className("cast-icon")).click();
    }

    /**
     * Action Player - Video Resume
     */
    public static void backStart(WebDriver driver){
        driver.findElement(By.cssSelector("a.bt.fp-icon-repeat")).click();
    }

    /**
     * Action Player - Video Continue
     */
    public static void continueVideo(WebDriver driver){
        driver.findElement(By.cssSelector("a.bt.fp-icon-continue")).click();
    }

    /**
     * Action Player Audio - Pause
     */
    public static void pauseAudio(WebDriver driver) {
        driver.switchTo().frame(0);
        driver.findElement(By.className("fp-play")).click();
    }

    /**
     * Action Player Audio - Play
     */
    public static void playAudio(WebDriver driver) {
        driver.switchTo().frame(0);
        driver.findElement(By.className("fp-play")).click();
    }


}
