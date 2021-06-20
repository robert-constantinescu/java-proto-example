package com.example;

import example.enumerations.EnumExample;
import example.enumerations.EnumExample.EnumMessage;

public class EnumMain {

    public static void main(String[] args) {

        System.out.println("Enum example in java");

        EnumMessage.Builder builder = EnumMessage.newBuilder();

        builder.setId(345);

        builder.setDayOfTheWeek(EnumExample.DayOfTheWeek.SUNDAY);

        EnumMessage message = builder.build();

        System.out.println(message);
    }
}
