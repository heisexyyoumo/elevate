package com.humorous.elevate.datastructure.avl;

public class AVLTreeDemo {

    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
//        int[] arr = {10, 12, 8, 9, 7, 6};
        int[] arr = {10, 11, 7, 6, 8, 9};
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        System.out.println("树的高度：" + avlTree.getRoot().height());
        System.out.println("左子树的高度：" + avlTree.getRoot().leftHeight());
        System.out.println("右子树的高度：" + avlTree.getRoot().rightHeight());
        System.out.println("根节点的值为：" + avlTree.getRoot().val);
    }
}


class AVLTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    //添加结点的方法
    public void add(Node node) {
        if (root == null) {
            root = node;//如果root为空则直接让root指向node
        } else {
            root.add(node);
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉排序树为空，不能遍历");
        }
    }

    public Node search(int val) {
        if (root == null) {
            return null;
        } else {
            return root.search(val);
        }
    }

    public Node searchParent(int val) {
        if (root == null) {
            return null;
        } else {
            return root.searchParent(val);
        }
    }

    //编写方法:
    //1. 返回的 以node 为根结点的二叉排序树的最小结点的值
    //2. 删除node 为根结点的二叉排序树的最小结点

    /**
     * @param node 传入的结点(当做二叉排序树的根结点)
     * @return 返回的 以node 为根结点的二叉排序树的最小结点的值
     */
    public int delRightTreeMin(Node node) {
        Node target = node;
        //循环的查找左子节点，就会找到最小值
        while (target.left != null) {
            target = target.left;
        }
        //这时 target就指向了最小结点
        //删除最小结点
        delNode(target.val);
        return target.val;
    }


    //删除结点
    public void delNode(int value) {
        if (root == null) {
            return;
        } else {
            //1.需求先去找到要删除的结点  targetNode
            Node targetNode = search(value);
            //如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            //如果我们发现当前这颗二叉排序树只有一个结点
            if (root.left == null && root.right == null) {
                root = null;
                return;
            }

            //去找到targetNode的父结点
            Node parent = searchParent(value);
            //如果要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                //判断targetNode 是父结点的左子结点，还是右子结点
                if (parent.left != null && parent.left.val == value) { //是左子结点
                    parent.left = null;
                } else if (parent.right != null && parent.right.val == value) {//是由子结点
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) { //删除有两颗子树的节点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.val = minVal;
            } else { // 删除只有一颗子树的结点
                //如果要删除的结点有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.val == value) {
                            parent.left = targetNode.left;
                        } else { //  targetNode 是 parent 的右子结点
                            parent.right = targetNode.left;
                        }
                    } else {
                        root = targetNode.left;
                    }
                } else { //如果要删除的结点有右子结点
                    if (parent != null) {
                        //如果 targetNode 是 parent 的左子结点
                        if (parent.left.val == value) {
                            parent.left = targetNode.right;
                        } else { //如果 targetNode 是 parent 的右子结点
                            parent.right = targetNode.right;
                        }
                    } else {
                        root = targetNode.right;
                    }
                }

            }

        }
    }
}


class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }


    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //左子树高度
    public int leftHeight() {
        if (left == null) {
            return 0;
        }
        return left.height();
    }

    //右子树高度
    public int rightHeight() {
        if (right == null) {
            return 0;
        }
        return right.height();
    }

    //添加结点的方法
    //递归的形式添加结点，注意需要满足二叉排序树的要求
    public void add(Node node) {
        if (node == null) {
            return;
        }

        //判断传入的结点的值，和当前子树的根结点的值关系
        if (node.val < this.val) {
            //如果当前结点左子结点为null
            if (this.left == null) {
                this.left = node;
            } else {
                //递归的向左子树添加
                this.left.add(node);
            }
        } else { //添加的结点的值大于 当前结点的值
            if (this.right == null) {
                this.right = node;
            } else {
                //递归的向右子树添加
                this.right.add(node);
            }

        }
        //当添加完一个节点后，如果：（右子树的高度 - 左子树的高度）> 1，进行左旋
        if (rightHeight() - leftHeight() > 1) {
            //如果右子树的左子树高度大于右子树的右子树高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                right.rightRotate();
            }
            leftRotate();
            return;
        }
        //当添加完一个节点后，如果：（左子树的高度 - 右子树的高度）> 1，进行左旋
        if (leftHeight() - rightHeight() > 1) {
            //如果左子树的右子树高度大于左子树的左子树高度
            if (left != null && left.leftHeight() < left.rightHeight()) {
                left.leftRotate();
            }
            rightRotate();

        }


    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    public Node search(int val) {
        if (this.val == val) {
            return this;
        } else if (this.val > val) {
            if (this.left != null) {
                return this.left.search(val);
            }
            return null;
        } else {
            if (this.right != null) {
                return this.right.search(val);
            }
            return null;
        }
    }

    public Node searchParent(int val) {
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else {
            if (this.left != null && this.val > val) {
                return this.left.searchParent(val);
            }
            if (this.right != null && this.val < val) {
                return this.right.searchParent(val);
            }
            return null;
        }
    }


    // 左旋
    public void leftRotate() {
        //创建新的节点，以当前根节点为值
        Node newNode = new Node(val);
        //把新的节点的左子树设置为当前节点的左子树
        newNode.left = left;
        //把新的节点的右子树设置成当前节点右子树的左子树
        newNode.right = right.left;
        //把当前节点的值替换为右子节点的值
        val = right.val;
        //把当前节点的右子树设置为当前节点右子树的右子树
        right = right.right;
        //把当前节点的左子树设置为新的节点
        left = newNode;
    }

    // 右旋
    public void rightRotate() {
        Node newNode = new Node(val);
        newNode.left = left.right;
        newNode.right = right;
        val = left.val;
        left = left.left;
        right = newNode;
    }

}
