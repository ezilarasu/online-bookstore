package com.ezil.onlinebookstore.repository;

import com.ezil.onlinebookstore.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RepositoryRestResource(collectionResourceRel = "bookCategory" , path="book-category")
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
