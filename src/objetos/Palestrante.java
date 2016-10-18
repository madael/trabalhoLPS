package objetos;

public class Palestrante {
    private int id;
    private String nome;
    private String universidade;
    private String area;
    private String minicurso;
    
    public Palestrante(){
        id=0;
        nome="";
        universidade="";
        area="";
        minicurso="";
    }
    
    public void imprimir(){
            System.out.println("ID Palestrante: "+id
                            +" Nome palestrante: "+nome
                            +" Universidade: "+universidade
                            +" Area de atuação: "+area
                            +" Minicurso: "+minicurso);
    }
    
    public Palestrante(int id, String nome, String universidade, String area, String minicurso){
        this.id=id;
        this.nome=nome;
        this.universidade=universidade;
        this.area=area;
        this.minicurso=minicurso;
    }   

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniversidade() {
        return universidade;
    }

    public void setUniversidade(String universidade) {
        this.universidade = universidade;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMinicurso() {
        return minicurso;
    }

    public void setMinicurso(String minicurso) {
        this.minicurso = minicurso;
    }
    
}
