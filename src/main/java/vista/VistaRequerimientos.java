package vista;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import controlador.ControladorRequerimientos;
import modelo.vo.Agregar_liderVo;
import modelo.vo.Requerimiento_1Vo; 
import modelo.vo.Requerimiento_2Vo; 

public class VistaRequerimientos  extends JFrame implements ActionListener {
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();
    private JButton boton1,boton2,boton3;
    private JSeparator separador ;
    private JLabel label[] =new JLabel[10];
    private JLabel labeltitulo, label1;
    private JTable tabla;
    private JScrollPane scrollPanel;
    private JTextField input[] = new  JTextField[10];
    Agregar_liderVo ob = new Agregar_liderVo();
    
    
    
   public VistaRequerimientos(){
    setLayout(null);
        separador= new JSeparator(SwingConstants.VERTICAL);
        separador.setBounds(450, 10, 1, 460);
        separador.setForeground(Color.GRAY);
        add(separador);
        label1= new JLabel("imagen");
        label1.setIcon(new ImageIcon(getClass().getResource("imagen.png")));
        label1.setBounds(125, 320, 200, 200);
        add(label1);
        labeltitulo=new JLabel("Reto 5");
        labeltitulo.setFont(new Font ("arial",Font.BOLD,40));
        labeltitulo.setBounds(160, 1, 200, 100);
        add(labeltitulo);
        boton1 = new JButton("Consulta 1") ;
        boton1.setBounds(20, 100, 120, 30);
        add(boton1);
        boton1.addActionListener(this);
        boton2 = new JButton("Consulta 2");
        boton2.setBounds(160, 100, 120, 30);
        add(boton2);
        boton2.addActionListener(this);
        boton3 = new JButton("Agregar lider");
        boton3.setBounds(300, 100, 120, 30);
        add(boton3); 
        boton3.addActionListener(this);   
        for (int i=0; i < 10 ;i++){
             label[i]=new JLabel();
             input[i]=new JTextField();
             input[i].setBounds(620, 40+i*40, 100, 20);
            add(input[i]);

        }
        label[0].setText("ID_Lider");
        label[1].setText("Nombre");
        label[2].setText("Primer Apellido");
        label[3].setText("Segundo Apellido");
        label[4].setText("Salario");
        label[5].setText("Ciudad Residencia");
        label[6].setText("Cargo");
        label[7].setText("Clasificacion");
        label[8].setText("Documento Identidad");
        label[9].setText("Fecha  Nacimiento");      
        for (int i=0; i < 10 ;i++){
            label[i].setBounds(480, 40+i*40, 150, 20);
            add(label[i]);
       }
       tabla= new JTable();
       scrollPanel= new JScrollPane();
       scrollPanel.setBounds(20, 150, 410, 220);
       scrollPanel.setViewportView(tabla);
       add(scrollPanel);



   }
@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == boton1){
        
        try {
      String s1 [] = new String[3];
      s1[0]= "Id_Lider";
      s1[1]= "Salario";
      s1[2]= "Ciudad";

      ArrayList<Requerimiento_1Vo> r1= controlador.consultarRequerimiento1();
      String matriz[][] = new String [r1.size()][3];
            for(int i=0; i < r1.size();i++){
                        matriz[i][0]= (r1.get(i).getID_Lider()+"");
                        matriz[i][1]= (r1.get(i).getSalario()+"");
                        matriz[i][2]= (r1.get(i).getCiudad_Residencia());  
                        }
    
       Modelo_tabla M1 = new Modelo_tabla(matriz,s1);
       tabla.setModel(M1);
      
                    } catch (Exception e1) {
                        System.out.println("Se ha producido el siguiente error:" + e1.getMessage());
                        e1.printStackTrace();
                    }
    }
    
    if (e.getSource() == boton2){
       try {
     String s1 [] = new String[3];
     s1[0]= "Id_Proyecto";
     s1[1]= "Nombre Material";
     s1[2]= "Importado";

     ArrayList<Requerimiento_2Vo> r2= controlador.consultarRequerimiento2();
     String matriz[][] = new String [r2.size()][3];
           for(int i=0; i < r2.size();i++){
                       matriz[i][0]= (r2.get(i).getID_Proyecto()+"");
                       matriz[i][1]= (r2.get(i).getNombre_Material());
                       matriz[i][2]= (r2.get(i).getImportado());  
                       }
   
      Modelo_tabla M1 = new Modelo_tabla(matriz,s1);
      tabla.setModel(M1);
     
                   } catch (Exception e1) {
                       System.out.println("Se ha producido el siguiente error:" + e1.getMessage());
                       e1.printStackTrace();
                   }
        
   }
    if (e.getSource() == boton3){
  try {
    ob.setID_Lider(Integer.parseInt(input[0].getText()));
    ob.setNombre(input[1].getText());
    ob.setPrimer_Apellido(input[2].getText());
    ob.setSegundo_Apellido(input[3].getText());
    ob.setSalario(Integer.parseInt(input[4].getText()));
    ob.setCiudad_Residencia(input[5].getText());
    ob.setCargo(input[6].getText());
    ob.setClasificacion(Integer.parseInt(input[7].getText()));
    ob.setDocumento(input[8].getText());
    ob.setFecha_nacimiento(input[9].getText());
    try {
      
        controlador.consultarlider(ob);
     } catch (SQLException e1) {
        e1.printStackTrace();
     }

   
  } catch (Exception e2) {
      JOptionPane.showMessageDialog(null, "Recuerde que ID_lider Salario  Y clasificacion solo reciben numeros      Tambien revise que todos los campos esten llenos");
  }
  
 
  

   }
}



}

    


