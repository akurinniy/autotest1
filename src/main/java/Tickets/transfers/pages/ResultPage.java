package Tickets.transfers.pages;

import Tickets.transfers.components.SearchForm;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ResultPage extends SearchForm {

    public void selectFirstTransfer() {

        $("[class='buy_button select_recommendation_button']").waitUntil(Condition.visible, 30000).click();

    }

    public void changeSearch() {
        $ (".change_search").click();
        $ ("[data-uil='swap']").click(); //SWAP button click ???
    }


}
