package com.arinze.hrbp.repositories;

import com.arinze.hrbp.models.A1;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface a1repository extends JpaRepository<A1,Integer> {

    Optional<A1> findByFullnameAndTermAndSubject(String fullname,String term, String subject);
    List <A1> findBySubjectAndTerm(String subject,String term);

    Optional<A1> findByFullnameAndTerm(String name,String term);

}
