public class ListaDinamica implements IEstruturaDinamica {
    private No primeiro;
    private No ultimo;
    private int tamanho;

    public ListaDinamica() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        if(this.primeiro == null) {
            return true;
        }
        return false;
    }


    public void inserirElemento(Object elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            primeiro = novoNo;
            ultimo = novoNo;
        } else {
            ultimo.setProx(novoNo);
            novoNo.setAnterior(ultimo);
            ultimo = novoNo;
        }
        tamanho++;
    }


    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] array = (Object[]) elementos;
            for (Object item : array) {
                inserirElemento(item);
            }
        } else {
            System.out.println("Elemento não foi inserido");
        }
    }


    public boolean removerElemento(Object elemento) {
        if (estaVazia()) {
            return false;
        }

        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {

                if (atual == primeiro) {
                    primeiro = atual.getProx();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    }
                }

                else if (atual == ultimo) {
                    ultimo = atual.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProx(null);
                    }
                }

                else {
                    No anterior = atual.getAnterior();
                    No proximo = atual.getProx();
                    anterior.setProx(proximo);
                    if (proximo != null) {
                        proximo.setAnterior(anterior);
                    }
                }
                tamanho--;
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }




    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] array = (Object[]) elementos;
            for (Object item : array) {
                removerElemento(item);
            }
        } else {
            System.out.println("Ocorreu um erro ao remover");
        }
    }




    public void removerTodasOcorrencias(Object elemento) {
        if (estaVazia()) {
            return;
        }

        No atual = primeiro;
        boolean removido = false;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {

                if (atual == primeiro) {
                    primeiro = atual.getProx();
                    if (primeiro != null) {
                        primeiro.setAnterior(null);
                    }
                }
                else if (atual == ultimo) {
                    ultimo = atual.getAnterior();
                    if (ultimo != null) {
                        ultimo.setProx(null);
                    }
                }

                else {
                    No anterior = atual.getAnterior();
                    No proximo = atual.getProx();
                    anterior.setProx(proximo);
                    if (proximo != null) {
                        proximo.setAnterior(anterior);
                    }
                }
                tamanho--;
                removido = true;
            }
            atual = atual.getProx();
        }


        if (!removido) {
            System.out.println("Nenhuma ocorrência foi encontrada.");
        }
    }

    @Override
    public boolean estaCheia() {
        return false;
    }


    public boolean buscarElemento(Object elemento) {
        if (estaVazia()) {
            return false;
        }

        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                return true;
            }
            atual = atual.getProx();
        }

        return false;
    }





    public void ordenarCrescente() {
        if (estaVazia() || tamanho == 1) {
            return;
        }

        boolean trocado;
        do {
            trocado = false;
            No atual = primeiro;
            while (atual.getProx() != null) {
                if (((Comparable) atual.getConteudo()).compareTo(atual.getProx().getConteudo()) > 0) {
                    Object temp = atual.getConteudo();
                    atual.setConteudo(atual.getProx().getConteudo());
                    atual.getProx().setConteudo(temp);
                    trocado = true;
                }
                atual = atual.getProx();
            }
        } while (trocado);
    }





    public void ordenarDecrescente() {
        if (estaVazia() || tamanho == 1) {
            return;
        }

        boolean trocado;
        do {
            trocado = false;
            No atual = primeiro;
            while (atual.getProx() != null) {
                if (((Comparable) atual.getConteudo()).compareTo(atual.getProx().getConteudo()) < 0) {

                    Object temp = atual.getConteudo();
                    atual.setConteudo(atual.getProx().getConteudo());
                    atual.getProx().setConteudo(temp);
                    trocado = true;
                }
                atual = atual.getProx();
            }
        } while (trocado);
    }



    public int quantidadeElementos() {
        return tamanho;
    }


    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        if (estaVazia()) {
            System.out.println("Lista vazia, nada para editar.");
            return;
        }

        No atual = primeiro;
        while (atual != null) {
            if (atual.getConteudo().equals(elementoAntigo)) {
                atual.setConteudo(elementoNovo);
                return;
            }
            atual = atual.getProx();
        }

        System.out.println("Elemento não encontrado na lista.");
    }


    public void limpar() {
        primeiro = null;
        ultimo = null;
        tamanho = 0;
    }





    public No obterPrimeiroElemento() {
        return primeiro;
    }

    public No obterUltimoElemento() {
        return ultimo;
    }



    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia.");
            return;
        }

        No atual = primeiro;
        System.out.print("Lista: ");
        while (atual != null) {
            System.out.print(atual.getConteudo() + " ");
            atual = atual.getProx();
        }
        System.out.println();
    }
}
