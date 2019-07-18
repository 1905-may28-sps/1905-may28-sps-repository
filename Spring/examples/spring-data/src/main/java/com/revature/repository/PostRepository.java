package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.beans.Post;

@Transactional
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
