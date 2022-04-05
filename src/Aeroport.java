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
            boolean correcto = false;
            String matricula = "";
            while (!correcto) {
                matricula = p.NextString("Matricula: ");
                if (p.MatriculaLibre(matricula, aeroport)) correcto = true;
                else System.out.println("Matricula repetida");
            }
            aeroport[i] = new Avio(matricula, p.NextInt("Autonomia: "), p.NextInt("Capacitat de carrega: "));
        }
    }

    public void controlar(Avio[] aeroport) {
        for (Avio avioA : aeroport) {
            for (Avio avioB : aeroport) {
                if (avioA != avioB) {
                    if (avioA.getAlititud() == avioB.getAlititud()) {
                        if ((avioA.getPos() == avioB.getPos())) {
                            System.out.printf("\nL'avio %s esta en perill amb l'avio %s\nEstan sobreposats\n", avioA.getMatricula(), avioB.getMatricula());
                        }
                        else if ((avioA.getPos() == avioB.getPos() + 1) || (avioA.getPos() == avioB.getPos() - 1)) {
                            System.out.printf("\nL'avio %s esta en perill amb l'avio %s\nEstan massa aprop\n", avioA.getMatricula(), avioB.getMatricula());
                        }
                    }
                }
            }
        }
    }

    public boolean MatriculaLibre(String matricula, Avio[] aeroport) {
        for (Avio avio : aeroport) {
            if (avio == null) break;
            else if (avio.getMatricula().equals(matricula)) return false;
        }
        return true;
    }

    public Avio AvionXMatricula(String matricula, Avio[] aeroport) {
        for (Avio avio : aeroport) {
            if (avio == null) break;
            else if (avio.getMatricula().equals(matricula)) return avio;
        }
        return null;
    }

    public static void main(String[] args) {
        Avio[] aeroport = new Avio[0];
        boolean stop = false;
        boolean creat = false;
        boolean avions = false;
        while (!stop) {
            if (!creat) {
                System.out.println("Benvingut al controlador del espai aeri\nQue vols fer?\n1- Crear aeroport\n0- Sortir");
                int opcioInt = p.NextInt("Opcio: ");
                if (opcioInt == 1) {
                    aeroport = p.Crear_Aeroport();
                    creat = true;
                    char opcioChar = p.NextString("Vols afegir avions? 'S' o 'N': ").toUpperCase().charAt(0);
                    if (opcioChar == 'S') {
                        p.AfegirAvio(aeroport);
                        avions = true;
                    }
                }
                else stop = true;
            }
            else if (!avions) {
                System.out.println("\nBenvingut al controlador del espai aeri\nQue vols fer?\n1- Afegir avions\n0- Sortir");
                int opcioInt = p.NextInt("Opcio: ");
                if (opcioInt == 1) {
                    p.AfegirAvio(aeroport);
                    avions = true;
                }
                else stop = true;
            }
            else {
                int opcioInt;
                char opcioChar;
                System.out.println("\nBenvingut al controlador del espai aeri\nQue vols fer?\n1- Mostrar info avions\n2- Moure avions\n3- Controlar perills\n0- Sortir");
                opcioInt = p.NextInt("Opcio: ");
                switch (opcioInt) {
                    case 1 -> {
                        for (Avio avio : aeroport) avio.MostrarInfo();
                        System.out.println();
                    }
                    case 2 -> {
                        boolean mover = true;
                        while (mover) {
                            opcioChar = p.NextString("Vols moure un avio? 'S' o 'N': ").toUpperCase().charAt(0);
                            if (opcioChar == 'S') {
                                String matricula = p.NextString("Matricula: ");
                                if (!p.MatriculaLibre(matricula, aeroport)) {
                                    Avio avio = p.AvionXMatricula(matricula, aeroport);
                                    opcioChar = p.NextString("Vols modificar la posicio X o l'alçada 'X' o 'Y': ").toUpperCase().charAt(0);
                                    if (opcioChar == 'X') {
                                        opcioInt = p.NextInt("endavant (1) endarrere (0): ");
                                        if (opcioInt == 1) avio.ModificarPos(true);
                                        else if (opcioInt == 0) avio.ModificarPos(false);
                                    } else if (opcioChar == 'Y') {
                                        opcioInt = p.NextInt("Amunt (1) Avall (0): ");
                                        if (opcioInt == 1) avio.ModificarAlt(true);
                                        else if (opcioInt == 0) avio.ModificarAlt(false);
                                    }
                                } else System.out.println("Matricula invalida");
                            } else mover = false;
                        }
                    }
                    case 3 -> p.controlar(aeroport);
                    default -> stop = true;
                }
            }
        }
    }
}
