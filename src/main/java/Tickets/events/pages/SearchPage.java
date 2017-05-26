package Tickets.events.pages;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public SearchPage selectCity() {
        $("[class='search js-search-form']").setValue("ส่ๅโ").pressEnter();
        return this;
    }

    public SearchPage chooseDate() {
    $("[name='date_to']").click();


        return this;
    }


}
