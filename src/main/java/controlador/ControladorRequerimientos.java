package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.dao.Agregar_lider_Dao;
import modelo.dao.Requerimiento_1Dao;
import modelo.dao.Requerimiento_2Dao;
import modelo.vo.Requerimiento_1Vo;
import modelo.vo.Requerimiento_2Vo;
import vista.VistaRequerimientos;
import modelo.vo.Agregar_liderVo;

public class ControladorRequerimientos {
    // Su código
    private Requerimiento_1Dao requerimiento1;
    private Requerimiento_2Dao requerimiento2;
   

    public ControladorRequerimientos() {
       this.requerimiento1 = new Requerimiento_1Dao();
       this.requerimiento2 = new Requerimiento_2Dao();
       
    }

    public ArrayList<Requerimiento_1Vo> consultarRequerimiento1() throws SQLException {
       return this.requerimiento1.requerimiento1();
    }


    public ArrayList<Requerimiento_2Vo> consultarRequerimiento2() throws SQLException {
        return this.requerimiento2.requerimiento2();
    }
    
    public void consultarlider(Agregar_liderVo ob) throws SQLException {
        Agregar_lider_Dao dao =new Agregar_lider_Dao();
        dao.requerimiento3(ob);
        
    }

    public void mostrarventana(){
        VistaRequerimientos formulario = new VistaRequerimientos();
         formulario.setBounds(50, 50, 800, 525);
         formulario.setResizable(false);
         formulario.setTitle("David Alejandro Torres || Reto 5");
         formulario.setVisible(true);
         formulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}   
