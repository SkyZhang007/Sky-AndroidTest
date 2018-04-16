package com.sky.androidtest.java;

/**
 * Created by yuetu-develop on 2018/4/8.
 */

public class LinkList {

    public Node<String> head;
    public Node<String> current;

    /**
     * 添加新结点
     * @param data 要添加的结点的数据
     */
    public void add(String data){
        if(head == null){// 头结点为null，说明链表中没有元素
            // 创建结点并把新结点赋值给当前结点
            head = new Node<String>(data);
            current = head;
        } else {
            // 创建新节点赋值给当前结点的下一个结点，让表连起来
            current.next = new Node<String>(data);
            // 当前索引向后移动一位，保证当前结点指向最新的结点
            // 这样再有新数据就一直向后链接
            current = current.next;
        }
    }

    /**
     * 打印单链表中所有结点数据
     * @param node 从该结点开始打印
     */
    public void printLinkList(Node node){
        if(node == null){
            return;
        }
        current = node;
        while (current != null){
            System.out.print(current.data);
            current = current.next;
        }
    }

    /**
     * @return 获取链表长度
     */
    public int getLinkListLength(){
        if(head == null){
            return 0;
        }
        int length = 0;
        Node node = head;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    /**
     * 反转链表，循环不会栈溢出
     * @param node
     * @return
     */
    public Node reverseList(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node current = node;
        Node next = null;
        Node reverseHead = null;
        while (current != null){
            // 记录当前结点的下一个结点用于指针后移
            next = current.next;

            // 3.下一轮循环时，旧的表的下一结点链接到新表头
            current.next = reverseHead;
            // 1.将当前结点赋值给新表头
            reverseHead = current;

            // 2.指针后移
            current = next;
        }
        return reverseHead;
    }

    /**
     * 递归反转链表
     * @param head
     */
    public void printRev(Node head){
        if(head != null){
            // 栈的特性，方法没跑完就不出口
            // 如果链表层级深可能造成栈溢出（栈是有深度的）
            printRev(head.next);
            System.out.print(head.data);
        }
    }

    /**
     * 查找单链表中间
     * @param head
     * @return
     */
    public Node findMidNode(Node head){
        if(head == null){
            return null;
        }
        // 定义两个
        Node first = head;
        Node second = head;
        // 两个同时移动，但是一个走一步另一个走两步
        while (second != null && second.next != null){
            first = first.next;
            second = second.next.next;
        }
        return first;
    }

    /**
     * 判断单链表是否成环
     * @param head
     * @return
     */
    public boolean hasCycle(Node head){
        if(head == null){
            return false;
        }
        Node first = head;
        Node second = head;
        while (second != null){
            first = first.next;
            second = second.next.next;
            if(first == second){
                return true;
            }
        }
        return false;
    }

    // 包含两部分 data（数据），next（下一个结点指针）
    class Node<E>{
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }

    public Node test(Node node){
        return null;
    }

}
