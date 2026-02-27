/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salon.service;

/**
 *
 * @author alber
 */
import com.salon.domain.Servicio;
import com.salon.repository.ServicioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @Transactional(readOnly = true)
    public List<Servicio> getServicios(boolean activo) {
        return servicioRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Servicio> getServicio(Integer id) {
        return servicioRepository.findById(id);
    }

    @Transactional
    public void save(Servicio servicio) {
        servicio = servicioRepository.save(servicio);

    }

    @Transactional
    public void delete(Integer id) {
        if (!servicioRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoría con ID " + id + " no existe.");
        }
        try {
            servicioRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la producto. Tiene datos asociados.", e);
        }
    }
}