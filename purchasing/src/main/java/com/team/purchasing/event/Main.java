package com.team.purchasing.event;

/**
 * @Auther: 018399
 * @Date: 2019/1/15 10:19
 * @Description:
 */
public class Main {

    public static MyEventListener listener = null;

    public static void main(String[] args){

        listener = new MyEventListener();
        EventSource 小白 = new EventSource("小白");
        小白.addMyEventListener(listener);
        小白.say("今天天气不错");
        小白.say("适合出去走走");
    }

}
