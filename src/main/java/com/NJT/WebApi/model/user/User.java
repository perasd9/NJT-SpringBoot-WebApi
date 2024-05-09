package com.NJT.WebApi.model.user;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
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
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ZaposleniVanNastave.class, name = "ZaposleniVanNastave"),
        @JsonSubTypes.Type(value = ZaposleniUNastavi.class, name = "ZaposleniUNastavi"),
        @JsonSubTypes.Type(value = Student.class, name = "Student")})
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

    @Column(name = "odobren", nullable = false)
    private Boolean odobren = false;

    @Column(name = "potvrdjen_mail", nullable = false)
    private Boolean potvrdjenMail = false;

    @Transient
    String type;

}