package tests.ui.ozon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tests.ui.ozon.classesOzon.MainPageOzon;

public class MainTestsOzon {
    private String inputStringFilters = "Шахматы";
    @BeforeEach
    public void setUp(){
        Configuration.baseUrl = "https://www.ozon.ru";
        Configuration.browserSize = "1366x768";
        Configuration.headless = false;
        Configuration.timeout = 15000;
    }
    @Test
    public void firstTest(){
        Selenide.open("/");
        MainPageOzon mainPage = new MainPageOzon();
        mainPage.inputStringSearchProduct(inputStringFilters);
    }
}
