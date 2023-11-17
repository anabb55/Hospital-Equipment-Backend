package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.SystemAdmin;

import java.util.List;

public interface SystemAdminService {

    public SystemAdmin findOne(Integer id) ;
    public SystemAdmin save(SystemAdmin admin) ;
    public void remove(Integer id);
}
