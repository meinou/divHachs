package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ImageReader {
    private static int byteArrayToInt(byte[] b)
    {
        return   b[3] & 0xFF |
                (b[2] & 0xFF) << 8 |
                (b[1] & 0xFF) << 16 |
                (b[0] & 0xFF) << 24;
    }
    public static void main(String[] args) {
        //C:/Users/mrsle/IdeaProjects/mlfigures/train-images.idx3-ubyte
        if (args.length < 2) {
            System.out.println("Please provide input and output files");
            System.exit(0);
        }

        String inputFile = "C:/Users/mrsle/IdeaProjects/mlfigures/train-images.idx3-ubyte";//args[0];
        String outputFile = "file"; //args[1];

        try {
            Path path = Paths.get(inputFile);
            byte[] fileContents = Files.readAllBytes(path);
            int j = 4;
            int a = 0;
            byte[] rno = new byte[4];
          //  int a = int((fileContents.length - 4)/4);
            int[] output = new int[(fileContents.length - 4)/4];
            while(j < fileContents.length) {
                for (int i = 0; i < 4; i++)
                    rno[i] = fileContents[j + i];
                output[a] = byteArrayToInt(rno);
                System.out.println(output[a]);
                j += 4;
                a++;

            }


            System.out.println(fileContents[8]);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}