package br.com.nexuscloud.main;

import br.com.nexuscloud.controller.CloudManager;
import br.com.nexuscloud.exception.CapacidadeExcedidaException;
import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.Container;
import br.com.nexuscloud.model.Servidor;

public class MainCloud {

    public static void main(String[] args) {

        // Passo 1
        CloudManager manager = new CloudManager();

        // Passos 2 e 3
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Passo 4
        manager.registrarCliente(cliente);
        manager.adicionarServidor(cliente, servidor);

        // Passo 5
        Container c1 = new Container("C-01", 10.0);
        Container c2 = new Container("C-02", 8.0);

       // Passo 6: UNCHECKED - estoura propositalmente
    //try {
       // servidor.alocarContainer(c1);
   //} catch (CapacidadeExcedidaException e) {
    // nunca executa aqui: o servidor está desligado, então a
    // ServidorOfflineException estoura antes e não é capturada
    //}

        // Passo 7: comente a linha do Passo 6 para o programa prosseguir

        // Passo 8
        servidor.ligar();

        // Passo 9: CHECKED — exige try-catch obrigatório
        try {
            servidor.alocarContainer(c1);
            servidor.alocarContainer(c2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        // Passo 10
        System.out.println("Fatura ativa: R$ " + manager.calcularFaturaAtiva(cliente));
    }
}