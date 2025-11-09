package com.embarkx.firstjobapp.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {  //can also extend with CrudRepository instead of JPA

}
