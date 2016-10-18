package objetos;

public class Administrador {
    private int idAdm;
    private String nome;
    private String senha;
    
    public Administrador(){
        idAdm=0;
        nome="";
        senha="";
    }
    
    public void imprimir(){
            System.out.println("ID adm: "+idAdm
                            +" Nome adm: "+nome
                            +" Senha: "+senha);
    }
    
    public Administrador(int idAdm, String nome, String senha){
        this.idAdm=idAdm;
        this.nome=nome;
        this.senha=senha;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int matricula) {
        this.idAdm = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
