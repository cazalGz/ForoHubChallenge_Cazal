package com.aluraCurso.ForoHubChallenge.controller;

import com.aluraCurso.ForoHubChallenge.domain.topic.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicController {
    @Autowired
    private ServiceTopic serviceTopic;
    @Autowired
    private TopicRepository topicRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Object> addTopic(@RequestBody @Valid DataTopic data, HttpServletRequest request, UriComponentsBuilder uriBuilder) {
        var response = serviceTopic.addTopic(data, request);
        var res = new ResponseTopic(response);
        URI url = uriBuilder.path("/topicos/{id}").buildAndExpand(response.getId()).toUri();
        return ResponseEntity.created(url).body(res);
    }

    @GetMapping
    public ResponseEntity<Page<ResponseTopic>> getTopics(@PageableDefault(sort = "creation", direction = Sort.Direction.ASC, size = 10) Pageable page) {
        return ResponseEntity.ok(topicRepository.findAll(page).map(ResponseTopic::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DetailTopical>> getTopic(@PathVariable Long id) {
        return ResponseEntity.ok(topicRepository.findId(id).map(DetailTopical::new));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DetailTopical> updateTopic(@PathVariable Long id, @Valid @RequestBody UpdateTopic data, HttpServletRequest request){
        var response = serviceTopic.update(id, data,request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id,HttpServletRequest request){
        serviceTopic.delete(id,request);
        return ResponseEntity.noContent().build();
    }
}
