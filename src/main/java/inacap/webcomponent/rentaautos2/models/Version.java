/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentaautos2.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import inacap.webcomponent.rentaautos2.models.Carroceria;
import inacap.webcomponent.rentaautos2.models.Combustible;
import inacap.webcomponent.rentaautos2.models.Modelo;
import inacap.webcomponent.rentaautos2.models.Traccion;
import inacap.webcomponent.rentaautos2.models.Transmision;


/**
 *
 * @author 
 */@Entity
 @Table(name = "version")
 
public class Version {

     @Id
     @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idVersion;
    private String nombre;
    private String detalle;
    private int puertas;
    private int pasajeros;
    private float cilindrada;
    private float rendimiento;
    private int capacidadMaletero;
    private int airbags;
    private boolean aireAcondicionado;
    private boolean cierreCentralizado;
    private boolean alzaVidriosElectricos;
    private boolean camarasRetroceso;
        @ManyToOne
    @JoinColumn(name = "idcombustible")
    private Combustible combustible;
            @ManyToOne
    @JoinColumn(name = "idcarroceria")
    private Carroceria carroceria;
                @ManyToOne
    @JoinColumn(name = "idtransmision")
    private Transmision transmision;
                    @ManyToOne
    @JoinColumn(name = "idtraccion")
    private Traccion traccion;
                        @ManyToOne
    @JoinColumn(name = "idmodelo")
    private Modelo modelo;

    public int getIdVersion() {
        return idVersion;
    }

    public void setIdVersion(int idVersion) {
        this.idVersion = idVersion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public int getPasajeros() {
        return pasajeros;
    }

    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }

    public float getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(float cilindrada) {
        this.cilindrada = cilindrada;
    }

    public float getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(float rendimiento) {
        this.rendimiento = rendimiento;
    }

    public int getCapacidadMaletero() {
        return capacidadMaletero;
    }

    public void setCapacidadMaletero(int capacidadMaletero) {
        this.capacidadMaletero = capacidadMaletero;
    }

    public int getAirbags() {
        return airbags;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isCierreCentralizado() {
        return cierreCentralizado;
    }

    public void setCierreCentralizado(boolean cierreCentralizado) {
        this.cierreCentralizado = cierreCentralizado;
    }

    public boolean isAlzaVidriosElectricos() {
        return alzaVidriosElectricos;
    }

    public void setAlzaVidriosElectricos(boolean alzaVidriosElectricos) {
        this.alzaVidriosElectricos = alzaVidriosElectricos;
    }

    public boolean isCamarasRetroceso() {
        return camarasRetroceso;
    }

    public void setCamarasRetroceso(boolean camarasRetroceso) {
        this.camarasRetroceso = camarasRetroceso;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public Carroceria getCarroceria() {
        return carroceria;
    }

    public void setCarroceria(Carroceria carroceria) {
        this.carroceria = carroceria;
    }

    public Transmision getTransmision() {
        return transmision;
    }

    public void setTransmision(Transmision transmision) {
        this.transmision = transmision;
    }

    public Traccion getTraccion() {
        return traccion;
    }

    public void setTraccion(Traccion traccion) {
        this.traccion = traccion;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Version() {
    }

    public Version(String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camarasRetroceso, Combustible combustible, Carroceria carroceria, Transmision transmision, Traccion traccion, Modelo modelo) {
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camarasRetroceso = camarasRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }

    private Version(int idVersion, String nombre, String detalle, int puertas, int pasajeros, float cilindrada, float rendimiento, int capacidadMaletero, int airbags, boolean aireAcondicionado, boolean cierreCentralizado, boolean alzaVidriosElectricos, boolean camarasRetroceso, Combustible combustible, Carroceria carroceria, Transmision transmision, Traccion traccion, Modelo modelo) {
        this.idVersion = idVersion;
        this.nombre = nombre;
        this.detalle = detalle;
        this.puertas = puertas;
        this.pasajeros = pasajeros;
        this.cilindrada = cilindrada;
        this.rendimiento = rendimiento;
        this.capacidadMaletero = capacidadMaletero;
        this.airbags = airbags;
        this.aireAcondicionado = aireAcondicionado;
        this.cierreCentralizado = cierreCentralizado;
        this.alzaVidriosElectricos = alzaVidriosElectricos;
        this.camarasRetroceso = camarasRetroceso;
        this.combustible = combustible;
        this.carroceria = carroceria;
        this.transmision = transmision;
        this.traccion = traccion;
        this.modelo = modelo;
    }
    


    
    
    
}
