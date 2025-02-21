package com.example.paymentmethod1;

import java.io.FileWriter;
import java.io.IOException;

public class ReceiptSaver {
    public static void saveReceiptToFile(String receipt, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(receipt);
            System.out.println("Kvittering gemt som: " + fileName);
        } catch (IOException e) {
            System.out.println("Fejl under gemning af kvittering: " + e.getMessage());
        }
    }
}