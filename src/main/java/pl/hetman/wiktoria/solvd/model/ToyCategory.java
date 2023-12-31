package pl.hetman.wiktoria.solvd.model;

public class ToyCategory {
    private Long id;
    private Long toyId;
    private Long categoryId;

    public ToyCategory() {
    }

    public ToyCategory(Long id, Long toyId, Long categoryId) {
        this.id = id;
        this.toyId = toyId;
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getToyId() {
        return toyId;
    }

    public void setToyId(Long toyId) {
        this.toyId = toyId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ToyCategory{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", categoryId=" + categoryId +
                '}';
    }
}
