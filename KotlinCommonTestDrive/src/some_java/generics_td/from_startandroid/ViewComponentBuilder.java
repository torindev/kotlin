package some_java.generics_td.from_startandroid;

public interface ViewComponentBuilder<C extends ViewComponent, M extends ViewModule>   {
    C buildComponent();
    ViewComponentBuilder<C,M> moduleProduce(M module);
}
