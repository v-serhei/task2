package com.verbitsky.task2.reader;

import com.verbitsky.task2.exception.SimpleCompositException;

import java.util.List;

public interface DataReader {
    List<String> readDataFromFile(String filePath) throws SimpleCompositException;
}
