package player.common;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot extends TestWatcher{


    @Override
    protected void failed(Throwable e, Description description)
    {
        String nomeClasse = description.getTestClass().getSimpleName();
        String nomeTeste = description.getMethodName();

        takeScreenshot(nomeClasse, nomeTeste);
    }

    public static void takeScreenshot(String nomeClasse, String nomeTeste)
    {
        try
        {
            // Cria um diretório "screenshots" na raiz do projeto
            new File("screenshots/").mkdirs();

            // Obtem um screenshot

            File screenshot = ((TakesScreenshot) BrowsersDrivers.getDriver(BrowsersDrivers.getBrowser()))
                    .getScreenshotAs(OutputType.FILE);

            // Cria um arquivo dentro do diretório "screenshots", contendo
            // o nome da classe/método de teste
            // Exemplo: "IncluirUsuarioTest-incluirComSucesso-screenshot.png"
            FileUtils.copyFile(screenshot, new File("screenshots/" + nomeClasse
                    + "-" + nomeTeste + "-screenshot.png"));

        } catch (IOException e)
        { e.printStackTrace();
        }
    }
}

