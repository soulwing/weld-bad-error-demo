package org.soulwing.cdi.demo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Type;
import java.util.Set;
import javax.enterprise.inject.spi.Annotated;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.InjectionPoint;

public class InjectionPointWrapper implements InjectionPoint {

  private final InjectionPoint delegate;

  public InjectionPointWrapper(InjectionPoint delegate) {
    this.delegate = delegate;
  }

  @Override
  public Type getType() {
    return delegate.getType();
  }

  @Override
  public Set<Annotation> getQualifiers() {
    return delegate.getQualifiers();
  }

  @Override
  public Bean<?> getBean() {
    return delegate.getBean();
  }

  @Override
  public Member getMember() {
    return delegate.getMember();
  }

  @Override
  public Annotated getAnnotated() {
    return delegate.getAnnotated();
  }

  @Override
  public boolean isDelegate() {
    return delegate.isDelegate();
  }

  @Override
  public boolean isTransient() {
    return delegate.isTransient();
  }

}
