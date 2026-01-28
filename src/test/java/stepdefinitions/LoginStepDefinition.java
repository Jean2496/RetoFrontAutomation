package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.LoginPageObject;
import utils.PropertyReader;
import utils.WebDriverFactory;

import static org.junit.Assert.*;


public class LoginStepDefinition {

    private final LoginPageObject loginPageObject;

    public LoginStepDefinition() {
        this.loginPageObject = new LoginPageObject(WebDriverFactory.getPage());
    }

    @Given("usuario se encuentra en la pagina de inicio")
    public void usuarioSeEncuentraEnLaPaginaDeInicio() {
        loginPageObject.navegarPaginaInicio();
    }

    @When("ingreso las credenciales validas")
    public void ingresoLasCredencialesValidas() {
        loginPageObject.login(PropertyReader.get("usuario_valido"), PropertyReader.get("contraseña_valida"));
    }

    @Then("valido que se logeo correctamente")
    public void validoQueSeLogeoCorrectamente() {
        assertTrue("El login fue exitoso", loginPageObject.loginExitoso());
    }

    @When("ingreso las credenciales invalidas")
    public void ingresoLasCredencialesInvalidas() {
        loginPageObject.login(PropertyReader.get("usuario_invalido"), PropertyReader.get("contraseña_invalida"));
    }

    @Then("valido que el usuario no se pudo logear correctamente")
    public void validoQueElUsuarioNoSePudoLogearCorrectamente() {
        String mensaje = loginPageObject.getMensajeError();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", mensaje);
    }
}
