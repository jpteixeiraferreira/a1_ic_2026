package buscaLargura;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Adjacente {

    private Vertice cidade;
    private int custo;

    public Adjacente(Vertice cidade, int custo) {
        this.cidade = cidade;
        this.custo  = custo;
    }

    public Vertice getCidade() { return cidade; }
    public int getCusto()      { return custo;  }
}

class Vertice {

    private String          rotulo;
    private int             distanciaObjetivo;
    private boolean         visitado;
    private List<Adjacente> adjacentes;

    public Vertice(String rotulo, int distanciaObjetivo) {
        this.rotulo            = rotulo;
        this.distanciaObjetivo = distanciaObjetivo;
        this.visitado          = false;
        this.adjacentes        = new ArrayList<>();
    }

    public String          getRotulo()            { return rotulo;            }
    public int             getDistanciaObjetivo() { return distanciaObjetivo; }
    public boolean         isVisitado()           { return visitado;          }
    public void            setVisitado(boolean v) { visitado = v;             }
    public List<Adjacente> getAdjacentes()        { return adjacentes;        }

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

    public List<Vertice> getCidades() { return cidades; }

    private void inicializarCidades() {
        cidades.add(new Vertice("Arad",          366));
        cidades.add(new Vertice("Zerind",         374));
        cidades.add(new Vertice("Oradea",         380));
        cidades.add(new Vertice("Sibiu",          253));
        cidades.add(new Vertice("Fagaras",        176));
        cidades.add(new Vertice("Rimnicu Vilcea", 193));
        cidades.add(new Vertice("Pitesti",        100));
        cidades.add(new Vertice("Timisoara",      329));
        cidades.add(new Vertice("Lugoj",          244));
        cidades.add(new Vertice("Mehadia",        241));
        cidades.add(new Vertice("Dobreta",        242));
        cidades.add(new Vertice("Craiova",        160));
        cidades.add(new Vertice("Bucareste",        0));
        cidades.add(new Vertice("Giurgiu",         77));
        cidades.add(new Vertice("Urziceni",        80));
        cidades.add(new Vertice("Hirsova",        151));
        cidades.add(new Vertice("Eforie",         161));
        cidades.add(new Vertice("Vaslui",         199));
        cidades.add(new Vertice("Iasi",           226));
        cidades.add(new Vertice("Neamt",          234));
    }

    private void criarAdjacencias() {
        Vertice arad     = getVertice("Arad");
        Vertice zerind   = getVertice("Zerind");
        Vertice oradea   = getVertice("Oradea");
        Vertice sibiu    = getVertice("Sibiu");
        Vertice fagaras  = getVertice("Fagaras");
        Vertice rimnicu  = getVertice("Rimnicu Vilcea");
        Vertice pitesti  = getVertice("Pitesti");
        Vertice timisoara= getVertice("Timisoara");
        Vertice lugoj    = getVertice("Lugoj");
        Vertice mehadia  = getVertice("Mehadia");
        Vertice dobreta  = getVertice("Dobreta");
        Vertice craiova  = getVertice("Craiova");
        Vertice bucharest= getVertice("Bucareste");
        Vertice giurgiu  = getVertice("Giurgiu");
        Vertice urziceni = getVertice("Urziceni");
        Vertice hirsova  = getVertice("Hirsova");
        Vertice eforie   = getVertice("Eforie");
        Vertice vaslui   = getVertice("Vaslui");
        Vertice iasi     = getVertice("Iasi");
        Vertice neamt    = getVertice("Neamt");

        arad.adicionarAdjacente(new Adjacente(zerind,    75));
        arad.adicionarAdjacente(new Adjacente(sibiu,    140));
        arad.adicionarAdjacente(new Adjacente(timisoara,118));

        zerind.adicionarAdjacente(new Adjacente(arad,   75));
        zerind.adicionarAdjacente(new Adjacente(oradea, 71));

        oradea.adicionarAdjacente(new Adjacente(zerind,  71));
        oradea.adicionarAdjacente(new Adjacente(sibiu,  151));

        sibiu.adicionarAdjacente(new Adjacente(arad,   140));
        sibiu.adicionarAdjacente(new Adjacente(oradea, 151));
        sibiu.adicionarAdjacente(new Adjacente(fagaras,  99));
        sibiu.adicionarAdjacente(new Adjacente(rimnicu,  80));

        fagaras.adicionarAdjacente(new Adjacente(sibiu,     99));
        fagaras.adicionarAdjacente(new Adjacente(bucharest,211));

        rimnicu.adicionarAdjacente(new Adjacente(sibiu,    80));
        rimnicu.adicionarAdjacente(new Adjacente(pitesti,  97));
        rimnicu.adicionarAdjacente(new Adjacente(craiova, 146));

        pitesti.adicionarAdjacente(new Adjacente(rimnicu,   97));
        pitesti.adicionarAdjacente(new Adjacente(craiova,  138));
        pitesti.adicionarAdjacente(new Adjacente(bucharest,101));

        craiova.adicionarAdjacente(new Adjacente(dobreta, 120));
        craiova.adicionarAdjacente(new Adjacente(rimnicu, 146));
        craiova.adicionarAdjacente(new Adjacente(pitesti, 138));

        timisoara.adicionarAdjacente(new Adjacente(arad,  118));
        timisoara.adicionarAdjacente(new Adjacente(lugoj, 111));

        lugoj.adicionarAdjacente(new Adjacente(timisoara,111));
        lugoj.adicionarAdjacente(new Adjacente(mehadia,   70));

        mehadia.adicionarAdjacente(new Adjacente(lugoj,   70));
        mehadia.adicionarAdjacente(new Adjacente(dobreta, 75));

        dobreta.adicionarAdjacente(new Adjacente(mehadia,  75));
        dobreta.adicionarAdjacente(new Adjacente(craiova, 120));

        bucharest.adicionarAdjacente(new Adjacente(fagaras, 211));
        bucharest.adicionarAdjacente(new Adjacente(pitesti, 101));
        bucharest.adicionarAdjacente(new Adjacente(giurgiu,  90));
        bucharest.adicionarAdjacente(new Adjacente(urziceni, 85));

        giurgiu.adicionarAdjacente(new Adjacente(bucharest, 90));

        urziceni.adicionarAdjacente(new Adjacente(bucharest, 85));
        urziceni.adicionarAdjacente(new Adjacente(hirsova,   98));
        urziceni.adicionarAdjacente(new Adjacente(vaslui,   142));

        hirsova.adicionarAdjacente(new Adjacente(urziceni, 98));
        hirsova.adicionarAdjacente(new Adjacente(eforie,   86));

        eforie.adicionarAdjacente(new Adjacente(hirsova, 86));

        vaslui.adicionarAdjacente(new Adjacente(urziceni,142));
        vaslui.adicionarAdjacente(new Adjacente(iasi,     92));

        iasi.adicionarAdjacente(new Adjacente(vaslui, 92));
        iasi.adicionarAdjacente(new Adjacente(neamt,  87));

        neamt.adicionarAdjacente(new Adjacente(iasi, 87));
    }

    public Vertice getVertice(String rotulo) {
        for (Vertice v : cidades) {
            if (v.getRotulo().equalsIgnoreCase(rotulo)) return v;
        }
        return null;
    }
}

class Largura {

    private Vertice objetivo;
    private boolean status;

    public Largura(Vertice objetivo) {
        this.objetivo = objetivo;
        this.status   = false;
    }

    public void buscar(Vertice inicial) {

        Queue<Vertice> fila   = new LinkedList<>();
        Queue<Integer> custos = new LinkedList<>();

        inicial.setVisitado(true);
        fila.add(inicial);
        custos.add(0);

        System.out.println("Iniciando busca em largura...\n");

        while (!fila.isEmpty()) {

            Vertice atual     = fila.poll();
            int     custoAtual = custos.poll();

            System.out.println(
                "Visitando: " + atual.getRotulo()
                + " | g(n)=" + custoAtual
                + " | h(n)=" + atual.getDistanciaObjetivo()
            );

            if (atual == objetivo) {
                System.out.println(
                    "\nObjetivo alcancado: " + objetivo.getRotulo()
                    + " | custo total=" + custoAtual
                );
                status = true;
                return;
            }

            List<Adjacente> candidatos = new ArrayList<>();
            for (Adjacente adj : atual.getAdjacentes()) {
                if (!adj.getCidade().isVisitado()) {
                    candidatos.add(adj);
                }
            }

            candidatos.sort(Comparator.comparingInt(Adjacente::getCusto));

            System.out.println("Expandindo vizinhos");

            if (!candidatos.isEmpty()) {

                Adjacente melhor    = candidatos.get(0);
                Vertice   vizinho   = melhor.getCidade();
                int       custoAre  = melhor.getCusto();
                int       novoCusto = custoAtual + custoAre;

                vizinho.setVisitado(true);
                fila.add(vizinho);
                custos.add(novoCusto);

                System.out.println(
                    "  Escolhido (menor aresta): " + vizinho.getRotulo()
                    + " | custo aresta=" + custoAre
                    + " | g(n)=" + novoCusto
                    + " | h(n)=" + vizinho.getDistanciaObjetivo()
                );

                for (int k = 1; k < candidatos.size(); k++) {
                    Adjacente desc = candidatos.get(k);
                    System.out.println(
                        "  Descartado (aresta maior): " + desc.getCidade().getRotulo()
                        + " | custo aresta=" + desc.getCusto()
                    );
                }
            }

            System.out.print("Fila atual: ");
            for (Vertice v : fila) System.out.print(v.getRotulo() + " -> ");
            System.out.println("\n--------------------------------------------------");
        }

        System.out.println("Nao ha mais cidades para visitar.");
    }

    public boolean isStatus() { return status; }
}

public class BuscaLargura {

    public static void main(String[] args) {

        Grafo   mapa      = new Grafo();
        Vertice arad      = mapa.getVertice("Arad");
        Vertice bucharest = mapa.getVertice("Bucareste");

        Largura busca = new Largura(bucharest);
        busca.buscar(arad);
    }
}