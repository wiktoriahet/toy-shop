package pl.hetman.wiktoria.solvd.model;

import java.util.List;

public class SupplierContactEmail {

    private Long id;
    private Long supplierId;
    private List<Email> emails;

    public SupplierContactEmail() {
    }

    public SupplierContactEmail(Long id, Long supplierId, List<Email> emails) {
        this.id = id;
        this.supplierId = supplierId;
        this.emails = emails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @Override
    public String toString() {
        return "SupplierContactEmail{" +
                "id=" + id +
                ", supplierId=" + supplierId +
                ", emails=" + emails +
                '}';
    }
}
