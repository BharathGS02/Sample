package com.kumuran.jsp;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.persistence.ManyToMany;

@Entity
@Table(name="book2")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)

	private Long bookId;
	private String bookName;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="author_book",joinColumns=@JoinColumn(name="book_id"),inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	@Column(name = "book_name")
	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}
}
