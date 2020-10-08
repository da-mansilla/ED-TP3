class ejercicio4{
    public static void main(String[] args){
        (new ejercicio4()).run();
    }
    public void run(){ 
           int option;
           do{ 
               Queue<Integer> queue1= new Queue<Integer>(20);
               Queue<Integer> queue2= new Queue<Integer>(20);
               System.out.println("Seleccione una opcion");
               System.out.println("1. Ingreso de Numeros");
               System.out.println("2. Generar Numeros");
               System.out.println("3. Salir");
               option = Helper.selectOption(1,3); 
               queue1= fillQueue(option);
               queue2= fillQueue(option);
               System.out.println("Queue 1: " + queue1.toString());
               System.out.println("Queue 2: " + queue2.toString());
               int comparation = compareQueue(queue1,queue2);
               System.out.println("El resultado es: " + comparation);
               if(comparation > 0 ){
                    System.out.println("Queue 1 es mayor que Queue 2");
               }else{
                    System.out.println("Queue 2 es mayor que Queue 1");
               }
           }while(option!=3);
    }
    public Queue<Integer> fillQueue(int option){ 
        Queue<Integer> queue = new Queue<Integer>(20);
        if(option ==1){
            System.out.println("Ingrese Numeros (Ingrese 0 para terminar)");
            int number = 1;
            while(number!= 0 && queue.size() <=20){ 
                number = Helper.inputNumber();
                if(number != 0){ 
                    try{ 
                        queue.add(number);
                    }catch(IllegalStateException e ){
                        number = 0; 
                    }
                }
            }
        }else{
            for(int i = 0; i<= Helper.generateRandomNumber(5,20); i++){
                int number = Helper.generateRandomNumber(1000);
                queue.add(number);
            }
        }
        return queue;
    }
    public int compareQueue(Queue<Integer> queue1,Queue<Integer> queue2){
        int container = 0;
        while(!queue1.isEmpty() && !queue2.isEmpty()){
            int element1 = queue1.remove();
            int element2 = queue2.remove();
            if(element1 > element2){
                ++container;
            }else{
                --container;
            }
        }
        return container;    
    }
}
