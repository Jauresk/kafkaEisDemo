package com.example.demo.services;

import com.example.demo.model.dto.WordDTO;
import com.example.demo.model.entity.Word;

import java.util.List;
import java.util.Optional;

public interface WordServices {

    List<WordDTO> listAll();

    WordDTO getById(String id);

    Optional<Word> findWordByContent(final List<Word> list, final String content);

    WordDTO save(Word word);
}
