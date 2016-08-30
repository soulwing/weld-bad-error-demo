# weld-bda-error-demo

This demo CDI extension creates three bean instances dynamically. Each
bean instance is of type `DemoService`. Each bean has a qualifier; one of
either `@Red`, `@Green`, or `@Blue`.

If this module is used in a demo web application, it should be possible to
inject a qualified instance of `DemoService` into an injection point on another
bean; e.g.

```
@ApplicationScoped
public class MyBean {

  @Inject @Red
  DemoService redService;
  
}
```