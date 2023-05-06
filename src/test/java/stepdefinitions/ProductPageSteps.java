package stepdefinitions;

import io.cucumber.java.en.And;
import pages.ProductPage;
import utilities.DriverManager;

public class ProductPageSteps {
    ProductPage productPage = new ProductPage(DriverManager.getDriver());


    @And("user add the product to shopping cart on the Product Page")
    public void userAddTheProductToShoppingCartOnTheProductPage() {
        productPage.addToCart();
    }

    @And("user taps {string} size on the Product Page")
    public void userTapsSizeOnTheProductPage(String size) {
        productPage.chooseSize(size);
        productPage.addToCartAgain();

    }


}
