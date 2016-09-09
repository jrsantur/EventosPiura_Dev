package com.model.events.repository;

import com.model.events.entities.Event;
import java.util.List;
import rx.Observable;


/**
 * Created by Junior on 06/09/2016.
 */
public interface EventRepository {

    Observable<Event> getEvent (final int characterId);
    Observable<List<Event>> getEvents (int offset);
}
