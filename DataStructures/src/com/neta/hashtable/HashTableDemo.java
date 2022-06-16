package com.neta.hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable table = new HashTable(8);

        for(int i = 0; i < 20; i++){
            Emp yae = new Emp(i, "Yae");
            table.add(yae);
        }

        table.list();

        table.findEmpById(12);

    }
}
// 创建 hashtable
class HashTable{
    private final EmpLinkedList[] empLinkedListsArray;
    private final int size;
    public HashTable(int size){
        // 初始化
        this.size = size;
        empLinkedListsArray = new EmpLinkedList[size];
        // 初始化每一条链表
        for(int i =0; i <size; i++){
            empLinkedListsArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp){
        // 根据员工的 id 得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        // 添加
        empLinkedListsArray[empLinkedListNo].add(emp);
    }

    // 遍历所有链表
    public void list(){
        for(EmpLinkedList list : empLinkedListsArray){
            list.list();
        }
    }

    // 根据 id 查找
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListsArray[empLinkedListNo].findEmpById(id);
        if(emp != null){
            System.out.println(emp);
        }
        else {
            System.out.println("无。。。");
        }
    }

    // 散列函数
    public int hashFun(int id){
        return id % size;
    }
}



// 一个雇员
class Emp{
    public int id;
    public String name;
    public Emp next;  // 默认为 null

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Emp(int id, String name){
        this.id = id;
        this.name = name;
    }
}

// 创建 EmpLinkedList
class EmpLinkedList{
    // 头指针，指向第一个 Emp
    private Emp head;

    // 添加雇员到链表
    public void add(Emp emp){
        // 添加第一个
        if(head == null){
            head = emp;
            return;
        }
        // 不是第一个
        // 定位到最后
        Emp curEmp = head;
        while (curEmp.next != null) {
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(){
        if(head == null){
            System.out.println("空的");
            return;
        }
        System.out.println("信息为:");
        Emp curEmp = head;
        while (curEmp.next != null) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    // 根据 id 查找雇员
    public Emp findEmpById(int id){
        // 空的
        if(head == null){
            System.out.println("空的");
            return null;
        }
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){
                break;
            }
            if(curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}

