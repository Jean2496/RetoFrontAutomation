package pageobjects;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import utils.BasePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPageObject extends BasePage {

    public ProductPageObject(Page page) {
        super(page);
    }

    public void agregarProductosAlCarrito(List<String> nombresProductos){
        for (String nombre : nombresProductos) {
            Locator producto = page.locator(".inventory_item").filter(new Locator.FilterOptions().setHasText(nombre));
            producto.locator("button:has-text(\"Add to cart\")").click();
        }
    }

    public void abrirCarrito(){
        page.click("#shopping_cart_container");
    }

    public boolean estaEnCarrito() {
        return page.url().contains("/cart.html");
    }

    public void ordenarProductosPor(String criterio) {
        page.selectOption(".product_sort_container", criterio);
    }

    public boolean validarProductosAtoZ(){
        List<String> nombres = page.locator(".inventory_item_name").allTextContents();
        List<String> ordenados = new ArrayList<>(nombres);
        Collections.sort(ordenados);
        return nombres.equals(ordenados);
    }

    public boolean validarProductosZtoA() {
        List<String> nombres = page.locator(".inventory_item_name").allTextContents();
        List<String> ordenados = new ArrayList<>(nombres);
        Collections.sort(ordenados, Collections.reverseOrder());
        return nombres.equals(ordenados);
    }

    public boolean validarPrecioAscendente(){
        List<String> precios = page.locator(".inventory_item_price").allTextContents();
        List<Double> valores = precios.stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .collect(Collectors.toList());
        List<Double> ordenados = new ArrayList<>(valores);
        Collections.sort(ordenados);
        return valores.equals(ordenados);

    }
    public boolean validarPrecioDescendente() {
        List<String> precios = page.locator(".inventory_item_price").allTextContents();
        List<Double> valores = precios.stream()
                .map(p -> Double.parseDouble(p.replace("$", "")))
                .collect(Collectors.toList());
        List<Double> ordenados = new ArrayList<>(valores);
        ordenados.sort(Collections.reverseOrder());
        return valores.equals(ordenados);
    }




}
