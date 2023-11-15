package com.ISAproject.hospitalequipment.service;

import com.ISAproject.hospitalequipment.domain.RegisteredUser;

import java.util.List;

public interface RegisteredUserService {
    public List<RegisteredUser> findAll() ;
    public RegisteredUser findOne(Integer id) ;
    public RegisteredUser save(RegisteredUser course) ;
    public void remove(Integer id);
    public boolean existsById(Integer id);

}
