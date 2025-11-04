package ar.edu.unahur.obj2.observer.Comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;

public class RiesgoPromedio implements IComportamiento {

    @Override
    public Double calcularRiesgo(List<Alerta> listaAlertas) {
        return listaAlertas.stream().mapToInt(alerta -> alerta.getNivel()).average().orElse(0.0);
    }

}
