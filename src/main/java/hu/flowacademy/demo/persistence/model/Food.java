package hu.flowacademy.demo.persistence.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "foods")
public class Food {

  @Id
  @Column
  private String name;

  @Column
  private Double energy;

  @ManyToMany(mappedBy = "foods")
  private List<Contact> contacts;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getEnergy() {
    return energy;
  }

  public void setEnergy(Double energy) {
    this.energy = energy;
  }

  public List<Contact> getContacts() {
    return contacts;
  }

  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }
}
