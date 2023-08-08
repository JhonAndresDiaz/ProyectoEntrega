
package Singleton;

import Modelos.Consulta;
import Modelos.Persona;
import Modelos.Peticion;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author diazje
 */
public class PersonaSingleton {
    
    private static PersonaSingleton INSTANCIA = new PersonaSingleton();
    ArrayList<Persona> listaPersonas;
    ArrayList<Consulta> listaConsultas;
    ArrayList<Peticion> listaPeticiones;
    ArrayList<String> listaEspecialidades;
    
    private PersonaSingleton() {
        listaPersonas = leerPersona();
        listaConsultas = leerConsultas();
        listaEspecialidades = leerEspecialidades();
        listaPeticiones = leerPeticiones();
    }
    
    public static PersonaSingleton getInstancia() {
        return INSTANCIA;
    }

    public ArrayList<Persona> getPersonas() {
        return listaPersonas;
    }
    
    public void setListaPersonas(ArrayList<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    
    public ArrayList<Consulta> getConsultas() {
        return listaConsultas;
    }
    
    public void setlistaPacientes (ArrayList<Consulta> listaConsultas){
        this.listaConsultas = listaConsultas;
    }
    
    public ArrayList<String> getEspecialidades() {
        return listaEspecialidades;
    }
    
    public ArrayList<Peticion> getPeticiones() {
        return listaPeticiones;
    }
    
    public void setlistaPeticiones (ArrayList<Peticion> listaPeticiones){
        this.listaPeticiones = listaPeticiones;
    }
 
    public void escribirPersona(){
        try {
            FileOutputStream archivo = new FileOutputStream("Personas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaPersonas); 
        } catch(IOException ex){
        }
    } 
    
    public ArrayList<Persona> leerPersona(){
        try {
            FileInputStream archivo = new FileInputStream("Personas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Persona>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){      
          return new ArrayList<>();
        }
    }
    
    public void escribirConsultas(){
        try {
            FileOutputStream archivo = new FileOutputStream("Consultas.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaConsultas); 
        } catch(IOException ex){
            
        }
    } 
    
    public ArrayList<Consulta> leerConsultas(){
        try {
            FileInputStream archivo = new FileInputStream("Consultas.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Consulta>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            
            return new ArrayList<>();
        }
    }
    
    public void escribirPeticiones(){
        try {
            FileOutputStream archivo = new FileOutputStream("Peticiones.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaPeticiones); 
        } catch(IOException ex){
            
        }
    } 
    
    public ArrayList<Peticion> leerPeticiones(){
        try {
            FileInputStream archivo = new FileInputStream("Peticiones.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<Peticion>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            
            return new ArrayList<>();
        }
    }
    
    public void escribirEspecialidades(){
        try {
            FileOutputStream archivo = new FileOutputStream("Especialidades.dat");
            ObjectOutputStream escritor = new ObjectOutputStream(archivo);
            escritor.writeObject(listaEspecialidades); 
        } catch(IOException ex){
        }
    }
    
    public ArrayList<String> leerEspecialidades(){
        try {
            FileInputStream archivo = new FileInputStream("Especialidades.dat");
            ObjectInputStream lector = new ObjectInputStream(archivo);
            return (ArrayList<String>) lector.readObject();
        } catch(IOException | ClassNotFoundException ex){
            
            this.listaEspecialidades = new ArrayList<>();
            this.listaEspecialidades.add( "-Elegir-");
            this.listaEspecialidades.add( "Medico General");
            this.listaEspecialidades.add( "Añadir Especialidad Nueva");
            return listaEspecialidades;
        }
    }
    
}
