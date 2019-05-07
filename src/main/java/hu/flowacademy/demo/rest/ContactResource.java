package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.service.ContactJPAService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactResource {

//  @Autowired
//  private ContactService contactService;

  @Autowired
  private ContactJPAService contactService;

  @GetMapping("/")
  public List<Contact> findAll() {
    return contactService.findAll();
  }

  @GetMapping("/{id}")
  public Contact findOne(@PathVariable Long id) {
    return contactService.findOne(id);
  }

  @PostMapping("/")
  public Contact save(@RequestBody Contact body) {
    return contactService.save(body);
  }

  @PutMapping("/")
  public Contact update(@RequestBody Contact body) {
    return contactService.update(body);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    contactService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
