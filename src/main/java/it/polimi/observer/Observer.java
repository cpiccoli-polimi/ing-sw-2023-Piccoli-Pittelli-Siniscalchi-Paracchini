package it.polimi.observer;

public interface Observer<T>{
    void update(T message);
}
