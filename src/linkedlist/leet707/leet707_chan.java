class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {

    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }

        Node curr = head;
        int i = 0;
        while (i++ < index) {
            curr = curr.next;
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node curr = head;
            head = new Node(val);
            head.next = curr;
            curr.prev = head;
        }
        size++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            Node curr = tail;
            tail = new Node(val);
            curr.next = tail;
            tail.prev = curr;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        } else if (index == 0) {
            addAtHead(val);
            return;
        } else {
            Node curr = head;
            int i = 0;
            while (i++ < index) {
                curr = curr.next;
            }
            Node insertedNode = new Node(val);
            insertedNode.prev = curr.prev;
            insertedNode.next = curr;

            curr.prev.next = insertedNode;
            curr.prev = insertedNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }

        if (index == 0) {
            Node curr = head.next;
            head = curr;
        } else if (index == size - 1) {
            Node curr = tail.prev;
            tail = curr;
        } else {
            Node curr = head;
            int i = 0;
            while (i++ < index) {
                curr = curr.next;
            }
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }

        size--;

    }

    public void printAll() {
        Node curr = head;
        int i = 0;
        while (i++ < size) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */