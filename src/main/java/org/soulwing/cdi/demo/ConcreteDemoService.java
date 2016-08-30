package org.soulwing.cdi.demo;

import java.io.PrintStream;

public class ConcreteDemoService implements DemoService {

  private final String color;

  public ConcreteDemoService(String color) {
    this.color = color;
  }

  public void sayHello(PrintStream outputStream)  {
    outputStream.println(color);
  }

}
