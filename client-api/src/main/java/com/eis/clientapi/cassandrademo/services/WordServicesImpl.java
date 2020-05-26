package com.example.demo.services;

import com.example.demo.model.dto.WordDTO;
import com.example.demo.model.entity.Word;
import com.example.demo.model.mapper.WordMapper;
import com.example.demo.repositories.WordRepository;
import com.example.demo.utils.WordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WordServicesImpl implements WordServices {

    private WordRepository wordRepository;

    @Autowired
    public WordServicesImpl(WordRepository wordRepository) {
        this.wordRepository =  wordRepository;
    }

    @Override
    public List<WordDTO> listAll() {
        List<Word> words = new ArrayList<>();
        wordRepository.findAll().forEach(words::add); //fun with Java 8
        return new WordMapper().wordsToWordDTOs(words);
    }

    @Override
    public WordDTO getById(String id) {
        return wordRepository.findById(id)
                .map(entity -> new WordMapper().wordToWordDTO(entity))
                .orElseThrow( ()-> new WordNotFoundException(String.format("Word not found for id: %s", id)));
    }

    @Override
    public Optional<Word> findWordByContent(final List<Word> list, final String content) {
            return list.stream().filter(w -> w.getContent().equals(content)).findAny();
    }

    @Override
    public WordDTO save(Word word) {
        Word savedWord = wordRepository.save(word);
        if(savedWord == null) {
            throw new NullPointerException();
        }
        System.out.println("Saved Word Id: " + savedWord.getId());
        return new WordMapper().wordToWordDTO(savedWord);
    }
}
