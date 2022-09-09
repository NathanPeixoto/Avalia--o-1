package Pilotos;


import java.io.IOException;
import java.util.Scanner;

import Pessoas.Pessoa;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        int MAX_ELEMENTOS = 5;
        int opcao, qtdCadastrados = 0;
        String busca,cpf = "";
        Pessoa[] pilotos = new Pessoa[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);


        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            //in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                if (qtdCadastrados >= MAX_ELEMENTOS) {
                    System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                    voltarMenu(in);
                    continue;
                }else{


                    pilotos[qtdCadastrados] = new Pessoa(qtdCadastrados);
                    
                    System.out.println("Dígite o nome do piloto: ");
                    pilotos[qtdCadastrados].setNome(in.next());

                    System.out.println("Dígite o CPF do piloto: ");
                    cpf = in.next();

                    for(int i=0; i< pilotos.length;i++){
                        if(pilotos[i] != null){
                            if(cpf.equals(pilotos[i].getCPF())){
                                System.out.println("\n\n\n\n\n\n\n\n\n\nPiloto com o CPF" + pilotos[i].getCPF() + " já cadastrado!");
                                cpf = "";
                                continue;
                            
                            }
                        }
                    }
                    
                    if(cpf != ""){

                        pilotos[qtdCadastrados].setCPF(cpf);
                        System.out.println("\n\n\n\n\n\n\n\n\n\nPiloto " + pilotos[qtdCadastrados].getNome() + " cadastrado com sucesso.\n");
                        qtdCadastrados += 1;
                    }
                }

                in.nextLine();
                voltarMenu(in);

            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    in.nextLine();
                    voltarMenu(in);
                    continue;
                }else{
                    System.out.println("Lista de pilotos:\n");
                    for(int i =0; i < pilotos.length; i++){
                        if(pilotos[i] != null){
                            System.out.println("\n\n\n\n\n\n\nPiloto(a): " + pilotos[i].getNome() + "\nCPF: " + pilotos[i].getCPF());
                        }
                    }
                }

                // Exiba os pilotos aqui

                in.nextLine();

                voltarMenu(in);
            } else if (opcao == 3) {
                
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há pilotos cadastrados para exibir.");
                    in.nextLine();
                    voltarMenu(in);
                    continue;
                }else{

                    System.out.println("\n\n\n\n\nDígite o CPF do piloto que deseja buscar.");

                    busca = in.next();
                    
                    for(int i=0;i<pilotos.length;i++){
                        if(pilotos[i] != null){
                            if(busca.equals(pilotos[i].getCPF())){
                                System.out.println("\n\n\n\n\n\n\n\n\nCPF identificado com sucesso! \n\nNome: " + pilotos[i].getNome());
                                System.out.println("CPF: " + pilotos[i].getCPF());
                                busca = "";
                            }
                        }
                    }

                    if(busca != ""){
                        System.out.println("\n\n\n\n\n\n\n\n\nErro na busca, CPF não identificado!");
                    }
                }

                in.nextLine();
                voltarMenu(in);

            } else if (opcao == 4) {

                System.out.println("\n\n\n\n\n\n\n\nDeseja quanto slots?");

                MAX_ELEMENTOS = in.nextInt();
                
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