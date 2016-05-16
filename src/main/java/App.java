import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.vtl";

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/index.vtl");
            model.put("bands", Band.all());
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String bandName = request.queryParams("bandName");
            String bandGenre = request.queryParams("bandGenre");
            if (bandName.equals("") || bandGenre.equals("")) {
                response.redirect("/");
                return null;
            } else {
                Band newBand = new Band(bandName, bandGenre);
                newBand.save();
                response.redirect("/");
                return null;
            }
        });

        get("/band/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Band band = Band.find(Integer.parseInt(request.params(":id")));

            model.put("band", band);
            model.put("template", "templates/band.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/band/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Band band = Band.find(Integer.parseInt(request.params(":id")));
            String venueName = request.queryParams("venueName");
            String venueCity = request.queryParams("venueCity");
            String venueState = request.queryParams("venueState");
            int venueCapacity = Integer.parseInt(request.queryParams("venueCapacity"));
            Venue venue = new Venue(venueName, venueCity, venueState, venueCapacity);
            venue.save();
            band.addVenue(venue);

            response.redirect("/band/" + band.getId());
            return null;
        });

        post("/delete/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Band band = Band.find(Integer.parseInt(request.params(":id")));
            band.delete();
            response.redirect("/");
            return null;
        });

        post("/band/:id/update", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Band band = Band.find(Integer.parseInt(request.params("id")));
            String bandName = request.queryParams("bandName");
            String genre = request.queryParams("bandGenre");
            band.update(bandName, genre);
            response.redirect("/band/" + band.getId());
            return null;
        });
    }
}
