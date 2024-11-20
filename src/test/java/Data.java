import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Data {
    public static void openPage() {
        open("sport");
    }

    public Data selectSection(String sectionName) {
        $("div[data-at-title='" + sectionName + "']")
                .shouldBe(visible, Duration.ofSeconds(30))
                .click();
        return this;
    }
}
