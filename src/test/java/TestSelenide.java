import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestSelenide {
    @Test
    void testSelenide(){
        open("https://github.com/selenide/selenide/");
        $("#wiki-tab").click();

        $("#wiki-pages-filter").setValue("Soft").pressEnter();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class}) class Tests { @Test void test() { Configuration.assertionMode = SOFT; open(\"page.html\"); $(\"#first\").should(visible).click(); $(\"#second\").should(visible).click(); }  }\n"));


    }

}
