package objetos;

public class Aluno {
    private String matricula;
    private String nome;
    private String senha;
    private String cpf;
    private String rg;
    private String email;
    private String nickname;
    private int idCurso;
    
    public Aluno(){
        matricula="";
        nome="";
        senha="";
        cpf="";
        rg="";
        email="";
        nickname="";
        idCurso=0;
    }
    
    public Aluno(String matricula, String nome, String senha, String cpf, String rg, String email, String nickname, int idCurso){
        this.matricula=matricula;
        this.nome=nome;
        this.senha=senha;
        this.cpf=cpf;
        this.rg=rg;
        this.email=email;
        this.nickname=nickname;
        this.idCurso=idCurso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    
    
}
