package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.StringUtils;

public abstract class CustomService<M, ID> {

  public M save(M user) {
    return getRepository().save(user);
  }

  public M update(M user) {
//    if (StringUtils.isEmpty(user.getUsername())) {
//      throw new ContactValidationException("User not found");
//    }
    return getRepository().save(user);
  }

  public List<M> findAll() {
    return getRepository().findAll();
  }

  public M findOne(ID id) {
    return getRepository().findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public void delete(ID id) {
    getRepository().deleteById(id);
  }

  protected abstract JpaRepository<M, ID> getRepository();

}
