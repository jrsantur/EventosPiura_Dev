package com.startup.piura.eventos.injector.components;

/**
 * Created by Junior on 06/09/2016.
 */

import com.model.events.rest.Endpoint;
import com.model.events.rest.EventAuthorizer;
import com.startup.piura.eventos.EventsApplication;
import com.startup.piura.eventos.injector.modulos.AppModule;
import dagger.Component;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;


@Singleton @Component(modules = AppModule.class)
public interface AppComponent {
    EventsApplication app();

    Endpoint restEndpoint();
    EventAuthorizer eventAuthorizer();

    @Named("ui_thread") Scheduler uiThread();
    @Named("executor_thread") Scheduler executorThread();
}
