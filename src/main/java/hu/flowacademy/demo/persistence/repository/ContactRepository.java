package hu.flowacademy.demo.persistence.repository;

import hu.flowacademy.demo.persistence.model.Contact;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

  private Map<String, Contact> contacts = new HashMap<>();

  public Contact save(Contact contact) {
    String id = UUID.randomUUID().toString();
    contact.setId(id);
    contacts.put(id, contact);
    return contact;
  }

  public Contact update(Contact contact) {
    contacts.put(contact.getId(), contact);
    return contact;
  }

  public List<Contact> findAll() {
    return contacts.entrySet().stream().map(Entry::getValue).collect(Collectors.toList());
  }

  public Contact findOne(String id) {
    return contacts.get(id);
  }

  public void delete(String id) {
    contacts.remove(id);
  }

  public boolean exists(String id) {
    return contacts.containsKey(id);
  }
}
