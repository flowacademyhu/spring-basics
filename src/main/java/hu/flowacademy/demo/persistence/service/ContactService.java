package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

  private final ContactRepository contactRepository;

  public ContactService(
      ContactRepository contactRepository) {
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

  public Contact findOne(String id) {
    return contactRepository.findOne(id);
  }

  public void delete(String id) {
    if (!contactRepository.exists(id)) {
      throw new ContactNotFoundException();
    }
    contactRepository.delete(id);
  }

}
