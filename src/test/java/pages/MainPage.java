package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String BASE_URL = "https://store.steampowered.com/";
    private SelenideElement
            linkToLoginPage = $("[class='global_action_link']"),
            sectionShop = $x("(.//*[@class='pulldown_desktop'])[1]"),
            linkToSupportPage = $x("(.//*[@class='menuitem '])[4]"),
            linkShopPageThroughTheSectionCuratorsSteam = $x(".//*[@class='popup_menu_item' and contains(text(), 'Кураторы Steam')]"),

            selectLanguageButton = $("[id='language_pulldown']"),

            selectedLanguage = $("#language_dropdown"),

            linkShop = $x("(.//*[@href='https://store.steampowered.com/?snr=1_4_4__global-header'])[2]"),

             selectedLanguage2 = $x(".//*[@href='?l=russian']");





    public LoginPage clickByLinkLoginPage() {
        open(BASE_URL);
        linkToLoginPage.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }

    public SupportPage clickByLinkSupportPage() {
        open(BASE_URL);
        linkToSupportPage.click();
        SupportPage supportPage = page(SupportPage.class);
        return supportPage;
    }

    public ShopPage clickByLinkShopPage() {
        open(BASE_URL);
        sectionShop.hover();
        linkShopPageThroughTheSectionCuratorsSteam.click();
        ShopPage shopPage = page(ShopPage.class);
        return shopPage;
    }

    public MainPage clickByLinkSelectLanguage() {
        open(BASE_URL);
        selectLanguageButton.click();
        return this;
    }

    public MainPage changeLanguage(String language) {
     //   selectedLanguage.find(byText((language))).click();
        selectedLanguage.find("[href='?l="+language+"']");
        return this;
    }

    public void checkTextInLinkShop(String expectedText) {
        linkShop.shouldBe(text(expectedText));
    }
}
