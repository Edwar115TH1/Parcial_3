public class ObjServicio {
    private int turno;
    private int Idcliente;
    private String Origen;
    private String Destino;
    private int Tipo_Mercancia;
    private int Peso;
    private int Prioridad;
    private int Estado;
    private String vehiculo_Asignado;

    public ObjServicio() {
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getIdcliente() {
        return Idcliente;
    }

    public void setIdcliente(int idcliente) {
        Idcliente = idcliente;
    }

    public String getOrigen() {
        return Origen;
    }

    public void setOrigen(String origen) {
        Origen = origen;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String destino) {
        Destino = destino;
    }

    public int getTipo_Mercancia() {
        return Tipo_Mercancia;
    }

    public void setTipo_Mercancia(int tipo_Mercancia) {
        Tipo_Mercancia = tipo_Mercancia;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public int getPrioridad() {
        return Prioridad;
    }

    public void setPrioridad(int prioridad) {
        Prioridad = prioridad;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int estado) {
        Estado = estado;
    }

    public String getVehiculo_Asignado() {
        return vehiculo_Asignado;
    }

    public void setVehiculo_Asignado(String vehiculo_Asignado) {
        this.vehiculo_Asignado = vehiculo_Asignado;
    }

    

}
