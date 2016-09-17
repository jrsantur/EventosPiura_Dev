package com.model.events.rest.utils.deserializers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.model.events.entities.Event;

import java.lang.reflect.Type;
import java.util.List;


public class ResultsEventsDeserialiser implements JsonDeserializer<List<Event>> {

    @Override
    public List<Event> deserialize(JsonElement je, Type typeOfT,
            JsonDeserializationContext context) throws JsonParseException {

            Type listType = new TypeToken<List<Event>>() {}.getType();

            JsonElement data = je.getAsJsonObject().get("data");
            JsonElement results = je.getAsJsonObject().get("results");
            JsonArray resultsArray = results.getAsJsonArray();
            JsonElement comicsObject = resultsArray.get(0);
            JsonElement items = comicsObject.getAsJsonObject().get("items");

            return new Gson().fromJson(items, listType);
        }
    }