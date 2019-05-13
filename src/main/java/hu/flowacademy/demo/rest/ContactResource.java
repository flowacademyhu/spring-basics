package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.service.ContactJPAService;
import hu.flowacademy.demo.persistence.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contact")
public class ContactResource extends CustomResource<Contact, Long> {

//  @Autowired
//  private ContactService contactService;

  @Autowired
  private ContactJPAService contactService;


  @Override
  protected CustomService<Contact, Long> getService() {
    return contactService;
  }
}
