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
public class AnotherBatch {

	private final JobBuilderFactory jobBuilderFactory;
	private final StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job anotherJob() {
		return jobBuilderFactory
				.get("anotherJob")
				.start(anotherStep())
				.build();
	}

	@Bean
	public Step anotherStep() {
		return stepBuilderFactory
				.get("anotherStep")
				.tasklet((contribution, chunkContext) -> {
					log.debug("anotherStep!! ");
					return RepeatStatus.FINISHED;
				}).build();
	}

}
