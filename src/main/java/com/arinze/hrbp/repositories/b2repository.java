package com.arinze.hrbp.repositories;

import com.arinze.hrbp.models.A1;
import com.arinze.hrbp.models.B2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface b2repository extends JpaRepository<B2,Integer> {
    Optional<B2> findByFullnameAndTermAndSubject(String fullname, String term, String subject);
    List<B2> findBySubjectAndTerm(String subject, String term);
    Optional<B2> findByFullnameAndTermAndStudentClass(String name,String term, String studentClass);
}
