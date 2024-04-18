package com.example.java_spring_8_2.modules.text;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@Component
public class SymbolCounter implements AppModuleContract {
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        return filePath.endsWith(".txt");
    }

    @Override
    public String GetDescription()
    {
        return "Counts how many symbols in file";
    }

    @Override
    public void Execute(String filePath)
    {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            int count = 0;
            while (reader.read() != -1)
                count++;
            System.out.println("Count of symbols in file: " + count);

        } catch (IOException e) {
            System.out.println("Error with " + e.getMessage());
        }
    }
}
