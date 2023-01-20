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

public class TesteCarrinho {

    WebDriver robo;

    @Before
    public void abrirNavegador(){

        System.setProperty("webdriver.chrome.driver", "C:\\WebDriver1\\chromedriver.exe");
        robo = new ChromeDriver();
        robo.get("https://www.saucedemo.com/");
        robo.findElement(By.id("user-name")).sendKeys("standard_user");
        robo.findElement(By.id("password")).sendKeys("secret_sauce");
        robo.findElement(By.id("login-button")).click();

    }

    @Dado("que o usuario tem acesso ao site da SwagLabs e adiciona um {string} ao carrinho")
    public void que_o_usuario_tem_acesso_ao_site_da_swag_labs_e_adiciona_um_ao_carrinho(String produto) {

        robo.findElement(By.id(produto)).click();

    }

    @Quando("ele clica no bota Carrinho para ser redirecionado a tela de CheckOut")
    public void ele_clica_no_bota_carrinho_para_ser_redirecionado_a_tela_de_check_out() {

        robo.findElement(By.className("shopping_cart_link")).click();
        robo.findElement(By.id("checkout")).click();

    }

    @Quando("clica no botao FINISH apos preencher os campos FirstName, LastName e ZipPostalCode com dados validos")
    public void clica_no_botao_finish_apos_preencher_os_campos_first_name_last_name_e_zip_postal_code_com_dados_validos() {

        robo.findElement(By.id("first-name")).sendKeys("Gustavo");
        robo.findElement(By.id("last-name")).sendKeys("Magalhães");
        robo.findElement(By.id("postal-code")).sendKeys("12345-678");
        robo.findElement(By.id("continue")).click();
        robo.findElement(By.id("finish")).click();

    }

    @Entao("a compra do usuario deve ser efetuada com sucesso")
    public void a_compra_do_usuario_deve_ser_efetuada_com_sucesso() {

        robo.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("THANK YOU FOR YOUR ORDER", robo.findElement(By.className("complete-header")).getText());

    }

}
