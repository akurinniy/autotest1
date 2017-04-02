import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class Car {

    String mail = "kurinniy.a@ki-technology.ru";
    String pass = "aktest";

    @Rule
    public TextReport textReport = new TextReport();

    static {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://car.tickets.ua";
        Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void quicktest(){
        open("https://car.tickets.ua/search/booking_v2?session_id=58df860f9aaea333f600003a&car_id=58df86119aaea333f600003d");
        $$("[class='field sex']").findBy(Condition.text("м")).click();

        $("[class='booking_price_button'] input").click();
        //$("[id='acceptIATA'] class='iCheck-helper'").click();
        //$("[id='agrement'] class='iCheck-helper'").click();
        $("#acceptIATA > div").hover().click();

        //$("[id='icheckbox_minimal hover'] input").click();
        //$("[id='icheckbox_minimal hover checked']").shouldBe(Condition.visible);


    }

    @Test
    public void simpleCarBookTest(){

        //Language: RUS

        open("");

        //Search Form

        //$("[class='chosen-single chosen-default']").setValue("алб");
        //$("[class='chosen-search' input]").setValue("алб");
        //$(".car_pu_country_id").shouldBe(Condition.visible);
        $("[data-option-array-index='3']").click();
        //$$(".active-result result-selected highlighted'] li").findBy(Condition.text("Албания"));
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
        $("[class='buy_button']").shouldBe(Condition.visible);
        $$("[class='buy_button']").get(0).click();
        Selenide.switchTo().window(1);

        // Contact Data
        // Enter registered email
        $("[id='email']").click();
        $("[id='email']").setValue(mail);
        $$("[id='pass']").findBy(Condition.visible).click();
        $("[id='pass']").setValue(pass).pressEnter();

        //Add Passenger
        //$("[class='add_passenger']").click();
        //$$("[input]").findBy(Condition.visible).click();
        $("[id='last_name']").click();
        $("[id='last_name']").setValue("Romanov");
        $("[id='first_name']").click();
        $("[id='first_name']").setValue("Roman");
        $("[id='birthday_day']").click();
        $("[id='birthday_day']").setValue("08");
        $("[id='birthday_month']").click();
        $("[id='birthday_month']").setValue("08");
        $("[id='birthday_year']").click();
        $("[id='birthday_year']").setValue("1988");
        $$("[class='field sex']").findBy(Condition.text("м")).click();


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

      //  $("[class='booking_price_button'] input").click();
        $("#acceptIATA > div").hover().click();
        $("[class='booking_price_button'] input").click();


    }


    @Test
    public void Test(){
        open("https://car.tickets.ua.default.staging.ttndev.com/m/search/results?session_id=58de5f07d1b6d3521800426b");
        /*$(".buy_button").click();
        Selenide.switchTo().window(1);*/
        openBuyCarPageByIndex(1);
        System.out.println(url());
    }

    @Test
    public void oTest(){
        open("");
        int size = $$(".country_select ul>li").size();
        $(".country_select").click();
        String country = $(".country_select ul>li", new Random().nextInt(size)).getText();
        $(".country_select input").setValue(country);
    }

    @Test
    public void scrolTest(){
        open("");
        int size = $$(".country_select ul>li").size();
        $(".country_select a").click();
        $(".country_select ul>li", new Random().nextInt(size)).scrollTo().click();
    }

    public void openBuyCarPageByIndex(int index){
        String baseUrl = $("[action*='search/booking']", index).getAttribute("action");
        String sessiodId = $("[action*='search/booking']", index).$("[name='session_id']").getValue();
        String carId = $("[action*='search/booking']", index).$("[name='car_id']").getValue();
        open(baseUrl + "?session_id=" + sessiodId + "&car_id=" + carId);
    }
}