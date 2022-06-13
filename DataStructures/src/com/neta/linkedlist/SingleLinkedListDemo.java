package com.neta.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode yae = new HeroNode(1, "Yae", "屑狐狸");
        HeroNode keqing = new HeroNode(2, "Keqing", "牛杂师傅");
        HeroNode kokomi = new HeroNode(3, "Kokomi", "五星观赏鱼");
        HeroNode ganyu = new HeroNode(4, "Ganyu", "王小美");

        SingleLinkedList list = new SingleLinkedList();

//        list.add(yae);
//        list.add(keqing);
//        list.add(kokomi);

        list.addByOrder(keqing);
        list.addByOrder(ganyu);
        list.addByOrder(yae);
        list.addByOrder(kokomi);

        list.update(new HeroNode(3,"Ayaka","神里"));
//        list.delete(1);
        list.list();

        System.out.println("节点个数="+getLength(yae));
        getHeroByIndex(yae,4);
        getHeroByIndex(yae,1);

        reverse(list.getHead());
        list.list();

    }
    // 统计节点个数(去除头节点)
    public static int getLength(HeroNode head){
        int count = 0;

        if(head.no != 0){
            count = 1;
        }
        HeroNode temp = head;
        while (temp.next != null){
            count++;
            temp = temp.next;
        }

        return count;
    }

    // 获取倒数第 k 个
    public static void getHeroByIndex(HeroNode head,int k){
        int start = 0;

        if(head.no != 0){
            start = 1;
        }

        int nums = getLength(head);

        if(nums < k){
            throw new RuntimeException("k过大");
        }else if(k < 0 ){
            throw new RuntimeException("K过小");
        }
        HeroNode temp = head;
        for(int i = start; i <= nums - k; i++){
            temp = temp.next;
        }

        System.out.printf("倒数第%d个是%s\n",k,temp);
    }

    // 反转单向链表
    public static void reverse(HeroNode head){
        HeroNode node = new HeroNode(0, "", "");
        HeroNode temp = head.next;
        while (temp != null) {
            HeroNode tempNext = temp.next;

            temp.next = node.next;
            node.next = temp;

            temp = tempNext;
        }

        head.next = node.next;
    }


}
// 定义一个 SingleLinkedList 来管理
class SingleLinkedList{
    // 初始化一个头节点,不存放具体的数据
    private final HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //    添加节点
    public void add(HeroNode heroNode){
        // head节点不能动，需要辅助节点
        HeroNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = heroNode;
    }

    // 按顺序添加
    public void addByOrder(HeroNode heroNode){
        HeroNode temp = head;

        boolean flag= false; // 是否存在

        while (true){
            if(temp.no == heroNode.no)
                throw new RuntimeException("存在的节点");

            // 找完了
            if(temp.next == null ){
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }else if(temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if(flag){
            System.out.println("已存在");
            return;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    // 根据 no 修改节点
    public void update(HeroNode newHeroNode){
        // 判断空
        if(head.next == null){
            System.out.println("空的");
            return;
        }

        // 找到需要修改的
        HeroNode temp = head;
        boolean flag = false;  // 是否找到该节点
        while (true){
            if(temp == null)
                break;
            if(temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }

        // 可以修改
        if(flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.println("不存在的hero");
        }
    }


    // 删除节点
    public void delete(int no){
        if(head.next == null){
            System.out.println("空的");
            return;
        }

        HeroNode temp = head;
        boolean flag = false;

        while (true){
            if(temp.next == null)
                break;
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("不存在的no");
        }


    }


    // 显示链表
    public void list(){
        // 判断是否为空
        if(head.next == null){
            System.out.println("空的");
            return;
        }
        // 头部不能动，使用辅助
        HeroNode temp = head;
        while (temp != null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


class HeroNode{
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    // 构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
