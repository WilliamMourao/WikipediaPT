package simples;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Artigo {
    String url;
    WebDriver driver;

    @Before
    public void iniciar() {
        url = "https://pt.wikipedia.org/";
       System.setProperty ("webdriver.chrome.driver", "drives/chrome/96/chromedriver.exe");
       driver = new ChromeDriver();

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);


    }
    @Test
    public void consultarartigos () {
        driver.get(url);
        driver.findElement(By.id("searchInput")).sendKeys("Ovo de Páscoa" + Keys.ENTER);


        //Validação do teste
       Assert.assertEquals("Ovos de Páscoa - Wikipédia, a enciclopédia livre",driver.getTitle());
        //Assert.assertTrue(driver.getTitle().contains("Ovo"));
    }

    @After
    public void finalizar () {
        driver.quit();
    }



}
