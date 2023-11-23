package TPI.Final141.repositorios;

import TPI.Final141.dominio.Tecnico;

public interface TecnicoRepositorio {
    
    Tecnico obtenerTecnicoPorID(int idTecnico);
    void guardarTecnico(Tecnico tecnico);
    void eliminarTecnico(Long idTecnico);
    
}
