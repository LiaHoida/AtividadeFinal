//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        IEstruturaDinamica ld = new ListaDinamica();

        // Testando inserirSequencia
        System.out.println("Inserindo sequência [1, 2, 3, 4, 5, 6]:");
        ld.inserirSequencia(new Object[]{1, 2, 3, 4, 5, 6});
        ld.exibir();

         // Testando a remoção de sequência
         System.out.println("\nRemovendo sequência [2, 4, 6]:");
         ld.removerSequencia(new Object[]{2, 4, 6});
         ld.exibir();

         // Testando inserirElemento
         System.out.println("\nInserindo o elemento 7:");
         ld.inserirElemento(7);
         ld.exibir();

         // Testando editarElemento
         System.out.println("\nEditando o elemento 3 para 10:");
         ld.editarElemento(3, 10);
         ld.exibir();

         // Testando a busca de um elemento
         System.out.println("\nBuscando o elemento 5:");
         boolean encontrado = ld.buscarElemento(5);
         System.out.println("Elemento 5 encontrado? " + encontrado);

         // Testando ordenarCrescente
         System.out.println("\nOrdenando a lista de forma crescente:");
         ld.ordenarCrescente();
         ld.exibir();

         // Testando ordenarDecrescente
         System.out.println("\nOrdenando a list de forma decrescente:");
         ld.ordenarDecrescente();
         ld.exibir();

          // Testando quantidade de elementos
         System.out.println("\nQuantidade de elementos na lista: " + ld.quantidadeElementos());

         // Testando limpar
         System.out.println("\nLimpando a lista:");
         ld.limpar();
         ld.exibir();

         // Testando a verificação de ld vazia
         System.out.println("\nA lista está vazia? " + ld.estaVazia());
            }
        }


