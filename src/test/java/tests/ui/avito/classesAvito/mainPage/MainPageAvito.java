package tests.ui.avito.classesAvito.mainPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import tests.ui.avito.classesAvito.mainPage.ismainpagenextresult.CardPage;
import tests.ui.avito.classesAvito.mainPage.ismainpagenextresult.TwoPageNextResult;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class MainPageAvito {
    SelenideElement searchString = $x("//input[@data-marker='search-form/suggest']");
    SelenideElement primaryElementProduct = $x("//div[@class='styles-list-M1e9B']/div[1]");



    public TwoPageNextResult inputStringSearchProduct(String string){
        searchString.should(Condition.visible).setValue(string).sendKeys(Keys.ENTER);
        return page(TwoPageNextResult.class);
    }

    public CardPage enterPrimaryElementProduct(){
        primaryElementProduct.should(Condition.visible).click();
        return page(CardPage.class);
    }


}
