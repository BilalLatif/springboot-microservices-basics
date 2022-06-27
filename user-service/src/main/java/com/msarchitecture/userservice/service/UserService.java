package com.msarchitecture.userservice.service;

import com.msarchitecture.userservice.VO.Department;
import com.msarchitecture.userservice.VO.ResponseTemplateVO;
import com.msarchitecture.userservice.entity.Users;
import com.msarchitecture.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Users saveUser(Users user) {
        log.info("Inside saveUser method of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment method of UserService");

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        Users user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://API-GATEWAY/departments/"+user.getDepartmentId(), Department.class);

        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }
}
