package org.jsp.cda.controller;

import org.jsp.cda.entity.Administrator;
import org.jsp.cda.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<?> saveAdmin(@RequestBody Administrator administrator){
        return adminService.saveAdmin(administrator);
    }

}
