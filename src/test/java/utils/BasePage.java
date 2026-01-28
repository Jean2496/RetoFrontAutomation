package utils;

import com.microsoft.playwright.Page;

public class BasePage {
    protected Page page;

    public BasePage(Page page) {
        this.page = page;
    }

    public void click(String selector) {
        page.click(selector);
    }

    public void escribir(String selector, String text) {
        page.fill(selector, text);
    }

    public String obtenerTexto(String selector) {
        return page.textContent(selector);
    }

    public boolean elementoVisible(String selector) {
        return page.isVisible(selector);
    }

    public void navigate(String url) {
        page.navigate(url);
    }

}
