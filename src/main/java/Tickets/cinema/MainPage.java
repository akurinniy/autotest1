package Tickets.cinema;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {


    public MainPage selectMovieFromBanner() {
        $(".btn btn-buy").click();
    return this;
    }
}
