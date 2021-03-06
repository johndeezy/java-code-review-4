import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Band{
    private int id;
    private String bandName;
    private String genre;

    public Band(String bandName, String genre) {
        this.bandName = bandName;
        this.genre = genre;
    }

    public String getBandName() {
        return bandName;
    }

    public String getGenre() {
        return genre;
    }

    public int getId() {
        return id;
    }

    public static List<Band> all() {
        String sql = "SELECT * FROM bands;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Band.class);
        }
    }

    @Override
    public boolean equals(Object otherBand) {
        if (!(otherBand instanceof Band)) {
            return false;
        } else {
            Band newBand = (Band) otherBand;
            return this.getBandName().equals(newBand.getBandName()) &&
            this.getGenre().equals(newBand.getGenre()) &&
            this.getId() == newBand.getId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO bands (bandName, genre) VALUES (:bandName, :genre);";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("bandName", this.bandName)
            .addParameter("genre", this.genre)
            .executeUpdate()
            .getKey();
        }
    }

    public static Band find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM bands WHERE id=:id;";
            Band band = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Band.class);
            return band;
        }
    }

    public void update(String bandName, String genre) {
        this.bandName = bandName;
        this.genre = genre;
        try(Connection con = DB.sql2o.open()) {
            String sql = "UPDATE bands SET bandName = :bandName, genre = :genre WHERE id = :id;";
            con.createQuery(sql)
            .addParameter("bandName", bandName)
            .addParameter("genre", genre)
            .addParameter("id", this.id)
            .executeUpdate();
        }
    }

    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String deleteQuery = "DELETE FROM bands WHERE id = :id;";
            con.createQuery(deleteQuery)
            .addParameter("id", this.getId())
            .executeUpdate();

            String joinDeleteQuery = "DELETE FROM bands_venues WHERE band_id = :band_id;";
            con.createQuery(joinDeleteQuery)
            .addParameter("band_id", this.getId())
            .executeUpdate();
        }
    }

    public void addVenue(Venue venue) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO bands_venues (band_id, venue_id) VALUES (:band_id, :venue_id);";
            con.createQuery(sql)
            .addParameter("band_id", this.id)
            .addParameter("venue_id", venue.getId())
            .executeUpdate();
        }
    }

    public List<Venue> getVenues() {
        try(Connection con = DB.sql2o.open()) {
            String joinQuery = "SELECT venue_id FROM bands_venues WHERE band_id = :band_id;";
            List<Integer> venueIds = con.createQuery(joinQuery)
            .addParameter("band_id", this.getId())
            .executeAndFetch(Integer.class);

            List<Venue> venues = new ArrayList<Venue>();

            for (Integer venueId : venueIds) {
                String venueQuery = "SELECT * FROM venues WHERE id = :venueId;";
                Venue venue = con.createQuery(venueQuery)
                .addParameter("venueId", venueId)
                .executeAndFetchFirst(Venue.class);
                venues.add(venue);
            }
            return venues;
        }
    }
}
