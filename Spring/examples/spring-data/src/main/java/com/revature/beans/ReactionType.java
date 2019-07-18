package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BLOG_REACTION_TYPE")
public class ReactionType {
	
	@Id
	@Column(name="BRT_ID")
	@SequenceGenerator(name="BRT_GEN", sequenceName="BRT_SEQ", allocationSize=1)
	@GeneratedValue(generator="BRT_GEN", strategy=GenerationType.SEQUENCE)
	private int id;
	private String imageUrl;
	
	public ReactionType() {}

	public ReactionType( String imageUrl) {
		super();
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
}
