package org.soulwing.cdi.demo;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class DemoMain {

  public static void main(String[] args) throws Exception {
    final Weld weld = new Weld();
    try {
      final WeldContainer container = weld.initialize();

      DemoInjectionTargetBean bean =
          container.instance().select(DemoInjectionTargetBean.class).get();

      bean.sayHello(System.out);
    }
    finally {
      weld.shutdown();
    }
  }

}
