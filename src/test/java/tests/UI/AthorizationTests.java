package tests.UI;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static helpers.DataHelper.dataConfig;
import static io.qameta.allure.Allure.step;

@Feature("Проверка авторизации")
public class AthorizationTests extends TestBase {

    @Test
    @DisplayName("Авторизация с валидными данными")
    public void athorizationWithValidCredentials(){
        step("Открывам главную страницу", () -> {
            open("https://m2.ru/");
        });
        step("Кликаем на Войти", () -> {
            $("a[href=\"/login\"] button").click();
        });
        step("Проверяем наличие вкладки вход", () -> {
            $("button[data-test=\"login-tab\"] span").shouldHave(Condition.text("Вход"));
        });
        step("Вводим логин", () -> {
            $("input[autocomplete=\"username\"]").setValue(dataConfig.testUser());
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[type=\"submit\"]").click();
        });
        step("Вводим пароль", () -> {
            $("input[autocomplete=\"current-password\"").setValue(dataConfig.testPassword());
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[type=\"submit\"]").click();
        });
        step("Проверяем заголовок в личном кабинете", () -> {
            $(byText("Поиск квартиры")).shouldBe();
        });
    }

    @Test
    @DisplayName("Авторизация с невалидными данными")
    public void athorizationWithInvalidCredentials(){
        step("Открывам главную страницу", () -> {
            open("https://m2.ru/");
        });
        step("Кликаем на Войти", () -> {
            $("a[href=\"/login\"] button").click();
        });
        step("Проверяем наличие вкладки вход", () -> {
            $("button[data-test=\"login-tab\"] span")
                    .shouldHave(Condition.text("Вход"));
        });
        step("Вводим логин", () -> {
            $("input[autocomplete=\"username\"]").setValue(dataConfig.testUser());
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[type=\"submit\"]").click();
        });
        step("Вводим пароль", () -> {
            $("input[autocomplete=\"current-password\"").setValue(dataConfig.testPassword());
        });
        step("Нажимаем на кнопку Продолжить", () -> {
            $("button[type=\"submit\"]").click();
        });
        step("Проверяем наличие подписи о некорректном логине или пароле", () -> {
            $("span[class~=\"auth_input-module__hint___2yscB\"]")
                    .shouldHave(Condition.text("Неправильный логин и/или пароль"));
        });
    }
}
