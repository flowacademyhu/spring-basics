package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.service.CustomService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CustomResource<M, ID> {

  @GetMapping("/")
  public List<M> findAll() {
    return getService().findAll();
  }

  @GetMapping("/{id}")
  public M findOne(@PathVariable ID id) {
    return getService().findOne(id);
  }

  @PostMapping("/")
  public M save(@RequestBody M body) {
    return getService().save(body);
  }

  @PutMapping("/")
  public M update(@RequestBody M body) {
    return getService().update(body);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable ID id) {
    getService().delete(id);
    return ResponseEntity.noContent().build();
  }

  protected abstract CustomService<M, ID> getService();

}
