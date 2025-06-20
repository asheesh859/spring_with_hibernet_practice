package com.demo.repository;

import com.demo.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CommentRepository extends JpaRepository<Comments, Integer> {

}

