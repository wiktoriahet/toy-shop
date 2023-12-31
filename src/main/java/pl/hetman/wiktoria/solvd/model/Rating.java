package pl.hetman.wiktoria.solvd.model;

public class Rating {
    private Long id;
    private String rating;

    public Rating() {
    }

    public Rating(Long id, String rating) {
        this.id = id;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", rating='" + rating + '\'' +
                '}';
    }
}
