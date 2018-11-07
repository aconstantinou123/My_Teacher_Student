package com.myteacher.Student.Repositories;

import com.myteacher.Student.Models.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    Student findByUsername(String username);
    Student findAllByTeacherId(String teacherId);
}
