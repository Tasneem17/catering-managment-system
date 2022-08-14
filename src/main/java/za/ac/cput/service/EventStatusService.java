package za.ac.cput.service;



import za.ac.cput.entity.EventStatus;

import java.util.List;

public interface EventStatusService extends IService<EventStatus,String>{

    List<EventStatus> findAllEvent_id(String eventStatus);
}
