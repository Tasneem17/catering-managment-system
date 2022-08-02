package za.ac.cput.entity;

public class Appointment {
    private String appointment_id;
    private String appointment_date;
    private String appointment_location;
    private String appointment_time;
    private String appointment_NumberOfGuest;

    //private constructor
    private Appointment(Builder builder){
        this.appointment_id = builder.appointment_id;
        this.appointment_date = builder.appointment_date;
        this.appointment_location = builder.appointment_location;
        this.appointment_time = builder.appointment_time;
        this.appointment_NumberOfGuest = builder.appointment_NumberOfGuest;
    }

    public String getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(String appointment_id) {
        this.appointment_id = appointment_id;
    }

    public String getAppointment_date() {
        return appointment_date;
    }

    public void setAppointment_date(String appointment_date) {
        this.appointment_date = appointment_date;
    }

    public String getAppointment_location() {
        return appointment_location;
    }

    public void setAppointment_location(String appointment_location) {
        this.appointment_location = appointment_location;
    }

    public String getAppointment_time() {
        return appointment_time;
    }

    public void setAppointment_time(String appointment_time) {
        this.appointment_time = appointment_time;
    }

    public String getAppointment_NumberOfGuest() {
        return appointment_NumberOfGuest;
    }

    public void setAppointment_NumberOfGuest(String appointment_NumberOfGuest) {
        this.appointment_NumberOfGuest = appointment_NumberOfGuest;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointment_id='" + appointment_id + '\'' +
                ", appointment_date='" + appointment_date + '\'' +
                ", appointment_location='" + appointment_location + '\'' +
                ", appointment_time='" + appointment_time + '\'' +
                ", appointment_NumberOfGuest='" + appointment_NumberOfGuest + '\'' +
                '}';
    }
    public static class Builder{
        private String appointment_id;
        private String appointment_date;
        private String appointment_location;
        private String appointment_time;
        private String appointment_NumberOfGuest;

        public Builder setAppointment_id(String appointment_id) {
            this.appointment_id = appointment_id;
            return this;
        }

        public Builder setAppointment_date(String appointment_date) {
            this.appointment_date = appointment_date;
            return this;
        }

        public Builder setAppointment_location(String appointment_location) {
            this.appointment_location = appointment_location;
            return this;
        }

        public Builder setAppointment_time(String appointment_time) {
            this.appointment_time = appointment_time;
            return this;
        }

        public Builder setAppointment_NumberOfGuest(String appointment_NumberOfGuest) {
            this.appointment_NumberOfGuest = appointment_NumberOfGuest;
            return this;
        }
        public Builder copy(Appointment appointment){
            this.appointment_id = appointment.appointment_id;
            this.appointment_date = appointment.appointment_date;
            this.appointment_location = appointment.appointment_location;
            this.appointment_time = appointment.appointment_time;
            this.appointment_NumberOfGuest = appointment.appointment_NumberOfGuest;
            return this;
        }
        public Appointment build(){
            return new Appointment(this);
        }
    }
}
