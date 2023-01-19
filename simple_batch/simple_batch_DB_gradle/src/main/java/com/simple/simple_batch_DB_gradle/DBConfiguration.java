package com.simple.simple_batch_DB_gradle;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DBConfiguration {

    private final DataSource dataSource;
    private static final Logger log = LoggerFactory.getLogger(DBConfiguration.class);

    @Bean
    public JdbcCursorItemReader<Bill> reader(){
        return new JdbcCursorItemReaderBuilder<Bill>()
                .name("reader")
                .fetchSize(10)
                .dataSource(dataSource)
                .rowMapper(new BeanPropertyRowMapper<>(Bill.class))
                .sql("SELECT aptcd, dongho, billym, saledt, amount FROM test")
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Bill> writer(){
        return new JdbcBatchItemWriterBuilder<Bill>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql("UPDATE test SET amount = '1000' WHERE aptcd = :aptcd and dongho = :dongho and billym = :billym")
                .dataSource(dataSource)
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, Step step1){
        return new JobBuilder("job",jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager){
        return new StepBuilder("step",jobRepository)
                .<Bill, Bill>chunk(10, transactionManager)
                .reader(reader())
                .writer(writer())
                .build();
    }
}
