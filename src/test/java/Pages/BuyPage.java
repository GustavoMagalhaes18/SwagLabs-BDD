package Pages;

import Steps.TesteCarrinho;
import org.openqa.selenium.By;

public class BuyPage extends TesteCarrinho {

    public void escolherProduto(){

        robo.findElement(By.id(produto)).click();

    }

}
