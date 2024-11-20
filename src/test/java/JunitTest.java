import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.assertj.core.api.Assertions.assertThat;

public class JunitTest extends TestBase {
    String number = "77777777777";
    String date = "11111999";
    String parol = "qwerty123";
    Data data = new Data();


    @CsvSource(value = {
            "Хоккей, https://betboom.ru/sport/ice-hockey",
            "Баскетбол, https://betboom.ru/sport/basketball",
            "Теннис, https://betboom.ru/sport/tennis"
    })
    @ParameterizedTest(name = "При выборе раздела {0} должен быть урл {1}")
    @Tag("Smoke")
    void shouldRedirectToCorrectPage(String sectionName, String expectedLink) {
        data.selectSection(sectionName);
        assertThat(url()).isEqualTo(expectedLink);
    }

    @Tag("SmokeForRegistration")
    void registrationField(){
        data.registrationButton()
                .phoneField(number)
                .passwordField(parol)
                .dateField(date);
    }
    @ParameterizedTest
    @CsvFileSource(resources = "/test_data/RegistrationField.csv", numLinesToSkip = 1)
    @Tag("SmokeForRegistration1")
    void registrationFieldWithFile(String phone, String password, String birthDate) {
        data.registrationButton()
                .phoneField(phone)
                .passwordField(password)
                .dateField(birthDate);
    }
}
