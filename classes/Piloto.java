package classes;

public class Piloto extends Pessoa {
    private String breve;
    private Aeronave aeronave;

    public String getBreve() {
        return breve;
    }

    public void setBreve(String breve) {
        this.breve = breve;
    }
    
    public Aeronave getAeronave() {
        return aeronave;
    }

    public void setAeronave(Aeronave aeronave) {
        this.aeronave = aeronave;
    }

    @Override
    public String toString() {
        String aeronaveInfo;
        if (aeronave == null) {
            aeronaveInfo = "Não há aeronave";
        } else {
            aeronaveInfo = aeronave.toString();
        }
        
        return
        "Nome: " + nome + "\n" +
        "Cpf: " + cpf + "\n" +
        "Brevê: " + breve + "\n" + "\nAeronave \n" + 
        aeronaveInfo;
    }
}
