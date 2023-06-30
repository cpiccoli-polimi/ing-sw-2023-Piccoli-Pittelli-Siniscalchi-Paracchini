package it.polimi.observer;

/**
 * @param <T> the thread
 * @author Lorenzo Pittelli
 */
public interface Observer<T>{
    void update(T message);
}
