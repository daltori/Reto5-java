package modelo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.vo.Requerimiento_2Vo;
import util.JDBCUtilities;

public class Requerimiento_2Dao {
    public ArrayList<Requerimiento_2Vo> requerimiento2() throws SQLException {
        ArrayList<Requerimiento_2Vo> r2 = new ArrayList<>();
        Connection connection = JDBCUtilities.getConnection();
        Requerimiento_2Vo objeto = null;
        try {
            String sql="SELECT p.ID_Proyecto, mc.Nombre_Material, mc.Importado FROM Proyecto p JOIN Compra c ON(p.ID_Proyecto=c.iD_Proyecto) JOIN MaterialConstruccion mc ON(c.ID_MaterialConstruccion=mc.ID_MaterialConstruccion) WHERE c.ID_Proyecto IN (1,184,400) ORDER BY p.ID_Proyecto ASC";
            Statement stm = connection.createStatement();
            ResultSet res=stm.executeQuery(sql);
             while (res.next()){
               objeto =  new Requerimiento_2Vo();
               objeto.setID_Proyecto(res.getInt("ID_Proyecto"));
               objeto.setNombre_Material(res.getString("Nombre_Material"));
               objeto.setImportado(res.getString("Importado"));
               r2.add(objeto);
                   

             }
             res.close();
             connection.close();
        } catch (SQLException e) {
            //TODO: handle exception
            System.out.println("Se ha producido el siguiente error:"+e.getMessage());
        }
        return r2;
    }
}