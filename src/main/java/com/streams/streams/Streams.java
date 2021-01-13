package com.streams.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Streams {

    List<User> users = new ArrayList<>();

        public void addUsertoList() {
            User user = new User("Filip", "Sulikowski", 22, List.of("Java", "JavaScript"));
            User user1 = new User("Kuba", "Kowal", 24, List.of("Python", "C#", "Scala"));
            User user2 = new User("Jacek", "Malysz", 14, List.of("Ruby", "JavaScript", "Kotlin"));
            User user3 = new User("Kamil", "Stoch", 44, List.of("Java", "JavaScript", "Docker", "Linux"));
            User user4 = new User("Tomasz", "Benek", 87, List.of("Scala"));

            users.add(user);
            users.add(user1);
            users.add(user2);
            users.add(user3);
            users.add(user4);

        }

        @Test
        public void showAllUsers() {
            addUsertoList();
            users.forEach(System.out::println);

        }

        @Test
        public void showNameAndSkills(){
            addUsertoList();
            users.stream().map(user -> user.getName() + "" + user.getSkills())
            .forEach(System.out::println);

        }

        @Test
        public void showAllSkills(){
            addUsertoList();
            List<String> a = users.stream()
                    .map(User::getSkills)
                    .flatMap(l -> l.stream())
                    .distinct()
                    .collect(Collectors.toList());

            System.out.println(a);
        }

        @Test
        public void showAllSkillsWithAorROnEnd(){
            addUsertoList();
            List<String> a = users.stream()
                    .map(User::getSkills)
                    .flatMap(Collection::stream)
                    .filter(skill -> skill.endsWith("a") || skill.endsWith("r"))
                    .distinct()
                    .collect(Collectors.toList());
            System.out.println(a);

        }




        @Test
        public void showSkillsOfTheYoungestUser(){
            addUsertoList();
            users.stream()
                    .sorted(Comparator.comparing(User::getAge))
                    .limit(1)
                    .map(User::getSkills)
                    .forEach(System.out::println);

        }

        @Test
        public void showNumberOfSkills(){
            addUsertoList();
            Long numer = users.stream()
                    .map(User::getSkills)
                    .flatMap(Collection::stream)
                    .distinct()
                    .count();
            System.out.println(numer);
        }

        @Test
        public void showSkillsOfTheOldestUser(){
            addUsertoList();
            users.stream().max(Comparator.comparing(User::getAge))
                    .ifPresent(user -> user.getSkills().forEach(System.out::println));
        }

        @Test
    public void sumOfUsersAge(){
        addUsertoList();
            int sumOfUserAge = users.stream()
                    .map(User::getAge)
                    .reduce(0, Integer::sum)
                    .intValue();

               System.out.println(sumOfUserAge);
        }

        @Test
    public void showNamesOfUsersLessThanThirty(){
            addUsertoList();
            users.stream()
                    .sorted(Comparator.comparing(User::getAge))
                    .takeWhile(user -> user.getAge()<30)
                    .map(User::getName)
                    .forEach(System.out::println);


        }





}
