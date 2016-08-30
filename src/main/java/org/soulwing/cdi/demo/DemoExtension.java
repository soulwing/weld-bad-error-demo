package org.soulwing.cdi.demo;

import java.util.logging.Logger;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;

public class DemoExtension implements Extension {

  private static final Logger logger = Logger.getLogger(
      DemoExtension.class.getName());

  public void beforeBeanDiscovery(@Observes BeforeBeanDiscovery event) {
    logger.info("starting bean discovery");
  }

  public void afterBeanDiscovery(@Observes AfterBeanDiscovery event) {
    event.addBean(new DemoServiceBean(new RedLiteral()));
    event.addBean(new DemoServiceBean(new GreenLiteral()));
    event.addBean(new DemoServiceBean(new BlueLiteral()));
    logger.info("finished bean discovery");
  }

}
