package pl.hetman.wiktoria.solvd.model;

public class ReviewRating {
    private Long id;
    private Long reviewId;
    private Long ratingId;

    public ReviewRating() {
    }

    public ReviewRating(Long id, Long reviewId, Long ratingId) {
        this.id = id;
        this.reviewId = reviewId;
        this.ratingId = ratingId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    @Override
    public String toString() {
        return "ReviewRating{" +
                "id=" + id +
                ", reviewId=" + reviewId +
                ", ratingId=" + ratingId +
                '}';
    }
}
