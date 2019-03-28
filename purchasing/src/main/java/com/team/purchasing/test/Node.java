package com.team.purchasing.test;

import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/3/26 10:43
 * @Description:
 */
@Data
public class Node<T> {

    private Node head;

    private Node next;

    private T data;

    public Node() {
    }

    public void addNode(T addData){

        //组装数据
        Node<T> newNode = new Node<>();
        newNode.setData(addData);

        if(head == null){
            //给头结点添加数据
            head = newNode;
        }else {
            //后续插入
            Node<T> temp = head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;

        }


    }

    /**
     * 指定位置插入
     * @param index
     * @param addData
     */
    public void insertData(int index, T addData){

        if(index < 1){
            return;
        }

        Node<T> newNode = new Node<>();
        newNode.setData(addData);

        //插入第一个位置
        if(index == 1){
            Node<T> temp = head;
            head = newNode;
            newNode.next = temp;
        }else {
            Node<T> temp = head;
            //其他位置,需要遍历
            int length = 1;
            while (temp.next != null) {
                if(index != length - 1){
                    temp = temp.next;
                    length ++;
                }

                //如果等于现在取到前后的节点
                newNode.next = temp.next;
                temp.next = newNode;

            }


        }

    }

    public String printData(){

        StringBuffer stringBuffer = new StringBuffer();

        if(head == null){
            return "没有数据";
        }

        if(head.next == null){
            return String.valueOf(head.data);
        }

        stringBuffer.append(head.data + ", ");

        Node newNode = head.next;


        while (newNode != null) {
            stringBuffer.append(newNode.data + ", ");
            newNode = newNode.next;
        }

        return stringBuffer.toString();

    }

    public static void main(String[] args) {
        Node<Integer> node = new Node<>();
        for(int i=0;i<10;i++){
            node.addNode(i);
        }
        node.insertData(2,-1);

        System.out.println(node.printData());
    }

}
