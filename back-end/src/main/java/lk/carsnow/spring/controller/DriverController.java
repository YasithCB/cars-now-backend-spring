/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.controller;

import lk.carsnow.spring.dto.DriverDTO;
import lk.carsnow.spring.service.DriverService;
import lk.carsnow.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("driver")
@CrossOrigin
public class DriverController {

    @Autowired
     DriverService driverService;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveDriver(@RequestBody DriverDTO driverDTO){
        driverService.saveDriver(driverDTO);
        return new ResponseUtil(200, "Successfully Saved.",null);
    }

    @GetMapping(params = {"test"})
    public ResponseUtil generateDriverIds(@RequestParam String test) {
        return new ResponseUtil(200, "Ok", driverService.generateDriverIds());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDrivers(){
        return new ResponseUtil(200, "Ok", driverService.getAllDrivers());
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchDriver(@PathVariable String id){
        return new ResponseUtil(200, "Ok.",driverService.searchDriver(id));
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateDriver(@RequestBody DriverDTO driverDTO){
        driverService.updateDriver(driverDTO);
        return new ResponseUtil(200, "Successfully Updated.",null);
    }

    @GetMapping(path = "/USER/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchUserFromDriver(@PathVariable("id") String id){
        return new ResponseUtil(200, "Ok.",driverService.searchUserFromDriver(id));
    }

    @GetMapping(path = "/status/{release}")
    public ResponseUtil assignRandomlyDriver(@PathVariable("release") String release) {
        return new ResponseUtil(200, "Ok", driverService.assignRandomlyDriver(release));
    }
    @GetMapping(path = "/RELEASE/{release}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchAvailableDriversOrReleasedDrivers(@PathVariable("release") String release){
        return new ResponseUtil(200, "Ok.",driverService.searchAvailableDriversOrReleaseDrivers(release));
    }


    @GetMapping(path = "/countOfAvailableDrivers/{release}")
    public ResponseUtil availableDriversOrOccupiedDrivers(@PathVariable("release") String release) {
        return new ResponseUtil(200, "Ok", driverService.availableDriversOrOccupiedDrivers(release));
    }


}
