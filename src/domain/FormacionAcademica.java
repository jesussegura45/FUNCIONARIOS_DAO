/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author Super
 */
public class FormacionAcademica {
    private int id;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
    private Funcionario funcionario;
    private EstadoFormacion estadoFormacion;
    private NivelFormacion nivelFormacion;
    private Universidad universidad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(LocalDateTime fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public EstadoFormacion getEstadoFormacion() {
        return estadoFormacion;
    }

    public void setEstadoFormacion(EstadoFormacion estadoFormacion) {
        this.estadoFormacion = estadoFormacion;
    }

    public NivelFormacion getNivelFormacion() {
        return nivelFormacion;
    }

    public void setNivelFormacion(NivelFormacion nivelFormacion) {
        this.nivelFormacion = nivelFormacion;
    }

    public Universidad getUniversidad() {
        return universidad;
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }
    
    
}
