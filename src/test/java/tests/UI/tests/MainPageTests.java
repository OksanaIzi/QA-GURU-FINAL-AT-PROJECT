package tests.UI.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import tests.TestBase;
import tests.UI.steps.MainPageSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;


public class MainPageTests extends TestBase {

    public final static String BASE_URL = "https://m2.ru/";

    MainPageSteps steps = new MainPageSteps();

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Проверка заголовка страницы")
    public void checkSuccessfulOpenPage(){
        steps.openPage(BASE_URL)
                .checkTitle();
    }

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Проверка отображения разделов меню")
    public void checkItemsIsDisplayed(){
        steps.openPage(BASE_URL)
                .checkItemsOnMainPage();
    }

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @DisplayName("Проверка отображаения разделов основного меню")
    public void checkItemsBaseMenuAreDisplayed(){
        steps.openPage(BASE_URL)
                .checkMenuItemBase();
    }

}
