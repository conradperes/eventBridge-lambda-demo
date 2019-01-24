package sparta.planosaude.lambda.dao;

import java.util.Collection;

import sparta.planosaude.lambda.entity.Student;

public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudentToDb(Student student);
}
