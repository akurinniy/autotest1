package Transfers;

import Transfers.components.ErrorPopup;
import Transfers.components.SearchForm;
import Transfers.pages.BookingPage;
import Transfers.pages.ResultPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.Random;

import static com.codeborne.selenide.Selenide.*;

public class Transfer extends BaseTest {

    @Rule
    public TextReport textReport = new TextReport().
            onSucceededTest(true).
            onSucceededTest(true);

    @Before
        public void before(){

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://transfer.tickets.ua";
        //Configuration.baseUrl = "https://transfer.tickets.ru.default.staging.ttndev.com";
        //Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();

    }

    @After
        public void after(){
        Selenide.clearBrowserCookies();

    }

    @Test
    public void woAuthBookForNewUser(){

        String mail = "kurinniy.a@ki-technology.ru";
        //String pass = "aktest";
        String pass = "123456"; //Staging password
        String departure [] = {"kie", "mos", "pet","pari"};

        int randomIndex = new Random().nextInt(departure.length);

        int rand = new Random().nextInt(1000);

        // Search Form (random search)

        open("");

        $("[data-direction='departure']").sendKeys(departure[randomIndex]);
        $("[data-auto-controller='TransferMainController']").shouldBe(Condition.visible);
        //$$("[data-uil='start_point'] li").findBy(Condition.text("Киeв (в черте города)")).click();
        $$("#ui-id-1 li").get(0).click();
        $$("#ui-id-2 li").get(0).click();
        $ ("[data-uil='submit_search']").click();

        // Transfers.Transfer select

        $("[class='buy_button select_recommendation_button']").waitUntil(Condition.visible, 30000).click();

        // Transfers.Transfer Details

        $("[name='route[0][from][flight_number]']").click();   //Flight number
        $("[name='route[0][from][flight_number]']").setValue("AS31234");    //Flight number
        $("[id='airport_from_date_0']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();

        if ($("[id='airport_from_time_0']").is(Condition.visible)){
            $("[id='airport_from_time_0']").click();
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
            $("[name='route[0][to][address]']").click();
            $("[name='route[0][to][address]']").setValue("auto test");
        }

        /*$("input[id*='in_city_from_time']").click();
        $("input[id*='in_city_from_time']").setValue("1200");
        $("[id='in_city_address_0']").sendKeys("test");
        $("[id='airport_to_date_0']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
        $("input[id*='airport_to_time']").click();
        $("input[id*='airport_to_time']").setValue("1700");*/

        //Contact Data

        $("input[name='user[name]']").click();
        $("input[name='user[name]']").setValue("Ivanov Ivan");
        $("input[name='user[phone]']").sendKeys("5044" + rand);
        $("input[name='user[email]']").sendKeys("testak0" + rand + "@gmail.com");
        $("[name='user[note]']").setValue("test book");

        // Payment Form

        $("[data-action='card-card_number_0']").setValue("4111");
        $("[data-action='card-card_number_1']").setValue("1111");
        $("[data-action='card-card_number_2']").setValue("1111");
        $("[data-action='card-card_number_3']").setValue("1111");
        $("[data-action='card-date_month']").setValue("10");
        $("[data-action='card-date_year']").setValue("19");
        $("[data-action='card-card_cvv']").setValue("571");
        $("[data-action='card-card_holder']").setValue("adsad fdgdfg");
        $(".paid_btn").click();
        $("#acceptIATA > div").hover().click();
        $(".paid_btn").click();

        //My account

        $(".allert-block").waitUntil(Condition.visible, 30000);
        $(".allert-close").click();
        $("a.cancel_booking").shouldBe(Condition.visible).click();
        switchTo().alert().accept();
        $("a.cancel_booking").shouldBe(Condition.hidden);

    }

    @Test
    public void simpleBookTest(){

        String mail = "kurinniy.a@ki-technology.ru";
        //String pass = "aktest";
        String pass = "123456";// Staging password

        open("");

        // Link header login

        /*$("[data-action='link-header_login']").click();
        //$("[class='popup_header']").shouldBe(Condition.visible);
        $("#login_popup [data-uil='email']").setValue(mail);
        $("#login_popup [data-uil='password']").setValue(pass).pressEnter();
        */

        $("[data-direction='departure']").sendKeys("kie");
        $("[data-auto-controller='TransferMainController']").shouldBe(Condition.visible);
        //$$("[data-uil='start_point'] li").findBy(Condition.text("Кие (в черте города)")).click();
        $$("#ui-id-1 li").findBy(Condition.text("Киев (в")).click();
        $$("#ui-id-2 li").findBy(Condition.text("Аэропорт Борисполь (Киев)")).click();
        $ ("[data-uil='submit_search']").click();
        $(".buy_button.select_recommendation_button").waitUntil(Condition.visible, 30000).click();
        $("[name='route[0][from][date]']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("24")).click();
        $("input[id*='in_city_from_time']").click();
        $("input[id*='in_city_from_time']").setValue("1200");
        $("[id='in_city_address_0']").sendKeys("test");
        $("[id='airport_to_date_0']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("24")).click();
        $("input[id*='airport_to_time']").click();
        $("input[id*='airport_to_time']").setValue("1700");


        // Login link authorisation

        /* $("[class='login link']").findBy(Condition.text("Авторизуйтесь")).click();
        $("[class='popup_header']").shouldBe(Condition.visible);
        $("[data-uil='email']").shouldBe(Condition.visible);
        $$("[data-uil='email']").get(1).setValue(mail);
        $$("[data-uil='password']").get(1).sendKeys(pass);
        */

        // Enter registered email

        $("[id='email']").click();
        $("[id='email']").setValue(mail);
        $$("[id='pass']").findBy(Condition.visible).click();
        $("[id='pass']").setValue(pass).pressEnter();


        // Payment Form

        $("[data-action='card-card_number_0']").setValue("4111");
        $("[data-action='card-card_number_1']").setValue("1111");
        $("[data-action='card-card_number_2']").setValue("1111");
        $("[data-action='card-card_number_3']").setValue("1111");
        $("[data-action='card-date_month']").setValue("10");
        $("[data-action='card-date_year']").setValue("19");
        $("[data-action='card-card_cvv']").setValue("571");
        $("[data-action='card-card_holder']").setValue("adsad fdgdfg");
        $(".paid_btn").click();
        $("#acceptIATA > div").hover().click();
     //   $(".paid_btn").click();

        //My account

        //Configuration.holdBrowserOpen=true;
     //   $(".allert-block").waitUntil(Condition.visible, 30000);
     //   $(".allert-close").click();
     //   $("a.cancel_booking").shouldBe(Condition.visible).click();
     //   switchTo().alert().accept();
     //   $("a.cancel_booking").shouldBe(Condition.hidden);
/*
if(){
    Transfers.Transfer.methodName(); //if static method
    new Transfers.Transfer().methodName(); //if not static
    Transfers.Transfer trns = new Transfers.Transfer(7); //if not static and need more methods from class
    trns.methodName();
} else{

}
 */
    }

    @Test
    public void validFieldsTest(){

        int rand = new Random().nextInt(1000);

        //Main page
        open("");
        $ ("[data-uil='submit_search']").click(); //search button click
        $("[id='from_name_error']").isDisplayed();
        $("[data-direction='departure']").sendKeys("kie");
        $$("#ui-id-1 li").findBy(Condition.text("Киев (в")).click();
        $ ("[data-uil='submit_search']").click(); //search button click
        $("[id='to_name_error']").isDisplayed();
        $$("#ui-id-2 li").findBy(Condition.text("Аэропорт Борисполь (Киев)")).click();
        $ ("[data-uil='submit_search']").click();


        //Result page

        $ (".change_search").click();
        $ ("[data-uil='swap']").click(); //SWAP button click ???
        $ ("[data-uil='submit_search']").click();
        $(".buy_button.select_recommendation_button").waitUntil(Condition.visible, 30000).click();

        //Payment page

        $(".paid_btn").click(); // buy button click
        $("[id='airport_flight_number_0_error']").isDisplayed();
        $("[name='route[0][from][flight_number]']").setValue("AS31234");
        $(".paid_btn").click(); // buy button click
        $("[id='airport_from_date_0_error']").isDisplayed();
        $(".paid_btn").click(); // buy button click
        $("[id='airport_flight_number_0_error']").isDisplayed();
        $("[name='route[0][from][flight_number]']").setValue("AS31234");
        $(".paid_btn").click(); // buy button click
        $("[id='airport_from_date_0_error']").isDisplayed();
        $("[id='airport_from_date_0']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $("[data-handler='next']").click();
        $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
        $(".paid_btn").click();
        $("#airport_from_time_0_error").isDisplayed();
        $("[id='airport_from_time_0']").setValue("1700");
        $(".paid_btn").click();
        $("[id='in_city_to_address_0_error']").isDisplayed();
        $("[name='route[0][to][address]']").setValue("auto test");
        $(".paid_btn").click();
        $("[id='name_error']").isDisplayed();
        $("[data-error-info]").click();
        //$("[id='in_city_address_0']").sendKeys("test");
        $("[data-error-info]").sendKeys("test");
        $(".paid_btn").click();
        $("[id='phone_error']").isDisplayed();
        //$("[id='phone']").click();
        $("[id='phone']").setValue("504405588");
        $(".paid_btn").click();
        $("[id='email_error']").isDisplayed();
       //$("[id='email']").click();
        $("[id='email']").setValue("dfgfdgdfg");
        $("[id='email_error']").isDisplayed();
        $("input[name='user[email]']").setValue("testak0" + rand + "@gmail.com");// email validation
        $(".paid_btn").click();
        $("[id='card_number_1_error']").isDisplayed();
        $("[data-action='card-card_number_0']").setValue("4111");
        $(".paid_btn").click();
        $("[id='card_number_1_error']").isDisplayed();
        $("[data-action='card-card_number_1']").setValue("1111");
        $(".paid_btn").click();
        $("[id='card_number_1_error']").isDisplayed();
        $("[data-action='card-card_number_2']").setValue("1111");
        $(".paid_btn").click();
        $("[id='card_number_1_error']").isDisplayed();
        $("[data-action='card-card_number_3']").setValue("1111");
        $(".paid_btn").click();
        $("[id='card_date_month_error']").isDisplayed();
        $("[data-action='card-date_month']").setValue("10"); // Actual month
        $(".paid_btn").click();
        $("[id='card_date_year_error']").isDisplayed();
        $("[data-action='card-date_year']").setValue("19"); // Actual year
        $(".paid_btn").click();
        $("[id='card_cvv_error']").isDisplayed();
        $("[data-action='card-card_cvv']").setValue("514");
        $(".paid_btn").click();
        $("[id='card_holder_error']").isDisplayed();
        $("[data-action='card-card_holder']").setValue("adsad fdgdfg");
        $(".paid_btn").click();
        $("[id='acceptIATA_error']").isDisplayed();
    }

    @Test

        public void simpleBookTestV2(){

        open("");

        new SearchForm().searchFormDefaultLocation();
        new ResultPage().selectFirstTransfer();
        BookingPage bookingPage = new BookingPage()
        .fillTransferDetailsToAirport()
        .fillContactDetailsForRegisteredUser()
        .fillPaymentData();
    }

    @Test

        public void woAuthBookForNewUserV2(){

        open("");

            new SearchForm().searchFormRandomLocation();
            new ResultPage().selectFirstTransfer();
            BookingPage bookingPage = new BookingPage()
            .fillTransferDetailsForRandomSearch()
            .fillDataForNewUser()
            .fillPaymentData();

    }

    @Test

        public void validFieldsTestV2() {

            int rand = new Random().nextInt(1000);

        open("");

          SearchForm SearchForm = new SearchForm();

            SearchForm.submitSearch();
            SearchForm.
            fillDeparture("kie").
            selectDefaultLocation1();
            new ErrorPopup().errorPopupDisplay();
            SearchForm.selectDefaultLocation2();
            SearchForm.submitSearch();

            ResultPage resultPage = new ResultPage();
            resultPage.changeSearch();
            resultPage.submitSearch();
            resultPage.selectFirstTransfer();

            BookingPage bookingPage = new BookingPage();
            ErrorPopup errorPopup = new ErrorPopup();

            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[name='route[0][from][flight_number]']").setValue("AS31234");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[name='route[0][from][flight_number]']").setValue("AS31234");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            bookingPage.selectNextMonthDataPicker();
            bookingPage.selectNextMonthDataPicker();
            bookingPage.selectNextMonthDataPicker();
            bookingPage.selectNextMonthDataPicker();
            bookingPage.selectNextMonthDataPicker();
            $$("[data-handler='selectDay']").findBy(Condition.text("20")).click();
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[id='airport_from_time_0']").setValue("1700");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[name='route[0][to][address]']").setValue("auto test");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();

           // $("[data-error-info]").click();
            $("[id='in_city_address_0']").setValue("test");
            $("[data-error-info]").setValue("test");

            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[id='phone']").setValue("504405588");

            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[id='email']").setValue("dfgfdgdfg");
            errorPopup.errorPopupDisplay();
            $("input[name='user[email]']").setValue("testak0" + rand + "@gmail.com");// email validation
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_number_0']").setValue("4111");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_number_0']").setValue("1111");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_number_0']").setValue("1111");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_number_0']").setValue("1111");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-date_month']").setValue("10");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-date_year']").setValue("19");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_cvv']").setValue("514");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();
            $("[data-action='card-card_holder']").setValue("adsad fdgdfg");
            bookingPage.pushPayButton();
            errorPopup.errorPopupDisplay();

    }



}
