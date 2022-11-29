class BrowserHistory {
    private Node head;
    private Node curr;
    private Node tail;

    private class Node {
        String val;
        Node next;
        Node prev;

        public Node(String val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        head = node;
        curr = head;
        tail = head;
    }

    public void visit(String url) {
        if (curr == tail) {
            Node temp = tail;
            tail = new Node(url);
            temp.next = tail;
            tail.prev = temp;
            curr = tail;
        } else {
            Node temp = curr;
            tail = new Node(url);
            temp.next = tail;
            tail.prev = temp;
            curr = tail;
        }

    }

    public String back(int steps) {
        int count = 0;
        while (curr.prev != null && count < steps) {
            curr = curr.prev;
            ++count;
        }
        return curr.val;
    }

    public String forward(int steps) {
        int count = 0;
        while (curr.next != null && count < steps) {
            curr = curr.next;
            ++count;
        }
        return curr.val;
    }
}