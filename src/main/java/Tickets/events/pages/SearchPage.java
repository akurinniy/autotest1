package Tickets.events.pages;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {

    public SearchPage selectCity() {
        $("[class='search js-search-form']").setValue("����").pressEnter();
        return this;
    }

    public SearchPage chooseDate() {
    $("[name='date_to']").click();


        return this;
    }


}
