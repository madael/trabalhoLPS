package objetos;

public class Patrocinador {
    private String id;
    private String nome;
    
    public Patrocinador(){
        id="";
        nome="";
    }
    public void imprimir(){
            System.out.println("ID Patrocinador: "+id
                            +" Nome Patrocinador: "+nome);
    }
    
    public Patrocinador(String id, String nome){
        this.id=id;
        this.nome=nome;
    }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
