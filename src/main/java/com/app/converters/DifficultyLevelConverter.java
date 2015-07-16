package com.app.converters;

import com.app.pojo.DifficultyLevel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DifficultyLevelConverter implements Converter<String, DifficultyLevel> {

    @Override
    public DifficultyLevel convert(String difLevel) {
        switch(difLevel){
            case "1": return DifficultyLevel.EASY;
            case "2": return DifficultyLevel.MEDIUM;
            case "3": return DifficultyLevel.HARD;
            default: throw new RuntimeException("Invalid Difficulty Level");
        }
    }
}