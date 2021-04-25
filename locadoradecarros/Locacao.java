package locadoradecarros;

import java.util.ArrayList;
import java.util.List;

public class Locacao {

    private double valorLocacao;
    private String horaLocacao;
    private String dataLocacao;
    private String kmAdquirida;
    private boolean devolvido;
    private String horaDevolucao;
    private String dataDevolucao;
    private String kmDevolvida;
    private String codigoLocacao;
    Cliente cli;
    Carro car;
    static List<Locacao> locacoes = new ArrayList<Locacao>();

    public Locacao(double valorLocacao, String horaLocacao, String dataLocacao, String kmAdquirida, boolean devolvido, String horaDevolucao, String dataDevolucao, String kmDevolvida, String codigoLocacao, Cliente cli, Carro car) {
        this.valorLocacao = valorLocacao;
        this.horaLocacao = horaLocacao;
        this.dataLocacao = dataLocacao;
        this.kmAdquirida = kmAdquirida;
        this.devolvido = devolvido;
        this.horaDevolucao = horaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.kmDevolvida = kmDevolvida;
        this.codigoLocacao = codigoLocacao;
        this.cli = cli;
        this.car = car;
    }

    //CONSTRUTOR PARA RETIRADA
    public Locacao(double valorLocacao, String horaLocacao, String dataLocacao, String kmAdquirida, boolean devolvido, String codigoLocacao, Cliente cli, Carro car) {
        this.valorLocacao = valorLocacao;
        this.horaLocacao = horaLocacao;
        this.dataLocacao = dataLocacao;
        this.kmAdquirida = kmAdquirida;
        this.devolvido = devolvido;
        this.codigoLocacao = codigoLocacao;
        this.cli = cli;
        this.car = car;
    }

    //CONSTRUTOR PARA DEVOLUÇÃO
    public Locacao() {
        this.horaDevolucao = horaDevolucao;
        this.dataDevolucao = dataDevolucao;
        this.kmDevolvida = kmAdquirida;
        this.devolvido = devolvido;
    }


    public Locacao(String horaDevolucao, String dataDevolucao, String kmDevolvida, boolean devolvido) {
    }

    public double getValorLocacao() {
        return valorLocacao;
    }

    public void setValorLocacao(float valorLocacao) {
        this.valorLocacao = valorLocacao;
    }

    public String getHoraLocacao() {
        return horaLocacao;
    }

    public void setHoraLocacao(String horaLocacao) {
        this.horaLocacao = horaLocacao;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getKmAdquirida() {
        return kmAdquirida;
    }

    public void setKmAdquirida(String kmAdquirida) {
        this.kmAdquirida = kmAdquirida;
    }

    public boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public String getHoraDevolucao() {
        return horaDevolucao;
    }

    public void setHoraDevolucao(String horaDevolucao) {
        this.horaDevolucao = horaDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getKmDevolvida() {
        return kmDevolvida;
    }

    public void setKmDevolvida(String kmDevolvida) {
        this.kmDevolvida = kmDevolvida;
    }

    public String getCodigoLocacao() {
        return codigoLocacao;
    }

    public void setCodigoLocacao(String codigoLocacao) {
        this.codigoLocacao = codigoLocacao;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
    }

    public Carro getCar() {
        return car;
    }

    public void setCar(Carro car) {
        this.car = car;
    }

    public void Cadastrar(Locacao locacao) {
        Locacao.locacoes.add(locacao);
    }

    public Locacao Consultar(String codigoLocacao) {
        int n = locacoes.size();

        for (int i = 0; i < n; i++) {
            Locacao l = locacoes.get(i);

            //COMPARA SE O CÓDIGO DA LOCAÇÃO É IGUAL AO CÓDIGO DIGITADO PELO USUÁRIO E RETORNA A LOCAÇÃO SE TRUE
            if (codigoLocacao.equals(l.getCodigoLocacao())) {
                System.out.print("\nDados da locação:\n\n");
                System.out.println("Valor Locação:" + l.getValorLocacao());
                System.out.println("Hora Locação:" + l.getHoraLocacao());
                System.out.println("Data Locação:" + l.getDataLocacao());
                System.out.println("Km Adquirida:" + l.getKmAdquirida());
                if(l.getDevolvido()){//PRINTA OS DADOS DA DEVOLUÇÃO
                    System.out.println("Hora Devolução:" + l.getHoraDevolucao());
                    System.out.println("Data Devolução:" + l.getDataDevolucao());
                    System.out.println("Km Devolvida:" + l.getKmDevolvida());
                }
                //DADOS DO CLIENTE
                System.out.print("\nCLIENTE:\n");
                System.out.println("Nome:" + l.cli.getNome());
                System.out.println("Tel:" + l.cli.getTelefone());
                System.out.println("Email:" + l.cli.getEmail());
                System.out.println("Cpf:" + l.cli.getCpf());
                System.out.println("end:" + l.cli.getEndereco());
                //DADOS DO CARRO
                System.out.print("\nCARRO:\n");
                System.out.println("Marca:" + l.car.getMarca());
                System.out.println("Modelo:" + l.car.getModelo());
                System.out.println("Placa:" + l.car.getPlaca());
                System.out.println("Chassi:" + l.car.getChassi());
                System.out.println("Cor:" + l.car.getCor());
                System.out.println("Tipo combustível:" + l.car.getTipoCombustivel());
                System.out.println("Km:" + l.car.getKm());

                return l;
            }

        }
        return null;
    }
}