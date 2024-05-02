package com.NJT.WebApi.api;

import com.NJT.WebApi.model.Student;
import com.NJT.WebApi.model.User;
import com.NJT.WebApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class starterAPI {

    UserService userService;

    @Autowired
    public starterAPI(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/adduser")
    public void addstudent(@RequestBody Student student) {

        userService.saveStudent(student);
    }

}
