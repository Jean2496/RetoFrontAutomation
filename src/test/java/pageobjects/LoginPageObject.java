package pageobjects;

import com.microsoft.playwright.Page;
import utils.BasePage;
import utils.PropertyReader;

public class LoginPageObject extends BasePage {
    public LoginPageObject(Page page) {
        super(page);
    }

    public void navegarPaginaInicio() {
        page.navigate(PropertyReader.get("base_url"));
    }

    public void login(String username, String password) {
        escribir("#user-name", username);
        escribir("#password", password);
        click("#login-button");
    }

    public boolean loginExitoso() {
        return page.url().contains("inventory.html");
    }

    public String getMensajeError() {
        return obtenerTexto("[data-test='error']");
    }

}
