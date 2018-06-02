package com.akrot.bookcrossing.repository;

import com.akrot.bookcrossing.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>
{
    @Query("SELECT book FROM Book book WHERE book.available = true")
    List<Book> getAllFree();

    List<Book> getByAuthorAndAvailable(String author, boolean available);
    List<Book> getByTitleAndAvailable(String title, boolean available);
}
