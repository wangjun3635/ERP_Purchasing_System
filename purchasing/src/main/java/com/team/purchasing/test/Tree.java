package com.team.purchasing.test;

import lombok.Data;

/**
 * @Auther: 018399
 * @Date: 2019/3/27 09:22
 * @Description: 二叉查找树
 */
@Data
public class Tree {

    private Tree rootNode;

    private Tree leftNode;

    private Tree rightNode;

    private int data;

    public void addNode(int addData){

        Tree newTree = new Tree();
        newTree.setData(addData);

        //根节点数据添加
        if(rootNode == null){
            rootNode = newTree;
        }
        //添加子节点
        else {
            Tree temp = rootNode;

            while (temp != null) {

                if(temp.data >= addData){
                    if(temp.leftNode == null){
                        temp.leftNode = newTree;
                        return;
                    }
                    temp = temp.leftNode;
                }

                else {
                    if(temp.rightNode == null){
                        temp.rightNode = newTree;
                        return;
                    }
                    temp = temp.rightNode;
                }

            }

        }

    }

    /**
     * 中序遍历
     * @param currentNode
     */
    public void printData(Tree currentNode){

        if(currentNode == null){
            System.out.println("二叉树为空");
            return;
        }
        if(currentNode.leftNode != null){
            printData(currentNode.leftNode);
        }
        System.out.print(currentNode.data+", ");
        if(currentNode.rightNode != null){
            printData(currentNode.rightNode);
        }

    }

    /**
     * 前序遍历
     * @param currentNode
     */
    public void prePrintData(Tree currentNode){

        if(currentNode == null){
            System.out.println("二叉树为空");
            return;
        }
        System.out.print(currentNode.data+", ");

        if(currentNode.leftNode != null){
            prePrintData(currentNode.leftNode);
        }

        if(currentNode.rightNode != null){
            prePrintData(currentNode.rightNode);
        }

    }

    /**
     * 后序遍历
     * @param currentNode
     */
    public void afterPrintData(Tree currentNode) {

        if(currentNode == null){
            System.out.println("二叉树为空");
            return;
        }

        if(currentNode.leftNode != null){
            prePrintData(currentNode.leftNode);
        }

        if(currentNode.rightNode != null){
            prePrintData(currentNode.rightNode);
        }

        System.out.print(currentNode.data+", ");

    }

    public int getHeight(Tree currentNode){

        if(currentNode == null){
            return 0;
        }

        int left = 0;
        int right = 0;
        if(currentNode.leftNode != null){
            left += getHeight(currentNode.leftNode);
        }
        if(currentNode.rightNode != null) {
            right += getHeight(currentNode.rightNode);
        }

        int max = Math.max(left, right);

        System.out.println(left + "," + right);

        return max + 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.addNode(10);
        tree.addNode(2);
        tree.addNode(12);
        tree.addNode(4);
        tree.addNode(1);
        tree.addNode(3);
        System.out.print("中序遍历 : ");
        tree.printData(tree.getRootNode());
        System.out.println();
        System.out.print("前序遍历 : ");
        tree.prePrintData(tree.getRootNode());
        System.out.println();
        System.out.print("后序遍历 : ");
        tree.afterPrintData(tree.getRootNode());
        System.out.println();

        System.out.println("高度 : " + tree.getHeight(tree.getRootNode()));
    }

}
