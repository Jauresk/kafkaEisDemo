package com.example.demo.controllers;

import com.example.demo.model.dto.WordDTO;
import com.example.demo.model.entity.Word;
import com.example.demo.services.WordServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@RequestMapping("/api")
@RestController
public class WordController {

    private final Logger log = LoggerFactory.getLogger(WordController.class);

    private WordServices wordServices;

    @Autowired
    public void setWordService(WordServices wordServices) {
        this.wordServices = wordServices;
    }

    //@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/allWords")
    public ResponseEntity<?> listAll() {
        log.trace("Reading all Words");
        return new ResponseEntity<>(wordServices.listAll(), HttpStatus.OK);
    }

    //@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable(value = "id") String id) {
        log.trace("Reading word information by Id");
        return new ResponseEntity<>(wordServices.getById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{content}", method = RequestMethod.GET)
    public ResponseEntity<?> findWordByContent(List<Word> list, @PathVariable(name ="content") String content) {
        log.trace("Find word by content");
        return new ResponseEntity<>(wordServices.findWordByContent(list, content), HttpStatus.OK);
    }

    @RequestMapping(value = "/word", method = RequestMethod.POST)
    public ResponseEntity<?> save(@Valid @RequestBody Word word) {
        log.trace("Saving word");
        return new ResponseEntity<>(wordServices.save(word), HttpStatus.OK);
    }
}
