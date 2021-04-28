package com.company.fileworker;

import java.io.*;

public class FileWorker {
    private String path;

    public FileWorker(String path){
        this.path=path;
    }

    public void writeInFile(String data, boolean bool) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, bool))) {
            writer.write(data);
            writer.append("\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void readFromFile(String data, boolean bool) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String string;
            StringBuffer fileData= new StringBuffer();
            while((string=reader.readLine()) !=null){
                fileData.append(string).append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
