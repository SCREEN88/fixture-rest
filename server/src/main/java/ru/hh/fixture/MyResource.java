package ru.hh.fixture;

import java.io.IOException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import ru.hh.fixture.beans.UserData;
import ru.hh.fixture.beans.resume.ResumeData;

@Path("/rest")
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

  @POST
  @Path("user")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public UserData sayJsonHello(UserData userData) throws IOException {
//    ObjectMapper objectMapper = new ObjectMapper();
//    objectMapper.findAndRegisterModules();
//    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//    System.out.println(objectMapper.readValue(userData, UserData.class));
    System.out.println(userData.getFamilyAndName());
    return new UserData();
  }

  @GET
  @Path("resume")
  @Produces(MediaType.APPLICATION_JSON)
  public ResumeData sayHelloToResume() {
    Resume resume = new Resume(new UserData(), true);
    //Resume resume = Resume.makeShortResume(new UserData());
    //resume.setResumePhoto("pre_waterfalls1aw.jpg");
    return resume.getResumeInfo();
  }

  @GET
  @Path("html")
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }
}
