package ar.edu.unahur.obj2.observer.Central;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.Entidades.IObserver;

public class CentralMonitoreo implements IObservado{
    private List<IObserver> entidades = new ArrayList<>();
    private List<Alerta> registroAlertas = new ArrayList<>();
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
        registroAlertas.add(alerta);
        notificar(alerta);
    }

    public Integer alertasTotales() {
        return registroAlertas.size();
    }
    public List<IObserver> getEntidades() {
        return entidades;
    }
    public List<Alerta> getRegistroAlertas() {
        return registroAlertas;
    }
}
