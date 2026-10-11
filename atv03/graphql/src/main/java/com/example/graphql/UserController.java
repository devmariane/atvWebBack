package com.example.graphql;

import java.util.ArrayList;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @QueryMapping
    public User me() {
        return new User("John Doe");
    }

    @QueryMapping
    public Hero hero() {
        return new Hero(1L, "Superman");
    }

    List<Review> reviews = new ArrayList<>();

    @MutationMapping
    public Review createReview(@Argument ReviewInput review) {
        Review new_review = new Review(1L, review.getStars(), review.getCommentary());
        reviews.add(new_review);
        return new_review;
    }

    @QueryMapping
    public Review review(@Argument Long id) {
        return reviews.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
    }
}
