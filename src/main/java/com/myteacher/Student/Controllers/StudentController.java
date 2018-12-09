package com.myteacher.Student.Controllers;

import com.myteacher.Student.Models.Student;
import com.myteacher.Student.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.myteacher.Student.Security.SecurityConstants.HEADER_STRING;
import static com.myteacher.Student.Security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PreAuthorize("hasRole('TEACHER')")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @RequestMapping(value = "/persist-login", method = RequestMethod.GET)
    public ResponseEntity<String> handle(@CookieValue("studentToken") String studentToken){
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(HEADER_STRING, TOKEN_PREFIX + studentToken);
        return new ResponseEntity<String>(responseHeaders, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Student getStudentByUsername(@PathVariable("username") String username){
        return studentRepository.findByUsername(username);
    }
}
