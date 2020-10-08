class ejercicio1{
    public static void main(String[] args){
        (new ejercicio1()).run();
    }
    public void run(){
       Queue<Integer> queue = new Queue<Integer>();
       int option;
       do{
           System.out.println("Seleccione una opcion");
           System.out.println("1. Ingreso numero");
           System.out.println("2. Generar numero");
           System.out.println("3. Salir");
           option = Helper.selectOption(1,3); 
           int number = inputNumbers(option);
           System.out.println("Numero: " + number);
           queue = getMultiplies(number);
           System.out.println(queue.toString());
       }while(option!=3);
    }
    public int inputNumbers(int option){
        if(option== 1){
            return Helper.inputNumber();
        }else{
            return Helper.generateRandomNumber(1,20);
        
        }
    }
    public Queue<Integer> getMultiplies(int number){ 
       Queue<Integer> queue = new Queue<Integer>(100);
       for(int i = 1; i<= 100; i++){
           if(i % number  != 0){
            queue.add(i);
           }
       }
       return queue;

    }
}
