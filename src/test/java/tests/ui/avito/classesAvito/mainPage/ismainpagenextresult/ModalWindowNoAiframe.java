package tests.ui.avito.classesAvito.mainPage.ismainpagenextresult;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class ModalWindowNoAiframe {
    //SelenideElement iframeModalIsRibbon = $x("//iframe[contains(@src,'https://content.adriver.ru')]");
    SelenideElement arrowLeftBtnNoIframe = $x("//div[contains(@class, 'leftButton')]//button[@class='story-viewer-arrow-ke0it']");
    SelenideElement arrowRightBtnNoIframe = $x("//div[@class='story-viewer-coverButton-HbDTz']/button[@class='story-viewer-arrow-ke0it']");
    ElementsCollection listArrowLeftBtnNoIframe = $$x("//div[contains(@class, 'leftButton')]//button[@class='story-viewer-arrow-ke0it']");
    ElementsCollection listArrowRightBtnNoIframe = $$x("//div[@class='story-viewer-coverButton-HbDTz']/button[@class='story-viewer-arrow-ke0it']");
    SelenideElement exitCrossBnt = $x("//button[@class='story-viewer-close-DmRwu']");

    SelenideElement clickNoIframeNewPage = $x("//a[@class='action']");

    public ModalWindowNoAiframe enterNoIframeArrowRight() {
        //Selenide.switchTo().frame(iframeModalIsRibbon); здесь не нужен айфрейм
        while (arrowRightBtnNoIframe.exists()) {
            arrowRightBtnNoIframe.click();
        }
        return this;
    }

    public ModalWindowNoAiframe enterNoIframeArrowLeft() {
        //Selenide.switchTo().frame(iframeModalIsRibbon); здесь не нужен айфрейм
        while (arrowLeftBtnNoIframe.exists()) {
            arrowLeftBtnNoIframe.click();
        }
        return this;
    }
    public TwoPageIsRibbon enterNoIframeRibbonButtonNewPageIsRibbon(){
        clickNoIframeNewPage.should(Condition.visible).click();//не кликается
        return page(TwoPageIsRibbon.class);
    }
    public ModalWindowNoAiframe exitClickModalWindow(){
        exitCrossBnt.click();
        return this;
    }
}
