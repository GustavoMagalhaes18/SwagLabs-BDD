package Steps;

import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TesteAcesso {

    WebDriver robo;

    @Before
    public void abrirNavegador(){

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver1\\chromedriver.exe");
        robo = new ChromeDriver();
        robo.get("https://www.saucedemo.com/");

    }

    @Dado("que o usuario esta na tela inicial do SwagLabs")
    public void que_o_usuario_esta_na_tela_inicial_do_swag_labs() {

        robo.get("https://www.saucedemo.com/");

    }

    @Quando("ele preenche com dados validos os campos {string} e {string}")
    public void ele_preenche_com_dados_validos_os_campos_e(String username, String password) {

        robo.findElement(By.id("user-name")).sendKeys(username);
        robo.findElement(By.id("password")).sendKeys(password);

    }

    @Quando("clica no botao LOGIN")
    public void clica_no_botao_login() {

        robo.findElement(By.id("login-button")).click();

    }

    @Entao("o usuario deve ter acesso ao site da SwagLabs")
    public void o_usuario_deve_ter_acesso_ao_site_da_swag_labs() {

        robo.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assertions.assertEquals("PRODUCTS", robo.findElement(By.className("title")).getText());

    }

}
