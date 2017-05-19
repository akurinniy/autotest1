package Tickets.transfers.pages;

import com.codeborne.selenide.Condition;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BookingPage {


    public BookingPage fillTransferDetailsForRandomSearch() {

        $("[name='route[0][from][flight_number]']").setValue("AS31234");    //Flight number
        $("[id='airport_from_date_0']").click();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();

        if ($("[id='airport_from_time_0']").is(Condition.visible)){
            $("[id='airport_from_time_0']").setValue("1700");
        }
        if ($("[id='airport_from_date_0']").is(Condition.visible)) {
            $("[id='airport_from_date_0']").click();
            selectNextMonthDataPicker();
            selectNextMonthDataPicker();
            selectNextMonthDataPicker();
            selectNextMonthDataPicker();
            selectNextMonthDataPicker();
            $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
        }

        if ($("[name='route[0][to][address]']").is(Condition.visible)) {
            $("[name='route[0][to][address]']").setValue("auto test");
        }
        return this;
    }

    public BookingPage fillContactDetailsForRegisteredUser() {

        String mail = "kurinniy.a@ki-technology.ru";
        //String pass = "aktest";
        String pass = "123456";// Staging password

        $("[id='email']").click();
        $("[id='email']").setValue(mail);
        $$("[id='pass']").findBy(Condition.visible).click();
        $("[id='pass']").setValue(pass).pressEnter();
        return this;
    }

    public BookingPage fillDataForNewUser() {

        int rand = new Random().nextInt(1000);


        $("input[name='user[name]']").setValue("Ivanov Ivan");
        $("input[name='user[phone]']").sendKeys("5044" + rand);
        $("input[name='user[email]']").sendKeys("testak0" + rand + "@gmail.com");
        $("[name='user[note]']").setValue("test book");
        return this;
    }

    public BookingPage fillTestCardNumber(){
        String cardNumber1 = "4111";
        String cardNumber2 = "1111";
        String cardMonth = "10";
        String cardYear = "20";
        String cardCVV = "579";
        String cardCardHolder = "adsad fdgdfg";

        $("[data-action='card-card_number_0']").setValue(cardNumber1);
        $("[data-action='card-card_number_1']").setValue(cardNumber2);
        $("[data-action='card-card_number_2']").setValue(cardNumber2);
        $("[data-action='card-card_number_3']").setValue(cardNumber2);
        $("[data-action='card-date_month']").setValue(cardMonth);
        $("[data-action='card-date_year']").setValue(cardYear);
        $("[data-action='card-card_cvv']").setValue(cardCVV);
        $("[data-action='card-card_holder']").setValue(cardCardHolder);
        return this;
    }

    public BookingPage fillPaymentData() {

        fillTestCardNumber();
        pushPayButton();
        $("#acceptIATA > div").hover().click();
        pushPayButton();
        return this;
    }

    public BookingPage pushPayButton() {
        $(".paid_btn").click();
        return this;
    }

    public BookingPage selectNextMonthDataPicker() {

        $("[id='airport_from_date_0']").click();
        $("[data-handler='next']").click();

        return this;
    }

    public BookingPage selectDateDataPicker() {

        $$("[data-handler='selectDay']").findBy(Condition.text("24")).click();
        return this;
    }

    public BookingPage setTransferInCityFromTime () {
        $("input[id*='in_city_from_time']").click();
        $("input[id*='in_city_from_time']").setValue("1200");
        return this;
    }

    public BookingPage setAirportToTime() {
        $("input[id*='airport_to_time']").click();
        $("input[id*='airport_to_time']").setValue("1700");
        return this;
    }

    public BookingPage fillTransferDetailsToAirport() {

        $("[name='route[0][from][date]']").click();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectNextMonthDataPicker();
        selectDateDataPicker();
        setTransferInCityFromTime();
        $("[id='in_city_address_0']").sendKeys("test");
        $("[id='airport_to_date_0']").click();
        selectDateDataPicker();
        setAirportToTime();

        return this;
    }

}


/*
for(int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
 */