package majd.project.classes.car;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarTask implements Runnable {
	
	@Autowired
	JobLauncher jobLauncher;
 
	@Autowired
	Job job;
	
    @Override
    public void run() {
    	String timeStamp = new SimpleDateFormat("yyyy.MM.dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		try {
			System.out.println("Starting the job at " + timeStamp + " ...");
			JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			jobLauncher.run(job, jobParameters);
			
		} catch (Exception e) {
			System.out.println("Job failed ...");
		}
		System.out.println("Finishing the job at " + timeStamp + " ...");
    }
}

