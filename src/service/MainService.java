/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.StudentDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import model.Student;

/**
 *
 * @author student
 */
public class MainService {
    
    private String url="jdbc:mysql://localhost/java1pcursultim";
    private Connection con;
    
    private MainService(){
        try{
            con=DriverManager.getConnection(url);
            
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    private static final class SingletonHolder{
        private static final MainService INSTANCE=  new MainService();
    }

public static MainService getInstance(){
    return SingletonHolder.INSTANCE;
}


public List<Student> getAllStudent(){
    StudentDao studentDao = new StudentDao(con);

    try{
        return studentDao.getAllStudent();

    } catch(SQLException e){
        return Collections.emptyList();
    }
}


public boolean adaugaStudent(Student student){
    boolean rez = false;
    StudentDao studentDao = new StudentDao(con);
    try{
        Optional<Student> optionalstudent =
            studentDao.findStudent(student.getCnp());
        if( ! optionalstudent.isPresent()){
            studentDao.adaugaStudent(student);
            rez=true;
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return rez;
}
public void stergeStudent(String Nume){
    StudentDao studentDao=new StudentDao(con);
try{
    studentDao.stergeStudent(Nume);

}catch(SQLException e){
    e.printStackTrace();
}

}

    
}
