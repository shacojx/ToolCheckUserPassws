
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
//    public static void check(ArrayList<String> ContextFile) {
//        boolean checkup = false;
//        int line = 0;
//        String code_line = null;
//        for (int i = 0; i < ContextFile.size(); i++) {
//            checkup = false;
//            line = 0;
//            code_line = null;
//            if (ContextFile.get(i).contains("user") || ContextFile.get(i).contains("pass")
//                    || ContextFile.get(i).contains("pwd") || ContextFile.get(i).contains("tài khoản") || ContextFile.contains("mật khẩu")) {
//                checkup = true;
//                line = i + 1;
//                code_line = ContextFile.get(i);
//                if (checkup = true) {
//                    System.out.println("------------- Find user pass done ---------------------");
//                    System.out.println("Code: " + code_line);
//                    System.out.println("Line: " + line);
//                    System.out.println("-------------------------------------------------------");
//
//                } else {
//                    System.out.println("Not find user password");
//                }
//            }
//
//        }
//    }

    public static void main(String[] args) throws IOException {
        ReadSourceCode RSC = new ReadSourceCode();
        RSC.listFilesForFolder(RSC.folder);

        FileWriter writer = new FileWriter("LogUserPasswd.txt", true);

        for (String file : RSC.listFile) {
            ArrayList<String> ContextFile = new ArrayList<>();
            try (FileReader reader = new FileReader(file);
                    BufferedReader br = new BufferedReader(reader)) {

                // read line by line
                String line;
                while ((line = br.readLine()) != null) {
                    ContextFile.add(line);
                }
                System.out.println("============= File name:" + file + " ======================");
                writer.write("============= File name:" + file + " ====================== \n");
//                check(ContextFile);
//===============================================
                boolean checkup = false;
                int line_code = 0;
                String code_line = null;
                for (int i = 0; i < ContextFile.size(); i++) {
                    checkup = false;
                    line_code = 0;
                    code_line = null;
                    if (ContextFile.get(i).contains("user") || ContextFile.get(i).contains("pass")
                            || ContextFile.get(i).contains("pwd") || ContextFile.get(i).contains("tài khoản") || ContextFile.contains("mật khẩu")) {
                        checkup = true;
                        line_code = i + 1;
                        code_line = ContextFile.get(i);
                        if (checkup = true) {
                            System.out.println("------------- Find user pass done ---------------------");
                            System.out.println("Code: " + code_line);
                            System.out.println("Line: " + line_code);
                            System.out.println("-------------------------------------------------------");
                            writer.write("------------- Find user pass done --------------------- \n");
                            writer.write("Code: " + code_line+"\n");
                            writer.write("Line: " + line_code+"\n");
                            writer.write("-------------------------------------------------------\n");
                        } else {
                            System.out.println("Not find user password");
                        }
                    }

                }

//==============================
            } catch (IOException e) {
                System.err.format("IOException: %s%n", e);
            }
        }

    }

}
