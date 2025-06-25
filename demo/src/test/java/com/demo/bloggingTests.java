package com.demo;

import com.demo.entity.Comments_1;
import com.demo.entity.Post_1;
import com.demo.repository.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class bloggingTests {

	@Autowired
	private Post_1_Repository post1Repository;

	@Autowired
	private Comment_1_Repository comment1Repository;

	@Test
	void saveRecord(){
		Post_1 post1 = new Post_1();
		post1.setTitle("this is post");
		post1Repository.save(post1);
	}
	@Test
	void addCommentsToExistingPost(){
		Long postId = 1L;
		Post_1 post1 = post1Repository.findById(postId).get();

		Comments_1 comments1 = new Comments_1();
		comments1.setContent("this is comment for post id 1 ");

		post1.getComments_1().add(comments1);
		post1Repository.save(post1);

	}

	@Test
	void deletePost(){
		post1Repository.deleteById(1L);
	}

	@Transactional
	@Test
	void getPostAndItsComments(){
	Post_1 post1 = post1Repository.findById(1L).orElseThrow();
	List<Comments_1> comments1List = post1.getComments_1();
	for(Comments_1 result : comments1List){
		System.out.println(result.getId());
		System.out.println(result.getContent());
	}

	}

}

