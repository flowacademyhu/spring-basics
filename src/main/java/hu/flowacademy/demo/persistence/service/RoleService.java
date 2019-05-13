package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.persistence.model.Role;
import hu.flowacademy.demo.persistence.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleService extends CustomService<Role, Long> {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  protected JpaRepository<Role, Long> getRepository() {
    return roleRepository;
  }
}
