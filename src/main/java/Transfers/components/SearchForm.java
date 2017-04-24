package Transfers.components;

import com.codeborne.selenide.Condition;

import java.util.Random;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchForm {

    public SearchForm fillDeparture(String departureLocation) {
        $("[data-direction='departure']").sendKeys(departureLocation);
        return this;
    }

    public SearchForm selectDefaultLocation1() {
        $("[data-auto-controller='TransferMainController']").shouldBe(Condition.visible);
        $$("#ui-id-1 li").findBy(Condition.text("Киев (в")).click();
        return this;
    }

    public SearchForm selectDefaultLocation2() {
        $("[data-auto-controller='TransferMainController']").shouldBe(Condition.visible);
        $$("#ui-id-2 li").findBy(Condition.text("Аэропорт Борисполь (Киев)")).click();
        return this;
    }

    public SearchForm submitSearch() {
        $("[data-uil='submit_search']").click();
        return this;
    }


    public SearchForm searchFormDefaultLocation() {

        String departureLocation = "kie";

        fillDeparture(departureLocation);
        selectDefaultLocation1();
        selectDefaultLocation2();
        submitSearch();
        return this;
    }

    public SearchForm selectRandomLocation() {
        $("[data-auto-controller='TransferMainController']").shouldBe(Condition.visible);
        $$("#ui-id-1 li").get(0).click();
        $$("#ui-id-2 li").get(0).click();
        return this;
    }


    public SearchForm searchFormRandomLocation() {

        String departure [] = {"kie", "mos", "pet","pari"};

        int randomIndex = new Random().nextInt(departure.length);

        $("[data-direction='departure']").sendKeys(departure[randomIndex]);
        selectRandomLocation();
        submitSearch();
        return this;
    }



}
