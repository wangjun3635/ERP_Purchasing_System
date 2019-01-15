package com.team.purchasing.event;

import java.util.EventObject;

/**
 * @Auther: 018399
 * @Date: 2019/1/15 10:14
 * @Description: java事件驱动模型
 */
public class MyEventObject extends EventObject {

    /***
     * 父类构造
     * @param source
     */
    public MyEventObject(Object source) {
        super(source);
    }
}
