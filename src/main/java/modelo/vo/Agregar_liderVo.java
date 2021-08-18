package modelo.vo;

public class Agregar_liderVo {
    private  Integer ID_Lider;
    private  Integer Salario,clasificacion;
    private String Primer_Apellido,Segundo_Apellido,Ciudad_Residencia,cargo,documento,fecha_nacimiento,nombre;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getID_Lider() {
        return ID_Lider;
    }
    public void setID_Lider(Integer iD_Lider) {
        ID_Lider = iD_Lider;
    }
    public Integer getSalario() {
        return Salario;
    }
    public void setSalario(Integer salario) {
        Salario = salario;
    }
    public Integer getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(Integer clasificacion) {
        this.clasificacion = clasificacion;
    }
    public String getPrimer_Apellido() {
        return Primer_Apellido;
    }
    public void setPrimer_Apellido(String primer_Apellido) {
        Primer_Apellido = primer_Apellido;
    }
    public String getSegundo_Apellido() {
        return Segundo_Apellido;
    }
    public void setSegundo_Apellido(String segundo_Apellido) {
        Segundo_Apellido = segundo_Apellido;
    }
    public String getCiudad_Residencia() {
        return Ciudad_Residencia;
    }
    public void setCiudad_Residencia(String ciudad_Residencia) {
        Ciudad_Residencia = ciudad_Residencia;
    }
    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }
    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
 
    
}
