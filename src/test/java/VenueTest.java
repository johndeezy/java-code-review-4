import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;
import java.util.List;


public class VenueTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Venue_objectInstantiatesCorrectly() {
        Venue myVenue = new Venue("Venue", "Dallas", "Texas", 100);
        assertTrue(myVenue instanceof Venue);
    }

    @Test
    public void getVenueName_returnsVenueName_String() {
        Venue myVenue = new Venue("Venue", "Dallas", "Texas", 100);
        assertEquals("Venue", myVenue.getVenueName());
    }

    @Test
    public void all_emptyAtFirst() {
        assertEquals(Venue.all().size(), 0);
    }
    //
    // @Test
    // public void equals_returnsTrueifTitlesAreTheSame() {
    //     Author firstAuthor = new Author("Author 1", "last");
    //     Author secondAuthor = new Author("Author 1", "last");
    //     assertTrue(firstAuthor.equals(secondAuthor));
    // }
    //
    // @Test
    // public void save_returnsTrueifTitlesAreTheSame() {
    //     Author firstAuthor = new Author("Author 1", "last");
    //     firstAuthor.save();
    //     assertEquals(Author.all().get(0), firstAuthor);
    // }
    //
    // @Test
    // public void save_assignsIdToObject_1() {
    //     Author firstAuthor = new Author("Author 1", "last");
    //     firstAuthor.save();
    //     Author savedAuthor = Author.all().get(0);
    //     assertEquals(savedAuthor.getId(), firstAuthor.getId());
    // }
    //
    // @Test
    // public void find_findsAuthorInDatabase_true() {
    //     Author myAuthor = new Author("Author1", "last");
    //     myAuthor.save();
    //     Author savedAuthor = Author.find(myAuthor.getId());
    //     assertTrue(myAuthor.equals(savedAuthor));
    // }
}
