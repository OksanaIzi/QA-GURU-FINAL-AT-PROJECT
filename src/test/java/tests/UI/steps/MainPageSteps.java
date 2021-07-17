package tests.UI.steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageSteps {

    @Step("Открываем главную страницу {url}")
    public MainPageSteps openPage(String url) {
        open(url);
        return this;
    }

    @Step("Проверяем заголовок страницы")
    public MainPageSteps checkTitle() {
        $(byTitle("Метр квадратный - ипотека и рефинансирование, онлайн сделки с недвижимостью - на сайте m2.ru")).shouldBe();
        return this;
    }

    @Step("Проверяем разделы меню")
    public MainPageSteps checkItemsOnMainPage() {
        $("button[data-test=\"buy-tab\"]").shouldBe();
        $("button[data-test=\"rent-tab\"]").shouldBe();
        $("button[data-test=\"new-building-tab\"]").shouldBe();
        $("button[data-test=\"mortgage-tab\"]").shouldBe();
        $("button[data-test=\"service-tab\"]").shouldBe();
        $("button[data-test=\"remont-tab\"]").shouldBe();
        return this;
    }

    @Step("Проверяем разделы основного меню")
    public MainPageSteps checkMenuItemBase() {
        $("a[data-test=\"favorites\"]").shouldBe();
        $("a[href=\"/saved-search\"]").shouldBe();
        $("a[href=\"/offer-placement/create\"]").shouldBe();
        $("a[href=\"/login\"]").shouldBe();
        return this;
    }
}