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

    @Test
    public void getBandName_returnsBandName_String() {
        Band myBand = new Band("Children of the Corn", "Jazz");
        assertEquals("Children of the Corn", myBand.getBandName());
    }

    @Test
    public void getGenre_returnsGenre_String() {
        Band myBand = new Band("Children of the Corn", "Jazz");
        assertEquals("Jazz", myBand.getGenre());
    }

    @Test
    public void getId_returnsId_int() {
        Band myBand = new Band("Children of the Corn", "Jazz");
        assertEquals(0, myBand.getId());
    }

    @Test
    public void all_emptyAtFirst() {
        assertEquals(Band.all().size(), 0);
    }

    @Test
    public void equals_returnsTrueifBandNamesAreTheSame() {
        Band firstBand = new Band("Band1", "Genre");
        Band secondBand = new Band("Band1", "Genre");
        assertTrue(firstBand.equals(secondBand));
    }

    @Test
    public void save_returnsTrueifTitlesAreTheSame() {
        Band firstBand = new Band("Band1", "Genre");
        firstBand.save();
        assertEquals(Band.all().get(0), firstBand);
    }

    @Test
    public void save_assignsIdToObject_1() {
        Band firstBand = new Band("Band1", "Genre");
        firstBand.save();
        Band savedBand = Band.all().get(0);
        assertEquals(savedBand.getId(), firstBand.getId());
    }
}
