package com.gd.demo.repository;

import com.gd.demo.domain.Sentence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, String> {

    List<Sentence> findAll();

    Sentence findSentencesById(Long sentenceID);

}
