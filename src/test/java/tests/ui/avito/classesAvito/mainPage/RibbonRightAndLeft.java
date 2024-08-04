package tests.ui.avito.classesAvito.mainPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import tests.ui.avito.classesAvito.mainPage.ismainpagenextresult.ModalWindowNoAiframe;

import static com.codeborne.selenide.Selenide.*;

public class RibbonRightAndLeft {
    SelenideElement arrowRightBtn = $x("//button[@class='story-previewer-controlButton-_Y_dh' and contains(@data-marker, 'right')]");
    SelenideElement arrowLeftBtn = $x("//button[@class='story-previewer-controlButton-_Y_dh' and contains(@data-marker, 'left')]");
    ElementsCollection listArrowRightBtn = $$x("//button[@class='story-previewer-controlButton-_Y_dh' and contains(@data-marker, 'right')]");
    ElementsCollection listArrowLeftBtn = $$x("//button[@class='story-previewer-controlButton-_Y_dh' and contains(@data-marker, 'left')]");
    SelenideElement twoElementRibbon = $x("//li[contains(@class, 'styles-module-listItem-SwHQc')and @data-index='1']");

    //SelenideElement iframeModalIsRibbon = $x("//iframe[contains(@src,'https://content.adriver.ru')]");
    SelenideElement arrowLeftBtnNoIframe = $x("//div[contains(@class, 'leftButton')]//button[@class='story-viewer-arrow-ke0it']");
    SelenideElement arrowRightBtnNoIframe = $x("//div[@class='story-viewer-coverButton-HbDTz']/button[@class='story-viewer-arrow-ke0it']");
    ElementsCollection listArrowLeftBtnNoIframe = $$x("//div[contains(@class, 'leftButton')]//button[@class='story-viewer-arrow-ke0it']");
    ElementsCollection listArrowRightBtnNoIframe = $$x("//div[@class='story-viewer-coverButton-HbDTz']/button[@class='story-viewer-arrow-ke0it']");
    SelenideElement exitCrossBnt = $x("//button[@class='story-viewer-close-DmRwu']");

    SelenideElement clickNoIframeNewPage = $x("//a[@class='action']");


    //Этот метод такой же как и стримы, только чрз циклы, но стримы не дебажатся и кажется выполняются только раз, так как в потоке
    public RibbonRightAndLeft clickArrowRightToInvisible(){
        while(arrowRightBtn.exists()){
        arrowRightBtn.click();}
            return this;
    }
    public RibbonRightAndLeft clickArrowLeftToInvisible(){
        while(arrowLeftBtn.exists()){
            arrowLeftBtn.click();
        }
        return this;
    }
//    public RibbonRightAndLeft clickArrowRightToInvisible2(){
//        listArrowRightBtn.stream()
//                .filter(element->element.exists())
//                .forEach(element -> element.click());
//        listArrowLeftBtn.stream()
//                .filter(element -> element.exists())
//                .forEach(element -> element.click());
//        return this;
//    }

    public ModalWindowNoAiframe enterTwoElementIsRibbon(){
        twoElementRibbon.should(Condition.enabled).click();
        return page(ModalWindowNoAiframe.class) ;
    }



}
