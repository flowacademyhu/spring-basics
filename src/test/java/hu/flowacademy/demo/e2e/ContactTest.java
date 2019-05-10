package hu.flowacademy.demo.e2e;

import com.google.gson.Gson;
import hu.flowacademy.demo.persistence.model.Contact;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.function.Consumer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ContactTest {

  private static final String PATH = "http://localhost:8080/contact/";
  private static final String CONTENT_TYPE = "Content-type";
  private static final String APPLICATION_JSON = "application/json";

  @Test
  public void testPostEndpoint() throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(PATH))
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .POST(BodyPublishers.ofString(new Gson().toJson(getContact(null, null))))
        .build();
    sendRequest(request, contact -> Assert.assertNotNull(contact.getId()));
  }

  @Test
  public void testPutEndpoint() throws IOException, InterruptedException {
    Contact sentContact = getContact(5L, 0L);
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(PATH))
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .PUT(BodyPublishers.ofString(new Gson().toJson(sentContact)))
        .build();
    sendRequest(request, contact -> Assert.assertEquals(contact.getName(), sentContact.getName()));
  }

  @Test
  public void testDeleteEndpoint() throws IOException, InterruptedException {
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(PATH + 11))
        .header(CONTENT_TYPE, APPLICATION_JSON)
        .DELETE()
        .build();
    sendRequest(request, null);
  }

  private void sendRequest(HttpRequest request, Consumer<Contact> validateMethod) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();

    client.sendAsync(request, BodyHandlers.ofString())
        .thenApply(response -> {
          if (response.statusCode() > 400) {
            throw new RuntimeException("Invalid request: " + response.statusCode());
          }
          String body = response.body();
          if (validateMethod != null) {
            validateMethod.accept(new Gson().fromJson(body, Contact.class));
          }
          return body;
        })
        .thenAccept(System.out::println)
        .join();

//    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
//    if (response.statusCode() > 400) {
//      throw new RuntimeException("Elbasztuk: " + response.statusCode());
//    }
//
//    Contact contact = new Gson().fromJson(response.body(), Contact.class);
//    Assert.assertNotNull(contact.getId());
  }

  private Contact getContact(Long id, Long version) {
    var contact = new Contact();
    contact.setId(id);
    contact.setName("Ferenc");
    contact.setMobileNumber("+666");
    contact.setAddress("Itt-ott");
    contact.setEmail("nincs");
    contact.setVersion(version);
    return contact;
  }

}
