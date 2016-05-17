import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static org.assertj.core.api.Assertions.assertThat;
import static org.fluentlenium.core.filter.FilterConstructor.*;
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;


public class AppTest extends FluentTest{

    public WebDriver webDriver = new HtmlUnitDriver();

    @Override
    public WebDriver getDefaultDriver() {
        return webDriver;
    }

    @ClassRule
    public static ServerRule server = new ServerRule();

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void rootTest() {
        goTo("http://localhost:4567/");
        assertThat(pageSource()).contains("Band Tracker");
    }

    @Test
    public void addBandTest() {
        goTo("http://localhost:4567/");
        fill("#bandName").with("Blanco");
        fill("#bandGenre").with("Rock");
        submit(".bandSubmit");
        assertThat(pageSource()).contains("Blanco");
    }

    @Test
    public void bandPageRouteTest() {
        goTo("http://localhost:4567/");
        fill("#bandName").with("Rock");
        fill("#bandGenre").with("Rock");
        submit(".bandSubmit");
        click("a", withText("Rock"));
        assertThat(pageSource()).contains("Update Band");
    }

    @Test
    public void addVenueRouteTest() {
        Band band = new Band("test", "test");
        band.save();
        goTo("http://localhost:4567/");
        click("a", withText("test"));
        fill("#venueName").with("TestVenue");
        fill("#venueCity").with("TestVenue");
        fill("#venueState").with("TestVenue");
        fill("#venueCapacity").with("1");
        submit(".submitVenue");
        assertThat(pageSource()).contains("TestVenue");
    }

}
