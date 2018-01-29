package me.tylergrissom.yamlstats;

import java.io.*;
import java.util.Scanner;

/**
 * Copyright (c) 2013-2018 Tyler Grissom
 */
public class YSApp {

    private Scanner scanner;

    public YSApp() {
        this.scanner = new Scanner(System.in);
    }

    public void log(Object obj) {
        System.out.println(obj);
    }

    public int count(File file) {
        if (file == null) throw new IllegalArgumentException("File path is invalid.");

        int count = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files == null) return 0;

            for (File inner :
                    files) {
                count += count(inner);
            }

            return count;
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.trim().equals(line)) count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public int count(String path) {
        return count(new File(path));
    }

    public void run() {
        log("Please enter the absolute path you would like to scan: ");

        String path = scanner.next();
        File file = new File(path);

        int count = count(file);

        System.out.println("Found a total of " + count + " root entries in the specified path.");
    }
}
