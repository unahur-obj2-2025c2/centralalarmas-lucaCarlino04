package ar.edu.unahur.obj2.observer.Alertas;

public class RegistroAlerta {
    private Alerta alerta;
    private Integer entidadesNotificadas;
    public RegistroAlerta(Alerta alerta, Integer entidadesNotificadas) {
        this.alerta = alerta;
        this.entidadesNotificadas = entidadesNotificadas;
    }

    public Alerta getAlerta() {
        return alerta;
    }

    public Integer getEntidadesNotificadas() {
        return entidadesNotificadas;
    }
}
