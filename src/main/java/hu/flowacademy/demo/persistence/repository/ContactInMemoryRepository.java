package hu.flowacademy.demo.persistence.repository;

import hu.flowacademy.demo.persistence.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class ContactInMemoryRepository {

  private Map<Long, Contact> contacts = new HashMap<>();

  public Contact save(Contact contact) {
//    String id = UUID.randomUUID().toString();
    contact.setId(new Random().nextLong());
    contacts.put(contact.getId(), contact);
    return contact;
  }

  public Contact update(Contact contact) {
    contacts.put(contact.getId(), contact);
    return contact;
  }

  public List<Contact> findAll() {
    return contacts.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
  }

  public Contact findOne(Long id) {
    return contacts.get(id);
  }

  public void delete(Long id) {
    contacts.remove(id);
  }

  public boolean exists(Long id) {
    return contacts.containsKey(id);
  }
}
