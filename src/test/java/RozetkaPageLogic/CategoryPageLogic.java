package RozetkaPageLogic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CategoryPageLogic {

    SelenideElement categoryLaptops =  $(By.xpath("//a[contains(@href, '/ua/notebooks/c80004/')]"));

    public SearchPageLogic clickOnCategoryLaptops (SelenideElement categoryLaptops) {
        categoryLaptops.shouldBe(Condition.visible).click();
        return page(SearchPageLogic.class);
    }
}
