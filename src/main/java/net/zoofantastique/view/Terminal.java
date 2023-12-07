package net.zoofantastique.view;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

public class Terminal {
    private Process process;
    private PrintWriter writer;

    public Terminal() {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder processBuilder;

        if (os.contains("win")) {
            processBuilder = new ProcessBuilder("cmd.exe");
        } else if (os.contains("nix") || os.contains("mac")) {
            processBuilder = new ProcessBuilder("/bin/bash");
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }

        try {
            process = processBuilder.start();
            OutputStream outputStream = process.getOutputStream();
            writer = new PrintWriter(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        writer.println(message);
        writer.flush();
    }
}