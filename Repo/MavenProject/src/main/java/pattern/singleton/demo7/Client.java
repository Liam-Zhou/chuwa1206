package pattern.singleton.demo7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

    public static void main(String[] args) throws Exception {
        writeObjectToFile();
        readObjectFromFile();
        readObjectFromFile();
    }

    // Read
    public static void readObjectFromFile() throws Exception{
        // 1. Create ObjectInputStream
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("./a.txt"));
        // 2. Read object
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);
        // 3. Release
        ois.close();
    }

    // Write
    public static void writeObjectToFile() throws Exception{
        // 1. get Singleton
        Singleton instance = Singleton.getInstance();
        // 2. Create ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("./a.txt"));
        // 3. write object
        oos.writeObject(instance);
        // 4. release
        oos.close();
    }
}
