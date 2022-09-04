package com.ronbay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 */
public class Test {

    public static void main(String[] args) {
//        Map<Integer, Integer> map = new HashMap<>();
//        System.out.println(map.get("a"));
//        Iterator<Integer> iterator =  map.keySet().iterator();
//        while (iterator.hasNext()){
//           Integer entry = iterator.next();
//        }
//        throw new IllegalArgumentException("");
        maxProfit(new int[]{2,4,1});
    }


    public static int maxProfit(int[] prices) {
        if(prices == null){
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        int index = 0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
                index = i;
            }
        }
        for(int i=index+1;i<prices.length;i++){
            int max = prices[i]-minPrice;
            if(max>maxProfit){
                maxProfit = max;
            }
        }
        return maxProfit;
    }
}
