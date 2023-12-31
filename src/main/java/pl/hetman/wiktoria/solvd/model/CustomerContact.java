package pl.hetman.wiktoria.solvd.model;

import java.util.List;

public class CustomerContact {
    private Long id;
    private Long customerId;
    private List<Email> emails;
    private List<Phone> phones;

    public CustomerContact() {
    }

    public CustomerContact(Long id, Long customerId, List<Email> emails, List<Phone> phones) {
        this.id = id;
        this.customerId = customerId;
        this.emails = emails;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "CustomerContact{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", emails=" + emails +
                ", phones=" + phones +
                '}';
    }
}
