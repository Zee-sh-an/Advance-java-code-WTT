package com.Question5.service;

import com.Question5.entities.Student;
import com.Question5.repo.StudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveStudent(){

        Student student=new Student();
        student.setId(56);
        student.setName("Zeeshan");
        studentRepo.add(student);
    }

}
