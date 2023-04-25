package com.javatechie.map_reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduceExample {

    public static void main(String[] args) {

    	// Map    -> Transfrmng data
    	// Reduce ->  Aggregatng data(combine elemnts of stream & produce single value)
        List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");

        int sum = 0;
        for (int no : numbers) {
            sum = sum + no;
        }
        System.out.println(sum);

        int sum1 = numbers.stream().mapToInt(i -> i).sum();  // gives sum of elements
        System.out.println(sum1);
                                                  // 0 -> initial value  
        Integer reduceSum = numbers.stream().reduce(0, (a, b) -> a + b);  // gives sum of elements
        System.out.println(reduceSum);   

        Optional<Integer> reduceSumWithMethodReference = numbers.stream().reduce(Integer::sum); // gives sum of elements but returns optional
        System.out.println(reduceSumWithMethodReference.get());

        
                                                 // 1 -> initial value
        Integer mulResult = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println(mulResult);

        Integer maxvalue = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxvalue);

        Integer maxvalueWithMethodReference = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxvalueWithMethodReference);


        String longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2)
                .get();
        System.out.println(longestString);

        
        //  EmployeeDatabase.getEmployees() =  List<Employee> 
        //get avg. of employees salary  whose grade A
        //get salary
        double avgSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .average().getAsDouble();

        System.out.println(avgSalary);

        double sumSalary = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getGrade().equalsIgnoreCase("A"))
                .map(employee -> employee.getSalary())
                .mapToDouble(i -> i)
                .sum();
        System.out.println(sumSalary);
    }
}
