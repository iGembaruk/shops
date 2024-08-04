package tests.ui.avito.classesAvito.mainPage.ismainpagenextresult;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Selenide.*;

public class CardPage {
SelenideElement h1 = $x("//h1");
private String mainWindowHandle; //Переменная для сохранения идентификатора основного окна

    public CardPage(){
        mainWindowHandle = WebDriverRunner.getWebDriver().getWindowHandle(); //Сохраняем идентификатор при инициализации в конструкторе
    }

    public String saveFirstWindows(){
        return mainWindowHandle;  //Возвращаем сохранённый идентификатор
    }

    public CardPage switchNewWindowCardProduct(){
        String firstWindow = saveFirstWindows(); // получаем идентификатор текущего окна
        WebDriverRunner.getWebDriver().getWindowHandles().stream()
                .filter(windowHandle -> !firstWindow.equals(windowHandle)) //фильтруем, чтобы найти новое окно
                .findFirst()// Находим первое окно, которое не является оригинальным
                .ifPresent(windowHandle -> WebDriverRunner.getWebDriver().switchTo().window(windowHandle)); // переключаемся на новое окно, если оно найдено

        return this;
    }

    public CardPage assertionsH1StringInput(String filterInputString){
        h1.should(Condition.partialText(filterInputString));
        return this;
    }

    public <T> T exitWindow(Class <T> tClass ){
        Selenide.closeWindow();
        return page(tClass);
    }

    public <T> T switchOldWindow(Class <T> tClass){
        WebDriverRunner.getWebDriver().switchTo().window(mainWindowHandle);
        return page(tClass);
    }
}
