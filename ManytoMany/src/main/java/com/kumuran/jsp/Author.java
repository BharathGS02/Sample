package com.kumuran.jsp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author2")
	public class Author
	{
	 
	  private Long authorId;
	  @Column(name="author_name")
	  private String authorName;

	  @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  public Long getAuthorId()
		{
			return authorId;
		}
		public void setAuthorId(Long authorId)
		{
			this.authorId = authorId;
		}

		
		public String getAuthorName()
		{
			return authorName;
		}
		public void setAuthorName(String authorName)
		{
			this.authorName = authorName;
		}
	}
