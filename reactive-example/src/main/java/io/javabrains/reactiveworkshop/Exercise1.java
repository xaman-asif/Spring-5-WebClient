package io.javabrains.reactiveworkshop;

import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
//        StreamSources.intNumbersStream().forEach(number -> System.out.println(number));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
//        StreamSources.intNumbersStream().filter(number -> number < 5)
//                .forEach(e -> System.out.println(e));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(number -> System.out.println(number));

        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        Integer value = StreamSources.intNumbersStream().filter(number -> number > 5)
                .findFirst()
                .orElse(-1);

        System.out.println(value);

        // Print first names of all users in userStream
        // TODO: Write code here
//        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));
//
//        StreamSources.userStream().map(user -> user.getFirstName())
//                .forEach(userName -> System.out.println(userName));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here
        Set<Integer> setOfIds = StreamSources.intNumbersStream().collect(Collectors.toSet());
        StreamSources.userStream().filter(user -> setOfIds.contains(user.getId()))
                .forEach(user -> System.out.println(user.getFirstName()));
    }

}
