package com.reporteriesgo.web.controller;

import com.reporteriesgo.persisrence.entity.ReporteRiesgo;
import com.reporteriesgo.persisrence.repository.ReporteRiesgoRepository;
import com.reporteriesgo.service.dto.ReporteRiesgoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.reporteriesgo.service.ReporteRiesgoService;
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


    @PostMapping("/{fecha}")
    public ResponseEntity<List<ReporteRiesgo>> obtenerReporteRiesgo (@RequestBody ReporteRiesgoDto dto){
        return ResponseEntity.ok(this.reporteRiesgoRepository.obtenerReporteRiesgo(dto.getFecha()));
    }

    /*
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
