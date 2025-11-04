package ar.edu.unahur.obj2.observer.Central;

import ar.edu.unahur.obj2.observer.Alerta;
import ar.edu.unahur.obj2.observer.Entidades.IObserver;

public interface IObservado {
    void agregarObserver(IObserver observador);
    void eliminarObserver(IObserver observador);
    void notificar(Alerta alerta);
}
