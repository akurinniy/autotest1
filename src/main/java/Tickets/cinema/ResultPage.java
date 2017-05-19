package Tickets.cinema;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage {

    public ResultPage selectCinema(){
        $("[name='search-item']").click();
        $("[id='ui-id-12']").click();

        return this;

    }

    public ResultPage selectMovieDate(){


    return this;
    }

    public ResultPage selectMovieTime() {
    return this;
    }
}
