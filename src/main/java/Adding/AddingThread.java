package Adding;

import Editing.EditingThread;

import static Operating.Server.sharedMemory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class AddingThread extends Thread {

    private ArrayList<Generator> generatorCreating(int port) {
        Random random = new Random();
        ArrayList<Generator> generators = new ArrayList<Generator>();
        int i=random.nextInt(9)+1;
        for (; i > 0; i--) {
            generators.add(new Generator(port));
        }
        return generators;
    }

    @Override
    public void run() {
        try {
            run(8000, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void run(int port, int j) throws IOException {
        ArrayList<Generator> generators = generatorCreating(port);
        while (j-- > 0){
            Socket tmp=null; int i=0;
            while(tmp==null)
                tmp=generators.get(i++%generators.size()).generate();
            sharedMemory.peekFirst().add(tmp);
            EditingThread editingThread = new EditingThread();
            editingThread.run();
        }
    }


}
