package com.gd.demo.repository;

import com.gd.demo.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentencesRepository extends JpaRepository<Word, String> {

    public List<Word> findAll();

}

//TODO: Repositories for saving data in the DB
