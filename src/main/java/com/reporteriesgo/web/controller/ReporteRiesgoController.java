package com.reporteriesgo.web.controller;

import com.reporteriesgo.persisrence.repository.ReporteRiesgoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/reporte-riesgo")
public class ReporteRiesgoController  {
    private final ReporteRiesgoRepository reporteRiesgoRepository;
    @Autowired
    public ReporteRiesgoController(ReporteRiesgoRepository reporteRiesgoRepository) {
        this.reporteRiesgoRepository = reporteRiesgoRepository;
    }
    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> obtenerReporteRiesgo() {
        // Convertir la fecha a Date
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {
            fecha = format.parse("10/07/2023");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Llamar al procedimiento almacenado
        java.sql.ResultSet[] resultado = new java.sql.ResultSet[1];
        reporteRiesgoRepository.obtenerReporteRiesgo(fecha);

        // Convertir el ResultSet a una lista de mapas
        List<Map<String, Object>> data = new ArrayList<>();
        try {
            ResultSet resultSet = resultado[0];
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            while (resultSet.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(i);
                    row.put(columnName, value);
                }
                data.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Devolver la lista de mapas como respuesta JSON
        return ResponseEntity.ok(data);
    }


/*
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
