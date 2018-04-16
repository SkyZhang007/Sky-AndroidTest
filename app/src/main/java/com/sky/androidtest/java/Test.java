package com.sky.androidtest.java;

/**
 * Created by yuetu-develop on 2018/4/8.
 */

public class Test {

    public static void main(String[] args){

//        linkListTest();



    }
    // 链表测试
    private static void linkListTest(){
        LinkList linkList = new LinkList();
        // 添加数据
        for (int i = 0; i < 10; i++){
            linkList.add("data"+i+"\n");
        }
        // 反转单链表
        LinkList.Node node = linkList.reverseList(linkList.head);
        linkList.printLinkList(node);
    }


}
