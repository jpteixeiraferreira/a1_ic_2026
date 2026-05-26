package buscaA;

import java.util.ArrayList;
import java.util.List;

class Adjacente {
    private Vertice cidade;
    private int custo;

    public Adjacente(Vertice cidade, int custo) {
        this.cidade = cidade;
        this.custo = custo;
    }

    public Vertice getCidade() {
        return cidade;
    }

    public int getCusto() {
        return custo;
    }
}

class Vertice {
    private String rotulo;
    private int distanciaObjetivo;
    private boolean visitado;
    private List<Adjacente> adjacentes;

    public Vertice(String rotulo, int distanciaObjetivo) {
        this.rotulo = rotulo;
        this.distanciaObjetivo = distanciaObjetivo;
        this.visitado = false;
        this.adjacentes = new ArrayList<>();
    }

    public String getRotulo() {
        return rotulo;
    }

    public int getDistanciaObjetivo() {
        return distanciaObjetivo;
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

    public void adicionarAdjacente(Adjacente adj) {
        adjacentes.add(adj);
    }
}

class Grafo {
    private List<Vertice> cidades;

    public Grafo() {
        cidades = new ArrayList<>();
        inicializarCidades();
        criarAdjacencias();
    }

    public List<Vertice> getCidades() {
        return cidades;
    }

    private void inicializarCidades() {

        Vertice arad = new Vertice("Arad", 366);
        Vertice bucharest = new Vertice("Bucareste", 0);
        Vertice craiova = new Vertice("Craiova", 160);
        Vertice dobreta = new Vertice("Dobreta", 242);
        Vertice eforie = new Vertice("Eforie", 161);
        Vertice fagaras = new Vertice("Fagaras", 176);
        Vertice giurgiu = new Vertice("Giurgiu", 77);
        Vertice hirsova = new Vertice("Hirsova", 151);
        Vertice iasi = new Vertice("Iasi", 226);
        Vertice lugoj = new Vertice("Lugoj", 244);
        Vertice mehadia = new Vertice("Mehadia", 241);
        Vertice neamt = new Vertice("Neamt", 234);
        Vertice oradea = new Vertice("Oradea", 380);
        Vertice pitesti = new Vertice("Pitesti", 100);
        Vertice rimnicu = new Vertice("Rimnicu Vilcea", 193);
        Vertice sibiu = new Vertice("Sibiu", 253);
        Vertice timisoara = new Vertice("Timisoara", 329);
        Vertice urziceni = new Vertice("Urziceni", 80);
        Vertice vaslui = new Vertice("Vaslui", 199);
        Vertice zerind = new Vertice("Zerind", 374);

        cidades.add(arad);
        cidades.add(zerind);
        cidades.add(oradea);
        cidades.add(sibiu);
        cidades.add(fagaras);
        cidades.add(rimnicu);
        cidades.add(pitesti);
        cidades.add(timisoara);
        cidades.add(lugoj);
        cidades.add(mehadia);
        cidades.add(dobreta);
        cidades.add(craiova);
        cidades.add(bucharest);
        cidades.add(giurgiu);
        cidades.add(urziceni);
        cidades.add(hirsova);
        cidades.add(eforie);
        cidades.add(vaslui);
        cidades.add(iasi);
        cidades.add(neamt);
    }

    private void criarAdjacencias() {

        Vertice arad = getVertice("Arad");
        Vertice zerind = getVertice("Zerind");
        Vertice sibiu = getVertice("Sibiu");
        Vertice timisoara = getVertice("Timisoara");
        Vertice lugoj = getVertice("Lugoj");
        Vertice mehadia = getVertice("Mehadia");
        Vertice dobreta = getVertice("Dobreta");
        Vertice craiova = getVertice("Craiova");
        Vertice rimnicu = getVertice("Rimnicu Vilcea");
        Vertice fagaras = getVertice("Fagaras");
        Vertice pitesti = getVertice("Pitesti");
        Vertice bucharest = getVertice("Bucareste");
        Vertice giurgiu = getVertice("Giurgiu");
        Vertice urziceni = getVertice("Urziceni");
        Vertice hirsova = getVertice("Hirsova");
        Vertice eforie = getVertice("Eforie");
        Vertice vaslui = getVertice("Vaslui");
        Vertice iasi = getVertice("Iasi");
        Vertice neamt = getVertice("Neamt");
        Vertice oradea = getVertice("Oradea");

        arad.adicionarAdjacente(new Adjacente(zerind, 75));
        arad.adicionarAdjacente(new Adjacente(sibiu, 140));
        arad.adicionarAdjacente(new Adjacente(timisoara, 118));

        zerind.adicionarAdjacente(new Adjacente(arad, 75));
        zerind.adicionarAdjacente(new Adjacente(oradea, 71));

        oradea.adicionarAdjacente(new Adjacente(zerind, 71));
        oradea.adicionarAdjacente(new Adjacente(sibiu, 151));

        sibiu.adicionarAdjacente(new Adjacente(arad, 140));
        sibiu.adicionarAdjacente(new Adjacente(oradea, 151));
        sibiu.adicionarAdjacente(new Adjacente(fagaras, 99));
        sibiu.adicionarAdjacente(new Adjacente(rimnicu, 80));

        fagaras.adicionarAdjacente(new Adjacente(sibiu, 99));
        fagaras.adicionarAdjacente(new Adjacente(bucharest, 211));

        rimnicu.adicionarAdjacente(new Adjacente(sibiu, 80));
        rimnicu.adicionarAdjacente(new Adjacente(pitesti, 97));
        rimnicu.adicionarAdjacente(new Adjacente(craiova, 146));

        pitesti.adicionarAdjacente(new Adjacente(rimnicu, 97));
        pitesti.adicionarAdjacente(new Adjacente(craiova, 138));
        pitesti.adicionarAdjacente(new Adjacente(bucharest, 101));

        craiova.adicionarAdjacente(new Adjacente(dobreta, 120));
        craiova.adicionarAdjacente(new Adjacente(rimnicu, 146));
        craiova.adicionarAdjacente(new Adjacente(pitesti, 138));

        timisoara.adicionarAdjacente(new Adjacente(arad, 118));
        timisoara.adicionarAdjacente(new Adjacente(lugoj, 111));

        lugoj.adicionarAdjacente(new Adjacente(timisoara, 111));
        lugoj.adicionarAdjacente(new Adjacente(mehadia, 70));

        mehadia.adicionarAdjacente(new Adjacente(lugoj, 70));
        mehadia.adicionarAdjacente(new Adjacente(dobreta, 75));

        dobreta.adicionarAdjacente(new Adjacente(mehadia, 75));
        dobreta.adicionarAdjacente(new Adjacente(craiova, 120));

        bucharest.adicionarAdjacente(new Adjacente(fagaras, 211));
        bucharest.adicionarAdjacente(new Adjacente(pitesti, 101));
        bucharest.adicionarAdjacente(new Adjacente(giurgiu, 90));
        bucharest.adicionarAdjacente(new Adjacente(urziceni, 85));

        giurgiu.adicionarAdjacente(new Adjacente(bucharest, 90));

        urziceni.adicionarAdjacente(new Adjacente(bucharest, 85));
        urziceni.adicionarAdjacente(new Adjacente(hirsova, 98));
        urziceni.adicionarAdjacente(new Adjacente(vaslui, 142));

        hirsova.adicionarAdjacente(new Adjacente(urziceni, 98));
        hirsova.adicionarAdjacente(new Adjacente(eforie, 86));

        eforie.adicionarAdjacente(new Adjacente(hirsova, 86));

        vaslui.adicionarAdjacente(new Adjacente(urziceni, 142));
        vaslui.adicionarAdjacente(new Adjacente(iasi, 92));

        iasi.adicionarAdjacente(new Adjacente(vaslui, 92));
        iasi.adicionarAdjacente(new Adjacente(neamt, 87));

        neamt.adicionarAdjacente(new Adjacente(iasi, 87));
    }

    public Vertice getVertice(String rotulo) {

        for (Vertice v : cidades) {

            if (v.getRotulo().equalsIgnoreCase(rotulo)) {
                return v;
            }
        }

        return null;
    }
}

class AEstrela {

    private Vertice objetivo;
    private boolean status;

    public AEstrela(Vertice objetivo) {
        this.objetivo = objetivo;
        this.status = false;
    }

    public void buscar(Vertice atual) {
        buscar(atual, 0);
    }

private void buscar(Vertice atual, int custoAtual) {

    int hAtual = atual.getDistanciaObjetivo();
    int fAtual = custoAtual + hAtual;

    System.out.println(
            "Visitando: " + atual.getRotulo()
            + " | g=" + custoAtual
            + " | h=" + hAtual
            + " | f=" + fAtual
    );

    atual.setVisitado(true);

    if (atual == objetivo) {

        System.out.println(
                "Objetivo alcançado: "
                + objetivo.getRotulo()
                + " | Custo total=" + custoAtual
        );

        status = true;

        return;
    }

    Vertice proximo = null;

    int menorValor = Integer.MAX_VALUE;

    int novoCusto = 0;

    for (Adjacente adj : atual.getAdjacentes()) {

        Vertice vizinho = adj.getCidade();

        if (!vizinho.isVisitado()) {

            int g = custoAtual + adj.getCusto();

            int h = vizinho.getDistanciaObjetivo();

            int f = g + h;

            System.out.println(
                    "  Avaliando: " + vizinho.getRotulo()
                    + " | g=" + g
                    + " | h=" + h
                    + " | f=" + f
            );

            if (f < menorValor) {

                menorValor = f;

                proximo = vizinho;

                novoCusto = g;
            }
        }
    }

    if (proximo != null) {

        System.out.println(
                ">> Próxima escolhida: "
                + proximo.getRotulo()
                + " | menor f=" + menorValor
        );

        System.out.println("--------------------------------");

        buscar(proximo, novoCusto);

    } else {

        System.out.println(
                "Não há mais cidades para visitar a partir de "
                + atual.getRotulo()
        );
    }
}

    public boolean isStatus() {
        return status;
    }
}

public class BuscaA {

    public static void main(String[] args) {

        Grafo mapa = new Grafo();

        Vertice arad = mapa.getVertice("Arad");

        Vertice bucharest =
                mapa.getVertice("Bucareste");

        AEstrela busca =
                new AEstrela(bucharest);

        busca.buscar(arad);
    }
}