package hu.flowacademy.demo.component;

import java.util.UUID;

public class Prototype {

  private String sessionId;

  public String getSessionId() {
    return sessionId;
  }

  public Prototype() {
    this.sessionId = UUID.randomUUID().toString();
  }
}
