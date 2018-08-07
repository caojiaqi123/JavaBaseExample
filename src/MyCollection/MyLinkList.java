package MyCollection;

public class MyLinkList {
    private Node first;
    private Node last;
    private int size;

    public void add(Object obj) {
        Node newNode = new Node();
        newNode.setData(obj);

        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            //新节点前一个为链表上的最后一个
            newNode.setPreNode(last);
            //链表的最后一个节点 从 null改为新节点
            last.setNextNode(newNode);
            //链表的最后一个节点变为新节点
            last = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        Node tem = next(index);
        return tem.getData();
    }

    private Node next(int index) {
        Node tem = null;
        if (first != null) {
            tem = first;
            for (int i = 0; i < index; i++) {
                tem = tem.getNextNode();
            }
        }
        return tem;
    }

    public void remove(int index) {
        Node tem = next(index);
        if (tem != null) {
            Node preNode = tem.getPreNode();
            Node nextNode = tem.getNextNode();
            preNode.setNextNode(nextNode);
            nextNode.setPreNode(preNode);
            size--;
        }

        tem = null;
    }
    public void insert(int index,Object data){
        Node next = next(index);


        Node newNode = new Node();
        newNode.setData(data);
        if (next!=null){
            Node preNode = next.getPreNode();
            preNode.setNextNode(newNode);
            newNode.setPreNode(preNode);

            newNode.setNextNode(next);
            next.setPreNode(newNode);

        }
    }

    public static void main(String[] args) {
        MyLinkList linkList = new MyLinkList();
        linkList.add("aaa");
        linkList.add("bbb");
        System.out.println(linkList.size());
    }
}

class Node {
    private Node preNode;
    private Node nextNode;
    private Object data;

    public Node getPreNode() {
        return preNode;
    }

    public void setPreNode(Node preNode) {
        this.preNode = preNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }


    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}