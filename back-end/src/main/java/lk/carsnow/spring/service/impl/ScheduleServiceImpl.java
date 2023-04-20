/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.service.impl;

import lk.carsnow.spring.dto.ScheduleDTO;
import lk.carsnow.spring.entity.Schedule;
import lk.carsnow.spring.repo.ScheduleRepo;
import lk.carsnow.spring.service.ScheduleService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepo scheduleRepo;

    @Autowired
    ModelMapper mapper;

    @Override
    public String generateScheduleId() {
       return scheduleRepo.generateScheduleId();
    }

    @Override
    public void saveSchedule(ScheduleDTO scheduleDTO) {
        if (!scheduleRepo.existsById(scheduleDTO.getScheduleId())) {
            scheduleRepo.save(mapper.map(scheduleDTO, Schedule.class));
        }else {
            throw new RuntimeException(scheduleDTO.getScheduleId()+" Schedule Already Exists..!");
        }
    }

    @Override
    public List<ScheduleDTO> getAllSchedules() {
        List<Schedule> scheduleList = scheduleRepo.findAll();
        return mapper.map(scheduleList, new TypeToken<List<ScheduleDTO>>(){
        }.getType());
    }


}

