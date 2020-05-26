package com.example.demo.repositories;

import com.example.demo.model.entity.Word;
import org.springframework.data.repository.CrudRepository;

public interface WordRepository extends CrudRepository<Word, String> {  // extends CassandraRepository<BookStoreEntity, UUID> {
}
