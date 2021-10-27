package student;

import java.util.List;


public interface StudentDAO {
	public boolean addStudent(Student s); //we can give any return type
	public boolean updateStudent(Student s);  //we can change the name of movie using this
	public boolean deleteStudent(int STUDENT_NO);  //to delete movie wrt id
	public List<Student> showAllStudents();
	public Student showStudentbyId(int sTUDENT_NO);


}

