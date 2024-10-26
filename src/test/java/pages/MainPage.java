package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private final String BASE_URL = "https://store.steampowered.com/";
    private SelenideElement
            linkToLoginPage = $("[class='global_action_link']");
    private SelenideElement sectionShop = $("[id='foryou_tab']");
    private SelenideElement linkToSupportPage = $x("(.//*[@class='menuitem '])[4]");
    private SelenideElement linkShopPageThroughTheSectionCuratorsSteam = $x(".//*[@class='popup_menu_item' and contains(text(), 'Кураторы Steam')]");

    private SelenideElement linkShopPageThroughTheSectionCuratorsSteam2 = $("[href='https://store.steampowered.com/curators/?snr=1_4_4__12']");
    private SelenideElement selectLanguageButton = $("[id='language_pulldown']");

    private SelenideElement selectedLanguage = $("#language_dropdown");

    private SelenideElement linkShop = $x("(.//*[@href='https://store.steampowered.com/?snr=1_4_4__global-header'])[2]");

    public SelenideElement language_pulldown = $("[id='language_pulldown']");


    public LoginPage clickByLinkLoginPage() {
//        open(BASE_URL);
        linkToLoginPage.click();
        LoginPage loginPage = page(LoginPage.class);
        return loginPage;
    }

    public SupportPage clickByLinkSupportPage() {
//        open(BASE_URL);
        linkToSupportPage.click();
        SupportPage supportPage = page(SupportPage.class);
        return supportPage;
    }

    public ShopPage clickByLinkShopPage() {
//        open(BASE_URL);
        sectionShop.hover();
        Selenide.sleep(2000);
        linkShopPageThroughTheSectionCuratorsSteam2.click();
        ShopPage shopPage = page(ShopPage.class);
        return shopPage;
    }

    public MainPage clickByLinkSelectLanguage() {
//        open(BASE_URL);
        selectLanguageButton.click();
        return this;
    }

    public MainPage changeLanguage(String language) {
        //   selectedLanguage.find(byText((language))).click();
        selectedLanguage.find("[href='?l=" + language + "']").click();
        return this;
    }

    public void checkTextInLinkShop(String expectedText) {
        Selenide.sleep(4000);
        linkShop.shouldBe(text(expectedText));
    }
}
