package com.akrot.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book
{
    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String title;
    private int releaseYear;
    boolean isAvailable;
}
