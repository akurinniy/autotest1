package Tickets.cinema;


import Tickets.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class CinemaTests extends BaseTest {

    static {
        Configuration.browser = "chrome";
        //Configuration.baseUrl = "https://kino.tickets.ua";
        Configuration.baseUrl = "https://kino.tickets.ua.default.staging.ttndev.com/";
        //Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void simpleBookTicketsUaV1(){
        open("");

        $("[class='col-3 col-xl-4 col-m-6 col-s-12'] a").click();
        $("[class='schedule-tabs js-tabs-header'] li").click();
        Selenide.switchTo().window(1);
        $("[ul class='seanses-item__time col-8 col-m-12 js-tabs-header']> li> a").click();


    }


//    @Test
//    public void simpleBookTicketsUaV2() {
//        MainPage.selectMovieFromBanner();
//        ResultPage
//        .selectCinema
//        .selectMovieDate
//        .selectTime
//        .selectPlace();
//
//
//        }
//
//
//
//
//
//    @Test
//    public void simpleBookTicketsRu(){
//
//    }
}
