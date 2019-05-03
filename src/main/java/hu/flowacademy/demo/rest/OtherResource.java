package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.component.MyComp;
import hu.flowacademy.demo.component.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherResource {

  @Autowired
  private MyComp myComp;

  @GetMapping("/sayHelloOther")
  public String getSomethingOther() {
//    return "2. Hello world! " + myComp.inc();
    return Singleton.getInstance().addChar("a");
  }

}
