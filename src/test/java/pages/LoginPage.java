package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {

    private SelenideElement
            loginForm = $x("(.//*[@type='text'])[1]"),
            passwordForm = $("[type='password']"),
            submitButton = $x("(.//*[@type='submit'])[1]"),

    invalidMessageByInvalidLoginOrPassword = $x(".//*[text()='Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова.']");

    public LoginPage setLoginAndPassword(String login, String password) {
        loginForm.setValue(login);
        passwordForm.setValue(password);
        submitButton.click();
        return this;
    }

    public void checkInvalidLoginMessage() {
        invalidMessageByInvalidLoginOrPassword
                .shouldBe(visible)
                .shouldBe(exactText("Пожалуйста, проверьте свой пароль и имя аккаунта и попробуйте снова."));

    }
}
