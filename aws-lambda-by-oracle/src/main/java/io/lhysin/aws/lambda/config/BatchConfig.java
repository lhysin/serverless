package io.lhysin.aws.lambda.config;

import org.springframework.context.annotation.Configuration;


@Configuration
public class BatchConfig {

//    @Bean
//    public JobRepository getJobRepository(DataSource dataSource) throws Exception {
//        log.debug("getJobRepository");
//        JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
//        factory.setDataSource(dataSource);
//        factory.setTransactionManager(getTransactionManager());
//        factory.afterPropertiesSet();
//        return (JobRepository) factory.getObject();
//    }
//
//    private PlatformTransactionManager getTransactionManager() {
//        return new ResourcelessTransactionManager();
//    }
//
//    @Bean
//    public JobLauncher getJobLauncher(DataSource dataSource) throws Exception {
//        log.debug("getJobLauncher");
//        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
//        jobLauncher.setJobRepository(getJobRepository(dataSource));
//        jobLauncher.afterPropertiesSet();
//        return jobLauncher;
//    }
}