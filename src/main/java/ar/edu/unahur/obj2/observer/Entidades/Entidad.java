package ar.edu.unahur.obj2.observer.Entidades;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.Comportamientos.IComportamiento;
import ar.edu.unahur.obj2.observer.Comportamientos.RiesgoCritico;

public class Entidad implements IObserver {
    private String nombre;
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

    private List<Alerta> alertasRecibidas = new ArrayList<>();
    private IComportamiento comportamiento = new RiesgoCritico();

    @Override
    public void actualizar(Alerta alerta) {
        alertasRecibidas.add(alerta);
    }

    public Double riesgo() {
        return comportamiento.calcularRiesgo(alertasRecibidas);
    }
}
