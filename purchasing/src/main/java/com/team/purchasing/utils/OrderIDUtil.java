package com.team.purchasing.utils;

import java.util.UUID;

/**
 * @Auther:ynhuang
 * @Date:4/3/19 下午9:42
 * 订单id生成规则
 */
public class OrderIDUtil {

    public static String getOrderId(){
        //最大支持1-9个集群机器部署
        int machineId = 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if(hashCodeV < 0) {//有可能是负数
            hashCodeV = - hashCodeV;
        }
        //0 代表前面补充0     
        //4 代表长度为4     
        //d 代表参数为正数型
         return machineId+ String.format("%015d", hashCodeV);

    }

}
