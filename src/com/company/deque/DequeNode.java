package com.company.deque;

public class DequeNode<T> {

    public DequeNode next;
    public DequeNode prev;
    public T value;

    public DequeNode(DequeNode next, DequeNode prev, T value) {
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    public DequeNode() {
        this.next = null;
        this.prev = null;
        this.value = null;
    }
}
