/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.controller;

import lk.carsnow.spring.dto.ScheduleDTO;
import lk.carsnow.spring.service.ScheduleService;
import lk.carsnow.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("schedule")
@CrossOrigin
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @GetMapping(params = {"tempId"})
    public ResponseUtil generateScheduleId(@RequestParam  String tempId){
        return new ResponseUtil(200,"load",scheduleService.generateScheduleId());
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveSchedule(@RequestBody ScheduleDTO scheduleDTO){
        scheduleService.saveSchedule(scheduleDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllSchedules(){
        return new ResponseUtil(200, "Ok", scheduleService.getAllSchedules());
    }

}

