package io.lhysin.aws.lambda.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@EnableBatchProcessing
@RequiredArgsConstructor
public class OracleHealthCheckBatch {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job oracleHealthCheckJob() {
		return jobBuilderFactory
				.get("oracleHealthCheckJob")
				.start(oracleHealthCheckStep())
				.build();
	}

	@Bean
	public Step oracleHealthCheckStep() {
		return stepBuilderFactory
				.get("oracleHealthCheckStep")
				.tasklet((contribution, chunkContext) -> {
					log.debug("oracleHealthCheckStep!! ");
					return RepeatStatus.FINISHED;
				}).build();
	}

}
