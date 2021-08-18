package com.eneselibol.crudwtihthymeleaf.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "permits")
public class Permits {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long permit_id;

    @Column(name = "starting_date")
    private String starting_date;

    @Column(name = "end_date")
    private String end_date;

    @Column(name = "reason_permits")
    private String reasonPermits;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Integer status;



    public String getReasonPermits() {
        return reasonPermits;
    }

    public void setReasonPermits(String reasonPermits) {
        this.reasonPermits = reasonPermits;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getPermit_id() {
        return permit_id;
    }

    public void setPermit_id(long permit_id) {
        this.permit_id = permit_id;
    }

    public String getStarting_date() {
        return starting_date;
    }

    public void setStarting_date(String starting_date) {
        this.starting_date = starting_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
