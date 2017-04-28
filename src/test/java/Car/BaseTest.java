package Car;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.junit.TextReport;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Rule;

public abstract class BaseTest {

    @Rule
    public TextReport textReport = new TextReport();

    @BeforeClass
    public static void beforeCLass(){

        Configuration.browser = WebDriverRunner.CHROME;
        ChromeDriverManager.getInstance().setup();

    }

    @After
    public void after(){
        Selenide.clearBrowserCookies();

    }

}