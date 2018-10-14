package com.gd.demo.repository;

import com.gd.demo.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, String> {

    List<Word> findAll();

    Word findByName(String name);

}