package br.com.dio.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.dio.service.EventEnum.CLEAR_SPACE;
import static javax.swing.UIManager.put;

public class NotifierService {

    private final Map<EventEnum, List<EventListener>> listeners = new HashMap<>(){{
        put(CLEAR_SPACE, new ArrayList<>());
    }};

    public void subscriber(final EventEnum eventType, EventListener listener){
        var seletedListeners = listeners.get(eventType);
        seletedListeners.add(listener);
    }

    public void notify(final EventEnum evenType){
        listeners.get(evenType).forEach(l -> l.update(evenType));
    }
}
