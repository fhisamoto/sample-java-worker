import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {

  public HelloJob() {
    // Instances of Job must have a public no-argument constructor.
  }

  public void execute(JobExecutionContext context) throws JobExecutionException {
    Config conf = ConfigFactory.load();
    System.out.println("Hello Quartz!" + conf.getString("lala"));
  }
}
