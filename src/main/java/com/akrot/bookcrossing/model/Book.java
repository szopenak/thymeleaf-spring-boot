package com.akrot.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book
{
    @Id
    @GeneratedValue
    private long id;
    private String author;
    private String title;
    private int releaseYear;
    boolean available;
    @Column(precision=18, scale=8)
    BigDecimal longitude;
    @Column(precision=18, scale=8)
    BigDecimal latitude;
}
