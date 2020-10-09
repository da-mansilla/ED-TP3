class ejercicio5{
    public static void main(String[]args){
        (new ejercicio5()).run();
    }
    public void run(){
        Queue<Email> inbox = new Queue<Email>(20);
        Queue<Email> inboxPrincipal= new Queue<Email>(20);
        Queue<Email> inboxSocial = new Queue<Email>(20);
        Queue<Email> inboxPromotion = new Queue<Email>(20);
        int option;
        do{
           System.out.println("Seleccione una opcion"); 
           System.out.println("1. Escribir un Email"); 
           System.out.println("2. Generar un Email"); 
           System.out.println("3. Revisar Correo"); 
           System.out.println("4. Salir"); 
           option = Helper.selectOption(1,4);
           switch(option){
               case 1:
                   inbox.add(writeEmail());
                   break;
               case 2:
                   inbox.add(generateEmail());
                   break;
               case 3:
                   showEmails(inboxSocial,inboxPromotion,inboxPrincipal); 
                   break;
           }
           while(!inbox.isEmpty()){
               char type = getTypeEmail(inbox.element());
               switch (type){
                    case 'a':
                        inboxSocial.add(inbox.remove());
                        break;
                    case 'b':
                        inboxPromotion.add(inbox.remove()); 
                        break;
                    case 'c':
                        inboxPrincipal.add(inbox.remove());
                        break;
               }
           }
        }while(option != 4);
    }
    public Email writeEmail(){
       System.out.println("Ingrese el remitente del Email");
       String sender = Helper.inputString();
       System.out.println("Ingrese el Asunto del Email");
       String subject= Helper.inputString();
       System.out.println("Ingrese el contenido del Email");
       String content= Helper.inputString();
       return new Email(sender,subject,content);
    }
    public Email generateEmail(){
        String sender = names[Helper.generateRandomNumber(0,9)];        
        int index = Helper.generateRandomNumber(0,9);
        String subject = subjects[index]; 
        String content = contents[index]; 
        return new Email(sender,subject,content);
    }
    public char getTypeEmail(Email email){
        String subject = email.getSubject().toLowerCase();
        if(subject.contains("facebook") || subject.contains("twitter") || subject.contains("reddit") || subject.contains("instagram")){
            return 'a';
        }
        else if(subject.contains("oferta") || subject.contains("venta") || subject.contains("viaje") || subject.contains("descuento")){
            return 'b';
        }
        else{
            return 'c';
        }
    }
    public void showEmails(Queue<Email> social, Queue<Email> promotion, Queue<Email> principal){
        if(social.isEmpty() && promotion.isEmpty() && principal.isEmpty()){
            System.out.println("No hay correos para mostrar");
        }
        System.out.println("<---Bandeja de Entrada Principal: "+ principal.size() + "--->");
        while(!principal.isEmpty()){
            principal.remove().show();
        }
        System.out.println("<---Bandeja de Entrada Social: "+ social.size() + "--->");
        while(!social.isEmpty()){
            social.remove().show();
        }
        System.out.println("<---Bandeja de Entrada Promocion: "+ promotion.size() + "--->");
        while(!promotion.isEmpty()){
            promotion.remove().show();
        }
    }
    public static String names[] = new String[] {"Agustin Mansilla", "Pedro Alonzo", "Javier Pettit","Fernanda Gonzales","Maria Dominguez","Celeste Terradez", "Adrian Mercado","Melisa Villagra","Gerardo Murga","Yesica Buendia"};
    public static String subjects[] = new String[] {"Oferta 10% Descuento en Aire Acondicionado", "Join to Reddit Now!", "Viaje gratis a Cancun","Venta de Celulares","Crea un Perfil en Facebook ahora!","Presentacion de TP", "Curso de Programacion","Venta de Gatitos","Informe Clinico","Descuento en viaje por Avion"};
    public static String contents[] = new String[] {"Aproveche esta oferta antes que se acaben!", "Create a new account of Reddit", "Ingrese el numero de tarjeta de credito para reclamar su viaje","Se vende J7 a 100 pesos","Stalckea a tus amigos y mucho mas!","Adjunto el TP para su presentacion", "Confirme su ingreso al Curso de programacion en Python-Django","Vendo michis de muchos colores","Los resultados de su analisis salieron negativos.","Promocion valida solo para las siguientes provincias: Jujuy, Salta, El Chaco"};

}
