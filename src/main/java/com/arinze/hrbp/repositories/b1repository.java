package com.arinze.hrbp.repositories;

import com.arinze.hrbp.models.A1;
import com.arinze.hrbp.models.B1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface b1repository extends JpaRepository<B1,Integer> {
    Optional<B1> findByFullnameAndTermAndSubject(String fullname, String term, String subject);
    List<B1> findBySubjectAndTerm(String subject, String term);
    Optional<B1> findByFullnameAndTermAndStudentClass(String name,String term, String studentClass);
}
