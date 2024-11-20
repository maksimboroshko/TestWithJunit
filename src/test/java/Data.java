import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Data {

    private static SelenideElement
registrationButton = $(".Button-sc-zdin7l-0.Header__RegButton-sc-w4usz4-6.gdoIGv"),
    phoneField = $(".sc-hneQBV.gIyqSu"),
    dateField = $("div.sc-bSkxYT input[name='birth_date']"),
    passwordField = $("div.sc-bSkxYT input[name='password']");

    public static void openPage() {
        open("sport");
    }

    public Data selectSection(String sectionName) {
        $("div[data-at-title='" + sectionName + "']")
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
        return this;
    }
    public Data registrationButton() {
        registrationButton.shouldBe(visible,Duration.ofSeconds(30)).shouldHave(text("Регистрация")).click();
        return this;
    }

    public Data phoneField(String value) {
        phoneField.shouldBe(visible, Duration.ofSeconds(30));
        phoneField.shouldBe(enabled, Duration.ofSeconds(30));
        phoneField.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phoneField.setValue(value);
        return this;
    }

    public  Data passwordField(String value) {
        passwordField.click();
        passwordField.setValue(value);
    return this;
    }
    public  Data dateField(String value) {
        dateField.click();
        dateField.setValue(value);
        return this;
    }


}
