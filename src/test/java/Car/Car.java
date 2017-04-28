package Car;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Rule;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class Car extends BaseTest {

    String mail = "kurinniy.a@ki-technology.ru";
    String pass = "aktest";
    //String pass = "123456"; // Staging password

    @Rule
    public TextReport textReport = new TextReport();

    static {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://car.tickets.ua";
        //Configuration.baseUrl = "https://car.tickets.ua.default.staging.ttndev.com/";
        //Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void simpleCarBookTest(){

        //Language: RUS

        open("");

        //Search Form

//        $(".country_select").click();
//        int size = $$(".country_select ul>li").size();
//        String country = $(".country_select ul>li", RandomUtils.nextInt(1, size)).getText();
//        $(".country_select input").setValue(country).click();

//        $(".country_select a").click();
//        int size = $$(".country_select ul>li").size();
//        $(".country_select ul>li", RandomUtils.nextInt(0, size)).scrollTo().click();

        $("[class='chosen-single chosen-default']").click();
        $("[data-option-array-index='3']").click();
        $("[id='pu_date']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
        $("[id='do_date']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("21")).click();
        $("[class='search_button']").click();
        //$("[class='buy_button']").shouldBe(Condition.visible);
        $$("[class='buy_button']").get(0).click();
        Selenide.switchTo().window(1);

        // Contact Data
        // Enter registered email
        $("[id='email']").click();
        $("[id='email']").setValue(mail);
        $$("[id='pass']").findBy(Condition.visible).click();
        $("[id='pass']").setValue(pass).pressEnter();

        //Add Saved Passenger's Data
        $(".add_passenger").click();
        $(".pasanger_select_row .submit").click();
        //$$("[input]").findBy(Condition.visible).click();

        //Add New Passenger Data

//        $("[id='last_name']").click();
//        $("[id='last_name']").setValue("Romanov");
//        $("[id='first_name']").click();
//        $("[id='first_name']").setValue("Roman");
//        $("[id='birthday_day']").click();
//        $("[id='birthday_day']").setValue("08");
//        $("[id='birthday_month']").click();
//        $("[id='birthday_month']").setValue("08");
//        $("[id='birthday_year']").click();
//        $("[id='birthday_year']").setValue("1988");
//        $(".sex label").hover().click();
//        $("#passengers_gender-M").closest(".icheckbox_minimal").click();


        //Payment Form

        $("[id='card_number_0']").click();
        $("[id='card_number_0']").setValue("4111");
        $("[id='card_number_1']").setValue("1111");
        $("[id='card_number_2']").setValue("1111");
        $("[id='card_number_3']").setValue("1111");
        $("[id='card_date_month']").setValue("10");
        $("[id='card_date_year']").setValue("19");
        $("[id='card_cvv']").setValue("571");
        $("[id='card_holder']").click();
        $("[id='card_holder']").setValue("adsad fdgdfg");

        $("[class='booking_price_button'] input").click();
        $("#acceptIATA > div").hover().click();
        //$("[class='booking_price_button'] input").click();
        //$(".btn cancel js-magnific-link").shouldBe(Condition.visible).click();
        //$(".popup_cancel__confirm").shouldBe(Condition.visible).click();

    }

    @Test
    public void oTest(){
        open("");
        $(".country_select").click();
        int size = $$(".country_select ul>li").size();
        System.out.println(size);
        String country = $(".country_select ul>li", RandomUtils.nextInt(1, size)).getText();
        $(".country_select input").setValue(country).pressEnter();
    }

    @Test
    public void scrolTest(){
        open("");
        $(".country_select a").click();
        int size = $$(".country_select ul>li").size();
        $(".country_select ul>li", RandomUtils.nextInt(0, size)).scrollTo().click();
    }

    @Test

    public void validationTestCar() {

        //Main page

        open("");
        $("[class='search_button']").click();
        $(".if_error").isDisplayed();

    }


}
