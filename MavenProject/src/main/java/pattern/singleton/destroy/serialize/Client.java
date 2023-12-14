package pattern.singleton.destroy.serialize;

import java.io.*;
// 测试序列化破坏单例模式
public class Client {
    public static void main(String[] args) throws Exception {
        // writeObect2File();
        readObjectFromFile(); // pattern.singleton.destroy.serialize.Singleton@1de0aca6
        readObjectFromFile(); // pattern.singleton.destroy.serialize.Singleton@255316f2
    }

    // 从文件读取数据（对象）
    public static void readObjectFromFile() throws Exception {
        //1, 创建对象输入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/jingwei/CS材料/Chuwa/hw/a.txt"));
        //2, 读取对象
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        //释放资源
        ois.close();
    }

    // 向文件中写数据（对象）
    public static void writeObect2File() throws Exception {
        //1, 获取Singleton对象
        Singleton instance = Singleton.getInstance();
        //2, 创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/jingwei/CS材料/Chuwa/hw/a.txt"));
        //3, 写对象
        oos.writeObject(instance);
        //4, 释放资源
        oos.close();
    }
}
