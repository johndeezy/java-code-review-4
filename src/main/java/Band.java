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
}
