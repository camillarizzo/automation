package player.classes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import player.common.BrowsersDrivers;
import player.common.CommonTexts;
import player.common.TestCaseEnv;

/**
 * Created by Camilla Rizzo on 10/09/17.
 */

public class CasesErrorTest extends PlayerCases{

    /**
     * Category Automation - Case 228 - Geoblock VOD
     * Test error message.
     */
    @Test
    public void testParametercase228() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.GEOBLOCK_VOD.getCase(env));
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.GEOBLOCK.getLanguage(language), driver.findElement(By.xpath("/html/body/div/div")).getText());
    }

    /**
     * Category Automation - Case 195 - Geoblock Live
     * Test error message.
     */
    @Test
    public void testParametercase195() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.GEOBLOCK_LIVE.getCase(env));
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.GEOBLOCK.getLanguage(language), driver.findElement(By.xpath("/html/body/div/div")).getText());
    }

    /**
     * Category Automation - Case 197 - Dispubled Media
     * Test error message.
     */
    @Test
    public void testParametercase197() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.DISPUBLED_MEDIA.getCase(env));
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.DISPUBLED.getLanguage(language), driver.findElement(By.xpath("/html/body/div/div")).getText());
    }

    /**
     * Category Automation - Case 198 - Domain restriction
     * Test error message.s
     */
    @Test
    public void testParametercase198() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.DOMAIN_RESTRICTION.getCase(env));
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Assert.assertEquals(CommonTexts.DOMAIN_RESTRICTION.getLanguage(language), driver.findElement(By.xpath("/html/body/div/div")).getText());
    }


}
