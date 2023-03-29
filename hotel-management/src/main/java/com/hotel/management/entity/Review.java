package com.hotel.management.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    private String reviewId;
    private String userId;
    private String hotelId;
    private int rating;
    private String comment;

}
