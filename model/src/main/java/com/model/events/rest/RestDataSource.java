package com.model.events.rest;

import com.model.events.entities.Event;
import com.model.events.entities.Preferencias;
import com.model.events.repository.EventRepository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;

public class RestDataSource  implements EventRepository{

    public static String END_POINT       = "http://gateway.marvel.com/";
    public static String PARAM_API_KEY   = "apikey";
    public static String PARAM_HASH      = "hash";
    public static String PARAM_TIMESTAMP = "ts";

    //private final EventApi mEventApi;

    @Inject
    public RestDataSource(EventAuthorizer eventAuthorizer){

        //this.mEventApi = mEventApi= null;
    }


    //obtener
    @Override
    public Observable<Event> getEvent(int characterId) {
        return null;
    }

    @Override
    public Observable<List<Event>> getEvents(int offset) {
        return null;
    }

    @Override
    public Observable<List<Preferencias>> getPreferencias(int offset) {
        return null;
    }
}

