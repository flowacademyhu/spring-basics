package hu.flowacademy.demo.persistence.service;

import hu.flowacademy.demo.exception.ContactNotFoundException;
import hu.flowacademy.demo.exception.ContactValidationException;
import hu.flowacademy.demo.persistence.model.Contact;
import hu.flowacademy.demo.persistence.model.User;
import hu.flowacademy.demo.persistence.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service
@Transactional
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User save(User user) {
    return userRepository.save(user);
  }

  public User update(User user) {
    if (StringUtils.isEmpty(user.getUsername())) {
      throw new ContactValidationException("User not found");
    }
    return userRepository.save(user);
  }

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findOne(String id) {
    return userRepository.findById(id).orElseThrow(ContactNotFoundException::new);
  }

  public void delete(String id) {
    userRepository.deleteById(id);
  }

}
