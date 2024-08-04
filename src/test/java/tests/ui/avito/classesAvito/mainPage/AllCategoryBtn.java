package tests.ui.avito.classesAvito.mainPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class AllCategoryBtn {
    SelenideElement allCategoryBtn = $x("//span[@class='styles-module-size_ms-YUHT8']");
    ElementsCollection listCategoryBtn = $$x("//div[@class='new-rubricator-content-rootCategory__text-yCz_U']");


    public AllCategoryBtn clickAllCategoryBtn(){
        allCategoryBtn.should(Condition.enabled).click();
        return this;
    }

    public AllCategoryBtn hoverCategoryElement(){
        Random random = new Random();
        int randomInd = random.nextInt(listCategoryBtn.size()-1);

        if(randomInd <= 7){
            listCategoryBtn.get(randomInd).should(Condition.enabled).hover();
        }
        else {
            listCategoryBtn.get(randomInd).should().should(Condition.enabled).scrollTo().hover();
        }
        return this;
    }
}
