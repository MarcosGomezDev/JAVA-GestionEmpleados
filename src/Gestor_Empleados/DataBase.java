package Gestor_Empleados;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MGM39434796P
 */
public class DataBase extends Empleado{
    
    public DataBase(){}
    
    public int altas(String codigo, String nombre, String idLocalizacion, String idManager) {
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root",""); 
                String sql = "insert into employees values(?,?,?,?)";
                PreparedStatement sentencia = cn.prepareStatement(sql);
                sentencia.setString (1,codigo);
                sentencia.setString (2,nombre);
                sentencia.setString (3,idLocalizacion);
                sentencia.setString (4,idManager);
                
                i = sentencia.executeUpdate();
                sentencia.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("hola");
        }
        return i;
    }
    
    public String buscar(String codigo){
        int i=0;
        String linea ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root","");
                String sql = "select * from employees where employee_id =?";
                PreparedStatement sentencia = cn.prepareStatement(sql);
                sentencia.setString (1,codigo);
                ResultSet resultado = sentencia.executeQuery();
                while (resultado.next()){
                    linea = linea +("ID Empleado: " + resultado.getString(1) + "\t" + 
                                    "Nombre: " + resultado.getString(2) + "\n" + 
                                    "Localización: " + resultado.getString(3) + "\t" + 
                                    "Encargado: " + resultado.getString(4) + "\n" +
                                    "\n");
                }
                sentencia.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       return linea;
    }
    
    public int modificar(String codigo, String nombre, String idLocalizacion, String idManager){
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root","");
                String sql = "UPDATE employees SET firstName = ?, location_name = ?, manager_name = ? WHERE employee_id = ?";
                PreparedStatement sentencia = cn.prepareStatement(sql);
                sentencia.setString(1,nombre);
                sentencia.setString(2,idLocalizacion);
                sentencia.setString(3,idManager);
                sentencia.setString(4,codigo);
                i = sentencia.executeUpdate();
                sentencia.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
    
    public int borrar(String codigo){
        int i=0;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root","");
                    String sql = "delete from employees Where employee_id=?";
                    PreparedStatement sentencia = cn.prepareStatement(sql);
                    sentencia.setString (1, codigo);
                    i = sentencia.executeUpdate();
                    sentencia.close();
                    cn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        return i;
    }
    
    public void mostrar (javax.swing.JTextArea txtarea){
        int i=0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root","");
                String sql = "select * from employees";
                Statement sentencia = cn.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                txtarea.setText("");
                while (resultado.next()){
                    txtarea.append("ID Empleado: " + resultado.getString(1) + "\t" + 
                                    "Nombre: " + resultado.getString(2) + "\n" + 
                                    "Localización: " + resultado.getString(3) + "\t" + 
                                    "Encargado: " + resultado.getString(4) + "\n" +
                                    "\n");
                }
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String listado (){
        String linea ="";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/gestion_empleados","root","");
                String sql = "select * from employees";
                Statement sentencia =cn.createStatement();
                ResultSet resultado = sentencia.executeQuery(sql);
                while (resultado.next()){
                    linea = linea +("ID Empleado: " + resultado.getString(1) + "\t" + 
                                    "Nombre: " + resultado.getString(2) + "\n" + 
                                    "Localización: " + resultado.getString(3) + "\t" + 
                                    "Encargado: " + resultado.getString(4) + "\n" +
                                    "\n");
                }
                sentencia.close();
                cn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
       return linea;
    }
}
