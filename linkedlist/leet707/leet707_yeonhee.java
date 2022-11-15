package linked_list;

class Node{
    public int val;
    public Node prev = null;
    public Node next = null;
    Node(int val)
    {
        this.val = val;
    }
}
class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int get(int index) {
        Node tmp = this.head;
        int cnt = 0;

        while(cnt < index)
        {
            cnt++;
            tmp = tmp.next;
            if(tmp.next == tail)
                break;
        }

        return tmp.val;
    }

    public void addAtHead(int val) {
        Node newNode =  new Node(val);
        newNode.next = this.head;

        if(this.head != null)
        {
            this.head.prev = newNode;
        }

        this.head = newNode;
        size++;

        if(this.head.next == null)
        {
            this.tail = this.head;
        }
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);

        if(this.size==0)
        {
            addAtHead(val);
            return;
        }

        this.tail.next = newNode;
        newNode.prev = this.tail;
        this.tail = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index == 0)
        {
            addAtHead(val);
            return;
        }
        if(index == this.size)
        {
            addAtTail(val);
            return;
        }

        Node tmp = this.head;
        int cnt = 0;
        while(cnt < index)
        {
            tmp = tmp.next;
            cnt++;
        }
        Node prevNode = tmp.prev;
        Node nextNode = tmp;
        Node newNode = new Node(val);

        prevNode.next = null;
        nextNode.prev = null;

        prevNode.next = newNode;
        newNode.prev = prevNode;
        newNode.next = nextNode;
        nextNode.prev = newNode;
        size++;

    }

    public void deleteAtIndex(int index) {
        Node tmp = this.head;
        int cnt = 0;
        while(cnt < index)
        {
            tmp = tmp.next;
            cnt++;
        }
        Node prevNode = tmp.prev;
        Node removedNode = tmp;
        Node nextNode = tmp.next;

        prevNode.next = null;
        removedNode.next = null;
        removedNode.prev = null;

       if(nextNode != null){
           nextNode.prev = null;
           nextNode.prev = prevNode;
           prevNode.next = nextNode;
       }
       else {
           this.tail = prevNode;
       }

       size--;
    }
    public void showAll()
    {
        if (this.head != null) {
            Node node = this.head;
            System.out.println(node.val);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.val);
            }
        }
    }
}


public class double_linked_list {
    public static void main(String[] args) {
        MyLinkedList myList = new MyLinkedList();
        myList.addAtTail(1);
        myList.addAtTail(3);
        myList.addAtTail(5);
        myList.addAtIndex(1,0);
        myList.deleteAtIndex(1);
        myList.showAll();
    }

}
