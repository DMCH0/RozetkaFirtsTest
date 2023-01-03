package RozetkaPageLogic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.*;

public class SearchPageLogic {

    SelenideElement firstProductInList = $(By.xpath("//span[@class='goods-tile__title']"));
    SelenideElement addFirstProductToBasket = $(By.xpath("//app-buy-button[@extclass='goods-tile__buy-button']"));
    SelenideElement clickOnBasketIcon = $(By.xpath("//*[contains(@class, 'badge')]"));

    public String searchPageTitle() {
        return firstProductInList.shouldBe(Condition.visible).text().trim();
    }
    public SearchPageLogic addFirstProductToBasket(SelenideElement addFirstProductToBasket) {
        addFirstProductToBasket.shouldBe(Condition.visible).click();
        return this;
    }
    public  SearchPageLogic checkBasketCounter (String expectedCount){
        String countAttribute = clickOnBasketIcon.shouldBe(Condition.visible).getAttribute("innerText");
        Assert.assertEquals(countAttribute,expectedCount);
        return this;
    }

    public CartPageLogic goToBasket (SelenideElement clickOnBasketIcon) {
        clickOnBasketIcon.click();
        return page(CartPageLogic.class);
    }
}
