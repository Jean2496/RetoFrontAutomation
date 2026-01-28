package pageobjects;

import com.microsoft.playwright.Page;
import utils.BasePage;

public class CheckoutPageObject extends BasePage {
    public CheckoutPageObject(Page page) {
        super(page);
    }

    public void llenarFormularioCheckout(String nombre, String apellido, String codigoPostal) {
        page.click("#checkout");
        page.fill("#first-name", nombre);
        page.fill("#last-name", apellido);
        page.fill("#postal-code", codigoPostal);
        page.click("#continue");
    }

    public void finalizarCOmpra(){
        page.click("#finish");
    }

    public boolean validaCompra() {
        return page.isVisible("text=Thank you for your order!");
    }
}
