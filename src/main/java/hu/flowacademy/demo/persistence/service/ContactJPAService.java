package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactJPARepository;
import java.util.List;
import javax.persistence.OptimisticLockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ContactJPAService {

  Logger logger = LoggerFactory.getLogger(ContactJPAService.class);

  private final ContactJPARepository contactJPARepository;

  public ContactJPAService(
      ContactJPARepository contactJPARepository) {
    this.contactJPARepository = contactJPARepository;
    logger.info("Hello, there is a ContactJPAService instance!");
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
    try {
      return contactJPARepository.save(contact);
    } catch (OptimisticLockException e) {
      System.err.println("Version is deprecated, reload your page!");
      // Force method: contact.version = getNewestVersion(); contactJPARepository.save(contact)
      return null;
    }
  }

  @Transactional(readOnly = true)
  public List<Contact> findAll() {
    return contactJPARepository.findAll();
  }

  @Transactional(readOnly = true)
  public Contact findOne(Long id) {
//    return contactJPARepository.findById(id).orElseThrow(() -> {throw new ContactNotFoundException();});
    return contactJPARepository.findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public void delete(Long id) {
    contactJPARepository.deleteById(id);
  }

}
