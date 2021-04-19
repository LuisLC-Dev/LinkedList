package uaslp.ingenieria.labs;

import uaslp.ingenieria.labs.list.LinkedList;

public class Main {

    public static void main(String[] args) {

        // Wrapper classes -> Integer, Float, Character, Boolean
        //Las wrapper classes son "Inmutables"

        LinkedList<Integer> lista1 = new LinkedList<>();
        LinkedList<String> lista2 = new LinkedList<>();

        lista1.add(1);
        lista1.add(4);
        lista1.add(3);
        lista1.add(7);

        lista2.add("hola");
        lista2.add(" Object ");
        lista2.add(" Oriented ");
        lista2.add(" Programming ");

        lista1.delete(3);

        System.out.println("---------------------");

        System.out.println("El tamaño es:" + lista1.getSize());

        LinkedList<Integer>.Iterator it = lista1.getIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        LinkedList<Integer>.ReverseIterator rit = lista1.getReverseIterator();

        while(it.hasNext()){
            int element = it.next();

            System.out.println("Dato: " + element);
        }

        System.out.println("---------------------");

        LinkedList<String>.Iterator itStrings = lista2.getIterator();

        while(itStrings.hasNext()){
            System.out.println(itStrings.next());
        }
    }
}
