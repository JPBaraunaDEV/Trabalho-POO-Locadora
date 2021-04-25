package locadoradecarros;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private String chassi;
    private String cor;
    private String tipoCombustivel;
    private String km;
    private int estado; //0 para disponível, 1 para alugado, 2 para manutenção
    static List<Carro> carros = new ArrayList<Carro>();

    public Carro(String marca, String modelo, String placa, String chassi, String cor, String tipoCombustivel, String km, int estado) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.chassi = chassi;
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.km = km;
        this.estado = estado;
    }

    public Carro() {
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    //MÉTODOS USADOS NO CRUD CLIENTE DA CLASSE CLIENTE
    public void Cadastrar(Carro carro) {
        Carro.carros.add(carro);
    }

    public Carro Consultar(String placa) {
        int n = carros.size();

        for (int i = 0; i < n; i++) {
            Carro c = carros.get(i);

            //COMPARA SE A PLACA DO CARRO DA LISTA É IGUAL A PLACA DIGITADA PELO USUÁRIO E RETORNA O CARRO SE TRUE
            if (placa.equals(c.getPlaca())) {
                System.out.print("Dados do carro:\n\n");
                System.out.println("Marca:" + c.getMarca());
                System.out.println("Modelo:" + c.getModelo());
                System.out.println("Placa:" + c.getPlaca());
                System.out.println("Chassi:" + c.getChassi());
                System.out.println("Cor:" + c.getCor());
                System.out.println("Tipo combustível:" + c.getTipoCombustivel());
                System.out.println("Km:" + c.getKm());
                //PRINTA O ESTADO DO CARRO
                switch (c.getEstado()) {
                    case 0:
                        System.out.println("Estado: Disponível" );
                        break;
                    case 1:
                        System.out.println("Estado: Alugado" );
                        break;
                    case 2:
                        System.out.println("Estado: Manutenção" );
                        break;

                }
                return c;
            }

        }
        return null;
    }

    public void Atualizar(Carro carro) {

        Scanner scan = new Scanner(System.in);

        //PROCURA NA LISTA DE CLIENTES O CLIENTE QUE BATE COM O CLIENTE ENVIADO POR PARÂMETRO
        for (int i = 0; i < Carro.carros.size(); i++) {
            if (carro.equals(Carro.carros.get(i))) {

                //RECEBE OS DADOS ATUALIZADOS DO CLIENTE
                System.out.println("Alteração dos dados do carro de placa: " + carro.getPlaca() );
                System.out.println("\nMarca:");
                marca = scan.next();
                Carro.carros.get(i).setMarca(marca);
                System.out.println("Modelo:");
                modelo = scan.next();
                Carro.carros.get(i).setModelo(modelo);
                System.out.println("Cor:");
                cor = scan.next();
                Carro.carros.get(i).setCor(cor);
                System.out.println("Tipo Combustível:");
                tipoCombustivel = scan.next();
                Carro.carros.get(i).setTipoCombustivel(tipoCombustivel);

                //SET ALTERAÇÕES DO CLIENTE
                Carro.carros.set(i, carro);

                //PRINTA OS DADOS ALTERADOS
                System.out.print("Dados do carro atualizados:\n\n");
                System.out.println("Marca:" + carros.get(i).getMarca());
                System.out.println("Modelo:" + carros.get(i).getModelo());
                System.out.println("Placa:" + carros.get(i).getPlaca());
                System.out.println("Chassi:" + carros.get(i).getChassi());
                System.out.println("Cor:" + carros.get(i).getCor());
                System.out.println("Tipo combustível:" + carros.get(i).getTipoCombustivel());
                System.out.println("Km:" + carros.get(i).getKm());
                //PRINTA O ESTADO DO CARRO
                switch (carros.get(i).getEstado()) {
                    case 0:
                        System.out.println("Estado: Disponível" );
                        break;
                    case 1:
                        System.out.println("Estado: Alugado" );
                        break;
                    case 2:
                        System.out.println("Estado: Manutenção" );
                        break;
                }
            }
        }
    }

    public void Remover(Carro carro) {
        Carro.carros.remove(carro);
    }

    public Carro Disponivel() {

        Scanner scan = new Scanner(System.in);

        int n = carros.size();

        for (int i = 0; i < n; i++) {
            Carro c = carros.get(i);

            //COMPARA SE O CARRO DA LISTA ESTA COM O ESTADO DISPONIVEL
            if (c.estado == 0) {
                System.out.print("\nDados do carro: " + i+1 +"\n\n");
                System.out.println("Marca:" + c.getMarca());
                System.out.println("Modelo:" + c.getModelo());
                System.out.println("Placa:" + c.getPlaca());
                System.out.println("Chassi:" + c.getChassi());
                System.out.println("Cor:" + c.getCor());
                System.out.println("Tipo combustível:" + c.getTipoCombustivel());
                System.out.println("Km:" + c.getKm());
                System.out.println("Estado: Disponível" );
            }

        }
        boolean achou = false;

        do{
            System.out.print("Digite a placa do carro escolhido\n\n");
            String p = scan.next();
            for(int j=0; j<n; j++){
                Carro car = carros.get(j);

                if(car.estado==0 && car.getPlaca().equals(p)){
                    achou = true;
                    return car;
                }
            }
        }while(!achou);
        return null;
    }
}