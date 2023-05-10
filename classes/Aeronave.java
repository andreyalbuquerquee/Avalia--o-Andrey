package classes;

public class Aeronave extends Piloto {
    private String modelo;
    private String numeroSerie;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    @Override
    public String toString() {
        return
        "Modelo: " + modelo +
        "\nNúmero da Série: " + numeroSerie + "\n"; 
    }
}
