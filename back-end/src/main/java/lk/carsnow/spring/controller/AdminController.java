/**
 * author  Yasith C Bandara
 * created 4/19/2023 - 3:13 PM
 * project back-end
 */

package lk.carsnow.spring.controller;

import lk.carsnow.spring.dto.AdminDTO;
import lk.carsnow.spring.service.AdminService;
import lk.carsnow.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping
    public ResponseUtil saveAdmin(@ModelAttribute AdminDTO dto){
        service.addAdmin(dto);
        return new ResponseUtil(200,dto.getId()+" Successfully Added..",null);
    }

    @GetMapping
    public ResponseUtil getAllAdmins(){
        ArrayList<AdminDTO> allAdmins = service.getAllAdmins();
        return new ResponseUtil(200,"Success..",allAdmins);
    }

    @DeleteMapping(params = "id")
    public ResponseUtil  deleteAdmin(String id){
        service.deleteAdmin(id);
        return new ResponseUtil(200,id+" Successfully deleted...!",null);
    }

    @PutMapping
    public ResponseUtil updateAdmin(@RequestBody AdminDTO dto){
        service.updateAdmin(dto);
        return new ResponseUtil(200, dto.getId()+" Successfully updated..", null);
    }

    @GetMapping(path ="/{password}/{name}")
    public ResponseUtil findByPasswordAndUsername(@PathVariable("password") String password, @PathVariable("name") String name){
        return new ResponseUtil(200, "Ok", service.findByPasswordAndUsername(password,name));
    }
}
