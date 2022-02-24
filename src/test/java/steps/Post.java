package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Post  extends Base {
    private Base base;

    public Post(Base base) {
        this.base = base;
    }

    @Dado("^que acesse A Wikipedia em portugues$")
    public void queAcesseAWikipediaEmPortugues()
    {
        base.driver.get(base.url);
    }

    @Quando("^pesquiso por \"([^\"]*)\"$")
    public void pesquisoPor(String produto)  {
        base.driver.findElement(By.id("searchInput")).sendKeys(produto + Keys.ENTER);

    }

    @Entao("^exibe a expressao \"([^\"]*)\" no titulo da guia$")
    public void exibeAExpressaoNoTituloDaGuia(String produto)  {
        Assert.assertTrue(base.driver.getTitle().contains(produto));
    }
}
