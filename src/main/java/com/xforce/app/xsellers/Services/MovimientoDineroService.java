package com.xforce.app.xsellers.Services;

import com.xforce.app.xsellers.Entities.Empleados;
import com.xforce.app.xsellers.Entities.MovimientoDinero;
import com.xforce.app.xsellers.Repositories.MovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoDineroService {

    private MovimientoDineroRepository movimientoDineroRepository;

    public MovimientoDineroService(MovimientoDineroRepository movimientoDineroRepository) {
        this.movimientoDineroRepository = movimientoDineroRepository;
    }

    public List<MovimientoDinero> getMovimientos(){
        return this.movimientoDineroRepository.findAll();
    }
    
}
