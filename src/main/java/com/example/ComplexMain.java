package com.example;

import example.complex.Complex;
import example.complex.Complex.ComplexMessage;
import example.complex.Complex.DummyMessage;

import java.util.Arrays;

public class ComplexMain {

    public static void main(String[] args) {

        System.out.println("Complex Example");

        DummyMessage oneDummy = newDummyMessage(55, "first dummy message");

        ComplexMessage.Builder builder = ComplexMessage.newBuilder();

        //singular field
        builder.setOneDummy(oneDummy);

        //repeated field
        builder.addMultipleDummy(newDummyMessage(11, "second dummy"));
        builder.addMultipleDummy(newDummyMessage(22, "third dummy"));

        builder.addAllMultipleDummy(Arrays.asList(newDummyMessage(33, "third dummy"), newDummyMessage(44, "fourth dummy")));


        //created the complex message
        ComplexMessage message = builder.build();

        System.out.println(message.toString());

    }

    public static DummyMessage newDummyMessage(Integer id, String name) {

        DummyMessage.Builder dummyMessageBuilder = DummyMessage.newBuilder();

        DummyMessage message = dummyMessageBuilder.setName("Name of the message ")
                .setId(52)
                .build();

        return message;
    }
}
