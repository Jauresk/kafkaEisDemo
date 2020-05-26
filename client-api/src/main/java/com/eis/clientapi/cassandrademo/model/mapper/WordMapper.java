package com.example.demo.model.mapper;

import com.example.demo.model.dto.WordDTO;
import com.example.demo.model.entity.Word;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class WordMapper {

    public WordDTO wordToWordDTO(Word word) {
        return new WordDTO(word);
    }

    public List<WordDTO> wordsToWordDTOs(List<Word> words) {
        return words.stream()
                .filter(Objects::nonNull)
                .map(this::wordToWordDTO)
                .collect(Collectors.toList());
    }

    public Word wordDTOToWord(WordDTO wordDTO) {
        if (wordDTO == null) {
            return null;
        } else {
            Word word = new Word();
            word .setId(wordDTO.getId());
            word.setContent(wordDTO.getContent());
            return word;
        }
    }

    public List<Word> wordDTOsToWords(List<WordDTO> wordDTOs) {
        return wordDTOs.stream()
                .filter(Objects::nonNull)
                .map(this::wordDTOToWord)
                .collect(Collectors.toList());
    }


}
