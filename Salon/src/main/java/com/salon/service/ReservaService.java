/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salon.service;

/**
 *
 * @author alber
 */
import com.salon.domain.Reserva;
import com.salon.repository.ReservaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    @Transactional(readOnly = true)
    public List<Reserva> getReservas(boolean activo) {  
        return reservaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Reserva> getReserva(Integer id) {
        return reservaRepository.findById(id);
    }

    @Transactional
    public void save(Reserva reserva) {
        reserva = reservaRepository.save(reserva);
        
    }

    @Transactional
    public void delete(Integer id) {
        if (!reservaRepository.existsById(id)) {
            throw new IllegalArgumentException("La categoría con ID " + id + " no existe.");
        }
        try {
            reservaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalStateException("No se puede eliminar la producto. Tiene datos asociados.", e);
        }
    }
}