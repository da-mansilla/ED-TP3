class ejercicio3{
    public static void main(String [] args){
        (new ejercicio3()).run();
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
               System.out.println("Queue 1 + Queue 2: " + union(queue1,queue2).toString());
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
    public Queue<Object> union(Queue<?> queue1,Queue<?> queue2){
        Queue<Object> result = new Queue<Object>(queue1.size()+ queue2.size());
        int length= queue1.size()+queue2.size();
        for(int i= 0; i<= length; i++){
            if(!queue1.isEmpty()){
                result.add(queue1.remove());
            }
            if(!queue2.isEmpty()){
                result.add(queue2.remove());
            }
        }
        return result;    
    }
}
