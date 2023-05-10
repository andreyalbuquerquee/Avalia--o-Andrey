package aplicativos;

import java.io.IOException;
import java.util.Scanner;

import classes.Piloto;
import classes.Aeronave;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 10;
        int opcao, qtdCadastrados = 0;
        Piloto [] lista = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);
        int breve;
        String cpf;

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Cadastrar aeronave");
            System.out.println("0 - Sair");
            System.out.print("Opção: \n\n");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, saio do cadastro
                if (qtdCadastrados == MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                } else {
                    Piloto piloto = new Piloto();
                    System.out.println("Insira, respectivamente, o nome, cpf, e breve do piloto");
                    piloto.setNome(in.nextLine());
                    piloto.setCpf(in.next());
                    System.out.println("Escolha a situação do brevê do piloto: \n1 - Autorizado\n2 - Não autorizado");
                    breve = in.nextInt();
                // Verifica o brevê
                    do {

                    if (breve == 1 ) {
                        piloto.setBreve("Autorizado");
                    } else if (breve == 2) {
                        piloto.setBreve("Não autorizado");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    
                    } while (breve != 1 && breve != 2);
                    
                // Cadastra
                    lista [qtdCadastrados] = piloto;
                    qtdCadastrados++;
                    System.out.println("\nPiloto cadastrado com sucesso.");
                    voltarMenu(in);
                }

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                } 
                // Exiba os pilotos aqui
                else {
                    for (int i = 0; i < qtdCadastrados; i++) {
                        if (lista[i] != null) {
                            System.out.println(lista[i].toString() + "\n\n***\n");;
                        }
                    }
                }

                voltarMenu(in);
            } else if (opcao == 3) {

                if (qtdCadastrados == 0 ) {
                    System.out.println("\nSem pilotos, não há como localizar");
                    voltarMenu(in);
                    continue;
                } else {
                    System.out.println("\nInforme o cpf do piloto");
                    cpf = in.nextLine();
                    Boolean achou = false;

                    for (Piloto piloto : lista) {
                        if (piloto != null && cpf .equals(piloto.getCpf())) {
                            System.out.println(piloto);
                            achou = true;
                        } 
                    }
                    if (!achou) {
                        System.out.println("\nPiloto não encontrado!");
                    }
                    voltarMenu(in);
                    continue;
                }


            } else if (opcao == 4) {
                 // Se não tem ninguém cadastrado no vetor, caio fora
                    if (qtdCadastrados == 0) {
                    System.out.println("\nSem pilotos, não há como cadastrar uma aeronave");
                    voltarMenu(in);
                    continue;
                } else {
                    
                    System.out.println("\nInforme o cpf do piloto");
                    cpf = in.next();
                    Boolean findCpf = false;

                    for (Piloto piloto : lista) {
                        if (piloto != null && cpf .equals(piloto.getCpf())) {
                            System.out.println("\nInforme, respectivamente, o modelo e número da série: ");
                            Aeronave aeronave = new Aeronave();
                            aeronave.setModelo(in.next());
                            aeronave.setNumeroSerie(in.next());
                            System.out.println("\nAeronave adicionada! Detalhes: \n");
                            System.out.println(aeronave);
                            piloto.setAeronave(aeronave);
                            findCpf = true;
                        } 
                    }
                    if (!findCpf) {
                        System.out.println("Piloto não encontrado!");
                        
                    } 
                }       
            }
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");

        System.out.flush();
    }
}

