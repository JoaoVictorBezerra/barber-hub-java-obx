package tech.projects.barberhub.constants.schedule;

public class ScheduleConstants {
    private ScheduleConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String CREATED = "Service scheduled with success.";
    public static final String BARBERSHOP_CLOSED = "Barbershop already closed on this time. Please, try soon.";
    public static final String ALREADY_SCHEDULED = "A service is already scheduled on this time.";
    public static final String INCORRECT_TIME = "Services only can be scheduled on half or o'clock time.";


}
