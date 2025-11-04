package ar.edu.unahur.obj2.observer.Entidades;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;
import ar.edu.unahur.obj2.observer.Comportamientos.IComportamiento;
import ar.edu.unahur.obj2.observer.Comportamientos.RiesgoCritico;

public class Entidad implements IObserver {
    private String nombre;
    private List<Alerta> alertasRecibidas = new ArrayList<>();
    private IComportamiento comportamiento = new RiesgoCritico();
    public Entidad(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Alerta> getAlertasRecibidas() {
        return alertasRecibidas;
    }

    public IComportamiento getComportamiento() {
        return comportamiento;
    }

    public void setComportamiento(IComportamiento comportamiento) {
        this.comportamiento = comportamiento;
    }

    @Override
    public void actualizar(Alerta alerta) {
        alertasRecibidas.add(alerta);
    }

    public Double riesgo() {
        return comportamiento.calcularRiesgo(alertasRecibidas);
    }

    public Alerta alertaMayorNivel() {
        return alertasRecibidas.stream().max(Comparator.comparingInt(Alerta::getNivel)).orElse(null);
    }
}
