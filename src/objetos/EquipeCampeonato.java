package objetos;

public class EquipeCampeonato {
    private int idEquipe;
    private String nomeEquipe;
    private int[] players;
    
    public EquipeCampeonato(){
        idEquipe=0;
        nomeEquipe="";
        players=new int[5];
    }
    
    public void imprimir(){
        for(int k=0;k<players.length;k++)
            System.out.println("Id equipe: "+idEquipe+" Nome equipe: "+nomeEquipe+" Jogador: "+players[k]);
    }
    
    public EquipeCampeonato(int idEquipe, String nomeEquipe, int[] players){
        this.idEquipe=idEquipe;
        this.nomeEquipe=nomeEquipe;
        this.players=players;
    }

    public int getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(int matricula) {
        this.idEquipe = matricula;
    }

    public String getNome() {
        return nomeEquipe;
    }

    public void setNome(String nome) {
        this.nomeEquipe = nome;
    }

    public int[] getPlayers() {
        return players;
    }

    public void setPlayers(int[] senha) {
        this.players = senha;
    }
}
