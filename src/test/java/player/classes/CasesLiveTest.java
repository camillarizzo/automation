package player.classes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import player.common.BrowsersDrivers;
import player.common.CommonTexts;
import player.common.TestCaseEnv;

/**
 * Created by Camilla Rizzo on 8/30/17.
 */

public class CasesLiveTest extends PlayerCases {

    /**
     * Category Automation - Case 192 - Backup Live HLS
     * Run live test and screen buttons.
     */
    @Test
    public void testLivecase192() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.BACKUP_LIVE.getCase(env));
        Thread.sleep(1000);
        player.Helpers.actionPlay(driver);
        Thread.sleep(10000);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        player.Helpers.actionPause(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        player.Helpers.actionOutput(driver);
        Thread.sleep(1000);
        driver.findElement(By.className("fp-output")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("triggerSubMenu")).click();
        Assert.assertEquals(false, driver.findElement(By.xpath("//*[@id=\"stQuality_1\"]/i")).isSelected());
        player.Helpers.actionSeekVolume(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-volumelevel")).isDisplayed());
        Thread.sleep(2000);
        player.Helpers.actionFullscreen(driver);
        Thread.sleep(1000);
    }

    /**
     * Category Automation - Case 193 - Backup Live + AD - HLS
     * Run live test and screen buttons.
     */
    @Test
    public void testLivecase193() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.LIVE_AD.getCase(env));
        Thread.sleep(3000);
        player.Helpers.actionPlay(driver);
        Thread.sleep(15000);
        player.Helpers.actionPause(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        player.Helpers.actionOutput(driver);
        Thread.sleep(1000);
        driver.findElement(By.className("fp-output")).click();
        Thread.sleep(1000);
        driver.findElement(By.className("triggerSubMenu")).click();
        Assert.assertEquals(false, driver.findElement(By.xpath("//*[@id=\"stQuality_1\"]/i")).isSelected());
        player.Helpers.actionSeekVolume(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-volumelevel")).isDisplayed());
        Thread.sleep(2000);
        player.Helpers.actionFullscreen(driver);
    }
    /**
     * Category Automation - Case 194 - Live HLS - DVR
     * Run live test and screen buttons.
     */
    @Test
    public void testLivecase194() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.LIVE_DVR.getCase(env));
        Thread.sleep(1000);
        player.Helpers.actionPlay(driver);
        Thread.sleep(3000);
        player.Helpers.actionPause(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-play")).isDisplayed());
        Thread.sleep(2000);
        player.Helpers.actionSeekVolume(driver);
        Assert.assertTrue(driver.findElement(By.className("fp-volumelevel")).isDisplayed());
        Thread.sleep(2000);
        player.Helpers.actionSeek(driver);
        Assert.assertEquals(CommonTexts.BACK_LIVE.getLanguage(language), driver.findElement(By.className("fp-btn-return-live")).getText());
        Thread.sleep(2000);
        player.Helpers.actionBacktoLive(driver);
        Assert.assertTrue(driver.findElement(By.className("alert-live")).isDisplayed());
        Thread.sleep(2000);
    }


}
