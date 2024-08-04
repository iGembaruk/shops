package tests.ui.ozon.classesOzon;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPageOzon {
    SelenideElement searchString = $x("//input[contains(@placeholder, 'Искать на Ozon')]");

    public MainPageOzon inputStringSearchProduct(String string){
    searchString.should(Condition.visible).setValue(string).sendKeys(Keys.ENTER);
        return this;
    }
}
