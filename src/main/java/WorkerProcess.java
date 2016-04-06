import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class WorkerProcess {

  class HelloJob implements Job {
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
      System.out.println("Hello Quartz!");
    }
  }

  public static void main(String[] args) {
    JobDetail job = newJob(HelloJob.class)
            .withIdentity("job1", "group1")
            .build();

    Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
            .startNow()
            .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever())
            .build();
    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException e) {
      e.printStackTrace();
    }

  }
}
