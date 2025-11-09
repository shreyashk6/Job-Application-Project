package com.embarkx.firstjobapp.job;


import com.embarkx.firstjobapp.company.Company;
import jakarta.persistence.*;

@Entity     //mapping the below class to DB
//@Table(name = "job_table")  //  telling DB that I need a table named job_table (OPTIONAL),
                                // instead of giving default class name to the table.
public class Job {
    @Id         //declares below line as Primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    private Company company;

    public Job() {//Whenever working with JPA we need to have a default Constructor!

    }

    public Job(Long id, String title, String minSalary, String description, String location, String maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.description = description;
        this.location = location;
        this.maxSalary = maxSalary;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
