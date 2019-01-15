package com.team.purchasing.event;

import java.util.EventListener;
import java.util.EventObject;

/**
 * @Auther: 018399
 * @Date: 2019/1/15 10:16
 * @Description:
 */
public class MyEventListener implements EventListener {

    /** EventListener是与EventObject同级的最原始的监听器，当然里面什么方法都没有 **/
    public void onMyEvent(EventObject e){

        /** 如果该类与EventObject实例处于同一个类中，可以直接使用==判断事件来源 **/
        if(e.getSource() instanceof EventSource){
            /** 事件来源于OtherSource时要处理的业务 **/
            EventSource tempSrc=(EventSource)e.getSource();
            System.out.println("收到来自"+tempSrc.getActioner()+"的事件!");
        }
		/*else if(e.getSource() instanceof OtherSource){
			System.out.println("事件来源于OtherSource时要处理的业务");
		}*/
    }

}
