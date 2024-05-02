package com.NJT.WebApi.service;

import com.NJT.WebApi.model.Student;
import com.NJT.WebApi.model.User;
import com.NJT.WebApi.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    StudentRepository studentRepository;

    @Autowired
    public UserService(StudentRepository userRepository) {
        this.studentRepository = userRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

}
