package ar.edu.unahur.obj2.observer;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Alertas.Alerta;
import ar.edu.unahur.obj2.observer.Central.CentralMonitoreo;
import ar.edu.unahur.obj2.observer.Comportamientos.RiesgoPromedio;
import ar.edu.unahur.obj2.observer.Entidades.Entidad;
import ar.edu.unahur.obj2.observer.Excepciones.NivelDeAlertaIncorrectoException;

public class MainTest {
    private CentralMonitoreo central;
    private Entidad entidad1;
    private Entidad entidad2;
    private Alerta calor;
    private Alerta lluvia;

    @BeforeEach
    void setUp() {
        central = new CentralMonitoreo();
        entidad1 = new Entidad("Hospital alemán");
        entidad2 = new Entidad("Hospital suizo");
        calor =new Alerta("calor", 6);
        lluvia = new Alerta("lluvia", 8);
        central.agregarObserver(entidad1);
        central.agregarObserver(entidad2);
    }

    @Test
    void dadoElSetUp_alAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo() {
        central.emitirAlerta(calor);
        central.emitirAlerta(lluvia);
        assertTrue(entidad1.getAlertasRecibidas().contains(calor) && entidad2.getAlertasRecibidas().contains(lluvia));
        assertEquals(10, entidad1.riesgo());
    }

    @Test
    void dadoElSetUp_alCambiarElComportamientoYAgregarAlertas_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo() {
        entidad1.setComportamiento(new RiesgoPromedio());
        central.emitirAlerta(calor);
        central.emitirAlerta(lluvia);
        assertEquals(7, entidad1.riesgo());
        assertEquals(10, entidad2.riesgo());
    }

    @Test
    void dadoElSetUp_alAgregarAlertasQuitarUnaEntidadYAgregaNuevaAlerta_SeVerificaCorretamenteLasAlertasRecibidasYElRiesgo() {
        central.emitirAlerta(calor);
        central.emitirAlerta(lluvia);
        central.eliminarObserver(entidad1);
        Alerta granizo = new Alerta("granizo", 7);
        central.emitirAlerta(granizo);
        assertTrue(entidad1.getAlertasRecibidas().size() == 2 && entidad1.riesgo() == 10);
        assertTrue(entidad2.getAlertasRecibidas().size() == 3 && entidad2.riesgo() == 7);
        assertEquals(5, central.totalAlertasEmitidas());
    }

    @Test
    void dadoElSetUp_alAgregarUnaAlertaConNivelFueraDeRango_seArrojaUnaExcepcion() {
        assertThrows(NivelDeAlertaIncorrectoException.class, () -> new Alerta("tormenta", 12));
    }

    @Test
    void dadoElSetUp_alAgregarUnaAlertaConNivelDentroDeRango_noSeArrojaNingunaExcepcion() {
        assertDoesNotThrow(() -> new Alerta("tormenta", 8));
    }
}