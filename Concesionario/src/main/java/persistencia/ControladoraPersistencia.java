
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Automovil;


public class ControladoraPersistencia {
    
    AutomovilJpaController automovilJpaController= new AutomovilJpaController();

    public void agregarAutomovil(Automovil auto) {

        automovilJpaController.crearAutomovil(auto);

    }

    public List<Automovil> traerAutos() {
        
        
        return automovilJpaController.findAutomovilEntities();
        
        
    }

    public void borrarauto(int idauto) {
        
        
        try {
            automovilJpaController.eliminarAutomovil(idauto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

  

    public Automovil trearauto(int idAuto) {
      return   automovilJpaController.findAutomovil(idAuto);
    }

    public void modificarAuto(Automovil auto) {
        
        try {
            automovilJpaController.editarAutomovil(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    

  
    
}
