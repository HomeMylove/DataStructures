package com.neta.stack;

public class CalculatorTest {
    public static void main(String[] args) {
        String exp = "3+20*6-2";
        Stack numStack = new Stack(10);
        Stack operStack = new Stack(10);
        // 需要的变量
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  // 扫描的结果
        StringBuilder keepNum = new StringBuilder(); // 用于拼接
        // 开始
        do {
            // 得到每一个字母
            ch = exp.substring(index, index + 1).charAt(0);
            // 判断 ch 是什么
            if (operStack.isOper(ch)) {
                if (!operStack.isEmpty()) {
                    // 判断优先级
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = Stack.cal(num1, oper, num2);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
                // 需要向后面再看一位
                keepNum.append(ch);
                char next = exp.substring(index+1, index + 2).charAt(0);
                // 是个操作符
                if(operStack.isOper(next)){
                    numStack.push(Integer.parseInt(keepNum.toString()));
                    keepNum = new StringBuilder();
                }
            }

            // index++
            index++;
            // 判断是否扫描完毕
        } while (index != exp.length());

        // 扫描完毕
        while (!operStack.isEmpty()) {
            // 符号栈为空结束
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = Stack.cal(num1, oper, num2);
            numStack.push(res);
        }

        System.out.println("结果是:"+numStack.pop());

    }
}

class Stack {
    private final int maxSize;
    private final int[] arr;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 查看栈顶
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!!");
        }
        return arr[top];
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full!!");
            return;
        }
        arr[++top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!!");
        }
        return arr[top--];
    }

    // 打印栈
    public void list() {
        if (isEmpty()) {
            System.out.println("Stack is empty!!");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.printf("stack [%d]=%s\n", i, arr[i]);
        }
    }

    // 返回优先级
    public int priority(int oper) {
        if (oper == '*' || oper == '/')
            return 1;
        else if (oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }

    // 判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    // 计算方法
    public static int cal(int a, int oper, int b) {
        int result = 0;
        switch (oper) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = b - a;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                result = b / a;
                break;
            default:
                break;
        }
        System.out.printf("%d %s %d = %d\n", b, (char)oper, a, result);
        return result;
    }
}

