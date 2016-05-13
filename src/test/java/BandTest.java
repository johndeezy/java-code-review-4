import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;


public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Band_instantiatesCorrectly() {
    Band myBand = new Band("Children of the Corn", "Jazz");
    assertTrue(myBand instanceof Band);
  }
}
