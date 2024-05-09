package com.NJT.WebApi.api;

import com.NJT.WebApi.model.user.User;
import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("api/v1/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

}
