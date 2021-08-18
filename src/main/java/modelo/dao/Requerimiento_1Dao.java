package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_1Vo;
import util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento_1Vo> requerimiento1() throws SQLException {
        ArrayList<Requerimiento_1Vo> r1 = new ArrayList<>();
        Connection connection = JDBCUtilities.getConnection();
        Requerimiento_1Vo objeto = null;
        try {
            String sql="SELECT ID_Lider ,Salario,Ciudad_Residencia  FROM Lider l WHERE Ciudad_Residencia = 'Barranquilla' AND Salario > 1071 ORDER BY Salario ASC";
            Statement stm = connection.createStatement();
            ResultSet res=stm.executeQuery(sql);
             while (res.next()){
               objeto =  new Requerimiento_1Vo();
               objeto.setID_Lider(res.getInt("ID_Lider"));
               objeto.setSalario(res.getInt("Salario"));
               objeto.setCiudad_Residencia(res.getString("Ciudad_Residencia"));
               r1.add(objeto);
                   

             }
             res.close();
             connection.close();
        } catch (SQLException e) {
            //TODO: handle exception
            System.out.println("Se ha producido el siguiente error:"+e.getMessage());
        }
        return r1;
    }
}