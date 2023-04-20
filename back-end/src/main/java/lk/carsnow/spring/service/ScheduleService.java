package lk.carsnow.spring.service;

import lk.carsnow.spring.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {

    String generateScheduleId();

    void saveSchedule(ScheduleDTO scheduleDTO);

    List<ScheduleDTO>getAllSchedules();

}
