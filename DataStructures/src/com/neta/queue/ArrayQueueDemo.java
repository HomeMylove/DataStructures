package com.neta.queue;

import java.util.Scanner;

/**
 * 用数组实现队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop){
            System.out.println("s:(show):显示队列");
            System.out.println("e:(exit):退出程序");
            System.out.println("a:(add):添加到队列");
            System.out.println("g:(get):取出数据");
            System.out.println("h:(head):显示头部");
            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int num = scanner.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        System.out.println(arrayQueue.getQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(arrayQueue.peekHead());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}

class ArrayQueue{
    private final int maxSize; // 最大容量
    private int front;  // 队列头
    private int rear;   // 队列尾
    private final int[] arr;  // 用于存放数据

    // 构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;  // 指向队列头部的前一个位置
        rear = -1;   // 指向队列尾，就是最后一个数据
    }

    // 判断队列是否满
    public boolean isFull(){
        return rear == maxSize - 1;
    }

    // 判断队列是否空
    public boolean isEmpty(){
        return front == rear;
    }

    // 添加数据到队列
    public void addQueue(int n){
        // 判断是否满
        if(isFull()){
            System.out.println("队列满了");
            return;
        }
        rear++;
        arr[rear] = n;
    }

    // 出队列
    public int getQueue(){
        // 判断空
        if(isEmpty()){
            throw new RuntimeException("空的队列");
        }
        front++;
        return arr[front];
    }

    // 显示队列的所有数据
    public void showQueue(){
        // 检查空
        if(isEmpty()){
            System.out.println("空的");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }

    }

    // 显示头部
    public int peekHead(){
        if(isEmpty()){
            throw  new RuntimeException("空的");
        }
        return arr[front+1];
    }
}
