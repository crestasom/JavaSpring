package com.crestaSom.hibernatedemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String comment;
	
	public Review(){
		
	}

	
	
	public Review(String review) {
		super();
		this.comment = review;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReview() {
		return comment;
	}

	public void setReview(String review) {
		this.comment = review;
	}



	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + comment + "]";
	}

	
	
}
