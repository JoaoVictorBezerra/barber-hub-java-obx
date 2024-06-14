package tech.projects.barberhub.constants.enums;

public enum ScheduleStatusEnum {
    CONFIRMED("CONFIRMED"),
    FINALIZED("FINALIZED");

    private final String type;
    ScheduleStatusEnum(String type) {
        this.type = type;
    }

    public String getStatus() {
        return this.type;
    }
}
