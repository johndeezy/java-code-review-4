import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Venue {
    private int id;
    private String venueName;
    private String venueCity;
    private String venueState;
    private int venueCapacity;


    public Venue(String venueName, String venueCity, String venueState, int venueCapacity) {
        this.venueName = venueName;
        this.venueCity = venueCity;
        this.venueState = venueState;
        this.venueCapacity = venueCapacity;
    }

    public int getId() {
        return id;
    }

    public String getVenueName() {
        return venueName;
    }

    public String getVenueCity() {
        return venueCity;
    }

    public String getVenueState() {
        return venueState;
    }

    public int getVenueCapacity() {
        return venueCapacity;
    }

    public static List<Venue> all() {
        String sql = "SELECT * FROM venues;";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Venue.class);
        }
    }

    @Override
    public boolean equals(Object otherVenue) {
        if (!(otherVenue instanceof Venue)) {
            return false;
        } else {
            Venue newVenue = (Venue) otherVenue;
            return this.getVenueName().equals(newVenue.getVenueName()) &&
            this.getVenueCity().equals(newVenue.getVenueCity()) &&
            this.getVenueState().equals(newVenue.getVenueState()) &&
            this.getVenueCapacity() == newVenue.getVenueCapacity() &&
            this.getId() == newVenue.getId();
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO venues (venueName, venueCity, venueState, venueCapacity) VALUES (:venueName, :venueCity, :venueState, :venueCapacity);";
            this.id = (int) con.createQuery(sql, true)
            .addParameter("venueName", this.venueName)
            .addParameter("venueCity", this.venueCity)
            .addParameter("venueState", this.venueState)
            .addParameter("venueCapacity", this.venueCapacity)
            .executeUpdate()
            .getKey();
        }
    }

    public static Venue find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM venues WHERE id=:id;";
            Venue venue = con.createQuery(sql)
            .addParameter("id", id)
            .executeAndFetchFirst(Venue.class);
            return venue;
        }
    }

}
