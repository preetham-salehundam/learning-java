package com.company.deque;

public interface ICustomDeque<T> {
    public int size();

    public boolean isEmpty();

    public void insertFirst(DequeNode<T> element);

    public void insertLast(DequeNode<T> element);

    public void removeFirst(DequeNode<T> element);

    public void removeLast(DequeNode<T> element);

    public void display();
}
