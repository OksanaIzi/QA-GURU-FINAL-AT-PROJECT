package tests.UI;

import annotations.Layer;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Layer("web")
@Owner("Izibekova")
@Feature("Главная страница - разделы меню")
public class BaseMenuTests extends TestBase {

    @Test
    @Story("Снять квартиру")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Снять 2-комн квартиру")
    public void rentFlatTest(){
        step("Открывам главную страницу", () -> {
            open("https://m2.ru/");
        });
        step("Кликаем на Снять", () -> {
            $("button[data-test=\"rent-tab\"]").click();
        });
        step("Заполняем поля", () -> {
            $("button[data-test=\"categoryType-trigger\"] span").shouldHave(Condition.text("Квартиру"));
            $("button[data-test=\"room-select-trigger\"]").click();
            $("input[name=\"ROOM_2\"]").parent().parent().click();
            $("button[data-test=\"price-popup-toggle\"]").click();
            $("input[placeholder=\"от\"]").setValue("35000");
            $("input[placeholder=\"до\"]").setValue("65000");
            $("button[data-test=\"price-popup-toggle\"]").click();
            $("button[data-test=\"region-select-trigger\"] span").shouldHave(Condition.text("Москва"));
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[data-gtm=\"main-click-promo-block-renttab-search-button\"]").click();
        });
        step("Проверяем, что результаты поиска соответствуют заданным", () -> {
            $("button[data-test=\"rooms-trigger\"] span").shouldHave(Condition.text("2 комнаты"));
            $("button[data-test=\"price-trigger\"] span span").shouldHave(Condition.text("35 – 65 тыс ₽"));
        });
    }

    @Test
    @Story("Проверить оценку недвижимости")
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("Сервисы - оценка недвижимости")
    public void checkServiceTest(){
        step("Открывам главную страницу", () -> {
            open("https://m2.ru/");
        });
        step("Кликаем на Сервисы", () -> {
            $("button[data-test=\"service-tab\"]").click();
        });
        step("Заполняем поля", () -> {
            $("button[aria-haspopup=\"listbox\"]").click();
            $$("ul[role=\"listbox\"]").get(0).click();
            $("input[placeholder=\"Введите адрес квартиры\"]").setValue("Москва генерала белова 28к3 кв 456");
            $("div[data-test=\"address-list\"] div[index=\"0\"]").click();
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[data-gtm=\"main-click-promo-block-servicetab-continue-button\"").click();
        });
        step("Проверяем, что есть разделы Купить и Продать", () -> {
            $(byText("Продать")).shouldBe();
            $(byText("Купить")).shouldBe();
        });
    }
}
