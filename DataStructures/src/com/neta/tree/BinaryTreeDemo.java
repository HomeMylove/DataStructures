package com.neta.tree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        // 创建二叉树
        BinaryTree binaryTree = new BinaryTree();
        HeroNode yae = new HeroNode(1, "Yae");
        HeroNode ei = new HeroNode(2, "Ei");
        HeroNode kokomi = new HeroNode(3, "Kokomi");
        HeroNode ayaka = new HeroNode(4, "Ayaka");

        yae.setLeft(ei);
        yae.setRight(kokomi);
        kokomi.setRight(ayaka);
        binaryTree.setRoot(yae);

        binaryTree.preOrder();
//        binaryTree.infixOrder();
//        binaryTree.postOrder();
//        System.out.println(binaryTree.preOrderSearch(3));
        binaryTree.delNode(4);
        binaryTree.preOrder();
    }
}

// 定义二叉树
class BinaryTree {
    private HeroNode root;

    public BinaryTree(HeroNode root) {
        this.root = root;
    }

    public BinaryTree() {
    }

    public HeroNode getRoot() {
        return root;
    }

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    // 删除节点
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空的");
        }
    }



    // 前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        }
    }

    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }
    }

    public void postOrder() {
        if (root != null) {
            root.postOrder();
        }
    }

    public HeroNode preOrderSearch(int no){
        if(root != null){
            return root.preOrderSearch(no);
        }else return null;
    }
}


// HeroNode 节点
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public void delNode(int no){
        if(this.left != null && this.left.no == no){
            this.left = null;
            return;
        }
        if(this.right != null && this.right.no == no){
            this.right = null;
            return;
        }
        // 左递归
        if(this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }


    // 前序遍历方法
    public void preOrder() {
        // 输出父节点
        System.out.println(this);
        // 左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        // 右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        // 比较当前节点是不是
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if(resNode != null){
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        return resNode;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }
}
