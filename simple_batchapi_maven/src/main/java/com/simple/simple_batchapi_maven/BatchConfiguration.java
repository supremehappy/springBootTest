package com.simple.simple_batchapi_maven;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class BatchConfiguration {
    
    private static final Logger log = LoggerFactory.getLogger(BatchConfiguration.class);

    @Bean
    public JdbcCursorItemReader<User> reader(DataSource dataSource){
        log.info("test--------------------------------reader()");
        return new JdbcCursorItemReaderBuilder<User>()
                .fetchSize(10)
                .sql("SELECT id, email, name FROM user")
                .rowMapper(new BeanPropertyRowMapper<>(User.class))
                .name("itemReader")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public ItemWriter<User> writer(){
        log.info("test--------------------------------writer()");
        return list -> {
            for(User t : list){
                log.info("t = {}", t);
            }
        };
    }

    @Bean
    public Job testJob(JobRepository jobRepository, Step step,
                    JobListener listener){
            log.info("test--------------------------------testJob()");
        return new JobBuilder("testJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository,
                        PlatformTransactionManager transactionManager,
                        DataSource dataSource){
        log.info("test--------------------------------step1()");
        return new StepBuilder("step1", jobRepository)
                .<User, User> chunk(10, transactionManager)
                .reader(reader(dataSource))
                .writer(writer())
                .build();
    }

}
