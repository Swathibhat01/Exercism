class DoublyLinkedList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;

    void push(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNextNode(node);
            node.setPreviousNode(tail);
            tail = node;
        }
    }

    T pop() {
        if (tail == null) {
            return null;
        }
        if (head == tail) {
            T value = tail.getValue();
            head = null;
            tail = null;
            return value;
        } else {
            T value = tail.getValue();
            tail = tail.getPreviousNode();
            tail.setNextNode(null);
            return value;
        }
    }

    T shift() {
        if (head == null) {
            return null;
        }
        if (head == tail) {
            T value = head.getValue();
            head = null;
            tail = null;
            return value;
        }
        T value = head.getValue();
        head = head.getNextNode();
        head.setPreviousNode(null);
        return value;

    }

    void unshift(T value) {
        Node<T> node = new Node<>(value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.setNextNode(head);
            head.setPreviousNode(node);
            head = node;
        }
    }


}

class Node<T> {

    private T value;
    private Node<T> previousNode;
    private Node<T> nextNode;

    Node(T value) {
        this.value = value;
    }

    T getValue() {
        return value;
    }

    Node<T> getPreviousNode() {
        return previousNode;
    }

    void setPreviousNode(Node<T> previousNode) {
        this.previousNode = previousNode;
    }

    Node<T> getNextNode() {
        return nextNode;
    }

    void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }


}