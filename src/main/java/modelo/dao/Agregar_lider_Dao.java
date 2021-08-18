package modelo.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modelo.vo.Agregar_liderVo;
import util.JDBCUtilities;

public class Agregar_lider_Dao {
   Agregar_liderVo ob = new Agregar_liderVo();
     public void requerimiento3(Agregar_liderVo ob1) throws SQLException {
        ob=ob1;
        Connection connection = JDBCUtilities.getConnection();
        try {
         
         String sql="INSERT Into Lider (ID_lider,Nombre,Primer_Apellido,Segundo_Apellido,Salario,Ciudad_Residencia,Cargo ,Clasificacion,Documento_Identidad,Fecha_Nacimiento) values (?,?,?,?,?,?,?,?,?,?)";
           
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ob.getID_Lider());
            stm.setString(2, ob.getNombre());
            stm.setString(3, ob.getPrimer_Apellido());
            stm.setString(4, ob.getSegundo_Apellido());
            stm.setInt(5, ob.getSalario());
            stm.setString(6, ob.getCiudad_Residencia());
            stm.setString(7, ob.getCargo());
            stm.setInt(8, ob.getClasificacion());
            stm.setString(9, ob.getDocumento());
            stm.setString(10, ob.getFecha_nacimiento());
            var res =stm.executeUpdate();
            
            if (res>0){
               JOptionPane.showMessageDialog(null, "Se Inserto un nuevo lider");
            }
            
             
             connection.close();
            } catch (SQLException e) {
               //TODO: handle exception
               System.out.println("Se ha producido el siguiente error:"+e.getMessage());
           }
       
       
     }
}