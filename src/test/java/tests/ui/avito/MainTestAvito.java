package tests.ui.avito;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import listener.RetryListener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import tests.ui.avito.classesAvito.mainPage.AllCategoryBtn;
import tests.ui.avito.classesAvito.mainPage.MainPageAvito;
import tests.ui.avito.classesAvito.mainPage.RibbonRightAndLeft;
import tests.ui.avito.classesAvito.mainPage.ismainpagenextresult.CardPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.closeWebDriver;

//@ExtendWith(RetryListener.class)
public class MainTestAvito {
    private String inputStringFilters = "Шахматы";
    private Integer inputFilterPriceTo = 1000;
    private Integer inputFilterPriceFinal = 5000;


    @BeforeEach
    public void setUp() {
        Configuration.baseUrl = "https://www.avito.ru";
        Configuration.browserSize = "1366x768";
        Configuration.headless = false;
        Configuration.timeout = 15000;
        //Configuration.fastSetValue = true; почему не работает
    }
    @AfterEach
    public void tearDown(){
        closeWebDriver();
    }

    @AfterAll//после запуска всех тестов
    public static void saveFailed() throws IOException {
        RetryListener.saveFailedTests();
    }

    @Test
    public void assertionsPrice1AndPrice2Test(){
        this.inputFilterPriceTo = inputFilterPriceTo;
        this.inputFilterPriceFinal = inputFilterPriceFinal;
        Assertions.assertTrue(inputFilterPriceTo <= inputFilterPriceFinal, inputFilterPriceTo + " не меньше либо равно " + inputFilterPriceFinal);
    }

    @Test
    @Tag("SEARCH")
    public void searchProductPriceToAndFinalTest() {
        Selenide.open("/");
        MainPageAvito mainPageAvito = new MainPageAvito();
        mainPageAvito.inputStringSearchProduct(inputStringFilters)
                .assertionsHeaderHasInputSearchString(inputStringFilters)
                .inputPriceTo(inputFilterPriceTo);
                //.inputPriceFinal(inputFilterPriceFinal);
    }

    @Test
    @Tag("SEARCH")
    public void searchProductContentTest() {
        Selenide.open("/");
        MainPageAvito mainPageAvito = new MainPageAvito();
        mainPageAvito.inputStringSearchProduct(inputStringFilters)
                .assertionsHeaderHasInputSearchString(inputStringFilters)
                .textContentIsSearchString(inputStringFilters);
    }


    @Test// в общем потоке падает ошибка если нет @AfterEach, нужно научиться понимать как закрывать окна чтобы возвращаться к нужному месту
    public void searchProductContentTestAndFitersTest() {
        Selenide.open("/");
        MainPageAvito mainPageAvito = new MainPageAvito();
        mainPageAvito.inputStringSearchProduct(inputStringFilters)
                .assertionsHeaderHasInputSearchString(inputStringFilters)
                .textContentIsSearchString(inputStringFilters)
                .switchNewWindowCardProduct()
                .assertionsH1StringInput(inputStringFilters)
                .switchOldWindow(CardPage.class);
    }

    @Disabled("пока не для моего ума")
    public void categoryRandomTest(){
        Selenide.open("/");
        AllCategoryBtn allCategoryBtn = new AllCategoryBtn();
        allCategoryBtn.clickAllCategoryBtn()
                .hoverCategoryElement();
    }
    @Tag("RIBBON")
    @Test
    public void assertionClickRibbonArrowRightAndLeftTest(){
        Selenide.open("/");
        RibbonRightAndLeft ribbonRightAndLeft = new RibbonRightAndLeft();
        ribbonRightAndLeft.clickArrowRightToInvisible()
                .clickArrowLeftToInvisible();
    }


    @Test
    public void enterAndExitModalWindowTest(){
        Selenide.open("/");
        RibbonRightAndLeft ribbonClick = new RibbonRightAndLeft();
        ribbonClick.enterTwoElementIsRibbon()
                .exitClickModalWindow();
    }

    //@Disabled("Вопросы, так как элемент не кликабельный")
    @Test
    public void assertionClickRibbonTest(){
        Selenide.open("/");
        RibbonRightAndLeft ribbonClick = new RibbonRightAndLeft();
        ribbonClick.enterTwoElementIsRibbon()//здесь ок, открывает второй элемент из ленты
                .enterNoIframeRibbonButtonNewPageIsRibbon();
    }

    @Tag("RIBBON")
    @Test
    public void assertionClickInEnterRibbonNoIframeArraysRightAndLeftTest(){
        Selenide.open("/");
        RibbonRightAndLeft ribbonClick = new RibbonRightAndLeft();
        ribbonClick.enterTwoElementIsRibbon()
                .enterNoIframeArrowRight()
                .enterNoIframeArrowLeft();
    }
    @Tag("SWITCHWINDOWS")
    @Test
    public void switchNewWindowsTest(){
        Selenide.open("/");
        MainPageAvito mainPageAvito = new MainPageAvito();
        mainPageAvito.enterPrimaryElementProduct()
                .switchNewWindowCardProduct();
    }
}
