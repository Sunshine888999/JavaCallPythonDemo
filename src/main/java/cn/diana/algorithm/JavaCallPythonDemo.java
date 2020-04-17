package cn.diana.algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JavaCallPythonDemo {

    public static void main(String[] args) {

        String[] arguments = new String[] {"/usr/bin/python3", "src/main/python/JavaCallPythonDemo.py"};
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8));
            String line = null;
            while ((line = bufferReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferReader.close();
            //process.waitFor()返回值为0表示我们调用python脚本成功，返回值为1表示调用python脚本失败
            int res = process.waitFor();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
