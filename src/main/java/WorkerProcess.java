import jobs.HelloJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class WorkerProcess {

  public static void main(String[] args) {
    JobDetail job = newJob(HelloJob.class).build();

    Trigger trigger = newTrigger().withIdentity("trigger1", "group1")
            .startNow()
            .withSchedule(simpleSchedule().withIntervalInSeconds(5).repeatForever())
            .build();
    try {
      Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
      scheduler.start();
      scheduler.scheduleJob(job, trigger);
    } catch (SchedulerException e) {
      e.printStackTrace();
    }

  }
}
