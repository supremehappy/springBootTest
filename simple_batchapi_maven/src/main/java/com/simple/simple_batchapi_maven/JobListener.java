package com.simple.simple_batchapi_maven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport{
    
    private static final Logger log = LoggerFactory.getLogger(JobListener.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JobListener(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public void afterJob(JobExecution jobExecution){
        if(jobExecution.getStatus() == BatchStatus.COMPLETED){
            log.info("!!! end !!!");

            jdbcTemplate.query("SELECT id, email, name FROM user", 
                (rs, row) -> new User(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3))
            ).forEach(user -> log.info("found = " + user ));
        }

        log.info("test ------------------------------------ afterJob()");
    }
}
