package za.ac.cput.entity;

public class EventStatus {
    private String event_id;
    private String event_Status;

    //private constructor
    private EventStatus(EventStatus.Builder builder){
        this.event_id = builder.event_id;
        this.event_Status = builder.event_status;
    }


    public String getEvent_id() {
        return event_id;
    }

    public void setEvent_id(String event_id) {
        this.event_id = event_id;
    }

    public String getEvent_Status() {
        return event_Status;
    }

    public void setEvent_Status(String event_Status) {
        this.event_Status = event_Status;
    }

    @Override
    public String toString() {
        return "EventStatus{" +
                "event_id='" + event_id + '\'' +
                ", event_Status='" + event_Status + '\'' +
                '}';
    }
    public static class Builder {
        private String event_id;
        private String event_status;

        public Builder setEvent_id(String event_id) {
            this.event_id = event_id;
            return this;
        }

        public Builder setEvent_status(String event_status) {
            this.event_status = event_status;
            return this;
        }
        public EventStatus.Builder copy(EventStatus eventstatus){
            this.event_id = eventstatus.event_id;
            this.event_status = eventstatus.event_Status;
            return this;
        }
        public EventStatus build(){
            return new EventStatus(this);
        }

    }
}
