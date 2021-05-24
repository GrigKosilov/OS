package Adding;

import java.io.IOException;
import java.net.ServerSocket;

public class Socket extends ServerSocket{
    static int lastID=0;
    int generatorID;
    final int ID;
    public int time;
    public int priority;

    public Socket(int port, int generatorID, int time, int priority) throws IOException {
        super(port);
        this.generatorID=generatorID;
        this.ID=lastID++;
        this.time=Math.abs(time%30);
        this.priority=Math.abs(priority%10);
    }

    @Override
    public String toString() {
        return "Adding.Socket{" +
                "generatorID=" + generatorID +
                ", ID=" + ID +
                ", time=" + time +
                ", priority=" + priority +
                '}';
    }
}
