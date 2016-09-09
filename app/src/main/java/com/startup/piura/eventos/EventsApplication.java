package com.startup.piura.eventos;

import android.app.Application;
import com.startup.piura.eventos.injector.components.AppComponent;
import com.startup.piura.eventos.injector.components.DaggerAppComponent;
import com.startup.piura.eventos.injector.modulos.AppModule;

/**
 * Created by Junior on 06/09/2016.
 */
public class EventsApplication  extends Application{
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }
    private void initializeInjector() {
        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
    public AppComponent getAppComponent() {
        return mAppComponent;
    }
}
