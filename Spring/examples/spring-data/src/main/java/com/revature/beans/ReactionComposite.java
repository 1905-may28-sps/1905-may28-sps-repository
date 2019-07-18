package com.revature.beans;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ReactionComposite implements Serializable{
	private int userId;
	private int postId;
	
	public ReactionComposite() {}

	public ReactionComposite(int userId, int postId) {
		super();
		this.userId = userId;
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	
}
