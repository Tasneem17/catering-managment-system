package za.ac.cput.factory;


import za.ac.cput.entity.EventStatus;
import za.ac.cput.util.Helper;


public class EventStatusFactory {
    public static EventStatus createEventStatus(String event_id, String event_Status){
        if (Helper.isNullorEmpty(event_id)|| Helper.isNullorEmpty(event_Status))
            return null;

        if (event_id.equals("")||event_id == null)
            return null;
        if (event_Status.equals("")||event_Status== null)
            return null;

        return new EventStatus.Builder().setEvent_id(event_id)
                .setEvent_status(event_Status)
                .build();

    }
}

