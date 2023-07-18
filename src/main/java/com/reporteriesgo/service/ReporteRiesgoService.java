package com.reporteriesgo.service;

import com.reporteriesgo.persisrence.entity.ReporteRiesgo;
import com.reporteriesgo.persisrence.repository.ReporteRiesgoRepository;
import com.reporteriesgo.service.dto.ReporteRiesgoDto;
import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class ReporteRiesgoService {
    private final ReporteRiesgoRepository reporteRiesgoRepository;

    public ReporteRiesgoService(ReporteRiesgoRepository reporteRiesgoRepository) {
        this.reporteRiesgoRepository = reporteRiesgoRepository;
    }

    @Transactional
    public List<ReporteRiesgo> obtenerReporteRiesgo(ReporteRiesgoDto reporteRiesgoDto) {
        //return reporteRiesgoRepository.obtenerReporteRiesgo(fecha);
        return  this.reporteRiesgoRepository.obtenerReporteRiesgo(reporteRiesgoDto.getFecha());
    }


    /*
    private final ReporteRiesgoRepository reporteRiesgoRepository;
    public ReporteRiesgoService(ReporteRiesgoRepository reporteRiesgoRepository) {
        this.reporteRiesgoRepository = reporteRiesgoRepository;
    }

    public List<ReporteRiesgo> obtenerReporteRiesgo() {
        // Llama al método findAll() del repositorio para obtener todos los registros de la entidad
        return reporteRiesgoRepository.findAll();
    }

/*
@Autowired
    public ReporteRiesgoService(ReporteRiesgoRepository reporteRiesgoRepository) {
        this.reporteRiesgoRepository = reporteRiesgoRepository;
    }

    public List<ReporteRiesgo> getAll(){
        return this.reporteRiesgoRepository.findAll();
    }

    public ReporteRiesgo get(String codigoId){
        return this.reporteRiesgoRepository.findById(codigoId).orElse(null);

    }

*/
}
