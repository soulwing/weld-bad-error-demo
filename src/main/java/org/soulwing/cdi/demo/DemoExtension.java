package org.soulwing.cdi.demo;

import java.lang.reflect.Type;
import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.spi.ProcessInjectionPoint;

public class DemoExtension implements Extension {

  private static final Logger logger = Logger.getLogger(
      DemoExtension.class.getName());

  public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event) {
    logger.info("starting bean discovery");
  }

  public <T, E> void processInjectionPoint(
      @Observes ProcessInjectionPoint<T, E> event) {
    final InjectionPoint injectionPoint = event.getInjectionPoint();
    final Type type = injectionPoint.getType();
    if (type instanceof Class
                                                                                                  && DemoService.class.isAssignableFrom((Class<?>) type)) {
      final InjectionPointWrapper wrapper =
          new InjectionPointWrapper(injectionPoint);
      logger.info("wrapped injection point " + injectionPoint);
      event.setInjectionPoint(wrapper);
    }
  }

  public void afterBeanDiscovery(@Observes AfterBeanDiscovery event) {
    event.addBean(new DemoServiceBean(new RedLiteral()));
    event.addBean(new DemoServiceBean(new GreenLiteral()));
    event.addBean(new DemoServiceBean(new BlueLiteral()));
    logger.info("finished bean discovery");
  }

}
