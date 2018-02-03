package player.classes;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import player.Helpers;
import player.common.BrowsersDrivers;
import player.common.CommonTexts;
import player.common.TestCaseEnv;

import java.util.concurrent.TimeUnit;

/**
 * Created by Camilla Rizzo on 9/04/17.
 */

public class CasesParametrosTest extends PlayerCases {

    /**
     * Category Automation - Case 199 - Cast
     * Run test cast button.
     */
    @Test @Ignore
    public void testParametercase199() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.CAST.getCase(env));
        Thread.sleep(1000);
        Helpers.actionPlay(driver);
        Thread.sleep(5000);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        Helpers.actionPause(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        Helpers.actionChromeCast(driver);
    }

    /**
     * Category Automation - Case 200 - Enable Controls
     * Run test screen buttons and confirm the non-display of some controls.
     */
    @Test
    public void testParametercase200() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.ENABLE_CONTROLS.getCase(env));
        Thread.sleep(1000);
        Helpers.actionPlay(driver);
        Thread.sleep(5000);
        Assert.assertFalse(driver.findElement(By.className("fp-progress")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.className("fp-play")).isDisplayed());
    }

    /**
     * Category Automation - Case 201 - Automatic Fullscreen
     * Run test screen buttons and confirm the automatic fullscreen.
     */
    @Test
    public void testParametercase201() throws Exception{
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.AUTOMATIC_FULLSCREEN.getCase(env));
        Thread.sleep(1000);
        Helpers.actionPlay(driver);
        Assert.assertTrue(driver.findElement(By.className("is-fullscreen")).isDisplayed());
        driver.findElement(By.className("fp-fullscreen")).click();
    }

    /**
     * Category Automation - Case 202 - Disable Fullscreen
     * Run test screen buttons and confirm the non-display of fullscreen.
     */
    @Test
    public void testParametercase202() throws Exception{
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.DISABLE_FULLSCREEN.getCase(env));
        Thread.sleep(2000);
        Helpers.actionPlay(driver);
        Thread.sleep(2000);
        Helpers.actionPause(driver);
        Thread.sleep(3000);
        Assert.assertEquals(false, driver.findElement(By.className("fp-fullscreen")).isDisplayed());
    }

    /**
     * Category Automation - Case 203 - Start
     * Run test watch from the beginning.
     */
    @Test
    public void testParametercase203Start() throws Exception{
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.RESUME_START.getCase(env));
        Thread.sleep(3000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.RESUME.getLanguage(language), driver.findElement(By.className("container")).getText());
        Helpers.backStart(driver);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        Double time = Double.parseDouble(((JavascriptExecutor) driver).executeAsyncScript(
                "var seleniumCallback = arguments[arguments.length - 1];" +
                        "var callback = () => seleniumCallback(window.sambaPlayer.getCurrentTime());" +
                        "window.evtDsp.on('player:start', callback);" +
                        "window.evtDsp.on('player:resume', callback);").toString());
        Assert.assertTrue(time < 3);
    }

    /**
     * Category Automation - Case 203 - Resume
     * Run test keep watching.
     */
    @Test
    public void testParametercase203Continue() throws Exception{
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.RESUME_CONTINUE.getCase(env));
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.RESUME.getLanguage(language), driver.findElement(By.className("container")).getText());
        Helpers.continueVideo(driver);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        Long time = (Long)((JavascriptExecutor) driver).executeAsyncScript(
                "var seleniumCallback = arguments[arguments.length - 1];" +
                        "var callback = () => {" +
                        "var t = window.sambaPlayer.getCurrentTime() | 0;" +
                        "t > 0 && seleniumCallback(t);" +
                        "};" +
                        "window.evtDsp.on('player:seek', callback);");
        System.out.println(time + " >> " + (10 >= time ||  time <= 14));
        Assert.assertTrue(10 >= time ||  time <= 14);
    }

    /**
     * Category Automation - Case 204 - Shared
     * Run test and confirm sharing button.
     */
    @Test
    public void testParametercase204() throws Exception{
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.SHARED.getCase(env));
        Thread.sleep(2000);
        Helpers.actionPlay(driver);
        Thread.sleep(2000);
        Helpers.actionPause(driver);
        driver.findElement(By.className("share")).click();
        Assert.assertEquals(CommonTexts.SHARING.getLanguage(language), driver.findElement(By.className("row-fluid")).getText());
    }


}
