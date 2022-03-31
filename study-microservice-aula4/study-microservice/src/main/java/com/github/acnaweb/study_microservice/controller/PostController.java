package com.github.acnaweb.study_microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.acnaweb.study_microservice.model.Post;
import com.github.acnaweb.study_microservice.repository.PostRepository;

@RestController
@RequestMapping("posts")
public class PostController {

//	private PostRepositoryOld postRepository = new PostRepositoryOld(); // criar Repository

	@Autowired
	private PostRepository postRepository; // criar Repository

	// Retrieve
	@GetMapping
	public List<Post> listarPosts() {
		return postRepository.findAll();
	}

	// Retrieve
	@GetMapping("{id}")
	public Post pesquisarPorId(@PathVariable Long id) {
		return postRepository.getById(id);
	}

	// Delete
	@DeleteMapping("{id}")
	public void apagarPost(@PathVariable Long id) {
		postRepository.deleteById(id);
	}

	// Create
	@PostMapping
	public Long criarPost(@RequestBody Post post) {
		Post postSalvo = postRepository.save(post);
		return postSalvo.getId();
	}

	// Update
	@PutMapping
	public Post atualizarPost(@RequestBody Post post) {
		return postRepository.save(post);
	}

}
