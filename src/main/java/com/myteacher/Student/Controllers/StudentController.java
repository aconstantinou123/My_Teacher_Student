package com.myteacher.Student.Controllers;

import com.myteacher.Student.Models.Student;
import com.myteacher.Student.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PreAuthorize("hasAuthority('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PreAuthorize("hasAuthority('STUDENT')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Student getStudentByUsername(@PathVariable("username") String username){
        return studentRepository.findByUsername(username);
    }
}
