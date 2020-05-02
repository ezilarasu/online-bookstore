package com.ezil.onlinebookstore.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ezil.onlinebookstore.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}