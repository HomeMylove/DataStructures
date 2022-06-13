package com.neta.stack;

/**
 * 链表模拟栈
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack(10);

        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.push(new Node(4));

        stack.list();
        System.out.println("出栈");
        System.out.println(stack.pop());
        System.out.println(stack.pop());

//        stack.list();
    }
}


class LinkedListStack{
    private final int maxSize;
    private final MyLinkedList list;
    private int top = -1;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
        list = new MyLinkedList();
    }

    // 栈满
    public boolean isFull(){
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }

    // 入栈,添加到头部？？？
    public void push(Node node){
        if(isFull()){
            System.out.println("满了");
            return;
        }
        list.addHead(node);
        top++;
    }


    // 出栈
    public Node pop(){
        if(isEmpty()){
            throw  new RuntimeException("空的");
        }
        top--;
        return list.peekHead();
    }

    // 遍历栈
    public void list(){
        list.show();
    }
}

class MyLinkedList{
    private Node head;

//    添加到头
    public void addHead(Node node){
        if(head == null){
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    // 取出头
    public Node peekHead(){
        Node h = head;
        head = head.next;
        h.next = null;
        return h;
    }

    // 遍历
    public void show(){
        Node temp = head;

        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
}

class Node{
    public int no;
    public Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                '}';
    }
}
