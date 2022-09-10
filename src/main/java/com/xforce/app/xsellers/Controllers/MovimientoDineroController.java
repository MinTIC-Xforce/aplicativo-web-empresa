package com.xforce.app.xsellers.Controllers;

import com.xforce.app.xsellers.Services.MovimientoDineroService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientoDineroController {
    MovimientoDineroService movimientoDineroService;

    public MovimientoDineroController(MovimientoDineroService movimientoDineroService) {
        this.movimientoDineroService = movimientoDineroService;
    }

    public MovimientoDineroController() {
    }


}
