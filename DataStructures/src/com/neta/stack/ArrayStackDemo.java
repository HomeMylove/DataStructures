package com.neta.stack;

import java.util.Scanner;

/**
 * 使用数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);

        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入操作");

        while (loop) {
            System.out.println("s(show):显示栈");
            System.out.println("e(exit):退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请选择");
            key = scanner.next();

            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "e":
                    System.out.println("退出");
                    loop = false;
                    break;
                case "push":
                    System.out.println("输入一个值");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        System.out.println("栈顶为" + stack.pop());
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

class ArrayStack {
    private final int maxSize;  // 栈的大小
    private final int[] stack;  // 数组，模拟栈，存放数据
    private int top = -1; // 初始值

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 判断栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("满了");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空的");
        }
        return stack[top--];
    }

    // 遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("没有");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }
}
