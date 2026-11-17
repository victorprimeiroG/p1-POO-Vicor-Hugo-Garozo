package br.com.nexuscloud.controller;

import br.com.nexuscloud.model.Cliente;
import br.com.nexuscloud.model.Servidor;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloudManager {

    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    public void adicionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.get(cliente).add(servidor);
    }

    public Set<Servidor> getServidores(Cliente cliente) {
        return bancoDeDados.getOrDefault(cliente, Collections.emptySet());
    }

    /**
     * RN04 - Streams: soma o precoPorHora apenas dos servidores LIGADOS.
     */
    public double calcularFaturaAtiva(Cliente c) {
        return bancoDeDados.getOrDefault(c, Collections.emptySet())
                .stream()
                .filter(Servidor::isStatusLigado)
                .mapToDouble(Servidor::getPrecoPorHora)
                .sum();
    }

    public Map<Cliente, Set<Servidor>> getBancoDeDados() {
        return bancoDeDados;
    }
}