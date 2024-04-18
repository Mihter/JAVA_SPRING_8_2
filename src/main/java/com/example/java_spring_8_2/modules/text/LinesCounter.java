package com.example.java_spring_8_2.modules.text;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


@Component
public class LinesCounter implements AppModuleContract
{
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        return filePath.endsWith(".txt");
    }

    @Override
    public String GetDescription()
    {
        return "Counts lines in txt file";
    }

    @Override
    public void Execute(String filePath)
    {
        File file = new File(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println("Lines in file - " + reader.lines().count());
        } catch (IOException e) {
            System.out.println("Error with - " + e.getMessage());
        }
    }
}
