package uaslp.ingenieria.labs.list;

public class LinkedList <T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public static final int AFTER=0;
    public static final int BEFORE=0;

    private static class Node<T>{
        private T data;
        private Node<T> previous;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node<T> getPrevious() {
            return previous;
        }

        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }

    public class Iterator {
        private Node<T> currentNode;

        public Iterator(Node<T> currentNode) {
            this.currentNode = head;
        }

        public boolean hasNext(){
            return currentNode != null;

        }

        public T next(){
            T data = currentNode.getData();
            currentNode= currentNode.getNext();
            return data;
        }

        Node<T> getCurrentNode() {
            return currentNode;
        }
    }

    public class ReverseIterator {

        private Node<T> currentNode;

        public ReverseIterator(Node<T> currentNode) {
            this.currentNode = tail;
        }

        public boolean hasPrevious(){
            return currentNode != null;
        }

        public T next(){
            T data = currentNode.getData();
            currentNode= currentNode.getPrevious();
            return data;
        }

    }

    public void add(T data){
        Node<T> node = new Node<>(data);

        node.setPrevious(tail);

        if(tail != null){
            tail.setNext(node);
        }
        if (head == null){
            head = node;
        }
        tail = node;
        size++;
    }

    public int getSize() {
        return size;
    }

    public T get(int index) {
        Node<T> currentNode = head;
        int currentIndex=0;

            while (currentIndex<index){
                currentNode=currentNode.getNext();
                currentIndex++;
            }

        return currentNode.getData();
        }

    public void delete(int index){
        Node<T> currentNode = head;
        int currentIndex=1;
        size--;
        if(index < 1 || index > size) {
            return;
        }
        if(index == 1){
            head = head.getNext();
            head.setPrevious(null);
        }
        if(index == size){
            tail=tail.getPrevious();
            tail.setNext(null);
        }
        else {
            while (currentIndex < index) {
                currentNode = currentNode.getNext();
                currentIndex++;
            }
            currentNode.getNext().setPrevious(currentNode.getPrevious());
            currentNode.getPrevious().setNext(currentNode.getNext());
            size--;
        }
        if(size == 0){
            head=null;
            tail=null;
        }

    }

    public Iterator getIterator(){
        return new Iterator(head);
    }

    public ReverseIterator getReverseIterator(){
        return new ReverseIterator(tail);
    }

    public void insert(T data, int position, Iterator it){

        Node<T> newNode = new Node<>(data);
        Node<T> currentNode = it.getCurrentNode();

        if(position == AFTER)
        {
            newNode.setNext(currentNode.getNext());
            newNode.setPrevious(currentNode);
            currentNode.getNext().setPrevious(newNode);
            if(currentNode.getNext() != null) {
                currentNode.setNext(newNode);
            }else{
                tail=newNode;
            }
        }
        if(position == BEFORE)
        {
            newNode.setNext(currentNode);
            if(currentNode.getPrevious() != null)
            {
                currentNode.getPrevious().setNext(newNode);
                newNode.setPrevious(currentNode.getPrevious());
            }
            else {
                head=newNode;
            }
            currentNode.setPrevious(newNode);
        }
        size++;
    }

    }
