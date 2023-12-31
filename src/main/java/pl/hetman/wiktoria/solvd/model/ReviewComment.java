package pl.hetman.wiktoria.solvd.model;

public class ReviewComment {
    private Long id;
    private Long reviewId;
    private String comment;

    public ReviewComment() {
    }

    public ReviewComment(Long id, Long reviewId, String comment) {
        this.id = id;
        this.reviewId = reviewId;
        this.comment = comment;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ReviewComment{" +
                "id=" + id +
                ", reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
