package com.NJT.WebApi.api;

import com.NJT.WebApi.exception.UserNameExistsException;
import com.NJT.WebApi.model.user.Student;
import com.NJT.WebApi.model.user.ZaposleniUNastavi;
import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/register")
public class RegistrationController {

    private final UserController user;
    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService, UserController user) {
        this.userService = userService;
        this.user = user;
    }

    @PostMapping("/zaposleniVanNastavi")
    public ResponseEntity registrujZaposlenogVanNastavi(@RequestBody ZaposleniVanNastave zaposleni){
        try {
            userService.registruj(zaposleni);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UserNameExistsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Username already exists");
        }
    }

    @PostMapping("/zaposleniUNastavi")
    public void registrujZaposlenogUNastavi(@RequestBody ZaposleniUNastavi zaposleni){
        userService.registruj(zaposleni);
    }

    @PostMapping("/student")
    public void registrujStudenta(@RequestBody Student student){
        userService.registruj(student);
    }


}
