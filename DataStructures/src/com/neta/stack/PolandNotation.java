package com.neta.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 创建一个逆波兰表达式
        String suffixExp = "3 4 + 5 * 6 -";
        // 思路
        // 1. 先将表达式放到 ArrayList 中
        // 2. 将 ArrayList 传递给一个方法，遍历 ArrayList 配合栈完成计算
        ArrayList<String> rpnList = getListString(suffixExp);

        System.out.println(calculator(rpnList));

    }

    // 将逆波兰表达式放入 ArrayList
    public static ArrayList<String> getListString(String suffixExp) {
        // 分割
        String[] split = suffixExp.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split)
            list.add(ele);
        return list;
    }

    // 计算
    public static int calculator(List<String> ls) {
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        // 遍历
        for (String item : ls) {
            // 取出
            if (item.matches("\\d+")) {
                // 多位数
                stack.push(item);
            } else {
                // 弹出 两个数并计算
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                switch (item) {
                    case "+":
                        res = num1 + num2;
                        break;
                    case "-":
                        res = num1 - num2;
                        break;
                    case "*":
                        res = num1 * num2;
                        break;
                    case "/":
                        res = num1 / num2;
                        break;
                    default:
                        throw new RuntimeException("wrong");
                }
                // 结果入栈
                stack.push(res + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
