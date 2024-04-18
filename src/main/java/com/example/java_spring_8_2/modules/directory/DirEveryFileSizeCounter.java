package com.example.java_spring_8_2.modules.directory;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.stereotype.Component;

import java.io.File;


@Component//класс является частью компонентов приложения
public class DirEveryFileSizeCounter implements AppModuleContract
{
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        File fileSystemElement = new File(filePath);
        return fileSystemElement.isDirectory();
    }


    @Override
    public String GetDescription()
    {
        return null;
    }

    @Override
    public void Execute(String filePath)
    {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        long size = 0;
        if (files != null)
            for (File file : files)
                if(file.isFile())
                    size+= file.length();

        System.out.println("Size is " + size);
    }
}