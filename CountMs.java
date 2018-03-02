package com.hqt.laojianghu.config.route;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * Created by liuzhen on 2018/3/1.
 */
public class CountMs {
    public static void main(String[] args) {
        File file = new File("/Users/admin/Documents/a.log");
        try {
            List<String> list = FileUtils.readLines(file);
            int i=0;
            int a = 0;
            int b=0;
            for (String line : list) {
                int index = line.indexOf("ms");
                if (i % 2 == 0) {
                    b += Integer.valueOf(line.substring(index - 3, index - 1).trim());
                    System.out.println("b"+line.substring(index-3, index-1));
                } else {
                    a += Integer.valueOf(line.substring(index - 3, index - 1).trim());
                    System.out.println("a"+line.substring(index-3, index-1));
                }
                i++;

            }
            System.out.println(a + 400);
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
