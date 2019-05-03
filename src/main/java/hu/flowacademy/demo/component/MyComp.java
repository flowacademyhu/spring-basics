package hu.flowacademy.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyComp {

  private int count;

  public int inc() {
    return ++count;
  }

}
