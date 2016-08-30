package org.soulwing.cdi.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

public class DemoServiceBean implements Bean<DemoService> {

  private final Annotation qualifier;
  private final ConcreteDemoService delegate;

  public DemoServiceBean(Annotation qualifier) {
    this.qualifier = qualifier;
    this.delegate = new ConcreteDemoService(
      qualifier.getClass().getSimpleName().replaceAll("Literal$", ""));
  }

  public Class<?> getBeanClass() {
    return ConcreteDemoService.class;
  }

  public Set<InjectionPoint> getInjectionPoints() {
    return Collections.emptySet();
  }

  public boolean isNullable() {
    return false;
  }

  public DemoService create(CreationalContext<DemoService> creationalContext) {
    return delegate;
  }

  public void destroy(DemoService demoService, CreationalContext<DemoService> creationalContext) {

  }

  public Set<Type> getTypes() {
    Set<Type> types = new HashSet<>();
    types.add(DemoService.class);
    return types;
  }

  public Set<Annotation> getQualifiers() {
    return Collections.singleton(qualifier);
  }

  public Class<? extends Annotation> getScope() {
    return Dependent.class;
  }

  public String getName() {
    return null;
  }

  public Set<Class<? extends Annotation>> getStereotypes() {
    return Collections.emptySet();
  }

  public boolean isAlternative() {
    return false;
  }
}
