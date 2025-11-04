package ar.edu.unahur.obj2.observer;

public class Alerta {
    private String tipo;
    private Integer nivel;
    public Alerta(String tipo, Integer nivel) {
        if (nivel > 10 || 0 > nivel) {
            throw new IllegalArgumentException("Nivel de alerta incorrecto.");
        }
        this.tipo = tipo;
        this.nivel = nivel;
    }
    public String getTipo() {
        return tipo;
    }
    public Integer getNivel() {
        return nivel;
    }

    public Boolean esCritica() {
        return nivel >= 8;
    }
}
