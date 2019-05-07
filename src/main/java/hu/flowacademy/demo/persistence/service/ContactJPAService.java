package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactJPARepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ContactJPAService {

  private final ContactJPARepository contactJPARepository;

  public ContactJPAService(
      ContactJPARepository contactJPARepository) {
    this.contactJPARepository = contactJPARepository;
  }


  public Contact save(Contact contact) {
    if (contact.getId() != null) {
      return update(contact);
      // or throw exception
    }
    return contactJPARepository.save(contact);
  }

  public Contact update(Contact contact) {
    if (contact.getId() == null) {
      throw new ContactValidationException("ID not found!");
    } else if (findOne(contact.getId()) == null) {
      throw new ContactNotFoundException();
    }
    return contactJPARepository.save(contact);
  }

  public List<Contact> findAll() {
    return contactJPARepository.findAll();
  }

  public Contact findOne(Long id) {
//    return contactJPARepository.findById(id).orElseThrow(() -> {throw new ContactNotFoundException();});
    return contactJPARepository.findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public void delete(Long id) {
    contactJPARepository.deleteById(id);
  }

}
