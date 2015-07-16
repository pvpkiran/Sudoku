package com.app.dao;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryStore implements DataStore {
    Map<Long, String> inMemoryStore = new ConcurrentHashMap<>();

    @Override
    public void addToStore(Long id, String sudokuAsString){
        inMemoryStore.put(id, sudokuAsString);
    }

    @Override
    public String getSudoku(Long id){
        return inMemoryStore.get(id);
    }
}
