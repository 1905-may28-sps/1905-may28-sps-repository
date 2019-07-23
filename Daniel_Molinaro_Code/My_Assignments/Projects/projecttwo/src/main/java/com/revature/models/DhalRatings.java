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
@Table(name="dhal_ratings")
public class DhalRatings {
	
	@Id
	@Column(name="rate_id")
//	@SequenceGenerator(name="dhal_users_trigger", sequenceName="dhal_users_seq", allocationSize=1)
//	@GeneratedValue(generator="dhal_users_trigger", strategy=GenerationType.SEQUENCE)
	private int rateId;
	
	@Column(name="rating", nullable=false)
	private double rating;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="rate_id")
	private DhalComments commentRateId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="rate_id")
	private DhalTrackRatings trackRateId;
	
	public DhalRatings() {}
	
	public DhalRatings(int rateId, double rating, DhalComments commentRateId, DhalTrackRatings trackRateId) {
	super();
	this.rateId = rateId;
	this.rating = rating;
	this.commentRateId = commentRateId;
	this.trackRateId = trackRateId;
}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public DhalComments getCommentRateId() {
		return commentRateId;
	}

	public void setCommentRateId(DhalComments commentRateId) {
		this.commentRateId = commentRateId;
	}

	public DhalTrackRatings getTrackRateId() {
		return trackRateId;
	}

	public void setTrackRateId(DhalTrackRatings trackRateId) {
		this.trackRateId = trackRateId;
	}
	
}