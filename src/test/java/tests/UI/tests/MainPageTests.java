package tests.UI.tests;

import annotations.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.TestBase;
import tests.UI.steps.MainPageSteps;

@Layer("web")
@Owner("Izibekova")
public class MainPageTests extends TestBase {

    public final static String BASE_URL = "https://m2.ru/";

    MainPageSteps steps = new MainPageSteps();

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @AutoMember("Izibekova")
    @ManualMember("Izibekova")
    @JiraIssues({@JiraIssue("QC5-9")})
    @DisplayName("Проверка заголовка страницы")
    public void checkSuccessfulOpenPage() {
        steps.openPage(BASE_URL)
                .checkTitle();
    }

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @AutoMember("Izibekova")
    @ManualMember("Izibekova")
    @JiraIssues({@JiraIssue("QC5-9")})
    @DisplayName("Проверка отображения разделов меню")
    public void checkItemsIsDisplayed() {
        steps.openPage(BASE_URL)
                .checkItemsOnMainPage();
    }

    @Test
    @Feature("Главная страница")
    @Tags({@Tag("regress"), @Tag("web")})
    @AutoMember("Izibekova")
    @ManualMember("Izibekova")
    @JiraIssues({@JiraIssue("QC5-9")})
    @DisplayName("Проверка отображаения разделов основного меню")
    public void checkItemsBaseMenuAreDisplayed() {
        steps.openPage(BASE_URL)
                .checkMenuItemBase();
    }
}
