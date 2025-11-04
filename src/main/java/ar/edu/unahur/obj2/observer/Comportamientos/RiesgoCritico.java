package ar.edu.unahur.obj2.observer.Comportamientos;

import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;

public class RiesgoCritico implements IComportamiento {

    @Override
    public Double calcularRiesgo(List<Alerta> listaAlertas) {
        if (!listaAlertas.isEmpty()) {
            Alerta ultimaAlerta = listaAlertas.getLast();
            return ultimaAlerta.esCritica() ? 10.0 : ultimaAlerta.getNivel();
        } else {
            return 0.0;
        }
    }
}
