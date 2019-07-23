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
@Table(name="dhal_playlists")
public class DhalPlaylists {
	
	@Id
	@Column(name="playlist_id")
	@SequenceGenerator(name="dhal_playlist_trigger", sequenceName="dhal_playlists_seq", allocationSize=1)
	@GeneratedValue(generator="dhal_playlist_trigger", strategy=GenerationType.SEQUENCE)
	private int playlistId;
	
	@Column(name="track_id", nullable=false)
	private int trackId;
	
	@Column(name="comment_id", nullable=false)
	private int commentId;
	

	public DhalPlaylists() {}


	public DhalPlaylists(int playlistId, int trackId, int commentId) {
		super();
		this.playlistId = playlistId;
		this.trackId = trackId;
		this.commentId = commentId;
	}


	public int getTradckIid() {
		return trackId;
	}


	public void setTradckIid(int playlistId) {
		this.playlistId = playlistId;
	}


	public double getTrackId() {
		return trackId;
	}


	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}


	public double getCommentId() {
		return commentId;
	}


	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	
	
	

	
}