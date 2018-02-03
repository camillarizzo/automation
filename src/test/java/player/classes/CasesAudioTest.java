package player.classes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import player.Helpers;
import player.common.BrowsersDrivers;
import player.common.CommonTexts;
import player.common.TestCaseEnv;

/**
 * Created by Camilla Rizzo on 10/04/17.
 */

public class CasesAudioTest extends PlayerCases {


        /**
         * Category Automation - Case 206 - Live Audio
         * Run test screen buttons.
         */
        @Test
        public void testParametercase206() throws Exception {
            driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.AUDIO_LIVE.getCase(env));
            Thread.sleep(1000);
            Helpers.pauseAudio(driver);
            driver.findElement(By.className("fp-mute")).click();
            Assert.assertTrue(driver.findElement(By.className("fp-volumeslider")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.className("tumblr_audio")).isDisplayed());
        }

        /**
         * Category Automation - Case 205 - VOD Audio
         * Run test screen buttons.
         */
        @Test
        public void testParametercase205() throws Exception {
            driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.AUDIO_VOD.getCase(env));
            Thread.sleep(1000);
            Helpers.playAudio(driver);
            driver.findElement(By.className("fp-mute")).click();
            Assert.assertTrue(driver.findElement(By.className("fp-volumeslider")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.className("tumblr_audio")).isDisplayed());
            Assert.assertTrue(driver.findElement(By.className("icon-repeat")).isDisplayed());
        }

        /**
         * Category Automation - Case 207 - Geoblock Audio
         * Test error message.
         */
        @Test
        public void testParametercase207() throws Exception {
            driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.GEOBLOCK_AUDIO.getCase(env));
            Thread.sleep(2000);
            driver.switchTo().frame(0);
            Assert.assertEquals(CommonTexts.GEOBLOCK.getLanguage(language), driver.findElement(By.xpath("/html/body/div/div")).getText());
        }

}
