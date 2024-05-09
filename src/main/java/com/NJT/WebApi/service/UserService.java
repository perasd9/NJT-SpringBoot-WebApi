package com.NJT.WebApi.service;

import com.NJT.WebApi.exception.UserNameExistsException;
import com.NJT.WebApi.model.user.Student;
import com.NJT.WebApi.model.user.ZaposleniUNastavi;
import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.repository.StudentRepository;
import com.NJT.WebApi.repository.ZaposleniUNastaviRepository;
import com.NJT.WebApi.repository.ZaposleniVanNastaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    StudentRepository studentRepository;
    ZaposleniVanNastaveRepository zaposleniVanNastaveRepository;
    ZaposleniUNastaviRepository zaposleniUNastaviRepository;

    @Autowired
    public UserService(
            StudentRepository studentRepository,
            ZaposleniVanNastaveRepository zaposleniVanNastaveRepository,
            ZaposleniUNastaviRepository zaposleniUNastaviRepository) {
        this.studentRepository = studentRepository;
        this.zaposleniVanNastaveRepository=zaposleniVanNastaveRepository;
        this.zaposleniUNastaviRepository=zaposleniUNastaviRepository;
    }

    public void registruj(ZaposleniVanNastave zaposleni) throws UserNameExistsException {
        if(zaposleniVanNastaveRepository.findByUsername(zaposleni.getUsername()).isPresent()){
        throw new UserNameExistsException();
        }
        zaposleniVanNastaveRepository.save(zaposleni);
    }

    public void registruj(ZaposleniUNastavi zaposleni) throws UserNameExistsException {

        if(zaposleniUNastaviRepository.findByUsername(zaposleni.getUsername()).isPresent()){
            throw new UserNameExistsException();
        }
        zaposleniUNastaviRepository.save(zaposleni);
    }

    public void registruj(Student student) throws UserNameExistsException {
        if(studentRepository.findByUsername(student.getUsername()).isPresent()){
            throw new UserNameExistsException();
        }
        studentRepository.save(student);
    }

}
