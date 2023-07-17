package com.reporteriesgo.persisrence.repository;

import com.reporteriesgo.persisrence.entity.ReporteRiesgo;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
@Repository
public interface ReporteRiesgoRepository extends ListCrudRepository<ReporteRiesgo,String> {
    @Procedure(value = "sp_Reporte_Riesgo")
    List<ReporteRiesgo> obtenerReporteRiesgo(@Param("PD_fecha") Date fecha);

}
