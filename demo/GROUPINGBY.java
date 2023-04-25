
public class GROUPINGBY {
	
}


 // 2nd highest Number frpm duplicate  and 2nd highest Salary

// numbers.stream().distinct().sorted(Comparator.reverseOrder())
//.skip(1).findFirst().get();

//Optional<Employee> emp = employeeList.stream()
//.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst().get();


	List<Employee> emp = new ArrayList<>();  
    emp.add(new Employee("Dipak", "Delhi", 21));  
    emp.add(new Employee("Sumit", "Delhi", 21));  
    emp.add(new Employee("Karan", "Delhi", 23));  
    emp.add(new Employee("Mona", "Udaipur", 23));  
    emp.add(new Employee("Rajesh", "Banglore", 23));  
    emp.add(new Employee("Niraj", "Banglore", 31));       
    
    /* Group by Employees by city before Java 8 world */     
    
    Map<String,List<Employee>> EmpByCity = new HashMap<>();  
      
    for(Employee p : emp)  
    {  
        if(!EmpByCity.containsKey(p.getCity()))  
        {  
            EmpByCity.put(p.getCity(), new ArrayList<>());                  
        }  
        EmpByCity.get(p.getCity()).add(p);  
    }  
    System.out.println("Employees grouped by cities before Java 8 : " + EmpByCity);        
    /* group objects of Employee class in Java 8 */  
    EmpByCity =  emp.stream().collect(Collectors.groupingBy(Employee::getCity));  
    System.out.println("Employees grouped by cities in Java 8: " + EmpByCity);  
    /* group Employees by age */  
    Map<Integer,List<Employee>> EmpByAge = emp.stream().collect(Collectors.groupingBy(Employee::getAge));  
    System.out.println("Employees grouped by age in Java 8: " + EmpByAge);  
    
//    OUTPUT -> 
//    
// Employees grouped by cities before Java 8 : {Delhi=[Dipak(Delhi,21), Sumit(Delhi,21), Karan(Delhi,23)], Banglore=[Rajesh(Banglore,23), Niraj(Banglore,31)], Udaipur=[Mona(Udaipur,23)]}
    
// Employees grouped by cities in Java 8: {Delhi=[Dipak(Delhi,21), Sumit(Delhi,21), Karan(Delhi,23)], Banglore=[Rajesh(Banglore,23), Niraj(Banglore,31)], Udaipur=[Mona(Udaipur,23)]}
    
// Employees grouped by age in Java 8: {21=[Dipak(Delhi,21), Sumit(Delhi,21)], 23=[Karan(Delhi,23), Mona(Udaipur,23), Rajesh(Banglore,23)], 31=[Niraj(Banglore,31)]}
//    
    class Employee  
    {  
        private String name;  
        private String city;  
        private int age;  
        public Employee(String name, String city, int age)   
        {  
            this.name = name;  
            this.city = city;  
            this.age = age;  
        }  
        public String getName() {  
            return name;  
        }  
        public void setName(String name) {  
            this.name = name;  
        }  
        public String getCity() {  
            return city;  
        }  
        public void setCity(String city) {  
            this.city = city;  
        }  
        public int getAge() {  
            return age;  
        }  
        public void setAge(int age) {  
            this.age = age;  
        }  
}
