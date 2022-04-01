import java.util.Scanner;

public class Aeroport {
    static Scanner input = new Scanner(System.in);
    static Aeroport p = new Aeroport();

    public int NextInt(String msg) {
        System.out.print(msg);
        return input.nextInt();
    }

    public String NextString(String msg) {
        System.out.print(msg);
        return input.next();
    }

    public Avio[] Crear_Aeroport() {
        int capacitat = 3;
        return new Avio[capacitat];
    }

    public void AfegirAvio(Avio[] aeroport) {
        for (int i = 0; i < aeroport.length; i++) {
            aeroport[i] = new Avio(p.NextString("Matricula: "), p.NextInt("Autonomia: "), p.NextInt("Alçada: "), p.NextInt("Capacitat de carrega: "), p.NextInt("Posicio X: "));
        }
    }

    public void controlar(Avio[] aeroport) {

    }

    public static void main(String[] args) {
    }

}
