import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://betboom.ru/";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
        Configuration.timeout = 10000;
    }

    @BeforeEach
    public void preparation() {
        Data.openPage();
    }
}
