package pl.hetman.wiktoria.solvd.model;

public class Discount {
    private Long id;
    private Integer percentage;

    public Discount() {
    }

    public Discount(Long id, Integer percentage) {
        this.id = id;
        this.percentage = percentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", percentage=" + percentage +
                '}';
    }
}
