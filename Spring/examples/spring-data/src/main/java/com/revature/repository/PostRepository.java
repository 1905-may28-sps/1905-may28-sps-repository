package com.revature.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Post;

@Transactional
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	
	List<Post> findBySubjectContainingIgnoreCaseOrBodyContainingIgnoreCase(String keyword1, String keyword2);

}
