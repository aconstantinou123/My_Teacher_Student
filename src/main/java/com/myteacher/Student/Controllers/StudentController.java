package com.myteacher.Student.Controllers;

import com.myteacher.Student.Models.Student;
import com.myteacher.Student.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
