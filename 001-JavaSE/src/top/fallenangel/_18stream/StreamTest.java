package top.fallenangel._18stream;

import java.io.*;
import java.util.Date;

public class StreamTest {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) {
        long startTime = new Date().getTime();

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream("F:/class文件研究.emmx")); BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("F:/class文件研究_copy.emmx"))) {
            int len;
            byte[] data = new byte[1024 * 2];
            while ((len = bis.read(data)) != -1) {
                bos.write(data, 0, len);
            }
            bos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long passTime = new Date().getTime() - startTime;
        System.out.println(passTime / 1000 + " " + passTime % 1000);
    }
}