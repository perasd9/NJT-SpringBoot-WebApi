package com.NJT.WebApi.repository;

import com.NJT.WebApi.model.user.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}