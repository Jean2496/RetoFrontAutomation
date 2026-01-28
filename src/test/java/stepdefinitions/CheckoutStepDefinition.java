package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.CheckoutPageObject;
import pageobjects.LoginPageObject;
import pageobjects.ProductPageObject;
import utils.PropertyReader;
import utils.WebDriverFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


public class CheckoutStepDefinition {

    private final LoginPageObject loginPageObject;
    private final CheckoutPageObject checkoutPageObject;
    private final ProductPageObject productPageObject;

    public CheckoutStepDefinition() {
        this.checkoutPageObject = new CheckoutPageObject(WebDriverFactory.getPage());
        this.productPageObject = new ProductPageObject(WebDriverFactory.getPage());
        this.loginPageObject = new LoginPageObject(WebDriverFactory.getPage());
    }

    @When("completa los datos del formulario")
    public void completaLosDatosDelFormulario() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        productPageObject.abrirCarrito();
        checkoutPageObject.llenarFormularioCheckout(PropertyReader.get("Primer_Nombre"), PropertyReader.get("Primer_Apellido"), PropertyReader.get("Codigo_Postal"));
    }

    @Then("finaliza la compra")
    public void finalizaLaCompra() {
        checkoutPageObject.finalizarCOmpra();
    }

    @And("valida que se completo correctamente")
    public void validaQueSeCOmpleteCorrectamente(){
        assertTrue(checkoutPageObject.validaCompra());
    }
}
