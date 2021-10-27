package student;

import java.time.LocalDate;

public class Student {
	int STUDENT_NO;
	String STUDENT_NAME;
	LocalDate STUDENT_DOB;
	LocalDate STUDENT_DOJ;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int STUDENT_NO, String STUDENT_NAME, LocalDate STUDENT_DOB, LocalDate STUDENT_DOJ) {
		super();
		STUDENT_NO = STUDENT_NO;
		STUDENT_NAME = STUDENT_NAME;
		STUDENT_DOB = STUDENT_DOB;
		STUDENT_DOJ = STUDENT_DOJ;
	}
	@Override
	public String toString() {
		return "Student NO=" + STUDENT_NO + "\nSTUDENT NAME=" + STUDENT_NAME + "\nSTUDENT DOB=" + STUDENT_DOB
				+ "\nSTUDENT DOJ=" + STUDENT_DOJ;
	}
	public int getSTUDENT_NO() {
		return STUDENT_NO;
	}
	public void setSTUDENT_NO(int sTUDENT_NO) {
		STUDENT_NO = sTUDENT_NO;
	}
	public String getSTUDENT_NAME() {
		return STUDENT_NAME;
	}
	public void setSTUDENT_NAME(String sTUDENT_NAME) {
		STUDENT_NAME = sTUDENT_NAME;
	}
	public LocalDate getSTUDENT_DOB() {
		return STUDENT_DOB;
	}
	public void setSTUDENT_DOB(LocalDate sTUDENT_DOB) {
		STUDENT_DOB = sTUDENT_DOB;
	}
	public LocalDate getSTUDENT_DOJ() {
		return STUDENT_DOJ;
	}
	public void setSTUDENT_DOJ(LocalDate sTUDENT_DOJ) {
		STUDENT_DOJ = sTUDENT_DOJ;
	}
	

}
