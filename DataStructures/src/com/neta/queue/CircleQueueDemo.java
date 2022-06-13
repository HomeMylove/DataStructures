package com.neta.queue;

import java.util.Scanner;

/**
 * 环形队列
 */
public class CircleQueueDemo {
    public static void main(String[] args) {
        CircleQueue circleQueue = new CircleQueue(3);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char key = ' ';
        while (loop) {
            System.out.println("s:(show):显示队列");
            System.out.println("e:(exit):退出程序");
            System.out.println("a:(add):添加到队列");
            System.out.println("g:(get):取出数据");
            System.out.println("h:(head):显示头部");
            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int num = scanner.nextInt();
                    circleQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        System.out.println(circleQueue.getQueue());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 'h':
                    try {
                        System.out.println(circleQueue.peekHead());
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

class CircleQueue {
    private final int maxSize; // 最大容量
    private int front;   // front 是第一个值的位置
    private int rear;  // rear 指的是最后一个数据的下一个位置
    private final int[] arr;  // 用于存放数据

    // 构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 判断队列是否空
    public boolean isEmpty() {
        return front == rear;
    }

    // 添加
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }

        arr[rear] = n;
        // 后移
        rear = (rear + 1) % maxSize;
    }

    // 取出
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("空的");
        }
        // 1.先保存到临时变量
        int value = arr[front];
        // 后移
        front = (front + 1) % maxSize;
        // 返回
        return value;
    }

    // 显示
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("空的");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列有效数据个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    // 显示头部
    public int peekHead() {
        if (isEmpty()) {
            throw new RuntimeException("空的");
        }
        return arr[front];
    }
}
