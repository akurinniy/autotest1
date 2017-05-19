package Tickets.cinema;


import Tickets.BaseTest;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class CinemaTests extends BaseTest {

    static {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://kino.tickets.ua";
        //Configuration.baseUrl = "https://kino.tickets.ua.default.staging.ttndev.com/";
        //Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void simpleBookTicketsUaV1(){
        $("[. 'm-info__controls' .'more-link']").click();


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
