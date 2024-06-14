package tech.projects.barberhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.projects.barberhub.model.barbershop.Barbershop;
import tech.projects.barberhub.model.schedule.Schedule;
import tech.projects.barberhub.model.user.User;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, String> {
    List<Schedule> findScheduleByUserId(User user);

    List<Schedule> findScheduleByBarbershopId(Barbershop id);
}
