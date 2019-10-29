package test.rsupport.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="board")
public class Board {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer no;
	
	@Column(length = 30)
	private String username;
	
	@Column(length = 400)
	private String title;
	
	@Column(columnDefinition = "TEXT")
	private String post;
	
	@Column
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column
	@UpdateTimestamp
	private LocalDateTime modifiedAt;
	
}
