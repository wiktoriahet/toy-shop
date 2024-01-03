package pl.hetman.wiktoria.solvd.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ToyShop")
public class ToyShop {

    private List<Toy> toys;
    private List<Employee> employees;
    private List<EmployeeContact> employeesContacts;
    private List<OrderDate> ordersDates;
    private List<SupplierContact> suppliersContacts;

    public ToyShop() {
    }

    @XmlElementWrapper(name = "toys")
    @XmlElement(name = "toy")
    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @XmlElementWrapper(name = "employeesContacts")
    @XmlElement(name = "employeeContact")
    public List<EmployeeContact> getEmployeesContacts() {
        return employeesContacts;
    }

    public void setEmployeesContacts(List<EmployeeContact> employeesContacts) {
        this.employeesContacts = employeesContacts;
    }

    @XmlElementWrapper(name = "ordersDates")
    @XmlElement(name = "orderDate")
    public List<OrderDate> getOrdersDates() {
        return ordersDates;
    }

    public void setOrdersDates(List<OrderDate> ordersDates) {
        this.ordersDates = ordersDates;
    }

    @XmlElementWrapper(name = "suppliersContacts")
    @XmlElement(name = "supplierContact")
    public List<SupplierContact> getSuppliersContacts() {
        return suppliersContacts;
    }

    public void setSuppliersContacts(List<SupplierContact> suppliersContacts) {
        this.suppliersContacts = suppliersContacts;
    }

    @Override
    public String toString() {
        return "ToyShop{" +
                "toys=" + toys +
                ", employees=" + employees +
                ", employeeContacts=" + employeesContacts +
                ", orderDates=" + ordersDates +
                ", supplierContacts=" + suppliersContacts +
                '}';
    }
}
