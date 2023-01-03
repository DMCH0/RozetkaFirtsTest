package RozetkaPageLogic;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPageLogic {

    SelenideElement categoryLaptopsAndPc = $(By.xpath("//a[@class='menu-categories__link']"));

    public CategoryPageLogic clickOnCategoryLaptopsAndPC (SelenideElement categoryLaptopsAndPc){
        categoryLaptopsAndPc.shouldBe(Condition.visible).click();
        return page(CategoryPageLogic.class);
    }
}
