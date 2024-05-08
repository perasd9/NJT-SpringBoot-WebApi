package com.NJT.WebApi.api;

import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.service.UserService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("api/v1/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //not implemented
    @PostMapping("/add/zaposlenivannastave")
    public void addZaposleniVANNastave(@RequestBody ZaposleniVanNastave zaposleniVanNastave) {

    }

}
