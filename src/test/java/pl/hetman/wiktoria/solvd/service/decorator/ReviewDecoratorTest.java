package pl.hetman.wiktoria.solvd.service.decorator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewDecoratorTest {

    @Test
    void validateReviewDecorator(){
        //given
        ReviewContent reviewContent = new ReviewContent(
                new ReviewDecoratorImpl()
        );

        //when
        String s = reviewContent.writeReview("Title", "Subtitle", "Description");

        //then
        Assertions.assertEquals("Title\nSubtitle\nDescription\n", s);


    }

}