package com.example.entity;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Entity for departments.
 */
public class Employee {
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Integer yearsWorking;
    private String email;
    private Department department;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getYearsWorking() {
        return yearsWorking;
    }

    public void setYearsWorking(Integer yearsWorking) {
        this.yearsWorking = yearsWorking;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Employee employee = (Employee) object;
        return Objects.equals(id, employee.id)
                && Objects.equals(name, employee.name)
                && Objects.equals(birthDate, employee.birthDate)
                && Objects.equals(yearsWorking, employee.yearsWorking)
                && Objects.equals(email, employee.email)
                && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthDate, yearsWorking, email, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", yearsWorking=" + yearsWorking +
                ", email='" + email + '\'' +
                ", department=" + department +
                '}';
    }
}
