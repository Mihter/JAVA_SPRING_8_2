package com.example.java_spring_8_2.modules;

public interface AppModuleContract
{
    boolean CanBeExecuted(String filePath);
    String GetDescription();
    void Execute(String filePath);
}
