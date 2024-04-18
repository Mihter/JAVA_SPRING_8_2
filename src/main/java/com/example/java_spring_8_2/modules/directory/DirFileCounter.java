package com.example.java_spring_8_2.modules.directory;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class DirFileCounter implements AppModuleContract
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
        return "Gets list of all files in dir";
    }

    @Override
    public void Execute(String filePath)
    {
        File directory = new File(filePath);
        File[] files = directory.listFiles();
        if (files != null)
            for (File file : files)
                if(file.isFile())
                    System.out.println(file.getName());
    }
}
