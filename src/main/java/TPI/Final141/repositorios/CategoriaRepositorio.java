package TPI.Final141.repositorios;

import TPI.Final141.dominio.Categoria;
import TPI.Final141.dominio.Cliente;

public interface CategoriaRepositorio {
    
    Categoria obtenerCategoriaPorID(int idCategoria);
    void guardarCategoria(Categoria Categoria);
    void eliminarCategoria(Long idCategoria);
    
}
