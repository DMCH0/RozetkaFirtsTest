package RozetkaPageLogic;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    private final MainPageLogic MAIN_PAGE_LOGIC = new MainPageLogic();
    private final CategoryPageLogic CATEGORY_PAGE_LOGIC = new CategoryPageLogic();
    private final SearchPageLogic SEARCH_PAGE_LOGIC = new SearchPageLogic();
    private final CartPageLogic CART_PAGE_LOGIC = new CartPageLogic();

    @BeforeMethod
    public void before() {
        Configuration.browserSize = "1730x950";
        open("https://rozetka.com.ua/ua/");
    }
    @Test
    public void RozetkaFirstTest() throws IOException {

        MAIN_PAGE_LOGIC
                .clickOnCategoryLaptopsAndPC(MAIN_PAGE_LOGIC.categoryLaptopsAndPc)
                .clickOnCategoryLaptops(CATEGORY_PAGE_LOGIC.categoryLaptops)
                .addFirstProductToBasket(SEARCH_PAGE_LOGIC.addFirstProductToBasket)
                .checkBasketCounter("1")
                .goToBasket(SEARCH_PAGE_LOGIC.clickOnBasketIcon);

        String productTitleOnSearchPage = SEARCH_PAGE_LOGIC.searchPageTitle();

        String productTitleInBasket = CART_PAGE_LOGIC.getTitleOnBasket();

        Assert.assertEquals(productTitleOnSearchPage,productTitleInBasket);

        String productPriceInBasket = CART_PAGE_LOGIC.getProductPrice();

        HashMap<String, String> productInfo = new HashMap<>();
        productInfo.put(productTitleInBasket, productPriceInBasket);

        FileWriter fileWriter = new FileWriter("product.txt");
        fileWriter.write(String.valueOf(productInfo));
        fileWriter.close();
    }
}
