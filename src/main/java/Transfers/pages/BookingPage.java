package Transfers.pages;

import com.codeborne.selenide.Condition;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookingPage {

    public String fromTime = "#airport_from_time_0",
                fromDate = "#airport_from_date_0";

    public void errorShouldBeVisibleFor(String selector){
        $(selector+"_error").shouldHave(Condition.visible);
    }

    public void fillTransferDetailsForRandomSearch() {

        $("[name='route[0][from][flight_number]']").setValue("AS31234");    //Flight number
        $("[id='airport_from_date_0']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();

        if ($("[id='airport_from_time_0']").is(Condition.visible)){
            $("[id='airport_from_time_0']").setValue("1700");
        }
        if ($("[id='airport_from_date_0']").is(Condition.visible)) {
            $("[id='airport_from_date_0']").click();
            $("[data-handler='next']").click();
            $("[data-handler='next']").click();
            $("[data-handler='next']").click();
            $("[data-handler='next']").click();
            $("[data-handler='next']").click();
            $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
        }

        if ($("[name='route[0][to][address]']").is(Condition.visible)) {
            $("[name='route[0][to][address]']").setValue("auto test");
        }

    }

    public void fillContactDetailsForRegisteredUser() {

        String mail = "kurinniy.a@ki-technology.ru";
        //String pass = "aktest";
        String pass = "123456";// Staging password

        // Enter registered email

        $("[id='email']").click();
        $("[id='email']").setValue(mail);
        $$("[id='pass']").findBy(Condition.visible).click();
        $("[id='pass']").setValue(pass).pressEnter();

    }

    public void fillDataForNewUser() {

        int rand = new Random().nextInt(1000);


        $("input[name='user[name]']").setValue("Ivanov Ivan");
        $("input[name='user[phone]']").sendKeys("5044" + rand);
        $("input[name='user[email]']").sendKeys("testak0" + rand + "@gmail.com");
        $("[name='user[note]']").setValue("test book");

    }

    public void fillPaymentData() {

        $("[data-action='card-card_number_0']").setValue("4111");
        $("[data-action='card-card_number_1']").setValue("1111");
        $("[data-action='card-card_number_2']").setValue("1111");
        $("[data-action='card-card_number_3']").setValue("1111");
        $("[data-action='card-date_month']").setValue("10");
        $("[data-action='card-date_year']").setValue("19");
        $("[data-action='card-card_cvv']").setValue("571");
        $("[data-action='card-card_holder']").setValue("adsad fdgdfg");
        pushPayButton();
        $("#acceptIATA > div").hover().click();
        //pushPayButton();

    }

    public void pushPayButton() {
        $(".paid_btn").click();

    }

    public void selectNextMonthDataPicker() {

        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();

    }

    public void selectDateDataPicker() {

        $$("[data-handler='selectDay']").findBy(Condition.text("24")).click();
    }

    public void setTransferInCityFromTime () {
        $("input[id*='in_city_from_time']").click();
        $("input[id*='in_city_from_time']").setValue("1200");
    }

    public void setAirportToTime() {
        $("input[id*='airport_to_time']").click();
        $("input[id*='airport_to_time']").setValue("1700");

    }

    public void fillTransferDetailsToAirport() {

        $("[name='route[0][from][date]']").click();
        selectNextMonthDataPicker();
        selectDateDataPicker();
        setTransferInCityFromTime();
        $("[id='in_city_address_0']").sendKeys("test");
        $("[id='airport_to_date_0']").click();
        selectDateDataPicker();
        setAirportToTime();
    }

}


/*
for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
 */