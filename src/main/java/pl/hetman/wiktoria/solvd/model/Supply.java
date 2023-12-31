package pl.hetman.wiktoria.solvd.model;

public class Supply {
    private Long id;
    private Long toyId;
    private Long supplierId;

    public Supply() {
    }

    public Supply(Long id, Long toyId, Long supplierId) {
        this.id = id;
        this.toyId = toyId;
        this.supplierId = supplierId;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", toyId=" + toyId +
                ", supplierId=" + supplierId +
                '}';
    }
}
