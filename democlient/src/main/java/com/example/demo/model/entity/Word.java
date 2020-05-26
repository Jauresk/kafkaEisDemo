package com.example.demo.model.entity;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("word")
public class Word {

    @PrimaryKey
    private String id;

    @Column(value = "title")
    private String content;

    public Word() {
    }

    public Word(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "word{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
