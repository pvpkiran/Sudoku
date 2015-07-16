package com.app.dao;

import org.springframework.stereotype.Component;

@Component
public interface DataStore {
    void addToStore(Long id, String sudokuAsString);
    String getSudoku(Long id);
}
