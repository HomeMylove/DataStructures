package com.neta.linkedlist;

/**
 * 演示双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        CharaNode yae = new CharaNode(1, "Yae", "屑狐狸");
        CharaNode ayaka = new CharaNode(2, "Ayaka", "白鹭公主");
        CharaNode kokomi = new CharaNode(3, "Kokomi", "五星观赏鱼");
        CharaNode keqing = new CharaNode(4, "Keqing", "牛杂师傅");

        DoubleLinkedList list = new DoubleLinkedList();

//        list.add(keqing);
//        list.add(yae);
//        list.add(kokomi);
//        list.add(ayaka);

//        CharaNode ei = new CharaNode(1, "ei", "雷军");
//        list.update(ei);
//        list.list();
//
//        list.del(3);
        list.addByOrder(keqing);
        list.addByOrder(yae);
        list.addByOrder(kokomi);
        list.addByOrder(ayaka);


        list.list();
    }
}

class DoubleLinkedList {
    private final CharaNode head = new CharaNode(0, "", "");

    public CharaNode getHead() {
        return head;
    }

    //    添加
    public void add(CharaNode node) {
        CharaNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = node;
        node.pre = temp;
    }

//    顺序添加
    public void addByOrder(CharaNode node){
        CharaNode temp = head;

        boolean flag = false; // 是否存在
        while (true){
            if(temp.next == null){
                break;
            }
            if(temp.next.no > node.no){
                break;
            }else if(temp.next.no == node.no){
                flag = true;
                break;
            }
            temp =  temp.next;
        }

        // 放在 temp 的后面
        if(flag){
            System.out.println("存在");
        }else {
            CharaNode next = temp.next;

            temp.next = node;
            node.pre = temp;

            if(next != null){
                next.pre = node;
                node.next = next;
            }
        }
    }


    // 修改
    public void update(CharaNode node) {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }

        CharaNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == node.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = node.name;
            temp.nickName = node.nickName;
        } else {
            System.out.println("不存在");
        }
    }

    // 删除
    public void del(int no) {
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        CharaNode temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
//            如果是最后一个节点就不要执行下面的语句
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("不存在的");
        }
    }


    // 显示链表
    public void list() {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("空的");
            return;
        }
        // 头部不能动，使用辅助
        CharaNode temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }
}

class CharaNode {
    public int no;
    public String name;
    public String nickName;
    public CharaNode next;
    public CharaNode pre;

    public CharaNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "CharaNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}


