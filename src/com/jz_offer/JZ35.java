package com.jz_offer;


public class JZ35 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //新增节点
        for (Node p = head; p != null; p = p.next.next) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
        }
        //新增随机指针节点
        for (Node p = head; p != null && p.next != null; p = p.next.next) {
            Node nodeNew = p.next;
            nodeNew.random = (p.random != null) ? p.random.next : null;

        }

        //删除奇数节点：

        Node  headNew=head.next;
        for (Node p = head; p != null; p = p.next) {
            Node nodeNew = p.next;
            p.next = p.next.next;
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next:null;
        }


        //删除原来的节点
        return headNew;
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
