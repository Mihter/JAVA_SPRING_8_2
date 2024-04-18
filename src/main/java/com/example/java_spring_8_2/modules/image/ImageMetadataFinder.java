package com.example.java_spring_8_2.modules.image;

import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.example.java_spring_8_2.modules.AppModuleContract;

import java.io.File;
import java.io.IOException;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Component;


@Component
public class ImageMetadataFinder implements AppModuleContract
{
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        return filePath.endsWith(".jpg");
    }

    @Override
    public String GetDescription()
    {
        return "Gets exif metadata of image";
    }

    @Override
    public void Execute(String filePath)
    {
        File file = new File(filePath);
        try {
            ExifSubIFDDirectory directory = ImageMetadataReader.
                    readMetadata(file).
                    getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            if (directory != null)
                for (Tag tag : directory.getTags())
                    System.out.println(tag.getTagName() + " and " + tag.getDescription());
            else
                System.out.println("No exif metadata");

        } catch (ImageProcessingException | IOException e) {
            System.out.println("Error with " + e.getMessage());
        }
    }
}
