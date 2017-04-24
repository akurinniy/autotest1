package Transfers.components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ErrorPopup {

    public ErrorPopup errorPopupDisplay() {

    if ($("[id='from_name_error']").isDisplayed()) {
            $("[id='from_name_error']").shouldBe(Condition.visible);
    }
    if ($("[id='to_name_error']").isDisplayed()) {
        $("[id='to_name_error']").shouldBe(Condition.visible);
    }
    if ($("[id='airport_flight_number_0_error']").isDisplayed()) {
        $("[id='airport_flight_number_0_error']").shouldBe(Condition.visible);
    }
    if ($("[id='airport_from_date_0_error']").isDisplayed()) {
        $("[id='airport_from_date_0_error']").shouldBe(Condition.visible);
    }
    if ($("[id='airport_flight_number_0_error']").isDisplayed()) {
        $("[id='airport_flight_number_0_error']").shouldBe(Condition.visible);
    }
    if ($("[id='airport_from_date_0_error']").isDisplayed()) {
        $("[id='airport_from_date_0_error']").shouldBe(Condition.visible);
    }


        $("[id='airport_from_time_0_error']").isDisplayed();


        $("[id='in_city_to_address_0_error']").isDisplayed();


        $("[id='name_error']").isDisplayed();


        $("[id='phone_error']").isDisplayed();


        $("[id='email_error']").isDisplayed();


        $("[id='email_error']").isDisplayed();


        $("[id='card_number_1_error']").isDisplayed();


        $("[id='card_number_1_error']").isDisplayed();


        $("[id='card_date_month_error']").isDisplayed();

        $("[id='card_date_year_error']").isDisplayed();

        $("[id='card_cvv_error']").isDisplayed();

        $("[id='card_holder_error']").isDisplayed();

        $("[id='acceptIATA_error']").isDisplayed();



        return this;
    }

}
