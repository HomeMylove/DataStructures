package com.neta.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree tree = new ArrBinaryTree(arr);
        tree.preOrder();
    }
}


// 编写一个 ArrayBinaryTree
class ArrBinaryTree {
    private final int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }
    //
    public void preOrder(){
        this.preOrder(0);
    }

    // 完成顺序存储二叉树的前序遍历
    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("空的数组");
            return;
        }
        System.out.println(arr[index]);
        // 向左
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        // 向右
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
