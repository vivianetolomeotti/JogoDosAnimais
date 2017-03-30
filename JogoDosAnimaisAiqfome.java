/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author viviane
 */
public class JogoDosAnimaisAiqfome {
    //usa-se um arrayList pois só precisamos buscar o pai e os filhos de um nó, informação que este mesmo nos dá
    //como não é necessária busca direta, não precisamos de uma estrutura mais completa
    static ArrayList<Animal> jogo = new ArrayList<Animal>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inicializaJogo();
        int exit = JOptionPane.showConfirmDialog(null, "Pense em um animal", null, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        //o jogo continua até o usuário mandar fechar
        while (exit != JOptionPane.CANCEL_OPTION) {

            //a primeira pergunta é a raiz
            Animal atual = jogo.get(0);
            int opcao;

            //faz as perguntas nos nós até chegar a uma folha, que é o nome de um animal.
            while (true) {
                String pergunta = atual.getPergunta();
                if (atual.getFilhoDireito() == null && atual.getFilhoEsquerdo() == null) {
                    opcao = JOptionPane.showConfirmDialog(null, "O animal que você pensou é " + pergunta, "Jogo dos animais", 0);
                    break;
                }
                opcao = JOptionPane.showConfirmDialog(null, "O animal que você pensou " + pergunta, "Jogo dos animais", 0);
                if (opcao == 0) {
                    atual = atual.getFilhoEsquerdo();
                } else {
                    atual = atual.getFilhoDireito();
                }
            }

            //se acertou o animal, recomeça o jogo, se errou cadastra o novo animal e o insere na árvore
            if (opcao == 0) {
                JOptionPane.showMessageDialog(null, "Acertei de novo!");
            } else {
                String novoAnimal = JOptionPane.showInputDialog("Qual o animal que você pensou?", atual);
                String novaPergunta = JOptionPane.showInputDialog("Um " + novoAnimal + "_________ mas um " + atual.getPergunta() + " não");
                insereAnimalPergunta(novoAnimal, novaPergunta, atual);
            }
            exit = JOptionPane.showConfirmDialog(null, "Pense em um animal", "Jogo dos animais", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }

    }

    //a pergunta e os dois animais iniciais.
    private static void inicializaJogo() {
        Animal pergunta1 = new Animal("vive na água", null, null, null);
        Animal macaco = new Animal("macaco", pergunta1, null, null);
        Animal tubarao = new Animal("tubarão", pergunta1, null, null);
        pergunta1.setFilhoEsquerdo(tubarao);
        pergunta1.setFilhoDireito(macaco);
        jogo.add(pergunta1);
        jogo.add(macaco);
        jogo.add(tubarao);

    }

    //inserindo um novo animal na árvore
    private static void insereAnimalPergunta(String novoAnimal, String novaPergunta, Animal atual) {
        //aqui, a última pergunta feita passa a apontar para uma nova pergunta.
        //essa pergunta, por sua vez, caso tenha resposta positiva aponta para o novo animal,
        // e caso tenha resposta negativa aponta para o animal que foi a tentativa da adivinhação
        Animal animalNovo = new Animal(novoAnimal, null, null, null);
        Animal perguntaAntiga = atual.getAnterior();
        Animal perguntaNova = new Animal(novaPergunta, perguntaAntiga, animalNovo, atual);

        //atualiza o filho correto de onde a pergunta veio
        if (perguntaAntiga.getFilhoEsquerdo().getPergunta() == atual.getPergunta()) {
            atual.getAnterior().setFilhoEsquerdo(perguntaNova);
        } else {
            atual.getAnterior().setFilhoDireito(perguntaNova);
        }

        animalNovo.setAnterior(perguntaNova);

        atual.setAnterior(perguntaNova);
        jogo.add(animalNovo);
        jogo.add(perguntaNova);

    }

}
