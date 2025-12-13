package com.t11g02.Sidescroller.model;

import com.t11g02.Sidescroller.model.game.elements.Monster;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool<T> {
    protected final List<T> inUse;
    protected List<T> notInUse;
    protected List<T> removalBuffer;

    public ObjectPool() {
        inUse = new ArrayList<>();
        notInUse = new ArrayList<>();
        removalBuffer = new ArrayList<>();
    }

    public T getNewObject() {
        if (notInUse.isEmpty()){
            return null;
        }
        T obj = notInUse.removeFirst();
        inUse.add(obj);
        return obj;
    }

    public void clearBuffer() {
        for (T obj : removalBuffer) {
            inUse.remove(obj);
            notInUse.add(obj);
        }
        removalBuffer.clear();
    }

    public void addToRemovalBuffer(T obj) {
        removalBuffer.add(obj);
    }

    public List<T> getInUse() {
        return inUse;
    }


}
