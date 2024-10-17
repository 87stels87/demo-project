package tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.MainPage;
import pages.SupportPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SteamTest {
    MainPage mainPage = new MainPage();
    SupportPage supportPage = new SupportPage();

    @Test
    public void negativeAuthorizationWithInvalidLogin() {
        open("https://store.steampowered.com/");
        mainPage.clickByLinkLoginPage()
                .setLoginAndPassword("login", "x")
                .checkInvalidLoginMessage();
    }

    @Test
    @DisplayName("Тест на проверку наименований пунктов поддержки. Используется степовый подход.")
    @Owner("okatev")
    public void checkNameSupportFields1() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открываем главную страницу", () -> {
                    open("https://store.steampowered.com/");
                }
        );
        step("На главной странице кликаем по ссылке Поддержка", () -> {
                    ;
                    mainPage.clickByLinkSupportPage();
                }
        );
        step("Переходим на страницу поддержки", () -> {
                    ;
                    supportPage.openSupportFields();
                }
        );
        step("Проверяем наименования полей на странице поддержки", () -> {
                    supportPage.openSupportFields();
                }
        );

    }

    @Test
    public void checkNameSupportFields2() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://store.steampowered.com/");
        mainPage.clickByLinkSupportPage()
                .openSupportFields()
                .checkSupportFields();
    }


//    @Test
//    public void checkVisibleCuratorIconAndTextByShopPage() {
//        SelenideLogger.addListener("allure", new AllureSelenide());
//        open("https://store.steampowered.com/");
//        mainPage.clickByLinkShopPage()
//                .checkVisibleCuratorIconAndTextByShopPage();
//
//    }


//    @CsvSource(value = {
//            "Español - España (испанский), TIENDA",
//            "English (inglés), STORE",
//            "Deutsch (German), SHOP",
//            "Русский (Russisch), МАГАЗИН"
//
//    })
//    @ParameterizedTest(name = "Для локали = {0} должен отображаться текст в ссылке Магазин = {1}")
//    public void testqwe(String testData, String expectedText) {
//        open("https://store.steampowered.com/");
//        mainPage.clickByLinkSelectLanguage()
//                .changeLanguage(testData)
//                .checkTextInLinkShop(expectedText);
//    }

}
