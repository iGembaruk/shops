package tests.ui.avito.classesAvito.mainPage.ismainpagenextresult;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class TwoPageNextResult {
    SelenideElement h1 = $x("//h1[@class='page-title-text-tSffu page-title-inline-zBPFx']");
    ElementsCollection listFirstProducts = $$x("//div[@class='items-items-kAJAg'and@data-marker='catalog-serp']/div");
    SelenideElement inputFilterPriceTo = $x("//input[@class='styles-module-input-Lisnt' and contains(@marker, 'from')]");
    SelenideElement inputFilterPriceFinal = $x("//input[@class='styles-module-input-Lisnt' and not(contains(@marker, 'from'))]");



    public TwoPageNextResult assertionsHeaderHasInputSearchString(String string){
        h1.should(Condition.partialText(string));
        return this;
    }

    public CardPage textContentIsSearchString(String string){
        listFirstProducts.find(Condition.partialText(string)).click();
        return page(CardPage.class);
    }

    public TwoPageNextResult inputPriceTo(Integer price1){
        inputFilterPriceTo.should(Condition.visible).setValue(Integer.toString(price1));
        inputFilterPriceTo.should(Condition.value(Integer.toString(price1)));
        return this;
    }

    public TwoPageNextResult inputPriceFinal(Integer price2){
        inputFilterPriceFinal.should(Condition.visible).setValue(Integer.toString(price2));
        inputFilterPriceFinal.should(Condition.value(Integer.toString(price2)));
        return this;
    }



}
