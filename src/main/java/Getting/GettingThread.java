package Getting;

public class GettingThread extends Thread {
    @Override
    public void run() {
        Handler_processor handler_processor = new Handler_processor();
        try {
            handler_processor.handle();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
