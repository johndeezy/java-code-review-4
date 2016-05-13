import java.util.ArrayList;
import java.util.List;
import org.sql2o.*;

public class Band{
    private int id;
    private String bandName;
    private String bandGenre;

    public Band(String bandName, String bandGenre) {
        this.bandName = bandName;
        this.bandGenre = bandGenre;
    }

    public String getBandName() {
        return bandName;
    }

    public String getBandGenre() {
        return bandGenre;
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

    
}
