package com.reporteriesgo.persisrence.repository;

import com.reporteriesgo.persisrence.entity.ReporteRiesgo;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ReporteRiesgoRepository extends JpaRepository<ReporteRiesgo, String> {
    @Transactional

    @Procedure(value = "PKG_RIESGOS.sp_Reporte_Riesgo",outputParameterName ="cursorType" )
     List<ReporteRiesgo> obtenerReporteRiesgo(
            @Param("fecha") Date fecha
    );


}
