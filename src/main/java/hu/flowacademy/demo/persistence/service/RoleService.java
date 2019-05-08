package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Role;
import hu.flowacademy.demo.persistence.repository.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService {

  @Autowired
  private RoleRepository roleRepository;


  public void delete(Long id) {
    roleRepository.deleteById(id);
  }

  public Role update(Role body) {
    if (body.getId() == null) {
      throw new ContactValidationException("Role id found!");
    }
    return roleRepository.save(body);
  }

  public Role save(Role body) {
    return roleRepository.save(body);
  }

  public Role findOne(Long id) {
    return roleRepository.findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public List<Role> findAll() {
    return roleRepository.findAll();
  }
}
