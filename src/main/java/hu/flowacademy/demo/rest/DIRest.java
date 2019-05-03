package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.component.Prototype;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/di")
public class DIRest {

  @Autowired
  private Prototype prototype;

  @GetMapping("/prototype")
  public String getSessionId() {
    return prototype.getSessionId();
  }

}
