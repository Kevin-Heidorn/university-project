package trabalhoa3; //Pacote do programa.

/*
 * @Author Zheng, Leon, Kevin Heidorn, Vinícius Paula
 */

/*
* Importação das funcionalidades como ArrayList e Scanner para armazenar e ler entradas dadas pelo usuário.
* Assim como Collections, List e Comparator... para uma funcionalidade específica de comparações de objetos numa dada lista específica.
*/
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class Programa {

    //Declaração da variável estática chamada listaFuncionarios que armazena objetos do tipo Funcionario em um ArrayList.
    private static ArrayList<Funcionario> listaFuncionarios = new ArrayList<>();

    /* Método main o qual o programa irá rodar. */
    public static void main(String[] args) {

        //Inicializa o método "cadastrarFuncionariosAutomaticos".
        cadastrarFuncionariosAutomaticos();

        //Estabelece o Scanner "scanner" para termos a leiturada das entradas do usuário.
        Scanner scanner = new Scanner(System.in);

        boolean sair = false; //A variável sair é inicializada como false, indicando que o programa não deve sair inicialmente.

        while (!sair) { //O loop é iniciado com a condição !sair, ou seja, enquanto sair for falso.

            exibirMenu();//Inicializa o método para exibir o menu.

            int opcao = scanner.nextInt(); //Instancia a variável e lê a entrada do usuário.

            /*
             * Chamando o scanner.nextLine(), o método nextLine() é executado, mas sem atribuir o resultado a uma variável.
             * Isso significa que a linha lida é descartada, mas o buffer é limpo, preparando-o para leituras subsequentes.
             */
            scanner.nextLine();

            /*Estrutura condicional switch-case para controle de entrada do usuario.*/
            switch (opcao) {
                case 1:
                    cadastrarFuncionarios(scanner); //Inicia o método de cadastrar funcionários.
                    break;
                case 2:
                    listagemFuncionarios(); //Ativa o método para listagem de funcionários.
                    break;
                case 3:
                    buscarFuncionario(scanner); //Inicia o método que busca um funcionário.
                    break;
                case 4:
                    mudarRegistro(); //Inicia o método que alterar um dos registros.
                    break;
                case 5:
                    removerFuncionario(scanner); //Inicia o método para remover um funcionário.
                    break;
                case 6:
                    sair = true; /*Altera o valor de "sair" para verdadeiro, finalizando então o programa*/
                    break;
                default:
                    System.out.println("\nOpção inválida."); //Impressão que expressa invalidação em relação à escolha do usuário.
            }
        }

    //Imprime uma linha confirmando que o programa foi encerrado.
    System.out.println("\nPrograma encerrado.");
    }

    // Método que imprime o Menu e suas opções disponíveis.
    private static void exibirMenu() {
        System.out.println("\n========== Menu =========="); //Sequencia de linhas de impressão.
        System.out.println("[1] Cadastrar um funcionário"); //para a interface do menu para o usuário.
        System.out.println("[2] Listar os funcionários");
        System.out.println("[3] Buscar um funcionário");
        System.out.println("[4] Mudar registro");
        System.out.println("[5] Remover um funcionário");
        System.out.println("[6] Sair do programa");
        System.out.println("==========================");
        System.out.print("\nDigite a opção desejada: ");
    }

    //Método para cadastrar um funcionário.
    private static void cadastrarFuncionarios(Scanner scanner) {

        /*
        * A seguir o código imprime uma linha que então é seguida de uma entrada que atribui um valor à sua variável.
        */
        System.out.print("\nDigite o Apelido do funcionário (max. 20 dígitos): ");
        String apelido = scanner.nextLine();

        System.out.print("\nDigite o Cargo do funcionário (max. 25 dígitos): ");
        String cargo = scanner.nextLine();

        System.out.print("\nDigite o Salário do funcionário: ");
        String salario = scanner.nextLine();

        System.out.print("\nDigite o PIN do funcionário (max. 3 dígitos): ");
        int pin = scanner.nextInt();

        scanner.nextLine(); //Limpa o scanner para evitar problemas.

        System.out.print("\nInforme o Email do funcionário: ");
        String email = scanner.nextLine();

        System.out.print("\nInforme o Número de Telefone do funcionário: ");
        String telefone = scanner.nextLine();

        System.out.print("\nInforme o CEP do funcionário: ");
        String cep = scanner.nextLine();

        //A seguir é instanciado um novo Funcionário de acordo com as entradas anteriormente solicitadas.
        Funcionario objeto = new Funcionario(apelido, cargo, salario, pin, email, telefone, cep);

        //Em seguida o método ".add" adiciona-o na ArrayList que armazena os funcionários.
        listaFuncionarios.add(objeto);

        //Imprime uma linha de código que confirma o cadastro do novo funcionário.
        System.out.println("\nFuncionário(a) cadastrado com sucesso!");
    }

    //Método para imprimir o menu das opções de listagem de funcionários.
    private static void menuListagem() {

        /* 
         * Imprime o menu com as opções disponíveis e exigindo em seguida uma opção a selecionar.
         */
        System.out.println("\n========== Menu Listagens ==========");
        System.out.println("[1] Listagem comum");
        System.out.println("[2] Listagem por ordem crescente");
        System.out.println("[3] Voltar.");
        System.out.println("==========================================");
        System.out.print("\nDigite a opção desejada: ");
    }

    private static void listagemFuncionarios() {

        //Instancia o Scanner scanner para ler entradas.
        Scanner scanner = new Scanner(System.in);
    
        boolean voltarMenuListagem = false; //Instancia voltarMenuListagem como variável boolean falsa.

        while (!voltarMenuListagem) { //Inicia loop while enquanto voltarMenuListagem for falso.

            menuListagem(); //Inicia o método para imprimir o menu de opções de listagem.

            int opcaoListagem = scanner.nextInt(); // Lê a opção do usuário.

            scanner.nextLine(); //Limpa o scanner String para evitar problemas.
        
            switch (opcaoListagem) {//Inicia estrutura condiciona switch-case para seleção de opções;
                case 1:
                    listarFuncionarios();//Inicia o método para listar funcionários.
                    break;
                case 2:
                    listarOrdenadamenteFuncionarios();//Inicia o método para listar funcionários ordenadamente.
                    break;
                case 3:
                    voltarMenuListagem = true; //Altera a variável para true finalizando o loop e retornando ao menu anterior.
                    break;
                default:
                    System.out.println("\nOpção inválida."); //Impressão que expressa invalidação em relação à escolha do usuário.
                    break;
            }

        }
    }

    // Método para listar os funcionários cadastrados.
    private static void listarFuncionarios() {

        /*
         * Imprime em formato tabular a lista dos funcionários.
         */
        System.out.println("\n\t===================================================");
        System.out.println("\t=============[TIME DE DESENVOLVIMENTO]=============");
        System.out.println("\t===================================================");
        System.out.printf("\t||%-20s||%-20s||%-3s||%n", "APELIDO", "CARGO", "PIN");
        System.out.println("\t===================================================");
    
        /* 
         * Para cada objeto vulgo funcionário da ArrayList, imprime as informações do funcionário em formato tabular.
         */
        for (Funcionario objeto : listaFuncionarios) {
            System.out.printf("\t||%-20s||%-20s||%-3s||%n", objeto.getApelido(), objeto.getCargo(), objeto.getPin());
        }
    
        //Impressão de linha para fechar a tabela.
        System.out.println("\t===================================================");
    }
    
    //Método que lista os funcionários por ordem crescente
    private static void listarOrdenadamenteFuncionarios() {

        // Ordena a lista de funcionários por ordem crescente do atributo "Pin".
        Collections.sort(listaFuncionarios, new Comparator<Funcionario>() {
            
            // Implementação do método compare() do Comparator para comparar os funcionários.
            public int compare(Funcionario objt1, Funcionario objt2) {

                // Compara os Pins dos funcionários.
                return Integer.compare(objt1.getPin(), objt2.getPin());
            }
        });
    
        /*
         * Imprime em formato tabular a lista dos funcionários.
         */
        System.out.println("\n\t===================================================");
        System.out.println("\t=============[TIME DE DESENVOLVIMENTO]=============");
        System.out.println("\t===================================================");
        System.out.printf("\t||%-20s||%-20s||%-3s||%n", "APELIDO", "CARGO", "PIN");
        System.out.println("\t===================================================");
    
        /* 
         * Para cada objeto funcionário da ArrayList, imprime as informações do funcionário em formato tabular.
         */
        for (Funcionario objeto : listaFuncionarios) {
            System.out.printf("\t||%-20s||%-20s||%-3s||%n", objeto.getApelido(), objeto.getCargo(), objeto.getPin());
        }
        
        //Impressão de linha para fechar a tabela.
        System.out.println("\t===================================================");
    }    
    
    // Método que busca um funcionário pelo Cargo.
    private static void buscarFuncionario(Scanner scanner) {

        //Imprime uma linha exigindo uma entrada.
        System.out.print("\nDigite o Cargo do funcionário para efetuar a busca: ");

        //Instancia a variável e lê a entrada do usuário.
        String funcionarioBusca = scanner.nextLine();

        /*
         * Imprime em formato tabular a lista dos funcionários.
         */
        System.out.println("\n\t====================================================[Resultado da Busca]====================================================");
        System.out.printf("\t||%-20s||%-20s||%-15s||%-3s||%-25s||%-15s||%-10s||%n", "NICKNAME FUNCIONÁRIO",
         "CARGO DO FUNCIONÁRIO", "SALÁRIO EM R$", "PIN", "EMAIL DO FUNCIONÁRIO", "TELEFONE", "CEP");
        System.out.println("\t============================================================================================================================");

        boolean encontrouResultado = false; // Variável para acompanhar se houve correspondência.

        /* 
         * Para cada objeto vulgo funcionário da ArrayList, imprime as informações do funcionário em formato tabular.
         */
        for (Funcionario objeto : listaFuncionarios) {
            if (objeto.getCargo().equals(funcionarioBusca)) {
            System.out.printf("\t||%-20s||%-20s||%-15s||%-3s||%-25s||%-15s||%-10s||%n", objeto.getApelido(),
             objeto.getCargo(), objeto.getSalario(), objeto.getPin(), objeto.getEmail(), objeto.getTelefone(), objeto.getCep());
                System.out.println("\t============================================================================================================================");

            encontrouResultado = true; // Se houver correspondência, atualiza a variável.
            }
        }

        //Verifica se nenhum resultado for encontrado, caso não encontre, inicia a impressão de duas linhas.
        if (!encontrouResultado) {
            System.out.println("\tenhum resultado encontrado.");
            System.out.println("\t===================================================================================");
        }
    }

    //Método que imprime um menu com opções de mudar ou não um registro.
    private static void menuMudarRegistro() {

        //Impressão das linhas do menu.
        System.out.println("\n========== Menu de Alterações ==========");
        System.out.println("[1] Mudar um registro sobre funcionário");
        System.out.println("[2] Voltar");
        System.out.println("==========================================");
        System.out.print("\nDigite a opção desejada: ");
    }

    //Método que inicia o processo de mudança de registro.
    private static void mudarRegistro() {
    
        //Instancia o Scanner scanner para ler entradas.
        Scanner scanner = new Scanner(System.in);
    
        boolean voltarMenu = false; //Instancia voltarMenu como variável boolean falsa.

        while (!voltarMenu) { //Inicia um loop while que dura enquanto a variável "voltarMenu" é falsa.

            menuMudarRegistro(); //Inicializa o método "menuMudarRegistro" que imprime o menu de opções.

            int opcaoMudarRegistro = scanner.nextInt(); // Lê a opção do usuário.

            scanner.nextLine(); //Limpa o scanner para evitar problemas.
        
            switch (opcaoMudarRegistro) { //Inicia uma estrutura condiciona switch-case para seleção de opções do menu.
                case 1:
                    mudarInformacaoFuncionario(scanner); //Inicializa o método que muda um registro.
                    break;
                case 2:
                    voltarMenu = true; /*Altera o valor de "voltar" para verdadeiro, retornando ao menu anterior*/
                    break;
                default: /* Caso nenhuma das opções anteriores forem atendidas,
                          * é impresso uma linha afirmando que a opção é inválida.
                          */
                    System.out.println("\nOpção inválida."); //Impressão que expressa invalidação em relação à escolha do usuário.

            } 
        }

        System.out.println("\nRetornando..."); //Caso a opção 2 seja escolhida, ele imprime uma mensagem antes do retorno ao menu.
    }

    //Método que exibe o menu de opções para alterar as informações de um funcionário.
    public static void menuInformacaoFuncionario() {

        //Impressão do menu de opções para alterar as informações do funcionário. 
        System.out.println("\n========== Opções ==========");
        System.out.println("[1] Alterar Apelido");
        System.out.println("[2] Alterar Cargo");
        System.out.println("[3] Alterar Salario");
        System.out.println("[4] Alterar Email");
        System.out.println("[5] Alterar Telefone");
        System.out.println("[6] Alterar endereco");
        System.out.println("[7] Voltar");
        System.out.println("=============================");
        System.out.print("\nDigite a opção desejada: ");
    }

    //Método que permite alterar as informações do Funcionário cadastrado no sistema.
    public static void mudarInformacaoFuncionario(Scanner scanner) {

        //Imprime uma exigência de entrada pelo usuário.
        System.out.print("\nInforme o apelido do funcionário que deseja modificar as informações: ");

        //Instancia a variável e lê a entrada do usuário.
        String buscarFuncionario = scanner.nextLine(); 
    
        boolean encontraResultado = false; //Instancia encontraResultado como variável boolean falsa.
    
        /*
         * Inicia uma estrutura de repetição for-each para cada objeto/funcionário da ArrayList.
         */
        for (Funcionario objeto : listaFuncionarios) {

            //Inicia estrutura condicional se o apelido do usuário coincidir com algum apelido registrado.
            if (objeto.getApelido().equals(buscarFuncionario)) {
                
                boolean voltarMenuDois = false; //Instancia a variável voltarMenuDois como falsa.
    
                /*
                 * Inicia estrutura de repetição que estará ativa enquanto variável boolean voltarMenuDois for falsa.
                 */
                while (!voltarMenuDois) {
    
                    menuInformacaoFuncionario(); //Inicia o método que imprime o menu para as opções sobre as informações do usuário.
    
                    int opcaoMudar = scanner.nextInt(); //Instancia uma variável e lê a entrada do usuário.
    
                    scanner.nextLine(); //Limpa o scanner para evitar problemas.
                    
                    switch (opcaoMudar) {
                        case 1:
                            alterarApelido(scanner, objeto); //Inicia o método alterarApelido.
                            break;
                        case 2:
                            alterarCargo(scanner, objeto); //Inicia o método alterarCargo.
                            break;
                        case 3:
                            alterarSalario(scanner, objeto); //Inicia o método alterarSalario.
                            break;
                        case 4:
                            alterarEmail(scanner, objeto); //Inicia o método alterarEmail.
                            break;
                        case 5:
                            alterarTelefone(scanner, objeto); //Inicia o método alterarTelefone.
                            break;
                        case 6:
                            alterarCep(scanner, objeto); //Inicia o método alterarCep.
                            break;
                        case 7:
                            // Instancia a variável voltarMenuDois como verdadeira e finaliza a estrutura condicional while.
                            voltarMenuDois = true;
                            System.out.println("\nRetornando..."); //Em seguida é impresso uma linha informando retorno.
                            break;
                        default:
                            System.out.println("\nOpção inválida."); //Impressão que expressa invalidação em relação à escolha do usuário.
                    }
                }
    
                encontraResultado = true; //Altera o valor da variável boolean para verdadeiro caso encontre resultado.
            }
        }
    
        //Se nenhum resultado for encontrado, imprime uma linha informando que o funcionário não foi encontrado.
        if (!encontraResultado) {
            System.out.println("\nNão foi possível encontrar o funcionário. Tente novamente.");
        }
    }
    
    //Método para alterar o Apelido do funcionário.
    public static void alterarApelido(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o Apelido do funcionário.
        System.out.print("\nInforme o novo apelido do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String apelidoAlterar = scanner.nextLine();
    
        objeto.setApelido(apelidoAlterar); //Utiliza o método setApelido para alterar o valor da variável do funcionário.
    
        //Imprime uma linha confirmando a alteração do Apelido.
        System.out.println("\nVocê alterou o apelido com sucesso!");
    }
    
    //Método para alterar o Cargo do funcionário.
    public static void alterarCargo(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o Cargo do funcionário.
        System.out.print("\nInforme o novo cargo do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String cargoAlterar = scanner.nextLine();
    
        objeto.setCargo(cargoAlterar); //Utiliza o método setCargo para alterar o valor da variável do funcionário.
    
        //Imprime uma linha confirmando a alteração do Cargo.
        System.out.println("\nVocê alterou o cargo com sucesso!");
    }

    //Método para alterar o Salário do funcionário.
    public static void alterarSalario(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o Salário do funcionário.
        System.out.print("\nInforme o novo salário do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String salarioAlterar = scanner.nextLine();

        objeto.setSalario(salarioAlterar); //Utiliza o método setSalario para alterar o valor da variável do funcionário.

        //Imprime uma linha confirmando a alteração do Salário.
        System.out.println("\nVocê alterou o salário com sucesso!");
    }

    //Método para alterar o Email do funcionário.
    public static void alterarEmail(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o Email do funcionário.
        System.out.print("\nInforme o novo Email do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String Alterar = scanner.nextLine();

        objeto.setEmail(Alterar); //Utiliza o método setEmail para alterar o valor da variável do funcionário.

        //Imprime uma linha confirmando a alteração do Email.
        System.out.println("\nVocê alterou o Email com sucesso!");
    }

    //Método para alterar o Número de Telefone do funcionário.
    public static void alterarTelefone(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o Nº de Telefone do funcionário.
        System.out.print("\nInforme o novo Número de Telefone do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String telefoneAlterar = scanner.nextLine();

        objeto.setTelefone(telefoneAlterar); //Utiliza o método setTelefone para alterar o valor da variável do funcionário.

        //Imprime uma linha confirmando a alteração do Nº de Telefone.
        System.out.println("\nVocê alterou o Número de Telefone com sucesso!");
    }

    //Método para alterar o CEP do funcionário.
    public static void alterarCep(Scanner scanner, Funcionario objeto) {

        //Imprime uma linha exigindo o CEP do funcionário.
        System.out.print("\nInforme o novo CEP do funcionário: ");

        //Instancia a variável e lê a entrada do usuário.
        String cepAlterar = scanner.nextLine();

        objeto.setCep(cepAlterar); //Utiliza o método setCep para alterar o valor da variável do funcionário.

        //Imprime uma linha confirmando a alteração do CEP.
        System.out.println("\nVocê alterou o CEP com sucesso!");
    }

    //Método que remove os funcionários.
    private static void removerFuncionario(Scanner scanner) {

        //Imprime linha pedindo por uma entrada.
        System.out.print("\nDigite o apelido do funcionário que deseja remover: ");

        String funcionarioRemover = scanner.nextLine(); // Entrada é lida e em seguida atribuída à variável.

        boolean removido = false; //Instancia uma variável boolean como falso.

        // Percorre a lista de funcionários (listaFuncionarios) usando um loop for-each.
        for (Funcionario objeto : listaFuncionarios) {

            //Verifica se o apelido do funcionário atual é igual ao apelido informado pelo usuário.
            if (objeto.getApelido().equals(funcionarioRemover)) {

                /* 
                 * Caso o apelido seja igual, remove o funcionário da lista e exibe
                 * uma mensagem expressando sucesso na remoção do funcionário.
                 */
                listaFuncionarios.remove(objeto);
                System.out.println("\nFuncionário removido com sucesso!");

                //Atualiza a variável boolean removido para true.
                removido = true;
                // Após a remoção do funcionário, a estrutura condicional é interrompida usando a instrução break.
                break;
            }
        }

        /* Se a variável "removido" for false, significa que nenhum funcionário foi removido,
         * pois nenhum funcionário teve o apelido igual ao informado pelo usuário. Nesse caso,
         * exibe uma mensagem informando que o funcionário não foi encontrado.
         */
        if (!removido) {
            System.out.println("\nFuncionário não encontrado.");
        }
    }

    // Cadastrar automaticamente alguns funcionários.
    private static void cadastrarFuncionariosAutomaticos() {

        /* 
         * Estabelecendo objetos vulgo funcionarios da classe Funcionario e seus respectivos dados. Nome, Cargo, Salário e PIN.
         */
        Funcionario objeto1 = new Funcionario("Coroninha", "CEO", "100.000.00", 101, "Coroninha@jec.com", "+55 (71) 92213-7626","11111-111");
        Funcionario objeto2 = new Funcionario("Lula Jr.", "Cyber Segurança", "70.500.00", 102, "LulaJr.@jec.com", "(74) 92426-2166","22222-222");
        Funcionario objeto3 = new Funcionario("Quer vinho", "Web Designer", "20.000.00", 103, "Quervinho@jec.com", "(77) 93425-2445","33333-333");
        Funcionario objeto4 = new Funcionario("Natal", "Dev Full-Stack", "80.000.00", 104, "Natal@jec.com", "(71) 93025-2601","44444-444");
        Funcionario objeto5 = new Funcionario("Sumido", "Marketing", "9.500.00", 105, "Sumido@jec.com", "(74) 93124-7032","55555-555");
        Funcionario objeto6 = new Funcionario("Jazida", "Dev Full-Stack", "80.000.00", 106, "Jazida@jec.com", "(74) 93784-1589","66666-666");
        Funcionario objeto7 = new Funcionario("Gepeto", "Revisador", "8.500.00", 107, "Gepeto@jec.com", "(74) 93351-0147","77777-777");

        /* 
         * Através do método ".add" adicionamos os funcionarios na ArrayList "listaFuncionarios".
         */
        listaFuncionarios.add(objeto1);
        listaFuncionarios.add(objeto2);
        listaFuncionarios.add(objeto3);
        listaFuncionarios.add(objeto4);
        listaFuncionarios.add(objeto5);
        listaFuncionarios.add(objeto6);
        listaFuncionarios.add(objeto7);
    }

}
