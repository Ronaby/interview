package com.ronbay.face.test;

import java.util.concurrent.Callable;

/**
 * @Description: 交易统计保存线程
 */
public class TransCountThread implements Callable<Face.UserTrans> {

    /**
     * 用户userId
     */
    private String userId;

    public TransCountThread(String userId){
        this.userId = userId;
    }

    @Override
    public Face.UserTrans call() throws Exception {
        //返回统计
        //统计单个用户去年的交易流水 select count(*) from t where id= userList.get(i) and  create_time between'2021-06-13 00:00:00' and create_time<='2022-06-13 23:59:59'
        System.out.println("统计单个用户去年的交易流水 select count(*) from t where id= userList.get(i) and  create_time between'2021-06-13 00:00:00' and create_time<='2022-06-13 23:59:59'");
        return null;
    }
}
