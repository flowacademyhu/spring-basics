package hu.flowacademy.demo.persistence.repository;

import hu.flowacademy.demo.persistence.model.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactJPARepository extends JpaRepository<Contact, Long> {

  @Query("SELECT c FROM Contact c WHERE c.phoneNumber = ?1")
  List<Contact> findByPhoneNumber(String phoneNumber);

//  @Query(nativeQuery = true, value = "") // in this case, value contains SQL, not HQL

  // select c from Contact c where c.phoneNumber = ?1 OR c.mobileNumber = ?2
  List<Contact> findByPhoneNumberOrMobileNumber(String phoneNumber, String mobileNumber);

}
