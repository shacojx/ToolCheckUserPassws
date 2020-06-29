/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class ReadSourceCode {

    public File folder = new File("D:\\SOURCE_UAT");
    static String temp = "";

    public ArrayList<String> listFile = new ArrayList<>();

    public void listFilesForFolder(final File folder) {
        
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
//                 System.out.println("Reading files under the folder "+folder.getAbsolutePath());
                listFilesForFolder(fileEntry);
            } else {
                if (fileEntry.isFile()) {
                    temp = fileEntry.getName();
                    if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equalsIgnoreCase("png")
                            || (temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equalsIgnoreCase("jpg")
                            || (temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equalsIgnoreCase("swg")) {
//                        System.out.println("File= " + folder.getAbsolutePath() + "\\" + fileEntry.getName());
//                        listFile.add(folder.getAbsolutePath() + "\\" + fileEntry.getName());

                    }else{
                         System.out.println("File= " + folder.getAbsolutePath() + "\\" + fileEntry.getName());
                        listFile.add(folder.getAbsolutePath() + "\\" + fileEntry.getName());
                    }
                }

            }
        }

    }
}
