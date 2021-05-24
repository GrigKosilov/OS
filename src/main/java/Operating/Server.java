package Operating;

import Adding.AddingThread;
import Adding.Socket;
import Editing.EditingThread;
import Getting.GettingThread;
import Getting.Handler_processor;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.*;

public class Server {
    public static LinkedBlockingDeque<ArrayList<Socket>> sharedMemory = new LinkedBlockingDeque<ArrayList<Socket>>();

    public static void main(String[] args) throws IOException, InterruptedException {
        sharedMemory.add(new ArrayList<Socket>());
        sharedMemory.add(new ArrayList<Socket>());

        AddingThread addingThread = new AddingThread();
        GettingThread gettingThread = new GettingThread();
        addingThread.run(8000, 15);
        gettingThread.run();
    }

}
