package sparta.planosaude.lambda.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sparta.planosaude.lambda.entity.Student;

@Repository("mysql")
public class MySqlStudentDaoImpl implements StudentDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;

//	private static class StudentRowMapper implements RowMapper<Student> {
//
//		@Override
//		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Student student = new Student();
//			student.setId(rs.getInt("id"));
//			student.setName(rs.getString("name"));
//			student.setCourse(rs.getString("course"));
//			return student;
//		}
//
//	}

	@Override
	public Collection<Student> getAllStudents() {
		System.out.println("AWS Lambda Java 8 RDS Super Power\n");
		List<Student> students =  new ArrayList<Student>();
		String currentTime = "unavailable";
		try {

			String endpoint = System.getenv("RDS_MYSQL_ENDPOINT");
			String port = System.getenv("RDS_MYSQL_PORT");
			String username = System.getenv("RDS_MYSQL_USERNAME");
			String password = System.getenv("RDS_MYSQL_PASSWORD");;
			String dbName = System.getenv("RDS_MYSQL_DB_NAME");
			System.out.println("PORT:"+port);

			Connection conn = DriverManager.getConnection("jdbc:mysql://"+ endpoint + ":" + port + "/" + dbName + "?useSSL=false", username, password);
			System.out.println("A Conexão esta fecada?"+conn.isClosed());
			Statement stmt = conn.createStatement();
			final String sql = "SELECT ID, NAME, COURSE FROM STUDENTS";

			ResultSet resultSet = stmt.executeQuery(sql);

			if (resultSet.next()) {
				Student s = new Student();
				s.setName(resultSet.getString("name"));
				s.setCourse( resultSet.getString("course"));
			}

			System.out.println("Succeeded! Result: " + currentTime + "\n");


		} catch (SQLException e) {
			System.out.println("Caught Exception: " + e.getMessage() + "\n");
		}
		//final String sql = "SELECT ID, NAME, COURSE FROM STUDENTS";
		//List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return students;
	}

	@Override
	public Student getStudentById(int id) {
//		final String sql = "SELECT ID, NAME, COURSE FROM STUDENTS WHERE ID = ?";
//		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
//		return student;
		return null;
	}

	@Override
	public void removeStudentById(int id) {
//		final String sql = "DELETE FROM STUDENTS WHERE ID = ?";
//		jdbcTemplate.update(sql, id);

	}

	@Override
	public void updateStudent(Student student) {
//		final String sql = "UPDATE STUDENTS SET name = ? , course = ?  WHERE ID = ?";
//		int id = student.getId();
//		String name = student.getName();
//		String course = student.getCourse();
//		jdbcTemplate.update(sql, new Object[] { name, course, id });

	}

	@Override
	public void insertStudentToDb(Student student) {
//		final String sql = "INSERT INTO STUDENTS (NAME, COURSE) VALUES( ? , ? )";
//		String name = student.getName();
//		String course = student.getCourse();
//		jdbcTemplate.update(sql, new Object[] { name, course });

	}

}
