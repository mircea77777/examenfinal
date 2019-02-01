/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import model.Student;

/**
 *
 * @author student
 */
public class StudentDao {
    
    private Connection con;

    public StudentDao(Connection con) {
        this.con = con;
    }
    
    
    public List<Student> getAllStudent() throws SQLException{
        
        String sql = "SELECT *FROM studenti";
        List <Student>  studenti=null;
        try (PreparedStatement stmt = con.prepareStatement(sql)){
           studenti=new ArrayList<>();
           ResultSet rs = stmt.executeQuery();

           while(rs.next()){
               int id = rs.getInt("id");
               String Nume=rs.getString("Nume");
               String Prenume=rs.getString("Prenume");
               int  cnp=rs.getInt("cnp");
               Student student=new Student(id,Nume,Prenume,cnp);
               studenti.add(student);
           }
       }
       return studenti;
    }
    
    
    
    public void adaugaStudent(Student s) throws SQLException{
        String sql="INSERT INTO studenti VALUES(?,?,?,)";
        try(PreparedStatement stmt=con.prepareStatement(sql)){
            stmt.setInt(1,s.getId());
            stmt.setString(1,s.getNume());
            stmt.setString(1,s.getPrenume());
            stmt.setInt(1,s.getCnp());
            stmt.executeUpdate();
//            if(rs.next()){
//            Student student=new Student();
//            student.setId(rs.getInt("id"));
//            student.setNume(rs.getString("Nume"));
//            student.setPrenume(rs.getString("Prenume"));
//            student.setId(rs.getInt("cnp"));
            
            }
    }  
            public void stergeStudent(String Nume)throws SQLException{
                String sql="SELECT FROM studenti WHERE  Nume=?";
                try(PreparedStatement stmt=con.prepareStatement(sql)){
                    stmt.setString(1,Nume);
                    stmt.executeUpdate();
                
                }
            
            
            }

    public Optional<Student> findStudent(int cnp) {
        return null;
    }
       
    
}
