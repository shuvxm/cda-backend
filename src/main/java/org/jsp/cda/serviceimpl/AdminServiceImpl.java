package org.jsp.cda.serviceimpl;

import org.jsp.cda.dao.AdminDao;
import org.jsp.cda.entity.Administrator;
import org.jsp.cda.responsestructure.ResponseStructure;
import org.jsp.cda.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public ResponseEntity<?> saveAdmin(Administrator administrator) {
        administrator = adminDao.saveAdmin(administrator);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Administrator saved successfully").body(administrator).build());
    }
}
