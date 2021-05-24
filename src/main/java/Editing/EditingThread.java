package Editing;

public class EditingThread extends Thread{
    @Override
    public void run() {
        Scheduler_processor.schedule();
    }
}
