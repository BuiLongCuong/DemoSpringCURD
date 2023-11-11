package app.service;

import app.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IService<Student>{
    List<Student> studentList = new ArrayList<>();

    public StudentService() {
        studentList.add(new Student(1,"Linh"));
        studentList.add(new Student(2,"Toàn"));
    }

    @Override
    public void add(Student student) {
        studentList.add(student);
    }

    @Override
    public Student findStudentById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public int findById(int id) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                return student.getId();
            }
        }
        return -1;
    }

    @Override
    public void delete(int id) {
        int index = findById(id);
        if(index != -1 ){
            studentList.remove(id);
        } else {
            System.out.println("Không có học sinh đó!");
        }
    }

    @Override
    public void update(int id, Student student) {
        int index = findById(id);
        if(index != -1 ){
            studentList.set(index,student);
        } else {
            System.out.println("Không có học sinh đó!");
        }
    }

    @Override
    public List findAll() {
       return this.studentList;
    }

//    @Override
//    public List<Student> findByName(String nameOut) {
//        List<Student> list = new ArrayList<>();
//        String sql = "select s.id, s.name, s.email, s.birthday, s.address,c.name as className\n" +
//                "from student s\n" +
//                "         join classroom c on c.id = s.classId\n" +
//                "where s.name like ? and s.deleteflag = 0;";
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1,'%' +nameOut+ '%');
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String email = resultSet.getString("email");
//                LocalDate birthday = resultSet.getDate("birthday").toLocalDate();
//                String address = resultSet.getString("address");
////                int classId = resultSet.getInt("classId");
//                String className = resultSet.getString("className");
//                Student student = new Student(id,name,email,birthday,address,className);
//                list.add(student);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        return list;
//    }
}
