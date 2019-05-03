package hu.flowacademy.demo;

import org.springframework.stereotype.Component;

@Component
public class MyComp {

  private int count;

  public int inc() {
    return ++count;
  }

}
