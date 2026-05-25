package jp.algoritmosbusca;

import java.util.ArrayList;
import java.util.List;

public class BuscaA {

    // =========================
    // CLASSE ADJACENTE
    // =========================
    static class Adjacente {

        private Vertice vertice;
        private int custo;

        public Adjacente(Vertice vertice, int custo) {
            this.vertice = vertice;
            this.custo = custo;
        }

        public Vertice getVertice() {
            return vertice;
        }

        public int getCusto() {
            return custo;
        }
    }

    // =========================
    // CLASSE VERTICE
    // =========================
    static class Vertice {

        private String rotulo;
        private int heuristica;
        private boolean visitado;

        private List<Adjacente> adjacentes;

        public Vertice(String rotulo, int heuristica) {

            this.rotulo = rotulo;
            this.heuristica = heuristica;
            this.visitado = false;

            adjacentes = new ArrayList<>();
        }

        public void adicionaAdjacente(
                Vertice vertice,
                int custo
        ) {
            adjacentes.add(
                    new Adjacente(vertice, custo)
            );
        }

        public String getRotulo() {
            return rotulo;
        }

        public int getHeuristica() {
            return heuristica;
        }

        public boolean isVisitado() {
            return visitado;
        }

        public void setVisitado(boolean visitado) {
            this.visitado = visitado;
        }

        public List<Adjacente> getAdjacentes() {
            return adjacentes;
        }
    }

    // =========================
    // CLASSE GRAFO
    // =========================
    static class Grafo {

        public Vertice arad =
                new Vertice("Arad", 366);

        public Vertice zerind =
                new Vertice("Zerind", 374);

        public Vertice oradea =
                new Vertice("Oradea", 380);

        public Vertice sibiu =
                new Vertice("Sibiu", 253);

        public Vertice fagaras =
                new Vertice("Fagaras", 176);

        public Vertice rimnicu =
                new Vertice("Rimnicu Vilcea", 193);

        public Vertice pitesti =
                new Vertice("Pitesti", 100);

        public Vertice bucharest =
                new Vertice("Bucharest", 0);

        public Grafo() {

            arad.adicionaAdjacente(zerind, 75);
            arad.adicionaAdjacente(sibiu, 140);

            zerind.adicionaAdjacente(oradea, 71);

            oradea.adicionaAdjacente(sibiu, 151);

            sibiu.adicionaAdjacente(fagaras, 99);
            sibiu.adicionaAdjacente(rimnicu, 80);

            rimnicu.adicionaAdjacente(pitesti, 97);

            fagaras.adicionaAdjacente(bucharest, 211);

            pitesti.adicionaAdjacente(bucharest, 101);
        }
    }

    // =========================
    // BUSCA A*
    // =========================

    private boolean encontrou = false;

    public void buscar(
            Vertice atual,
            int custoAtual
    ) {

        atual.setVisitado(true);

        System.out.println(
                "\nCidade atual: "
                + atual.getRotulo()
        );

        System.out.println(
                "Custo acumulado: "
                + custoAtual
        );

        if (atual.getHeuristica() == 0) {

            encontrou = true;

            System.out.println(
                    "\nDestino encontrado!"
            );

            System.out.println(
                    "Custo total: "
                    + custoAtual
            );

            return;
        }

        Adjacente melhor = null;

        int menorF = Integer.MAX_VALUE;

        for (Adjacente adj : atual.getAdjacentes()) {

            Vertice vizinho =
                    adj.getVertice();

            if (!vizinho.isVisitado()) {

                int g =
                        custoAtual
                        + adj.getCusto();

                int h =
                        vizinho.getHeuristica();

                int f = g + h;

                System.out.println(
                        "Vizinho: "
                        + vizinho.getRotulo()
                        + " | g="
                        + g
                        + " h="
                        + h
                        + " f="
                        + f
                );

                if (f < menorF) {

                    menorF = f;

                    melhor = adj;
                }
            }
        }

        if (melhor != null && !encontrou) {

            buscar(
                    melhor.getVertice(),
                    custoAtual
                    + melhor.getCusto()
            );
        }
    }

    // =========================
    // MAIN
    // =========================

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        BuscaA busca =
                new BuscaA();

        busca.buscar(
                grafo.arad,
                0
        );
    }
}