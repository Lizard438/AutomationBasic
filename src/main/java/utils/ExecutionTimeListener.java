package utils;

import org.testng.IExecutionListener;

import java.time.Duration;
import java.time.Instant;

public class ExecutionTimeListener implements IExecutionListener {

    private Instant start;
    private Instant finish;

    @Override
    public void onExecutionStart() {
        start = Instant.now();
    }

    @Override
    public void onExecutionFinish(){
        finish = Instant.now();
        System.out.println(Duration.between(start,finish));
    }
}
