package Tickets.events;

import Tickets.BaseTest;
import Tickets.events.pages.SearchPage;
import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.Before;
import org.junit.Test;

public class EventsTests extends BaseTest {

    @Before
    public void before() {

        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://events.tickets.ua";
        //Configuration.baseUrl = "https://events.tickets.ru.default.staging.ttndev.com";
        //Configuration.holdBrowserOpen = true;
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void simpleBookKarabas() {
        SearchPage searchPage = new SearchPage();
            searchPage.selectCity()
            .chooseDate();
          //  .selectCategory()
         //   .selectEvent();
     //  EventPage.selectPlace();


    }


    @Test
    public void simpleBookShahtar(){

            }

    @Test
    public void searchFormTest() {


    }

    @Test
    public void bannerRedirectTest()
    {


    }
    @Test
    public void filterCategoryTest(){

    }

}