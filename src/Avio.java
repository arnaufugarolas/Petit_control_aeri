public class Avio {
    private String matricula;
    private int autonomia;
    private int alititud;
    private int capacitat;
    private int pos;

    public Avio(String matricula, int autonomia, int capacitat) {
        this.matricula = matricula;
        this.autonomia = autonomia;
        this.alititud = 0;
        this.capacitat = capacitat;
        this.pos = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getAlititud() {
        return alititud;
    }

    public void setAlititud(int alititud) {
        this.alititud = alititud;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public void ModificarPos(boolean direccio) {
        if (direccio) this.setPos(this.getPos() + 1);
        else this.setPos(this.getPos() - 1);
    }

    public void ModificarAlt(boolean direccio) {
        if (direccio) this.setAlititud(this.getAlititud() + 1);
        else this.setAlititud(this.getAlititud() - 1);
    }

    public void MostrarInfo() {
        System.out.printf("\nAvio: %s\n - Autonomia: %d\n - Capacitat: %d\n - Posicio X: %d\n - Alititud: %d\n", this.getMatricula(), this.getAutonomia(), this.getCapacitat(), this.getPos(), this.getAlititud());
    }

}