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
@Table(name="dhal_trending")
public class DhalTrending {
	
	@Id
	@Column(name="trend_id")
	@SequenceGenerator(name="dhal_trending_trigger", sequenceName="dhal_trending_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_trending_trigger", strategy=GenerationType.SEQUENCE)
	private int trendId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;
	
	public DhalTrending() {}
	
}
