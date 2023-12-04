/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package a3;
import java.io.*;
import java.util.*;
public class Fase1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("entrada2.txt"));
        PrintWriter writer = new PrintWriter(new FileWriter("saida.txt"));

        HashMap<String, HashSet<String>> pessoas = new HashMap<>();

        String line;
        while ((line = reader.readLine()) != null) {
            String[] comando = line.split(" ");
            String[] names;
            HashSet<String> group;

            switch (comando[0]) {
                case "grupo:":
                    names = Arrays.copyOfRange(comando, 2, comando.length);
                    group = new HashSet<>();
                    Collections.addAll(group, names);

                    for (String name : group) {
                        pessoas.put(name, group);
                    }
                    break;

                case "existe:":
                    if (pessoas.containsKey(comando[1])) {
                        writer.println("[" + comando[1] + "] existe");
                    } else {
                        writer.println("[" + comando[1] + "] não existe");
                    }
                    break;

                case "conhece:":
                    String nome1 = comando[1];
                    String nome2 = comando[2];

                    if (pessoas.get(nome1) == pessoas.get(nome2)) {
                        writer.println("[" + nome1 + "] conhece [" + nome2 + "]");
                    } else {
                        writer.println("[" + nome1 + "] não conhece [" + nome2 + "]");
                    }
                    break;
            }
        }
        writer.close();
        reader.close();
    }
}