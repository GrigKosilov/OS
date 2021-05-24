package Getting;

import Adding.Socket;
import static Operating.Server.sharedMemory;

public class Handler_processor {
    public void handle() throws InterruptedException {
        while(sharedMemory.peekFirst().size()>0){
            Socket temp = sharedMemory.peekFirst().remove(0);
            //wait(temp.time);
            temp.time=0;
            sharedMemory.peekLast().add(temp);
        }
    }
}
