import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class JunitTest extends TestBase {
    String number = "7";
    String date = "1";
    String parol = "qwerty123";
    Data data = new Data();

    @ParameterizedTest
    @CsvSource({
            "Хоккей, https://betboom.ru/sport/ice-hockey",
            "Баскетбол, https://betboom.ru/sport/basketball",
            "Теннис, https://betboom.ru/sport/tennis"
    })
    void shouldRedirectToCorrectPage(String sectionName, String expectedLink) {
        data.selectSection(sectionName);
        assertThat(url()).isEqualTo(expectedLink);
    }


    @Test
    void RegistrationField(){
        data.registrationButton()
                .phoneField(number)
                .passwordField(parol)
                .dateField(date);
    }
}
