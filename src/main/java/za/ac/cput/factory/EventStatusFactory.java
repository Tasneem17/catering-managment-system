package za.ac.cput.factory;


import za.ac.cput.entity.EventStatus;
import za.ac.cput.util.Helper;


public class EventStatusFactory {
    public static EventStatus build(String event_id, String event_Status){
        if (Helper.isNullorEmpty(event_id)|| Helper.isNullorEmpty(event_Status))
            return null;

        return new EventStatus.Builder().setEvent_id(event_id)
                .setEvent_status(event_Status)
                .build();

    }
}

