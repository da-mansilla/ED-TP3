class Email{
    private String sender;
    private String subject;
    private String content;

    public Email(){
        
    }
    public Email(String sender, String subject, String content){
        this.sender = sender;
        this.subject = subject;
        this.content = content;
    }
    public void show(){
        System.out.println("Remitente: " + this.getSender());
        System.out.println("Asunto: " + this.getSubject());
        System.out.println("Contenido: " + this.getContent());
        System.out.println("");
    }
    public void setSender(String sender){
        this.sender = sender;
    }
    public void setSubject(String subject){
        this.subject= subject;
    }
    public void setContent(String content){
        this.content = content;
    }
    public String getSender(){
        return this.sender;
    }
    public String getSubject(){
        return this.subject;
    }
    public String getContent(){
        return this.content;
    }
}
