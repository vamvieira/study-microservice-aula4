package com.github.acnaweb.study_microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.acnaweb.study_microservice.model.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
