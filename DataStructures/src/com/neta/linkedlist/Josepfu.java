package com.neta.linkedlist;

import java.security.PublicKey;

/**
 * 约瑟夫问题
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList list = new CircleSingleLinkedList();

        list.addBoy(5);

        list.showBoy();

        list.countBoy(1,2,5);
    }
}
// 环形单向列表
class CircleSingleLinkedList{
    // 创建一个 first 节点
    private Boy first = null;

    // 添加节点
    public void addBoy(int nums){
        // 数据校验
        if(nums < 1){
            System.out.println("不正确");
            return;
        }

        Boy curBoy = null;  // 辅助 boy ,帮助构建环形列表

        // for 循环创建
        for(int i = 1; i <= nums; i++){
            // 根据编号创建节点
            Boy boy = new Boy(i);
            if(i == 1){
                first = boy;
                first.setNext(first);  // 构成环
                curBoy = first;  // 指向第一个
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }


    }

    /**
     *
     * @param startNo 开始的序号
     * @param countNum 步长
     * @param nums 一共有几个
     */
    public void countBoy(int startNo, int countNum,int nums){
        // 校验
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("参数输入有误");
        }
        Boy helper = first;

        while (helper.getNext().getNo() != startNo) {
            helper = helper.getNext();
        }
        // 确定 first
        first = helper.getNext();

        while (true){
            if(first.getNext() == first){
                System.out.printf("结束,%d获胜",first.getNo());
                break;
            }

            // 旋转 countNum
            for(int i = 0; i < countNum - 1; i++){
                helper = helper.getNext();
                first = first.getNext();
            }
//            first 出局
            System.out.printf("%d号出局\n",first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }





    }

    // 遍历环形链表
    public void showBoy(){
        // 空的
        if(first == null){
            System.out.println("空的");
            return;
        }
        Boy curBoy = first;
        do {
            System.out.println(curBoy);
            curBoy = curBoy.getNext();
        } while (curBoy != first);
    }
}

class Boy {
    private int no; // 编号
    private Boy next;  // 指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}