/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;


public class Controladora {
    
    
    
    ControladoraPersistencia controlPersis=new ControladoraPersistencia();

    public void agregarAutomovil(String modelo, String marca, String motor, String color, String patente, int cantPuertas) {
        
        Automovil auto= new Automovil();
        
        
        
    auto.setModelo(modelo);
    auto.setMarca(marca);
    auto.setMotor(motor);
    auto.setColor(color);
    auto.setPatente(patente);
    auto.setCantPuertas(cantPuertas);

    controlPersis.agregarAutomovil(auto);
        
        

    }

    public List<Automovil> traerautos() {
        
        return controlPersis.traerAutos();
       
    }

    public void borrarauto(int idauto) {

      controlPersis.borrarauto(idauto);

    }

    public Automovil traerautos(int idAuto) {

       return  controlPersis.trearauto(idAuto);
    }

    public void modificarAuto(Automovil auto, String modelo, String marca, String motor, String color, String patente, int cantPuertas) {


    auto.setModelo(modelo);
    auto.setMarca(marca);
    auto.setMotor(motor);
    auto.setColor(color);
    auto.setPatente(patente);
    auto.setCantPuertas(cantPuertas);

    controlPersis.modificarAuto(auto);


    }

  

   
    
}
