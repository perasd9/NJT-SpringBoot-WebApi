package com.NJT.WebApi.service;

import com.NJT.WebApi.model.user.Student;
import com.NJT.WebApi.model.user.ZaposleniVanNastave;
import com.NJT.WebApi.repository.StudentRepository;
import com.NJT.WebApi.repository.ZaposleniVanNastaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    StudentRepository studentRepository;
    ZaposleniVanNastaveRepository zaposleniVanNastaveRepository;

    @Autowired
    public UserService(
            StudentRepository userRepository,
            ZaposleniVanNastaveRepository zaposleniVanNastaveRepository) {
        this.studentRepository = userRepository;
        this.zaposleniVanNastaveRepository=zaposleniVanNastaveRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public void saveZaposleniVan(ZaposleniVanNastave zaposleniVanNastave){
        zaposleniVanNastaveRepository.save(zaposleniVanNastave);
    }

}
