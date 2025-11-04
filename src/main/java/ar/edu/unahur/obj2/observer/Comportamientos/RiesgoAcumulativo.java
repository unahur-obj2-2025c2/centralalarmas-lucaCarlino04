package ar.edu.unahur.obj2.observer.Comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;

public class RiesgoAcumulativo implements IComportamiento {

    @Override
    public Double calcularRiesgo(List<Alerta> listaAlertas) {
        return listaAlertas.stream().filter(Alerta::esCritica).mapToDouble(a -> a.getNivel()).sum();
    }

}
