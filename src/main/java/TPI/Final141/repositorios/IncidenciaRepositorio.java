package TPI.Final141.repositorios;
import TPI.Final141.dominio.Incidencia;
import java.util.Date;
import java.util.List;


public interface IncidenciaRepositorio {
    
    List<Incidencia> obtenerTodasLasIncidencia();
    Incidencia obtenerIncidenciaPorId(Long idIncidencia);
    void guardarIncidencia(Incidencia incidencia);
    void eliminarIncidencia(Long idIncidencia);
    List<Incidencia> obtenerIncidenciaPorFecha(Date fechaInicial, Date fechaFinal);
    
}
