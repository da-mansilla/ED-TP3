public class Queue <ELEMENT> {
    private final static Integer defaultDimension = 10;

    private ELEMENT [] data;
    private int head;
    private int tail;
    private int count;

    public Queue (){
        this(Queue.defaultDimension);
    }
    public Queue(int dimension){
        this.data = (ELEMENT[]) new Object[dimension];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public boolean isEmpty(){
        return this.count<= 0;
    }
    public int size(){
        return this.count;
    }
    private int next(int pos){
        if(++pos >= this.data.length){
            pos = 0;
        }
        return pos;
    }


    // Inserta un elemento en la Cola si es posible
    // Devuelve False en el caso de que la cantidad de elementos sobrepase
    // el tamaño del array interno
    public boolean offer(ELEMENT element){
        if(this.size() >= this.data.length){
            return false;
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }
    // Inserta un elemento en la Cola si es posible
    // Devuelve False en el caso de que la cantidad de elementos sobrepase
    // el tamaño del array interno
    public boolean add(ELEMENT element){
        if(this.size() >= this.data.length){
            throw new IllegalStateException("Cola llena");
        }
        this.data[this.tail] = element;
        this.tail = this.next(this.tail);
        ++this.count;

        return true;
    }



    // Devuelve pero no elimina la el elemento en la salida de la Cola.
    // Devuelve una Exception en el caso de que esté vacia
    public ELEMENT element(){
        if(this.size() <= 0){
            throw new IllegalStateException("Cola vacia...");
        }
        return this.data[this.head];
    }
    // Devuelve pero no elimina el elemento en la salida de la Cola.
    // Devuelve False en el caso de que esté vacia
    public ELEMENT peek(){
        if(this.size() <= 0){
            return null;
        }
        return this.data[this.head];
    }


    // Devuelve y Elimina el elemento en la salida de la Cola
    // Devuelve null en el caso de que esté vacia
    public ELEMENT pool(){
        if(this.size() <= 0){
            return null;
        }
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return result;
    }
    // Devuelve y Elimina el elemento en la salida de la Cola
    // Devuelve una Excepcion en el caso de que esté vacia
    public ELEMENT remove(){
        if(this.size() <= 0){
            throw new IllegalStateException("Cola vacia");
        }
        ELEMENT result = this.data[this.head];
        this.head = this.next(this.head);
        --this.count;
        return result;
    }
    public static Queue<Object> union(Queue<?> queue1,Queue<?> queue2){
        Queue<Object> result = new Queue<Object>(queue1.size()+ queue2.size());
        while(!queue1.isEmpty()){
           result.add(queue1.remove()); 
        }
        while(!queue2.isEmpty()){
           result.add(queue2.remove()); 
        }
        return result;    
    }
    public Queue<Object> union(Queue<?> queue2){
       return Queue.union(this,queue2); 
    }
    @Override
    public String toString() {
 
        if (this.size() <=0) {
            return "";
        }
 
        // from https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/StringBuilder.html
        StringBuilder sb = new StringBuilder();
        sb.append("[" + this.data[this.head].toString());
 
        for (int cta = 1, pos = this.next(this.head); cta < this.size(); ++cta, pos = this.next(pos)) {
            sb.append(", " + this.data[pos].toString());
        }
 
        sb.append("]");
        return sb.toString();
    }
    public Object[] toArray() {
        Object[] result = new Object[this.count];
        for(int i = 0, pos = this.head, cta = this.size(); cta > 0; ++i, pos = this.next(pos), --cta) {
            result[i] = this.data[pos];
        }
        return result;
    }
}
