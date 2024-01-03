package pl.hetman.wiktoria.solvd.model;

import java.util.List;

public class ToyShop {
    private List<Toy> toys;
    private List<Employee> employees;
    private List<EmployeeContact> employeeContacts;
    private List<OrderDate> orderDates;
    private List<SupplierContact> supplierContacts;

    public ToyShop() {
    }

    public List<Toy> getToys() {
        return toys;
    }

    public void setToys(List<Toy> toys) {
        this.toys = toys;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<EmployeeContact> getEmployeeContacts() {
        return employeeContacts;
    }

    public void setEmployeeContacts(List<EmployeeContact> employeeContacts) {
        this.employeeContacts = employeeContacts;
    }

    public List<OrderDate> getOrderDates() {
        return orderDates;
    }

    public void setOrderDates(List<OrderDate> orderDates) {
        this.orderDates = orderDates;
    }

    public List<SupplierContact> getSupplierContacts() {
        return supplierContacts;
    }

    public void setSupplierContacts(List<SupplierContact> supplierContacts) {
        this.supplierContacts = supplierContacts;
    }

    @Override
    public String toString() {
        return "ToyShop{" +
                "toys=" + toys +
                ", employees=" + employees +
                ", employeeContacts=" + employeeContacts +
                ", orderDates=" + orderDates +
                ", supplierContacts=" + supplierContacts +
                '}';
    }
}
