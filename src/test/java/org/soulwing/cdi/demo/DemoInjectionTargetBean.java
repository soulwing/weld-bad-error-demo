package org.soulwing.cdi.demo;

import java.io.PrintStream;
import javax.inject.Inject;

public class DemoInjectionTargetBean {

  @Inject @Red
  DemoService redService;

  @Inject @Green
  DemoService greenService;

  @Inject @Blue
  DemoService blueService;


  public void sayHello(PrintStream outputStream) {
    redService.sayHello(outputStream);
    greenService.sayHello(outputStream);
    blueService.sayHello(outputStream);
  }

}
