package com.example.java_spring_8_2;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ExitCodeEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.example.java_spring_8_2")//объединяет несколько других аннотаций и служит точкой входа для приложения Spring Boot
//сканирует указаный пакет с их свойствами и зависимостями

public class App
{
    private static List<AppModuleContract> modules;

    @Autowired//указывает вставить свойство из контекста
    public App(List<AppModuleContract> modules)
    {
        App.modules = modules;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
        main2(args);
    }
    public static void main2(String[] args)
    {
        var scanner = new Scanner(System.in);
        System.out.print("Enter path to file(or enter C to exit): ");
        String filePath = scanner.nextLine();
        if (filePath.equals("C"))
        {
            System.out.println("Bye");
            return;
        }

        File file = new File(filePath);

        if (!file.exists())
        {
            System.out.println("File does not exist");
            return;
        }

        var allAppModules = new ArrayList<AppModuleContract>();
        for (var module : modules)
        {
            if (module.CanBeExecuted(filePath))
            {
                allAppModules.add(module);
            }
        }

        System.out.println("All functions of modules:");
        for (int i = 0; i < allAppModules.size(); i++)
        {
            System.out.println(i + " " + allAppModules.get(i).GetDescription());
        }
        //Integer.valueOf(i).toString()
        System.out.print("Enter needed function:");
        allAppModules.get(scanner.nextInt()).Execute(filePath);
        main2(args);
    }

}
