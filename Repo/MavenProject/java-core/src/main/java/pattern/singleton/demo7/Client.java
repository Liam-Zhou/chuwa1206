package pattern.singleton.demo7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {
    public static void main(String[] args) throws Exception{
        //wirteObject2File();
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile()throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\ChuwaAssignment\\chuwa1206\\Repo\\MavenProject\\a.txt"));
        Singleton instance = (Singleton) ois.readObject();
        System.out.println(instance);

        ois.close();
    }

    public  static void wirteObject2File()throws Exception{
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\ChuwaAssignment\\chuwa1206\\Repo\\MavenProject\\a.txt"));
        oos.writeObject(instance) ;
        oos.close();
    }
}
