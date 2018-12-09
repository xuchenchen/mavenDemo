package com.ryx.pojo;

import java.io.IOException;
import java.io.InputStream;

public class InvokeBat4 {

    public void runbat(String batName) {
        String cmd = "cmd /k start D:\\soft\\gssoft\\java\\webtomcat\\webapps\\pkg\\Android\\ruishuarun.bat";// pass
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            InputStream in = ps.getInputStream();
            int c;
            while ((c = in.read()) != -1) {
                System.out.print(c);// 如果你不需要看输出，这行可以注销掉
            }
            in.close();
            ps.waitFor();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("child thread donn");
}}
