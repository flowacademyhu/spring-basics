package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.persistence.model.Role;
import hu.flowacademy.demo.persistence.model.User;
import hu.flowacademy.demo.persistence.service.RoleService;
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
@RequestMapping("/roles")
public class RoleResource {

  @Autowired
  private RoleService roleService;

  @GetMapping("/")
  public List<Role> findAll() {
    return roleService.findAll();
  }

  @GetMapping("/{id}")
  public Role findOne(@PathVariable Long id) {
    return roleService.findOne(id);
  }

  @PostMapping("/")
  public Role save(@RequestBody Role body) {
    return roleService.save(body);
  }

  @PutMapping("/")
  public Role update(@RequestBody Role body) {
    return roleService.update(body);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    roleService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
