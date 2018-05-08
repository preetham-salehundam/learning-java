package com.company.deque;

public interface ICustomStack<T> {

    public int size();

    public boolean isEmpty();

    public DequeNode<T> Pop();

    public DequeNode<T> Push();
}
