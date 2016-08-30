/*
 * File created on Aug 30, 2016
 *
 * Copyright (c) 2016 Carl Harris, Jr
 * and others as noted
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
