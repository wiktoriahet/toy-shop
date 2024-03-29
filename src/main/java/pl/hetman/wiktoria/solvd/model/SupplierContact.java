package pl.hetman.wiktoria.solvd.model;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;

import java.util.List;

public class SupplierContact {

    private Long id;
    private Long supplierId;
    private List<Email> emails;
    private List<Phone> phones;

    public SupplierContact() {
    }

    public SupplierContact(Long id, Long supplierId, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.supplierId = supplierId;
        this.emails = emails;
        this.phones = phones;
    }

    @XmlAttribute(name = "id")
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

    @XmlElementWrapper(name = "emails")
    @XmlElement(name = "email")
    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    @XmlElementWrapper(name = "phones")
    @XmlElement(name = "phone")
    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "SupplierContact{" +
                "id=" + id +
                ", supplierId=" + supplierId +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
