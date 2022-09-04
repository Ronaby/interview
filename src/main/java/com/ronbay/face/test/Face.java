package com.ronbay.face.test;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 请编写一段程序（开发语言不限）用于从一张9000W条记录的客户交易流水表中，
 * 统计每一个客户在过去1年的交易频次，并保存在另外一张数据表中。（请附代码）
 */
public class Face {

    @Data
    public static class User{
        //用户Id
        private String userId;

        //用户名
        private String userName;

        //交易时间
        private LocalDateTime createTime;

    }

    /**
     * 用户交易统计表User_trans
     */
    @Data
    public static class UserTrans {
        //用户Id
        private String userId;
        //交易次数
        private Integer transCount;
        //交易年份
        private LocalDate transYear;
    }




    /**
     * 先对9000w条数据按照 用户进行分组  select user_id from t group by user_id where create_time between'2021-06-13 00:00:00' and create_time<='2022-06-13 23:59:59'  ;
     * 能得到线程数List<userId>
     *
     */

    private static final List<User> userList= new ArrayList<>();

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<UserTrans>> futureList = new ArrayList<>();
        ThreadPoolExecutor executorService =  new ThreadPoolExecutor(5,15,60, TimeUnit.SECONDS,new LinkedBlockingDeque<>(),new ThreadPoolExecutor.AbortPolicy());
        for (int i=0;i<userList.size() ;i++){
            Future<UserTrans> future = executorService.submit(new TransCountThread(userList.get(i).getUserId()));
            futureList.add(future);
        }

        for (int i=0;i<futureList.size();i++){
            Future<UserTrans> future = futureList.get(i);
            UserTrans userTrans = future.get();
            //用户Id
            String userId = userTrans.getUserId();
            //用户交易次数
            Integer transCount = userTrans.getTransCount();
            //写入保存到表User_trans
            System.out.println("用户交易统计表User_trans");
        }

    }



}
