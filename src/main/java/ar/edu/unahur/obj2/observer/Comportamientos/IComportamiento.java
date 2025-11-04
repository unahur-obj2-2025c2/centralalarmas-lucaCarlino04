package ar.edu.unahur.obj2.observer.Comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;

public interface IComportamiento {
    Double calcularRiesgo(List<Alerta> listaAlertas);
}
