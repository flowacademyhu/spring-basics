package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactInMemoryRepository;
import java.util.UUID;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
public class ContactServiceTest {

  private ContactInMemoryService contactService = new ContactInMemoryService(
      new ContactInMemoryRepository());

  @Test
  public void testSave() {
    Contact contact = new Contact();
    contactService.save(contact);
  }

  @Test
  public void testSaveWithId() {
    Contact contact = new Contact();
    contactService.save(contact);
    contactService.save(contact);
  }

  @Test(expected = ContactNotFoundException.class)
  public void testUpdateNotExistsId() {
    Contact contact = new Contact();
    contact.setId(3L);
    contactService.update(contact);
  }

  @Test(expected = ContactValidationException.class)
  public void testUpdateWithoutId() {
    Contact contact = new Contact();
    contactService.update(contact);
  }

  @Test
  public void testUpdateWithValidId() {
    Contact contact = new Contact();
    contactService.save(contact);
    contactService.update(contact);
  }

  @Test
  public void testDelete() {
    Contact contact = new Contact();
    contactService.save(contact);
    contactService.delete(contact.getId());
  }

  @Test(expected = ContactNotFoundException.class)
  public void testDeleteWithInvalidId() {
    contactService.delete(1L);
  }

}
