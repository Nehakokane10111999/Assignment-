package student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
public class studentOperations {

	public static void main(String[] args) {
		int STUDENT_NO;
		String STUDENT_NAME;
		LocalDate STUDENT_DOB;
		LocalDate STUDENT_DOJ;
		int year;
		int month;
		int dayOfMonth;
		
		Boolean flag,exit=false;
		Scanner sc=new Scanner(System.in);
		Student s=null;
		List<Student> slist=null;
		StudentDaoImpl simpl=new StudentDaoImpl();
		do {
		System.out.println("What do you want to do? Enter number according to option : ");
		System.out.println("1----> Add Student Details");
		System.out.println("2----> Show All Student");
		System.out.println("3----> Update Student");
		System.out.println("4----> Delete Student");
		System.out.println("5----> Show student by Student no");
		System.out.println("6----> Exit");
		int option=sc.nextInt();
		sc.nextLine();
		
		switch(option) {
		case 1:
			
			System.out.println("Enter Student no : ");
			STUDENT_NO=sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student name : ");
			STUDENT_NAME=sc.nextLine();
			
			System.out.println("Enter year of Birth : ");
			year=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Month of Birth .No. between 1 to 12 only : ");
			month=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter day of Birth. No between 1 to 31 only : ");
			dayOfMonth=sc.nextInt();
			sc.nextLine();
			
			STUDENT_DOB=LocalDate.of(year, month, dayOfMonth);

			System.out.println("Enter year of Join : ");
			year=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter Month of Join .No. between 1 to 12 only : ");
			month=sc.nextInt();
			sc.nextLine();
			
			System.out.println("Enter day of Join. No between 1 to 31 only : ");
			dayOfMonth=sc.nextInt();
			sc.nextLine();
			
			STUDENT_DOJ=LocalDate.of(year, month, dayOfMonth);
			s=new Student();
			s.setSTUDENT_NO(STUDENT_NO);
			s.setSTUDENT_NAME(STUDENT_NAME);
			s.setSTUDENT_DOB(STUDENT_DOB);
			s.setSTUDENT_DOJ(STUDENT_DOJ);
			flag=simpl.addStudent(s);
			if(flag)
			{
				System.out.println("Student Added Successfully....");
			}
			else
			{
				System.out.println("Error while adding Student details....");
			}
			
			break;
		case 2:
			slist=simpl.showAllStudents();
			if(slist!=null && slist.isEmpty()!=true)
			{
				for(Student s1: slist)
				{
					System.out.println(s1);
					System.out.println("---------------------------------------------------------------------------------------------");
					
				}
			}
			else
			{
				System.out.println("No Students in Database....");
			}
			break;
			
		case 3:
			System.out.println("Enter student no to be updated...");
			STUDENT_NO=sc.nextInt();
			sc.nextLine();
			s=simpl.showStudentbyId(STUDENT_NO);
			if(s!=null)
			{
				System.out.println("Your Student Details : \n"+s);
				System.out.println("Are you sure you want to update Student :Ans in yes or no");
				String choice=sc.nextLine();
				if(choice.equals("yes"))
				{
					System.out.println("Enter student Name : ");
					STUDENT_NAME=sc.nextLine();
					System.out.println("Enter year of Birth : ");
					year=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Month of Birth .No. between 1 to 12 only : ");
					month=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter day of Birth. No between 1 to 31 only : ");
					dayOfMonth=sc.nextInt();
					sc.nextLine();
					
					STUDENT_DOB=LocalDate.of(year, month, dayOfMonth);

					System.out.println("Enter year of Join : ");
					year=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Month of Join .No. between 1 to 12 only : ");
					month=sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter day of Join. No between 1 to 31 only : ");
					dayOfMonth=sc.nextInt();
					sc.nextLine();
					
					STUDENT_DOJ=LocalDate.of(year, month, dayOfMonth);
					s=new Student();
					s.setSTUDENT_NO(STUDENT_NO);
					s.setSTUDENT_NAME(STUDENT_NAME);
					s.setSTUDENT_DOB(STUDENT_DOB);
					s.setSTUDENT_DOJ(STUDENT_DOJ);
					flag=simpl.updateStudent(s);
					
					if(flag)
						System.out.println("Student updated successfully");
						
					else
						System.out.println("Error while updating");
				}
					else if(choice.equals("no"))
						System.out.println("Thank You! Plz continue browsing our website");
					else
						System.out.println("Plz give input in yes or no only");
				}
				else
					{
						System.out.println("Plz check the student no given. We do not have any Student with this no.");
					}
			
				break;
			
			case 4:
				System.out.println("Enter Student no to be deleted...");
			STUDENT_NO=sc.nextInt();
			sc.nextLine();
			
			s=simpl.showStudentbyId(STUDENT_NO);
			if(s!=null)
			{
				System.out.println("Your Student Details : \n"+s);
				System.out.println("Are you sure you want to delete Student :Ans in yes or no");
				String choice=sc.nextLine();
				if(choice.equals("yes"))
				{
					flag=simpl.deleteStudent(STUDENT_NO);					
					if(flag)
						System.out.println("Student deleted successfully");
						
					else
						System.out.println("Error while deleteing");
				}
					else if(choice.equals("no"))
						System.out.println("Thank You! Plz continue browsing our website");
					else
						System.out.println("Plz give input in yes or no only");
				}
				else
					{
						System.out.println("Plz check the student no given. We do not have any Student with this no.");
					}
				
				break;
			case 5:
				System.out.println("Enter Student No...");
				STUDENT_NO=sc.nextInt();
				sc.nextLine();
				
				s=simpl.showStudentbyId(STUDENT_NO);
				if(s!=null)
				{
					System.out.println("Your Student Details : \n"+s);
				}
				else
				{
					System.out.println("Plz check the student no given. We do not have any Student with this no.");
				}
				break;
			case 9:
				exit=true;
				System.out.println("*********  Thank You  *********");
				break;
			
		default:
			System.out.println("Plz enter no between given options....\n\n");


			}}while(exit==false);

						}

			

}