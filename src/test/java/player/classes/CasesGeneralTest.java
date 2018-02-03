package player.classes;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import player.Helpers;
import player.common.BrowsersDrivers;
import player.common.CommonTexts;
import player.common.TestCaseEnv;

import static org.junit.Assert.fail;

/**
 * Created by Camilla Rizzo on 10/04/17.
 */

public class CasesGeneralTest extends PlayerCases {

    /**
     * Category Automation - Case 208 - Caption
     * Run test caption.
     */
    @Test
    public void testParametercase208() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.CAPTION.getCase(env));
        Thread.sleep(1000);
        Helpers.actionPlay(driver);
        Thread.sleep(1000);
        Helpers.actionPause(driver);
        Thread.sleep(1000);
        Helpers.actionCaption(driver);
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#player > div.fp-ui")).click();
        Thread.sleep(2000);
        driver.findElement(By.className("box-output")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"player\"]/div[5]/div[4]/ul/li[3]/a")).click();
        Thread.sleep(1000);
        Assert.assertEquals(false, driver.findElement(By.xpath("//*[@id=\"player\"]/div[5]/div[4]/ul/li[3]/a/ul/li[8]")).isSelected());
    }

    /**
     * Category Automation - Case 209 - Lead pré
     * Run test collector lead.
     */
    @Test
    public void testParametercase209() throws Exception {
        driver.get(BrowsersDrivers.baseURL + "/automacao/pcases/" + TestCaseEnv.LEAD_PRE.getCase(env));
        Thread.sleep(1000);
        Helpers.actionPlay(driver);
        Thread.sleep(2000);
        Assert.assertEquals(CommonTexts.LEAD.getLanguage(language), driver.findElement(By.className("container")).getText());
    }

    }


