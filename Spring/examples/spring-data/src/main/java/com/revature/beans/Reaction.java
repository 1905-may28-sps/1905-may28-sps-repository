package com.revature.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BLOG_REACTION")
public class Reaction  {

	@EmbeddedId
	private ReactionComposite composite;
	
	@ManyToOne
	private ReactionType type;
	
	public Reaction() {}

	public ReactionComposite getComposite() {
		return composite;
	}

	public void setComposite(ReactionComposite composite) {
		this.composite = composite;
	}

	public ReactionType getType() {
		return type;
	}

	public void setType(ReactionType type) {
		this.type = type;
	}

	public Reaction(ReactionComposite composite, ReactionType type) {
		super();
		this.composite = composite;
		this.type = type;
	}
	
	
	
	
}
