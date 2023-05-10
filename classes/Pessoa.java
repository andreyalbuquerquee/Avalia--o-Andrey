package classes;
import java.util.Scanner;

public class Pessoa {
    protected String nome;
    protected String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        Scanner sc = new Scanner(System.in);
        
        if (cpf.length() == 11) {
        this.cpf = cpf;
        } else {
            System.out.println("O cpf deve ter 11 dígitos! Tente novamente.");
            setCpf(sc.next());
            sc.close();

        }

    }


}
