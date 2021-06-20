package com.example;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import example.simple.Simple;

import java.util.Arrays;

public class ProtoToJSONMain {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        System.out.println("Hello To Json");

        Simple.SimpleMessage.Builder builder = Simple.SimpleMessage.newBuilder();

        builder.setId(42)
                .setIsSimple(true)
                .setName("Simple Message Object Name created by chaining methods");

        builder.addAllSampleList(Arrays.asList(4, 5, 6));

        //Print the message as JSON
        String jsonString = JsonFormat.printer()
                    //other methods can by chained on the printer() to configure some options
                    .print(builder);
        System.out.println(jsonString);


        //convert back to a proto buffer file from JSON
        Simple.SimpleMessage.Builder builder2 = Simple.SimpleMessage.newBuilder();
        JsonFormat.parser()
                .merge(jsonString, builder2);

        System.out.println(builder2);


    }
}
