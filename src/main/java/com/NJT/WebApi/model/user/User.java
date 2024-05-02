package com.NJT.WebApi.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "user")
@Inheritance
@DiscriminatorColumn(name="user_type")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Email
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ime_prezime", nullable = false)
    private String imePrezime;

    @Column(name = "password", nullable = false)
    private String password;

}