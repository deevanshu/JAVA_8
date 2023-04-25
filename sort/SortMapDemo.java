package com.javatechie.stream.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.javatechie.stream.api.example.Employee;

public class SortMapDemo {

	public static void main(String[] args) {

		Map<String, Integer> map = new HashMap<>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary()));
		
		
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);

		System.out.println(employeeMap);

		List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));    // Ascending Sorting By Key 
		Collections.sort(entries, (o1, o2) -> o2.getKey().compareTo(o1.getKey()));    // Descending Sorting By Key 
		
		Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));  // Ascending Sorting By Value 
		Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));  // Descending Sorting By Value 
		/*
		 * for (Entry<String, Integer> entry : entries) {
		 * System.out.println(entry.getKey() + "   " + entry.getValue()); }
		 */

		 map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);             // Ascending Sorting By Key
		 map.entrySet().stream().sorted(Map.Entry.comparingByKey().reversed()).forEach(System.out::println);  // Descending Sorting By Key
		 
		 map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);             // Ascending Sorting By Value
		 map.entrySet().stream().sorted(Map.Entry.comparingByValue().reversed()).forEach(System.out::println);  // Descending Sorting By Value
		 
		 
		 
		 Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())); // Ascending Sorting 
		 Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o2.getSalary() - o1.getSalary())); // Descending Sorting
		 
		 
		 
		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept)))       // Ascending Sorting Custom obj as key 
				.forEach(System.out::println);
		
		employeeMap.entrySet().stream()
		.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getDept).reversed()))    // Descending Sorting Custom obj as key 
		.forEach(System.out::println);

	}
}
