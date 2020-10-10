class Documento{
    private String nombre;
    private int cantidadHojas;
    private String formatoHoja;
    private int cantidadCopias;
    private String preferencias;

    public Documento(){
        
    }
    public Documento(String nombre, int cantidadHojas, String formatoHojas, int cantidadCopias, String preferencias){
        this.nombre = nombre;
        this.cantidadHojas = cantidadHojas;
        this.formatoHoja= formatoHojas;
        this.cantidadCopias = cantidadCopias;
        this.preferencias = preferencias;
    }
    public void mostrarDocumento(){
        System.out.println("Nombre..............:"+ this.nombre); 
        System.out.println("Cantidad de Hojas...:"+ this.cantidadHojas);
        System.out.println("Tamaño Papel........:"+ this.formatoHoja);
        System.out.println("Numero de Copias....:"+ this.cantidadCopias);
        System.out.println("Preferencias........:"+ this.preferencias);
        System.out.println();
    }
    public String getNombre(){
        return this.nombre;
    }
    public int getCantidadHojas(){
        return this.cantidadHojas;
    }
    public String getFormatoHoja(){
        return this.formatoHoja;
    }
    public int getCantidadCopias(){
        return this.cantidadCopias;
    }
    public String getPreferencias(){
        return this.preferencias;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setCantidadHojas(int cantidadHojas){
        this.cantidadHojas = cantidadHojas;
    }
    public void setFormatoHojas(String formatoHoja){
        this.formatoHoja = formatoHoja;
    }
    public void setCantidadCopias(int cantidadCopias){
        this.cantidadCopias = cantidadCopias;
    }
    public void setPreferencias(String preferencias){
        this.preferencias = preferencias;
    }

}
