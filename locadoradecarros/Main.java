package locadoradecarros;


import java.util.Scanner;


//Bibliotecas importadas para data e hora função dataAcao()

import java.util.Calendar;
import java.util.Locale;
import java.text.DateFormat;
import java.util.Date;

public class Main {

    //CRUD PRINCIPAL
    public static int Crud() {

        Scanner scan = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("Locadora de Carros\n");
            System.out.println("1 - Cliente");
            System.out.println("2 - Carro");
            System.out.println("3 - Locação");
            System.out.println("0 - Sair");
            opcao = scan.nextInt();

            if (opcao < 0 || opcao > 3) {
                System.out.println("Opção inválida\n");
            }
        } while (opcao < 0 || opcao > 3);

        return opcao;
    }

    //CRUD DO CLIENTE
    public static int CrudCliente() {

        Scanner scan = new Scanner(System.in);
        Cliente cliente = new Cliente();
        String nome;
        String tel;
        String email;
        String cpf;
        String end;
        boolean existe;
        int opcao;

        do {
            System.out.println("Cliente\n");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            opcao = scan.nextInt();

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida\n");
            } else {
                switch (opcao) {
                    case 1://Cadastrar
                        System.out.println("Nome: ");
                        nome = scan.next();
                        System.out.println("Telefone: ");
                        tel = scan.next();
                        System.out.println("email: ");
                        email = scan.next();
                        System.out.println("CPF: ");
                        cpf = scan.next();
                        System.out.println("Endereço: ");
                        end = scan.next();

                        //CADASTRA OS DADOS DO CLIENTE NA LISTA CLIENTES
                        cliente.Cadastrar(new Cliente(nome, tel, email, cpf, end));

                        //passando um cliente da lista para variavel c1
                        //Cliente c1 = Cliente.clientes.get(0);
                        break;

                    case 2://Consultar
                        System.out.println("\nDigite o CPF para consulta: ");
                        cpf = scan.next();
                        Cliente clienteaux = cliente.Consultar(cpf);

                        if (clienteaux == null) {
                            System.out.println("Cpf não cadastrado.\n");
                        }

                        break;

                    case 3:
                        System.out.println("Digite o CPF para alteracao: ");
                        cpf = scan.next();
                        clearBuffer(scan);
                        Cliente clienteatt = cliente.Consultar(cpf);

                        if (clienteatt == null) {
                            System.out.println("Cpf não cadastrado.\n");
                        } else {
                            cliente.Atualizar(clienteatt);
                        }
                        break;

                    case 4:
                        System.out.println("Digite o CPF para consulta: ");
                        cpf = scan.next();
                        clearBuffer(scan);
                        Cliente clienterem = cliente.Consultar(cpf);

                        if (clienterem == null) {
                            System.out.println("Cpf não cadastrado.\n");
                        } else {
                            cliente.Remover(clienterem);
                            System.out.println("Cliente removido.\n");
                        }
                        break;
                }
            }
        } while (opcao < 1 || opcao > 4);

        return opcao;
    }

    //Registra a data e hora da operação efetuada
    public static void dataAcao(){
        Calendar calendario = Calendar.getInstance();
        Date data = calendario.getTime();
        DateFormat hora = DateFormat.getTimeInstance();
        Locale brasil = new Locale("pt", "BR"); //Retorna a língua e o país
        DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
        System.out.println("\nData e hora da operação: " + f2.format(data) +" "+ hora.format(data));
    }

    //CRUD DO CARRO
    public static int CrudCarro() {

        Scanner scan = new Scanner(System.in);
        Carro carro = new Carro();
        String marca;
        String modelo;
        String placa;
        String chassi;
        String cor;
        String tipoCombustivel;
        String km;
        int estado;
        int opcao;

        do {
            System.out.println("Carro\n");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Consultar");
            System.out.println("3 - Atualizar");
            System.out.println("4 - Remover");
            opcao = scan.nextInt();

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida\n");
            }else{
                switch (opcao) {
                    case 1://Cadastrar
                        System.out.println("Marca: ");
                        marca = scan.next();
                        System.out.println("Modelo: ");
                        modelo = scan.next();
                        System.out.println("Placa: ");
                        placa = scan.next();
                        System.out.println("Chassi: ");
                        chassi = scan.next();
                        System.out.println("Cor: ");
                        cor = scan.next();
                        System.out.println("Tipo cobustível: ");
                        tipoCombustivel = scan.next();
                        System.out.println("Quilometragem: ");
                        km = scan.next();
                        do{
                            System.out.println("Estado: ");
                            System.out.println("0 - DISPONÍVEL: ");
                            System.out.println("1 - ALUGADO: ");
                            System.out.println("2 - MANUTENÇÃO: ");
                            estado = scan.nextInt();
                            clearBuffer(scan);

                            if(estado<0 || estado>2){
                                System.out.println("Estado deve ser entre 0 e 2 ");
                            }
                        }while(estado<0 || estado>2);

                        //CADASTRA OS DADOS DO CLIENTE NA LISTA CLIENTES
                        carro.Cadastrar(new Carro(marca, modelo, placa, chassi, cor, tipoCombustivel, km, estado));
                        break;

                    case 2://Consultar
                        System.out.println("\nDigite a PLACA para consulta: ");
                        placa = scan.next();
                        Carro carroAux = carro.Consultar(placa);

                        if (carroAux == null) {
                            System.out.println("Placa não cadastrada.\n");
                        }
                        break;

                    case 3:
                        System.out.println("Digite a PLACA para alteracao: ");
                        placa = scan.next();
                        Carro carroAtt = carro.Consultar(placa);

                        if (carroAtt == null) {
                            System.out.println("Placa não cadastrada.\n");
                        } else {
                            carro.Atualizar(carroAtt);
                        }
                        break;

                    case 4:
                        System.out.println("Digite a PLACA para consulta: ");
                        placa = scan.next();
                        Carro carroRem = carro.Consultar(placa);

                        if (carroRem == null) {
                            System.out.println("Placa não cadastrada.\n");
                        } else {
                            carro.Remover(carroRem);
                            System.out.println("Carro removido.\n");
                        }
                        break;
                }
            }
        } while (opcao < 1 || opcao > 4);

        return opcao;
    }

    //CRUD DA LOCAÇÃO
    public static int CrudLocacao() {

        Scanner scan = new Scanner(System.in);
        Carro carro = new Carro();
        Cliente cliente = new Cliente();
        String cpf;
        Locacao locacao = new Locacao();
        double valorLocacao;
        String horaLocacao;
        String dataLocacao;
        String kmAdquirida;
        boolean devolvido;
        String horaDevolucao;
        String dataDevolucao;
        String kmDevolvida;
        String codigoLocacao;
        int opcao;

        do {
            System.out.println("Locação\n");
            System.out.println("1 - Retirada");
            System.out.println("2 - Devolução");
            System.out.println("3 - Consulta");
            opcao = scan.nextInt();

            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida\n");
            }else{
                switch (opcao) {
                    case 1://Retirada
                        //RECEBE O CLIENTE
                        System.out.println("\nDigite o CPF para consulta: ");
                        cpf = scan.next();
                        Cliente clienteAux = cliente.Consultar(cpf);
                        if (clienteAux == null) {
                            System.out.println("Cpf não cadastrado.\n");
                        } else {
                            //RECEBE O CARRO
                            Carro carroAux = carro.Disponivel();
                            if(carroAux == null){
                                System.out.println("Carro não cadastrado.\n");
                            }else{
                                //RECEBE OS DADOS DA LOCAÇÃO E REGISTRA
                                carroAux.setEstado(1);
                                System.out.println("Dados da locação:\n");
                                System.out.println("Digite o valor da locação: ");
                                valorLocacao = scan.nextDouble();
                                clearBuffer(scan);
                                System.out.println("Digite a hora da locação: ");
                                horaLocacao = scan.next();
                                System.out.println("Digite a data da locação: ");
                                dataLocacao = scan.next();
                                System.out.println("Digite a quilometragem adquirida do carro: ");
                                kmAdquirida = scan.next();
                                //clearBuffer(scan);

                                devolvido = false;
                                System.out.println("Digite o código da locação:");
                                codigoLocacao = scan.next();

                                locacao.Cadastrar(new Locacao(valorLocacao, horaLocacao, dataLocacao, kmAdquirida, devolvido, codigoLocacao, clienteAux, carroAux));
                                dataAcao();
                            }
                        }
                        break;

                    case 2://devolução
                        System.out.println("\nDigite o código de locação para fazer a devolução: ");
                        codigoLocacao = scan.next();
                        Locacao locacaoAux = locacao.Consultar(codigoLocacao);

                        if (locacaoAux == null) {
                            System.out.println("Código não localizado.\n");
                        }else if(!locacao.getDevolvido()){
                            System.out.println("Digite a hora da devolução: ");
                            horaDevolucao = scan.next();
                            System.out.println("Digite a data da devolução: ");
                            dataDevolucao = scan.next();
                            System.out.println("Digite a quilometragem devolvida do carro: ");
                            kmDevolvida = scan.next();
                            clearBuffer(scan);
                            devolvido = true;
                            locacaoAux.car.setEstado(0);

                            locacao.Cadastrar(new Locacao(horaDevolucao, dataDevolucao, kmDevolvida, devolvido));
                            dataAcao();
                        }else{
                            System.out.println("Devolução já realizada.\n");
                        }
                        break;

                    case 3:
                        System.out.println("\nDigite o código de locação para consultar: ");
                        codigoLocacao = scan.next();
                        Locacao locacaoAtt = locacao.Consultar(codigoLocacao);

                        if (locacaoAtt == null) {
                            System.out.println("Código não cadastrado.\n");
                        }
                        break;
                }
            }
        } while (opcao < 1 || opcao > 3);

        return opcao;
    }

    //MAIN
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int opCrud, opcao;

        Carro c = new Carro();

        //RODA O CRUD ATÉ QUE A OPÇÃO SAIR SEJA SELECIONADA
        do {
            opCrud = Crud();

            switch (opCrud) {
                //CASO ESCOLHA O MENU DO CLIENTE
                case 1:
                    opcao = CrudCliente();
                    //FINALIZADO - IDEIA: BOOLEAN PARA SABER SE O CLIENTE ESTA COM ALGUM CARRO EM SUA POSSE,
                    //E NA CONSULTA APRESENTAR OS DADOS DO CLIENTE E CARRO TAMBÉM
                    break;
                //CASO ESCOLHA O MENU DO CARRO
                case 2:
                    opcao = CrudCarro();
                    //DESENVOLVER AQUI AS FUNCIONALIDADES DO CRUDCARRO()
                    break;

                case 3:
                    opcao = CrudLocacao();
                    //DESENVOLVER AQUI AS FUNCIONALIDADES DO CRUDLOCACAO()
                    break;
            }
        } while (opCrud != 0);

    }

    private static void clearBuffer(Scanner scan) {
        if (scan.hasNextLine()) {
            scan.nextLine();
        }
    }
}