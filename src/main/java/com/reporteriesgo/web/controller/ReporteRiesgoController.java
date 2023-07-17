package com.reporteriesgo.web.controller;

import com.reporteriesgo.persisrence.entity.ReporteRiesgo;
import com.reporteriesgo.persisrence.repository.ReporteRiesgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reporte-riesgo")
public class ReporteRiesgoController  {
    private final ReporteRiesgoRepository reporteRiesgoRepository;
    @Autowired
    public ReporteRiesgoController(ReporteRiesgoRepository reporteRiesgoRepository) {
        this.reporteRiesgoRepository = reporteRiesgoRepository;
    }


    @GetMapping
    public List<ReporteRiesgo> obtenerReporteRiesgo(Date fecha) {
        return reporteRiesgoRepository.obtenerReporteRiesgo(fecha);
    }



    /*
    private final ReporteRiesgoService reporteRiesgoService;
    @Autowired
    public ReporteRiesgoController(ReporteRiesgoService reporteRiesgoService) {
        this.reporteRiesgoService = reporteRiesgoService;
    }


    @GetMapping
    public ResponseEntity<List<ReporteRiesgo>> getAll()
    {
        return ResponseEntity.ok(this.reporteRiesgoService.getAll());
    }
    @GetMapping("/{codigoId}")
    public ResponseEntity<ReporteRiesgo> get(String codigoId)
    {
        return ResponseEntity.ok(this.reporteRiesgoService.get(codigoId));
    }
*/


}
