package hu.flowacademy.demo.exception;

public class ContactNotFoundException extends RuntimeException {

  public ContactNotFoundException() {
    super("Contact not found!");
  }
}
