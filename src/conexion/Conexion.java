/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import entidades.Login;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author awelo
 */
public class Conexion {
    private final String usuario="root";
    private final String password="awelo";
    private final String url="jdbc:mysql://localhost:3306/proyecto_javita";
    private Connection con=null;
    
    public Connection conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con =(Connection)DriverManager.getConnection(url,usuario,password);
            System.out.println("Se conecto correctamente");
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Error en la conexion"+e);
        }
        return con;
    }
    
    public int validar(Login login){
        ResultSet obtener=null;
        String ID=login.getID();
        String contra=login.getPassword();
        int valido=0;
        try{
            String sql="SELECT idempleados FROM proyecto_javita.empleados where idEmpleados="+ID;
            conectar();
            Statement statement= con.createStatement();
            
            ResultSet result=statement.executeQuery(sql);
            if(result!=null){
                
            }
            System.out.println("Se conecto correctamente");
        } catch(Exception e){
            System.out.println("Error en la conexion "+e);
        }
        return valido;
    }
    
}
