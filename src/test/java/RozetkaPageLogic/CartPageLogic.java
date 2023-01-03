package RozetkaPageLogic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class CartPageLogic {

    SelenideElement titleOfProductInCart = $(By.xpath("//a[contains(@class, 'cart-product__title')]"));
    SelenideElement cartPrice = $(By.xpath("// *[contains(@class, 'sum-price')]"));

    public  String getTitleOnBasket (){
        return titleOfProductInCart.shouldBe(Condition.visible).text().trim();
    }

    public String getProductPrice() {
        return cartPrice.shouldBe(Condition.visible).text();
    }
}

