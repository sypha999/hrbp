package com.arinze.hrbp.repositories;

import com.arinze.hrbp.models.A1;
import com.arinze.hrbp.models.A2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface a2repository extends JpaRepository<A2,Integer> {
    Optional<A2> findByFullnameAndTermAndSubject(String fullname, String term, String subject);
    List<A2> findBySubjectAndTerm(String subject, String term);
    Optional<A2> findByFullnameAndTerm(String name, String term);
}
