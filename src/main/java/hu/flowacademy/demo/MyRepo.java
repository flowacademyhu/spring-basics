package hu.flowacademy.demo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepo {

  private List<Object> list = new ArrayList<>();

  public void add(Object o) {
    list.add(o);
  }

  public void delete(int i) {
    list.remove(i);
  }

}
