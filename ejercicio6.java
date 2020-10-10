class ejercicio6{
    public static void main(String[] args){
        (new ejercicio6()).run();
    }
    public void run(){
        Queue<Documento> colaImpresion= new Queue<Documento>(20);
        int option;
        do{
            System.out.println("Ingrese una opcion"); 
            System.out.println("1. Imprimir Documento"); 
            System.out.println("2. Generar Documento Imprimir");
            System.out.println("3. Imprimir");
            System.out.println("4. Salir");
            option = Helper.selectOption(1,4);
            switch(option){
                case 1:
                        colaImpresion.add(escribirDocumento());
                        break;
                case 2:
                        colaImpresion.add(generarDocumento());
                        break;
                case 3: 
                        if(!colaImpresion.isEmpty()){
                            imprimirDocumentos(colaImpresion);
                        }
                        
            }
        }while(option != 4);
    }
    public Documento escribirDocumento(){
        System.out.println("Nombre del documento:");
        String nombre = Helper.inputString();
        System.out.println("Cantidad de Hojas:");
        int cantidadHojas = Helper.inputPositiveNumber();
        System.out.println("Tamaño de Papel:");
        System.out.println("1. A4:");
        System.out.println("2. Oficio:");
        System.out.println("3. Carta:");
        int eleccion = Helper.selectOption(1,3);
        String formato= null; 
        switch(eleccion){
            case 1 : formato = "A4";
                     break;
            case 2 : formato = "Oficio";
                     break;
            case 3 : formato = "Carta";
                     break;
        }
        System.out.println("Numero de Copias:");
        int cantidadCopias = Helper.inputPositiveNumber();
        System.out.println("Preferencias :");
        System.out.println("1. Color");
        System.out.println("2. Escala de Grises");
        eleccion = Helper.selectOption(1,2);
        String preferencias= null;
        switch(eleccion){
            case 1: preferencias = "Color";
                    break;
            case 2: preferencias = "Escala de Grises";
                    break;
        }
        return new Documento(nombre,cantidadHojas,formato,cantidadCopias,preferencias);
    }
    public Documento generarDocumento(){
       String nombre = nombreDocumentos[Helper.generateRandomNumber(0,6)]; 
       int cantidadHojas = Helper.generateRandomNumber(1,10);
       int eleccion = Helper.generateRandomNumber(3);
       String formato = null;
       switch(eleccion){
            case 1 : formato = "A4";
                     break;
            case 2 : formato = "Oficio";
                     break;
            case 3 : formato = "Carta";
                     break;
       }
       int cantidadCopias = Helper.generateRandomNumber(1,10);
       String preferencias= null;
       eleccion = Helper.generateRandomNumber(2);
       switch(eleccion){
            case 1: preferencias = "Color";
                    break;
            case 2: preferencias = "Escala de Grises";
                    break;
       }
       return new Documento(nombre, cantidadHojas, formato, cantidadCopias, preferencias);   
    }
    public void imprimirDocumentos(Queue<Documento> cola){
        System.out.println("Documentos a Imprimir: "+ cola.size());
        int documentosColor= 0;
        int documentosOficio = 0;
        Documento documentoMayorNumeroCopias = new Documento();
        Documento documentoMenorCantidadHojas= new Documento();
        boolean flag = true;
        boolean flag2 = true;
        while(!cola.isEmpty()){
            Documento documento = cola.remove();
            if(documento.getPreferencias() == "Color"){
                ++documentosColor;
            }
            if(documento.getFormatoHoja() == "Oficio"){
                ++documentosOficio;
            }
            if(flag){
               documentoMayorNumeroCopias = documento;
               flag = false;
            }else{
                if(documento.getCantidadCopias() > documentoMayorNumeroCopias.getCantidadCopias()){
                    documentoMayorNumeroCopias = documento;
                }
            }
            if(flag2){
               documentoMenorCantidadHojas= documento;
               flag2 = false;
            }else{
                if(documento.getCantidadHojas() < documentoMenorCantidadHojas.getCantidadHojas()){
                    documentoMenorCantidadHojas= documento;
                }
            }
            documento.mostrarDocumento();
        }
        System.out.println("Documentos a Color: " + documentosColor);
        System.out.println("Documentos de Tamaño Oficio: " + documentosOficio);
        System.out.println("Documento Mayor numero de Copias: " + documentoMayorNumeroCopias.getNombre());
        System.out.println("Documento Menor numero de Hojas: " + documentoMenorCantidadHojas.getNombre());
        
    }
    public static String[] nombreDocumentos= new String[]{"TP N° 3","Receta de Galletas","Informe de Reparacion PC", "Facturacion Enero 2020", "Poesia Dia de la Bandera","Electromagnetismo","Guia de Como Sobrevivir en la Selva durante 30 dias"};
    
}
