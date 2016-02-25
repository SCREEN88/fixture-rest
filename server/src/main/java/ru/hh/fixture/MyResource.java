package ru.hh.fixture;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class MyResource {

    @GET
    @Path("text")
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hello Jersey!";
    }

    @GET
    @Path("xml")
    @Produces(MediaType.TEXT_XML)
    public UserData sayXMLHello() {
        return new UserData();
    }

    @GET
    @Path("json")
    @Produces(MediaType.APPLICATION_JSON)
    public UserData sayJsonHello() {
        return new UserData();
    }

    @GET
    @Path("html")
    @Produces(MediaType.TEXT_HTML)
    public String sayHtmlHello() {
        return "<html> " + "<title>" + "Hello Jersey" + "</title>"
                + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
    }
}
