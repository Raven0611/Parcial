package Clase;

public class Main {

    public static void main(String[] args) {
        int[][] x = {{2, 3, 2, 5}, {3, 3, 2, 5}, {1, 4, 3, 2}, {2, 3, 4, 5}};

        Clinica clinica = new Clinica("Ayshat", x);

        System.out.println(clinica.toString());
    }

}