package 并发;

import io.netty.channel.Channel;
import sun.misc.Unsafe;

/**
 * @Description:
 * @Author
 * @Date 2024/2/28
 * @Version 1.0
 */
public class CasTest {
    public static void main(String[] args) {
        Entity entity = new Entity();
        Unsafe unsafe = UnsafeFactory.getUnsafe();
        long offset = UnsafeFactory.getFieldOffset(unsafe, Entity.class,"x");
        boolean successful ;
        successful = unsafe.compareAndSwapInt(entity,offset,0,3);
        System.out.println(successful + "\t" + entity.x);

        successful = unsafe.compareAndSwapInt(entity,offset,3,5);
        System.out.println(successful + "\t" + entity.x);

        successful = unsafe.compareAndSwapInt(entity,offset,3,8);
        System.out.println(successful + "\t" + entity.x);


    }
}

class Entity{
    int x = 0 ;
}
