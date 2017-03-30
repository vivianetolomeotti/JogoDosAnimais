/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author viviane
 */
public class Animal {
    
    String pergunta;
    //essa variável é necessária para o momento da atualização da árvore, para que se saiba onde inserir a nova pergunta
    Animal anterior;
    //o filho esquerdo representa a resposta "SIM" e o direito representa a resposta "NÃO"
    Animal filhoEsquerdo;
    Animal filhoDireito;

    //construtor
    public Animal(String pergunta, Animal anterior, Animal filhoEsquerdo, Animal filhoDireito) {
        this.pergunta = pergunta;
        this.anterior = anterior;
        this.filhoEsquerdo = filhoEsquerdo;
        this.filhoDireito = filhoDireito;
    }

    //getters
    public Animal getAnterior() {
        return anterior;
    }

    public String getPergunta() {
        return pergunta;
    }

    public Animal getFilhoEsquerdo() {
        return filhoEsquerdo;
    }

    public Animal getFilhoDireito() {
        return filhoDireito;
    }

    //setters
    public void setAnterior(Animal anterior) {
        this.anterior = anterior;
    }

    public void setFilhoEsquerdo(Animal filhoEsquerdo) {
        this.filhoEsquerdo = filhoEsquerdo;
    }

    public void setFilhoDireito(Animal filhoDireito) {
        this.filhoDireito = filhoDireito;
    }

}
