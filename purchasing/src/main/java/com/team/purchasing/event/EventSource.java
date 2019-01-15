package com.team.purchasing.event;

import java.util.Vector;

/**
 * @Auther: 018399
 * @Date: 2019/1/15 10:15
 * @Description:
 */
public class EventSource {

    /**
     * 表明谁触发了事件
     */
    private String who;

    Vector listeners = new Vector();

    public EventSource(String who){
        this.who = who;
    }

    public String getActioner(){
        return who;
    }

    public void addMyEventListener(MyEventListener listener){
        listeners.add(listener);
    }

    /** 设定say方法能被MyEventListener对象监听到 **/
    public void say(String words){
        System.out.println(this.getActioner()+"说："+words);
        for(int i=0;i<listeners.size();i++){
            MyEventListener listener=(MyEventListener) listeners.elementAt(i);
            /** 发布事件。当然应该事先规划say方法事件能发布给哪些事件监听器 **/
            listener.onMyEvent(new MyEventObject(this));
        }
    }

}
