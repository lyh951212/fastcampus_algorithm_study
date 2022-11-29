// Single-LinkedList
class MyLinkedList {
    class Node {
        int data;
        Node next;
        
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    
    public MyLinkedList() { 
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public int get(int index) {
        Node node = this.head;
        
        int i = 0;
        
        while(node != null && i<index){
            node = node.next;
            i++;
        } 
        
        Node resultNode = node;
        return (resultNode!=null) ? resultNode.data : -1;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        
        newNode.next = this.head;
        
        if(this.head == null) this.tail = newNode;
        
        this.head = newNode;
        this.size += 1;
    }
    
    public void addAtTail(int val) {
        if(this.head == null){
            addAtHead(val);
            return;
        }
        
        Node newNode = new Node(val);
        
        this.tail.next = newNode;
        this.tail = newNode;
        this.size += 1;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == 0){
            addAtHead(val);
            return;
        }
        if(index == this.size){
            addAtTail(val);
            return;
        }
        
        Node node = this.head;
        
        int i = 0;
        
        while(node != null && i<index-1){
            node = node.next;
            i++;
        } 
        
        Node resultNode = node;
        
        if(resultNode == null) return;
        
        Node newNode = new Node(val);
        newNode.next = resultNode.next;
        resultNode.next = newNode;
        this.size += 1;
    }
    
    public void deleteAtIndex(int index) {
        if(index == 0){
            this.head = this.head.next;
            this.size -= 1;
            return;
        }
        
        Node node = this.head;
        
        int i = 0;
        
        while(node != null && i<index-1){
            node = node.next;
            i++;
        } 
        
        Node resultNode = node;
        if(resultNode == null || resultNode.next == null) return;
        
        resultNode.next = node.next.next;
        
        if(resultNode.next == null) this.tail = resultNode;
        this.size -= 1;
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
