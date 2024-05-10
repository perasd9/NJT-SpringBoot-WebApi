package com.NJT.WebApi.service;

import com.NJT.WebApi.exception.RegistrationException;
import com.NJT.WebApi.model.user.Student;
import com.NJT.WebApi.model.user.User;
import com.NJT.WebApi.model.user.ZaposleniUNastavi;
import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.repository.StudentRepository;
import com.NJT.WebApi.repository.UserRepository;
import com.NJT.WebApi.repository.ZaposleniUNastaviRepository;
import com.NJT.WebApi.repository.ZaposleniVanNastaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepository userRepository;
    StudentRepository studentRepository;
    ZaposleniVanNastaveRepository zaposleniVanNastaveRepository;
    ZaposleniUNastaviRepository zaposleniUNastaviRepository;
    EncryptionService encryptionService;

    @Autowired
    public UserService(
            StudentRepository studentRepository,
            ZaposleniVanNastaveRepository zaposleniVanNastaveRepository,
            ZaposleniUNastaviRepository zaposleniUNastaviRepository,
            UserRepository userRepository,
            EncryptionService encryptionService) {
        this.studentRepository = studentRepository;
        this.zaposleniVanNastaveRepository=zaposleniVanNastaveRepository;
        this.zaposleniUNastaviRepository=zaposleniUNastaviRepository;
        this.userRepository = userRepository;
        this.encryptionService = encryptionService;
    }

    public void registerUser(User user) throws RegistrationException {
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RegistrationException("Email already exists");
        }
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RegistrationException("Username already exists");
        }
        user.setPassword(encryptionService.encryptPassword(user.getPassword()));
        upisiUBazu(user);


    }

    private void upisiUBazu(User user) throws RegistrationException {
        if (user instanceof ZaposleniVanNastave) {
            zaposleniVanNastaveRepository.save((ZaposleniVanNastave) user);
        } else if (user instanceof ZaposleniUNastavi) {
            zaposleniUNastaviRepository.save((ZaposleniUNastavi) user);
        } else if (user instanceof Student) {
            studentRepository.save((Student)user);
        }else {
            throw new RegistrationException("Invalid user type");
        }
    }

}
