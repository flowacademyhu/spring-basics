package hu.flowacademy.demo.config;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.repository.ContactJPARepository;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class InitDataLoader implements CommandLineRunner {

  @Autowired
  private ContactJPARepository contactJPARepository;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Init data loader running:");
    if (args != null) {
      Stream.of(args).forEach(System.out::println);
    }

    contactJPARepository.save(createContact());
  }

  private Contact createContact() {
    Contact contact = new Contact();
    contact.setName("Admin");
    contact.setAddress("Admin utca 2");
    contact.setEmail("admin@spam4.me");
    return contact;
  }
}
