package com.example.java_spring_8_2.modules.image;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


@Component
public class ImageGifConverter implements AppModuleContract
{
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        return filePath.endsWith(".jpg");
    }

    @Override
    public String GetDescription()
    {
        return "Converts file into gif";
    }

    @Override
    public void Execute(String filePath)
    {
        var file = new File(filePath);
        try {
            var image = ImageIO.read(file);
            ImageIO.write(image, "png", new File(filePath.replaceAll(".jpg", ".gif")));
            System.out.println("Converted");
        } catch (IOException e) {
            System.out.println("Error with " + e.getMessage());
        }
    }
}
