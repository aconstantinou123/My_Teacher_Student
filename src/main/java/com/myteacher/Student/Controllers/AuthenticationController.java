package com.myteacher.Student.Controllers;

import com.myteacher.Student.Models.Student;
import com.myteacher.Student.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private StudentRepository repository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public AuthenticationController(StudentRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.repository = repository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
    public void signUp(@RequestBody Student student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        repository.save(student);
    }

}

