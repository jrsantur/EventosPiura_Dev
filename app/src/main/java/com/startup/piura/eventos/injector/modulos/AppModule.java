package com.startup.piura.eventos.injector.modulos;

/**
 * Created by Junior on 06/09/2016.
 */
import com.model.events.rest.Endpoint;
import com.model.events.rest.EventAuthorizer;
import com.startup.piura.eventos.BuildConfig;
import com.startup.piura.eventos.EventsApplication;

import dagger.Module;
import dagger.Provides;
import javax.inject.Named;
import javax.inject.Singleton;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


@Module
public class AppModule {
    private final EventsApplication mAvengersApplication;

    public AppModule(EventsApplication mAvengersApplication) {
        this.mAvengersApplication = mAvengersApplication;
    }
    @Provides @Singleton
    EventsApplication provideEventsApplicationContext() {
        return mAvengersApplication; }


    @Provides
    EventAuthorizer provideMarvelAuthorizer() {
        return new EventAuthorizer(BuildConfig.EVENT_PUBLIC_KEY, BuildConfig.EVENT_PRIVATE_KEY);
    }

    @Provides
    Endpoint provideRestEndpoint() {
        return new Endpoint("http://gateway.marvel.com/");
    }

    //   @Provides @Singleton
    //CharacterRepository provideDataRepository(RestDataSource restDataSource) {
    //    return restDataSource; }

    @Provides @Named("executor_thread")
    Scheduler provideExecutorThread() {
        return Schedulers.newThread();
    }

    @Provides @Named("ui_thread")
    Scheduler provideUiThread() {
        return AndroidSchedulers.mainThread();
    }
}
