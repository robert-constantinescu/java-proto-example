package com.example;

import example.simple.Simple;
import example.simple.Simple.SimpleMessage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;

public class SimpleMain {

    public static void main(String[] args) {
        System.out.println("Hello Proto-World");

        SimpleMessage.Builder builder = SimpleMessage.newBuilder();

        //setting the simple.proto properties
        builder.setId(42);
        builder.setIsSimple(true);
        builder.setName("Simple message name");

        builder.setId(42)
                .setIsSimple(true)
                .setName("Simple Message Object Name created by chaining methods");


        //setting repeated fields
        builder.addSampleList(1);
        builder.addSampleList(2);
        builder.addAllSampleList(Arrays.asList(4, 5, 6));

        System.out.println(builder);
        builder.clearSampleList();


        //methods can also be chained
        builder.addSampleList(1)
                .addSampleList(2)
                .addAllSampleList(Arrays.asList(4, 5, 6));

        // This will replace the element at index 4. Index can't be higher than the list length. index < list.size()
        builder.setSampleList(4, 99);
        System.out.println(builder);

        //after the message is build we can only read it's properties and not set them anymore
        SimpleMessage message = builder.build();

        // write the protocol buffer binary, to a binary file (.bin)
        try {
            FileOutputStream outputStream = new FileOutputStream("simple_message.bin");
            message.writeTo(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // send as byte array to a network
        byte[] bytes = message.toByteArray();

        System.out.println("Reading from file .......\n");
        try {
            FileInputStream inputStream = new FileInputStream("simple_message.bin");
            SimpleMessage messageFromFile = SimpleMessage.parseFrom(inputStream);
            System.out.println(messageFromFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
