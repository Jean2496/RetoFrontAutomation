package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPageObject;
import pageobjects.ProductPageObject;
import utils.PropertyReader;
import utils.WebDriverFactory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ProductStepDefinition {

    private final ProductPageObject productPageObject;
    private final LoginPageObject loginPageObject;

    public ProductStepDefinition() {
        this.loginPageObject = new LoginPageObject(WebDriverFactory.getPage());
        this.productPageObject = new ProductPageObject(WebDriverFactory.getPage());
    }

    @When("agrega productos al carrito")
    public void agregaProductosAlCarrito() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        String productos = PropertyReader.get("productos");
        List<String> listaProductos = Arrays.asList(productos.split(","));
        productPageObject.agregarProductosAlCarrito(listaProductos);
    }

    @Then("el carrito debe mostrar los productos correctamente")
    public void elCarritoDebeMostrarLosProductosCorrectamente() {
        productPageObject.abrirCarrito();
        assertTrue(productPageObject.estaEnCarrito());
    }

    @When("escoge la opcion de filtrar producto alfabeticamente A to Z")
    public void escogeLaOpcionDeFiltrarProductoAlfabeticamenteAtoZ() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        productPageObject.ordenarProductosPor("Name (A to Z)");
    }

    @When("escoge la opcion de filtrar producto alfabeticamente Z to A")
    public void escogeLaOpcionDeFiltrarProductoAlfabeticamenteZtoA() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        productPageObject.ordenarProductosPor("Name (Z to A)");
    }

    @When("escoge la opcion de filtrar producto por precio Low To High")
    public void escogeLaOpcionDeFiltrarProductoPorPrecioLowToHigh() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        productPageObject.ordenarProductosPor("Price (low to high)");
    }

    @When("escoge la opcion de filtrar producto alfabeticamente High To Low")
    public void escogeLaOpcionDeFiltrarProductoAlfabeticamenteHightoLow() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
        productPageObject.ordenarProductosPor("Price (high to low)");
    }

    @Then("se valida que se filtro correctamente A to Z")
    public void seValidaQueSeFiltroCorrectamenteAtoZ() {
        assertTrue(productPageObject.validarProductosAtoZ());
    }

    @Then("se valida que se filtro correctamente Z to A")
    public void seValidaQueSeFiltroCorrectamenteZtoA() {
        assertTrue(productPageObject.validarProductosZtoA());
    }

    @Then("se valida que se filtro correctamente Low To High")
    public void seValidaQueSeFiltroCorrectamenteLowToHigh() {
        assertTrue(productPageObject.validarPrecioAscendente());
    }

    @Then("se valida que se filtro correctamente High To Low")
    public void seValidaQueSeFiltroCorrectamenteHighToLow() {
        assertTrue(productPageObject.validarPrecioDescendente());
    }
}
