package com.revature.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="dhal_comments")
public class DhalComments {
	
	@Id
	@Column(name="comments_id")
	@SequenceGenerator(name="dhal_comments_trigger", sequenceName="dhal_comments_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_comments_trigger", strategy=GenerationType.SEQUENCE)
	private int commentsId;
	
	@Column(name="author_id", nullable=false)
	private int authorId;
	
	@Column(name="post_date", nullable=false)
	private String postDate;
	
	@Column(name="comment_s", nullable=false)
	private String commentS;
	
	@Column(name="rate_id", nullable=false)
	private int rateId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="comment_id")
	private DhalPlaylists commentId;
	

	public DhalComments() {}


	public DhalComments(int commentsId, int authorId, String postDate, String commentS, int rateId, DhalPlaylists commentId) {
		super();
		this.commentsId = commentsId;
		this.authorId = authorId;
		this.postDate = postDate;
		this.commentS = commentS;
		this.rateId = rateId;
		this.commentId = commentId;
	}


	public int getId() {
		return commentsId;
	}


	public void setId(int id) {
		this.commentsId = id;
	}


	public int getAuthorId() {
		return authorId;
	}


	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}


	public String getPostDate() {
		return postDate;
	}


	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}


	public String getCommentS() {
		return commentS;
	}


	public void setCommentS(String commentS) {
		this.commentS = commentS;
	}


	public int getRateId() {
		return rateId;
	}


	public void setRateId(int rateId) {
		this.rateId = rateId;
	}


	public DhalPlaylists getCommentId() {
		return commentId;
	}


	public void setCommentId(DhalPlaylists commentId) {
		this.commentId = commentId;
	}
	
	
	
	
	
}