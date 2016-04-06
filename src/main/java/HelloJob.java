import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

class HelloJob implements Job {

  public HelloJob() {
    // Instances of Job must have a public no-argument constructor.
  }

  public void execute(JobExecutionContext context) throws JobExecutionException {
    System.out.println("Hello Quartz!");
  }
}
