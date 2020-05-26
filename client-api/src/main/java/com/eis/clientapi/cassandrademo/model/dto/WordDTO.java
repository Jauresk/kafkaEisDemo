package com.example.demo.model.dto;

import com.example.demo.model.entity.Word;
import org.springframework.data.cassandra.core.mapping.Column;

public class WordDTO {

    private String id;

    private String content;

    public WordDTO() {
    }

    public WordDTO(Word word) {
        this.id = word.getId();
        this.content = word.getContent();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
