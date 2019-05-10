package hu.flowacademy.demo.persistence.service.integration;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.service.ContactJPAService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactIntTest {

  @Autowired
  private ContactJPAService contactJPAService;

  @Test
  public void testFindOne() {
    Contact contact = contactJPAService.findOne(2L);
    Assert.assertNotNull(contact);
  }


}
