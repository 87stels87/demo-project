package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ShopPage {
    private SelenideElement
            curatorLinkByIgromaniya = $x(".//span[contains(text(),'Игромания')]");


    public ShopPage checkVisibleCuratorIconAndTextByShopPage() {
        curatorLinkByIgromaniya.shouldBe(visible);
        return this;
    }
}
