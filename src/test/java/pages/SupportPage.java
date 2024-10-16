package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.HashSet;
import java.util.Set;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SupportPage {
    private SelenideElement
            helpButton = $(" [class='btn_medium btnv6_blue_hoverfade btn_login_nag_right']");

    private ElementsCollection
            collectionSupportFields = $$("[class='help_wizard_button help_wizard_arrow_right']");


    public SupportPage openSupportFields() {
        helpButton.click();
        return this;
    }

    public void checkSupportFields() {
        collectionSupportFields.shouldHave(size(4));
        collectionSupportFields.get(0).shouldBe(exactText("Я не помню имя или пароль своего аккаунта Steam"));
        collectionSupportFields.get(1).shouldBe(exactText("Мой аккаунт украли, помогите восстановить его"));
        collectionSupportFields.get(2).shouldBe(exactText("Письмо с кодом Steam Guard не пришло"));
        collectionSupportFields.get(3).shouldBe(exactText("Мой мобильный аутентификатор Steam был удален или утерян"));
    }
}
