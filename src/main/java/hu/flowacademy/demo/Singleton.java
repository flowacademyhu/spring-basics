package hu.flowacademy.demo;

public class Singleton {

  private String characters;

  private static Singleton instance;

  public static Singleton getInstance() {
    if (instance == null) {
      instance = new Singleton();
    }
    return instance;
  }

  private Singleton() {
    this.characters = "";
  }

  public String addChar(String str) {
    this.characters += str;
    return characters;
  }



}
