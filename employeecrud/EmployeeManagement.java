package com.employeecrud;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class EmployeeManagement {
private static final File Data_file=  new File("E:\\eclipse\\ObjectDemo\\Employee.text");

 private static final List<Employee> em= new ArrayList<>();
  public static  void main(String arg[]) {
	 showEmployeeData();
	  SaveEmployeeData();
	  ReadData();
  }
 
 private static void showEmployeeData() {
	 Scanner sc=new Scanner(System.in);
	 int choice;
	
	 do {
		 System.out.println(" Employee management system : ");
		 System.out.println(" 1 -> Add employee");
		 System.out.println(" 2 -> view all employee");
		 System.out.println(" 3 -> update employee");
		 System.out.println(" 4 -> Search eployee using id");
		 System.out.println(" 5 ->  Exit ");
		 System.out.println(" enter your choice");
		  choice=sc.nextInt();
		    sc.nextLine();
    switch(choice) {
		    
    case 1:
		    	 AddEmployee();
		    	 break;
		    
    case 2 :
		    	ViewEmployee();
		    	break;
		    	
    case 3 :
		    	UpdateEmployee();
		    	break;
		    	
    case 4:
		    	SearchEmployee();
		    	break;
    case 5: 
		    	 SaveEmployeeData();
		    	System.out.println("  employee data saved succesfully...");
		    	break;
		    	
    default :
		   System.out.println("pleas choose correct option ");
   }
		    
 } while(choice!=5);
 }
	 public static void AddEmployee() {
	 Scanner sc=new Scanner(System.in);
	 System.out.println("Enter employee id :");
    int id=sc.nextInt();
	 System.out.println(" Enter the employee name:");		     
    String name =sc.next();
	 System.out.println(" Enter the employee position ");
	 String position =sc.next();
   System.out.println(" Enter  the employee salary");
    double salary=sc.nextDouble();
    
    em.add(new Employee(id,name,position,salary));
	  System.out.println(" data add succefully");       
		     
	 }
	 public static void ViewEmployee() {
		 if(em.isEmpty()) {
			 System.out.println(" no employee found");
		 }
		 else
			 for(Employee emp:em) {
				 System.out.println(emp);
			 }
	 }
	 public static void UpdateEmployee() {
		  Scanner sc=new Scanner(System.in); 
		   System.out.println(" enter id for  update :"); 
		  int id=sc.nextInt();
		   sc.nextLine();
		   boolean found=false;
		    for(Employee emp: em) {
		    	if(emp.getId()==id) {
		    		System.out.println(" Enter employee name for update :");
		    	  String name=sc.next();
		    	System.out.println(" Enter employee position: ");
		    	String position=sc.next();
		   System.out.println(" Enter the employee slary"); 
		  double salary=sc.nextDouble();
		  
		  emp.setName(name);
		  emp.setPosition(position);
		  emp.setSalary(salary);
		    found =true;
		    break;
		    	}
		    }
		    if(found) {
		    	System.out.println(" employe fund with id :"+id);
		    }
		    else
		    {
		    	System.out.println("employee not found with id:"+id);
		    }
	 }
	 public static  void SearchEmployee() {
	  Scanner sc=new Scanner(System.in);
	     int id=sc.nextInt();
	      boolean found =false;
	      for(Employee emp: em) {
	  	   if(emp.getId()==id) {
	     System.out.println(" employee found \n"+emp);
	    	 found =true;   
	  	   }
	      }
	     if (found) {
	    	 System.out.println(" Employee found id with "+id);
	     }
	     else {
	    	 System.out.println(" Employee not found id with"+id);
	     }
		 
		 
	 }
	 public static void ReadData() {
		 System.out.println(" Employee data read from hera");
		 try(BufferedReader rd=new BufferedReader(new FileReader(Data_file))){
	     	String  line;
	     	while((line = rd.readLine())!=null) {
	     		String []data=line.split(",");
	     		int id=Integer.parseInt(data[0]);
	     		String name= data[1];
	     		String position =data[2];
	     	     double salary=Double.parseDouble(data[3]);
	     	     em.add(new Employee(id,name,position,salary));
	     	     
	     	}
			 
		 }catch(FileNotFoundException exe) {
			 System.out.println(" Employee file not found ");
		 }catch(IOException exe) {
			 System.out.println(" Error occured while occured employee data");
		 }
	 }
	  public static  void SaveEmployeeData() {
		try( BufferedWriter wr=new BufferedWriter(new FileWriter(Data_file))){
			 for(Employee emp:em) {
	        wr.write(emp.getId()+"," +emp.getName()
	        +","+emp.getPosition()+","+ emp.getSalary());			 
			wr.newLine();	 
			 }
		} catch(IOException exe) {
	   System.out.println(" error occured while saved employee data");		
		}
		 
	 }
	 
 }
	

