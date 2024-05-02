package com.NJT.WebApi.api;

import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add/zaposlenivannastave")
    public void addZaposleniVANNastave(@RequestBody ZaposleniVanNastave zaposleniVanNastave) {

        userService.saveZaposleniVanNastave(zaposleniVanNastave);
    }

}
