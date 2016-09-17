package com.domain.events;

import com.model.events.entities.Preferencias;

import java.util.List;

import rx.Observable;

/**
 * Created by Junior on 17/09/2016.
 */

public class GetPreferenceUsecase extends Usecase<List<Preferencias>> {


    @Override
    public Observable<List<Preferencias>> buildObservable() {
        return null;
    }
}
