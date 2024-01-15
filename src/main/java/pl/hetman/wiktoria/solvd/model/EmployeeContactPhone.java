package pl.hetman.wiktoria.solvd.model;

import java.util.List;

public class EmployeeContactPhone {

    private Long id;
    private Long employeeId;
    private List<Phone> phones;

    public EmployeeContactPhone() {
    }

    public EmployeeContactPhone(Long id, Long employeeId, List<Phone> phones) {
        this.id = id;
        this.employeeId = employeeId;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "EmployeeContactPhone{" +
                "id=" + id +
                ", employeeId=" + employeeId +
                ", phones=" + phones +
                '}';
    }
}
