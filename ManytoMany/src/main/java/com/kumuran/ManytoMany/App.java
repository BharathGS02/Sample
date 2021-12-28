package com.kumuran.ManytoMany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.kumuran.jsp.Author;
import com.kumuran.jsp.Book;

public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class).addAnnotatedClass(Author.class);
		SessionFactory factory = con.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Set<Author> javaAuthor = new HashSet<Author>();//jeeva
		Set<Author> java2ndAuthors = new HashSet<Author>();//jeeva and sasi
		Set<Author> pythonAuthor = new HashSet<Author>();//sasi

		Author author = new Author();
		author.setAuthorName("bharath");
		javaAuthor.add(author);

		Author author2 = new Author();
		author2.setAuthorName("vikash");
       //many authors
		java2ndAuthors.add(author);
		java2ndAuthors.add(author2);
		pythonAuthor.add(author2);
       //many books
		Book book = new Book();
		book.setBookName("How to Program with Java");

		Book book2 = new Book();
		book2.setBookName("How to Program with Java 2nd Edition");

		Book book3 = new Book();
		book3.setBookName("How to program with Python");

		book.setAuthors(javaAuthor);//jeeva
		book2.setAuthors(java2ndAuthors);//jeeva and sasi
		book3.setAuthors(pythonAuthor);//sasi 
            //persitence on child side
		session.save(book);
		session.save(book2);
		session.save(book3);
		tx.commit();
		session.close();
		factory.close();
    }
}
