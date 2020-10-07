class ejercicio2{
    public static void main(String[] args){
        (new ejercicio2()).run();
    }
    public void run(){ 
       int option;
       do{
           Queue<Character> chars= new Queue<Character>(20);
           Queue<Character> upperChars= new Queue<Character>(20);
           System.out.println("Seleccione una opcion");
           System.out.println("1. Ingreso de letras");
           System.out.println("2. Generar letras");
           System.out.println("3. Salir");
           option = Helper.selectOption(1,3); 
           chars = inputChars(chars,option);
           System.out.println("Cola original:   " + chars.toString());
           int countVocals = 0;
           while(!chars.isEmpty()){
                char c = chars.remove();     
                if(isVocal(c)){
                   c= Character.toUpperCase(c);
                   countVocals++;
                }
                upperChars.add(c);
           }
           System.out.println("Cola modificada: " + upperChars.toString());
           System.out.println("Vocales introducidas:" + countVocals);
       }while(option!=3);
    }
    public Queue<Character> inputChars(Queue<Character> queue, int option){ 
        Queue<Character> chars = new Queue<Character>(20);
        if(option ==1){
            System.out.println("Ingrese letras (Ingrese @ para terminar)");
            char c= '\0';
            while(c!= '@' && queue.size() <=20){ 
                c = Helper.inputChar();
                if(c != '@'){
                    try{ 
                        chars.add(c);
                    }catch(IllegalStateException e ){
                        c = '@';
                    }
                }
            }
        }else{
            for(int i = 0; i<= Helper.generateRandomNumber(5,20); i++){
                char c = Helper.generateRandomCharacter();
                chars.add(c);
            }
        }
        return chars;
    }
    public boolean isVocal(char c){
        if(c == 'a' || c=='e' || c=='i' || c=='o' || c=='u'){
            return true;
        }else{
            return false;
        }
    }
}
