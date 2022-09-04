package com.ronbay;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器
 */
public class MyClassLoaderTest {

    static class MyClassLoader extends ClassLoader{
        private String classPath;

        public MyClassLoader(String classPath){
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws IOException {
            name =  name.replaceAll("\\.", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len =fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();;
            return data;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                byte[] data = loadByte(name);
                //defineClass将一个字节数组转为Class对象，这个字节数组是class文件读取后最终的字节 数组。
                return defineClass(name,data,0, data.length);
            } catch (IOException e) {
                e.printStackTrace();
                throw new ClassNotFoundException();
            }
        }

        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)){
                Class<?> c = findLoadedClass(name);
                if (c == null){
                    long t1 = System.nanoTime();
                    c = findClass(name);
//                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
//                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
//            return super.loadClass(name, resolve);
        }

        /**
         * 重写类加载方法，实现自己的加载逻辑，不委派给双亲加载
         */

        public static void main(String[] args) throws Exception {

            //初始化自定义类加载器，会先初始化父类ClassLoader，其中会把自定义类加载器的父加载器设置为应用程序类加载器AppClassLoader
            MyClassLoader classLoader = new MyClassLoader("/Users/zhangyunpeng/workspace/interview");
            Class clazz = classLoader.loadClass("java.lang.String");
            Object obj = clazz.newInstance();
            Method method = clazz.getDeclaredMethod("sout", Class.forName("java.lang.String"));
            method.invoke(obj,"张三");
            System.out.println(clazz.getClassLoader().getClass().getName());
        }
    }
}
