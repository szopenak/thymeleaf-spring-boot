package com.akrot.bookcrossing.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    @NotNull
    @Size(min=2, max=50)
    private String author;
    @NotNull
    @Size(min=2, max=50)
    private String title;
    @NotNull
    @Min(-2000)
    @Max(2018)
    @NumberFormat
    private int releaseYear;
    @NotNull
    @DecimalMin("-180")
    @DecimalMax("180")
    BigDecimal longitude;
    @NotNull
    @DecimalMin("-90")
    @DecimalMax("90")
    BigDecimal latitude;
}
