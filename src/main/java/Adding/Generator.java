package Adding;

import Adding.Socket;

import java.io.IOException;
import java.util.Random;

public class Generator {
    static int lastID=0;
    final int ID;
    int port;

    Generator(int port){
        this.ID=lastID++;
    }
    public Socket generate() throws IOException {
        Random random = new Random();

        if (random.nextInt(100) < 25)
            return new Socket(port, ID, random.nextInt(), random.nextInt());
        else
            return null;
    }

}

//ServerSocket