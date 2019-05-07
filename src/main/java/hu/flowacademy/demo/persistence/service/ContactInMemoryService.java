package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactInMemoryRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class ContactInMemoryService {

  private final ContactInMemoryRepository contactRepository;

  public ContactInMemoryService(
      ContactInMemoryRepository contactRepository) {
    this.contactRepository = contactRepository;
  }

  public Contact save(Contact contact) {
    if (contact.getId() != null) {
      return update(contact);
      // or throw exception
    }
    return contactRepository.save(contact);
  }

  public Contact update(Contact contact) {
    if (contact.getId() == null) {
      throw new ContactValidationException("ID not found!");
    } else if (!contactRepository.exists(contact.getId())) {
      throw new ContactNotFoundException();
    }
    return contactRepository.update(contact);
  }

  public List<Contact> findAll() {
    return contactRepository.findAll();
  }

  public Contact findOne(Long id) {
    return contactRepository.findOne(id);
  }

  public void delete(Long id) {
    if (!contactRepository.exists(id)) {
      throw new ContactNotFoundException();
    }
    contactRepository.delete(id);
  }

}
