package com.model.events.rest;

import com.model.events.entities.Event;
import com.model.events.entities.Preferencias;
import com.model.events.rest.wrappers.UsuarioPreferencia;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by Junior on 06/09/2016.
 */
public interface EventApi {

    @GET("")
    Observable<List<Event>> getEventById(@Query("id") int id);

    @GET("")
    Observable<List<Event>> getEvents (@Query("offset") int offset);

    @GET("")
    Observable<Preferencias> getPreferencias();

    @POST("")
    Observable<List<UsuarioPreferencia>> sendPreferenciasUsuario(@Body UsuarioPreferencia usuarioPreferencia);
}
