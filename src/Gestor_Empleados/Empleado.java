package Gestor_Empleados;

/**
 *
 * @author MGM39434796P
 */
public class Empleado {
    
    private String codigo;
    private String nombre;
    private String idLocalizacion;
    private String idManager;
    
    public Empleado (){}
    
    public Empleado(String codigo, String nombre, String idLocalizacion, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.idLocalizacion = idLocalizacion;
        this.idManager = descripcion;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(String idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getIdManager() {
        return idManager;
    }

    public void setIdManager(String idManager) {
        this.idManager = idManager;
    }
}
