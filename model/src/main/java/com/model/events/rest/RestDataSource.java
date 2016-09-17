package com.model.events.rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.model.events.entities.Event;
import com.model.events.entities.Preferencias;
import com.model.events.repository.EventRepository;
import com.model.events.rest.utils.deserializers.EventsResultsDeserializer;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import static com.squareup.okhttp.logging.HttpLoggingInterceptor.*;

import java.util.List;

import javax.inject.Inject;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.functions.Func1;

public class RestDataSource  implements EventRepository{

    public static String END_POINT       = "http://gateway.marvel.com/";
    public static String PARAM_API_KEY   = "apikey";
    public static String PARAM_HASH      = "hash";
    public static String PARAM_TIMESTAMP = "ts";

    private final EventApi mEventApi;

    @Inject
    public RestDataSource(EventAuthorizer eventAuthorizer){
        OkHttpClient client = new OkHttpClient();
        /*
        MarvelSigningIterceptor signingIterceptor =
                new MarvelSigningIterceptor(
                        marvelAuthorizer.getApiClient(),
                        marvelAuthorizer.getApiSecret());
        */
        HttpLoggingInterceptor logginInterceptor = new HttpLoggingInterceptor();
        logginInterceptor.setLevel(Level.BODY);

        //client.interceptors().add(signingIterceptor);
        client.interceptors().add(logginInterceptor);


        Gson customGsonInstance = new GsonBuilder()
                .registerTypeAdapter(new TypeToken<List<Event>>() {}.getType(),
                        new EventsResultsDeserializer<Event>())

        //        .registerTypeAdapter(new TypeToken<List<CollectionItem>>() {}.getType(),
        //                new MarvelResultsDeserializer<CollectionItem>())

                .create();

        Retrofit eventApiAdapter = new Retrofit.Builder()
                .baseUrl(END_POINT)
                .addConverterFactory(GsonConverterFactory.create(customGsonInstance))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();


        mEventApi = eventApiAdapter.create(EventApi.class);

    }

    @Override
    public Observable<Event> getEvent(int ventId) {
        return mEventApi.getEventById(ventId).flatMap(new Func1<List<Event> ,Observable<Event>>(){
            @Override public Observable<Event> call (List<Event> events){
                return Observable.just(events.get(0));
            }
        });
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

