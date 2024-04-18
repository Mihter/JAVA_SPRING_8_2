package com.example.java_spring_8_2.modules.mp3;

import com.example.java_spring_8_2.modules.AppModuleContract;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.springframework.stereotype.Component;

import java.io.File;


@Component
public class TrackDurationCounter implements AppModuleContract
{
    @Override
    public boolean CanBeExecuted(String filePath)
    {
        return filePath.endsWith(".mp3");
    }

    @Override
    public String GetDescription()
    {
        return "Counts duration of track";
    }

    @Override
    public void Execute(String filePath)
    {
        File file = new File(filePath);
        try {
            AudioFile track = AudioFileIO.read(file);
            System.out.println("Duration in seconds - " + track.getAudioHeader().getTrackLength());
        } catch (Exception e) {
            System.out.println("Error with " + e.getMessage());
        }
    }
}
