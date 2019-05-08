package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.model.User;
import hu.flowacademy.demo.persistence.service.ContactJPAService;
import hu.flowacademy.demo.persistence.service.UserService;
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
@RequestMapping("/users")
public class UserResource {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public List<User> findAll() {
    return userService.findAll();
  }

  @GetMapping("/{id}")
  public User findOne(@PathVariable String id) {
    return userService.findOne(id);
  }

  @PostMapping("/")
  public User save(@RequestBody User body) {
    return userService.save(body);
  }

  @PutMapping("/")
  public User update(@RequestBody User body) {
    return userService.update(body);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
