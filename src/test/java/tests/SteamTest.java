package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Owner;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;
import pages.SupportPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SteamTest {
    MainPage mainPage = new MainPage();
    SupportPage supportPage = new SupportPage();


    @BeforeAll
    public static void setupBrowser() {

        Configuration.browser = System.getProperty("browser");
        Configuration.browserVersion = System.getProperty("browserVersion");
        Configuration.headless = false;
      //  Configuration.remote = "http://176.108.250.152:4444/wd/hub/";
        Configuration.remote = System.getProperty("selenide.remote");
        Configuration.webdriverLogsEnabled = true;

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }


    @BeforeEach
    public void setUp() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://store.steampowered.com/");
        if (!mainPage.language_pulldown.getText().equals("язык"))
            mainPage.clickByLinkSelectLanguage().changeLanguage("russian");
    }

    @AfterEach
    public void addAttachments() {
        Attach.screenshotAs("last screen");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

//    @Test
//    public void negativeAuthorizationWithInvalidLogin() {
//
//        mainPage.clickByLinkLoginPage()
//                .setLoginAndPassword("login", "x")
//                .checkInvalidLoginMessage();
//    }

    @Test
    @DisplayName("Тест на проверку наименований пунктов поддержки. Используется степовый подход.")
    @Owner("okatev")
    public void checkNameSupportFields1() {
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
                    supportPage.checkSupportFields();
                }
        );

    }

    @Test
    public void checkNameSupportFields2() {
        mainPage.clickByLinkSupportPage()
                .openSupportFields()
                .checkSupportFields();
    }


/*    @Test
    public void checkVisibleCuratorIconAndTextByShopPage() {
        mainPage.clickByLinkShopPage()
                .checkVisibleCuratorIconAndTextByShopPage();

    }*/


    @CsvSource(value = {
            "spanish, TIENDA",
            "english, STORE",
            "german, SHOP",
            "turkish, MAĞAZA      "

    })
    @ParameterizedTest(name = "Для локали = {0} должен отображаться текст в ссылке Магазин = {1}")
    public void testqwe(String testData, String expectedText) {
        mainPage.clickByLinkSelectLanguage()
                .changeLanguage(testData)
                .checkTextInLinkShop(expectedText);
    }

}
