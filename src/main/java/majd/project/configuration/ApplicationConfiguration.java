package majd.project.configuration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import majd.project.classes.car.Car;
import majd.project.classes.car.CarItemProcessor;


@Configuration
@EnableBatchProcessing
public class ApplicationConfiguration {
	
	
	/*
	 * Job
	 * */
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	/*
	 * datasource
	 * */
	@Autowired
	public DataSource dataSource;
	
	// Entity manager configuration for transactional annotation
	@Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean emf() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
       
        
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(new String[] {"majd.project"});
        emf.setJpaVendorAdapter(
        new HibernateJpaVendorAdapter());
        emf.setJpaProperties(additionalProperties());
        return emf;
   }
    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
        properties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
        properties.setProperty("hibernate.show_sql", "true");
         
        return properties;
    }
	
	
	@Bean
	public JdbcCursorItemReader<Car> reader() {
		JdbcCursorItemReader<Car> reader = new JdbcCursorItemReader<Car>();
		reader.setDataSource(dataSource);
		reader.setSql("SELECT id, type FROM Car");
		reader.setRowMapper(new CarRowMapper());
		
		return reader;
	}
	
	public class CarRowMapper implements RowMapper<Car>{

		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			Car car = new Car();
			car.setId(rs.getInt("id"));
			car.setType(rs.getString("type"));
			return car;
		}

	} 
	
	@Bean
	 public CarItemProcessor processor(){
	  return new CarItemProcessor();
	 }
	
	@Bean
	 public FlatFileItemWriter<Car> writer(){
	  FlatFileItemWriter<Car> writer = new FlatFileItemWriter<Car>();
	  writer.setResource(new ClassPathResource("cars.csv"));
	  writer.setLineAggregator(new DelimitedLineAggregator<Car>() {{
	   setDelimiter(",");
	   setFieldExtractor(new BeanWrapperFieldExtractor<Car>() {{
	    setNames(new String[] { "id", "type" });
	   }});
	  }});
	  
	  return writer;
	 }
	 
	 
	 
	 @Bean
	 public Step step1() {
	  return stepBuilderFactory.get("step1").<Car, Car> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer())
	    .build();
	 }
	 
	 @Bean
	 public Job exportCarJob() {
	  return jobBuilderFactory.get("exportCarJob")
	    .incrementer(new RunIdIncrementer())
	    .flow(step1())
	    .end()
	    .build();
	 }
	 
	 @Bean
	    public TaskScheduler taskScheduler() {
	        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
	        threadPoolTaskScheduler.setPoolSize(5);
	        threadPoolTaskScheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
	        return threadPoolTaskScheduler;
	    }
}
	

