package hu.flowacademy.demo.rest;

import hu.flowacademy.demo.component.MyComp;
import hu.flowacademy.demo.component.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicResource {

//  @Autowired
//  private MyComp myComp;

//  private final MyComp myComp;

//  public BasicResource(MyComp myComp) {
//    this.myComp = myComp;
//    integerObjectMap.put(1, "Task1");
//    integerObjectMap.put(2, "Task2");
//    integerObjectMap.put(3, "Task3");
//  }

  private MyComp myComp;

  @Autowired
  public void setMyComp(MyComp myComp) {
    this.myComp = myComp;
  }

  @GetMapping("/sayHello")
  public String getSomething() {
    return Singleton.getInstance().addChar("b");
  }


  Map<Integer, Object> integerObjectMap = new HashMap<>();

  public BasicResource() {
    integerObjectMap.put(1, "Task1");
    integerObjectMap.put(2, "Task2");
    integerObjectMap.put(3, "Task3");
  }

  @GetMapping("/tasks")
  public Map<Integer, Object> getTasks() {
    return integerObjectMap;
  }

  @GetMapping("/tasks/{id}")
  public Object getTasks(@PathVariable Integer id, @RequestHeader("Content-Type") String contentType) {
    System.err.println(contentType);
    return integerObjectMap.get(id);
  }

  @PostMapping("/tasks")
  public Object saveTask(@RequestBody Object body) {
    Integer key = integerObjectMap.keySet().stream().max((item1, item2) -> item1.compareTo(item2))
        .orElse(new Random().nextInt(Integer.MAX_VALUE));
    integerObjectMap.put(key + 1, body);
    return body;
  }

  @PutMapping("/tasks/{id}")
  public Object updateTask(@RequestBody Object body, @PathVariable Integer id) {
    System.err.println("Update id is: " + id);
    integerObjectMap.put(id, body);
    return body;
  }

  @DeleteMapping("/tasks")
  public void deleteTask(@RequestParam("id") Integer id) {
    integerObjectMap.remove(id);
    System.err.println("Task deleted " + id);
  }

}
