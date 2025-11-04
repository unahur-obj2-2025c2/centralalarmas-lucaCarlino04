package ar.edu.unahur.obj2.observer.Central;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;
import ar.edu.unahur.obj2.observer.Alertas.RegistroAlerta;
import ar.edu.unahur.obj2.observer.Entidades.IObserver;

public class CentralMonitoreo implements IObservado{
    private List<IObserver> entidades = new ArrayList<>();
    private List<RegistroAlerta> registroAlertas = new ArrayList<>();
    @Override
    public void agregarObserver(IObserver observador) {
        entidades.add(observador);
    }
    @Override
    public void eliminarObserver(IObserver observador) {
        entidades.remove(observador);
    }
    
    @Override
    public void notificar(Alerta alerta) {
        entidades.forEach(e -> e.actualizar(alerta));
    }

    public void emitirAlerta(Alerta alerta) {
        RegistroAlerta nuevaAlerta = new RegistroAlerta(alerta, entidades.size());
        registroAlertas.add(nuevaAlerta);
        notificar(alerta);
    }

    public Integer totalAlertasEmitidas() {
        return registroAlertas.stream().mapToInt(alerta -> alerta.getEntidadesNotificadas()).sum();
    }
    public List<IObserver> getEntidades() {
        return entidades;
    }
    public List<RegistroAlerta> getRegistroAlertas() {
        return registroAlertas;
    }
}
