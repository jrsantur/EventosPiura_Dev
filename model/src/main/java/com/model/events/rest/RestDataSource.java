package com.model.events.rest;

import javax.inject.Inject;

public class RestDataSource {

    public static String END_POINT       = "http://gateway.marvel.com/";
    public static String PARAM_API_KEY   = "apikey";
    public static String PARAM_HASH      = "hash";
    public static String PARAM_TIMESTAMP = "ts";

    //private final EventApi mEventApi;

    @Inject
    public RestDataSource(EventAuthorizer eventAuthorizer){

        //this.mEventApi = mEventApi= null;
    }
}

