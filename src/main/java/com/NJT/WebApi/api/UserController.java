package com.NJT.WebApi.api;

import com.NJT.WebApi.model.user.User;
import com.NJT.WebApi.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userService.getById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllByOdobren(@RequestParam String odobren) {
        List<User> users = userService.getAllByOdobren(odobren);

        return ResponseEntity.ok(users);
    }

}
