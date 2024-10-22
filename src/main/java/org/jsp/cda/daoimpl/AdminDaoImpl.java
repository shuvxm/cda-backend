package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.AdminDao;
import org.jsp.cda.entity.Administrator;
import org.jsp.cda.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {

    @Autowired
    private AdminRepository adminRepository;
    @Override
    public Administrator saveAdmin(Administrator administrator) {
        return adminRepository.save(administrator);
    }
}
