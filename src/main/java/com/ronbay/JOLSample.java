package com.ronbay;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName: JOLSample
 * @Description:
 * @Author
 * @Date 2022/5/7
 * @Version 1.0
 */
public class JOLSample {
    public static void main(String[] args) {
         ClassLayout layout = ClassLayout.parseInstance(new Object());
         System.out.println(layout.toPrintable());

         System.out.println();
         ClassLayout layout1 = ClassLayout.parseInstance(new int[]{});
         System.out.println(layout1.toPrintable());

         System.out.println();
         ClassLayout layout2 = ClassLayout.parseInstance(new A());
         System.out.println(layout2.toPrintable());
         }
         public static class A{

         }
}


