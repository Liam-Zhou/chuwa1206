package pattern.singleton.demo9;

import java.io.IOException;
import java.io.InputStream;

public class RuntimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();

        Process process = runtime.exec("ipconfig");

        InputStream is = process.getInputStream();

        byte[] arr = new byte[1024*1024*100];
        int len = is.read(arr);
        System.out.println(new String(arr,0,len,"GBK"));
    }
}
