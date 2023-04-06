package com.jh.board.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Comment")
@Table(name = "Comment")
public class CommentEntity {
	@Id
	private int boardNumber;
	private String userEmail;
	private String likeUserProfile;
	private String likeUserNickname;
	

}
