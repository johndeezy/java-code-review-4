import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;


public class BandTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  // @Test
  // public void Band_instantiatesCorrectly() {
  //   Band myBand = new Band("Tim", "Anker");
  //   assertTrue(myBand instanceof Band);
  // }
}
