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
@Table(name="dhal_track_ratings")
public class DhalTrackRatings {
	
	@Id
	@Column(name="track_id")
	@SequenceGenerator(name="dhal_track_ratings_trigger", sequenceName="dhal_track_ratings_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_track_ratings_trigger", strategy=GenerationType.SEQUENCE)
	private int trackId;
	
	@Column(name="rate_id", nullable=false)
	private int rateId;
	
	@Column(name="rater_id", nullable=false)
	private int raterId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="track_id")
	private DhalTrending type;

	public DhalTrackRatings() {}

	public DhalTrackRatings(int trackId, int rateId, int raterId, DhalTrending type) {
		super();
		this.trackId = trackId;
		this.rateId = rateId;
		this.raterId = raterId;
		this.type = type;
	}

	public int getTradckIid() {
		return trackId;
	}

	public void setTradckIid(int trackId) {
		this.trackId = trackId;
	}

	public double getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public double getRaterId() {
		return raterId;
	}

	public void setRaterId(int raterId) {
		this.raterId = raterId;
	}

	public DhalTrending getType() {
		return type;
	}

	public void setType(DhalTrending type) {
		this.type = type;
	}
	
	
	

	
}