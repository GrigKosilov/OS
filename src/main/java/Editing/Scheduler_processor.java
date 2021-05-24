package Editing;

import Adding.Socket;
import java.util.Comparator;
import java.util.LinkedList;

import static Operating.Server.sharedMemory;

public class Scheduler_processor {
    public static void schedule(){
        sharedMemory.peekFirst().sort(Comparator.comparing(obj -> obj.priority));
    }
}