package com.ljw.controller;

import com.ljw.annotation.Log;
import com.ljw.entity.dao.OperationLogQuery;
import com.ljw.entity.dto.DiagnosisStatisticsDTO;
import com.ljw.entity.dto.PatientStatisticsDTO;
import com.ljw.entity.po.OperationLog;
import com.ljw.entity.vo.*;
import com.ljw.service.DashboardService;
import com.ljw.enums.BusinessType;

import javax.annotation.Resource;

import com.ljw.service.DiagnosisReportService;
import com.ljw.service.EyeImagesService;
import com.ljw.service.OperationLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping({"/dashboard"})
public class DashboardController extends ABaseController {
    @Resource
    private DashboardService dashboardService;
    @Resource
    private OperationLogService operationLogService;
    @Resource
    private EyeImagesService eyeImagesService;
    @Resource
    private DiagnosisReportService diagnosisReportService;

    @GetMapping({"/overview"})
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO overview() {
        OverviewVO overviewVO = this.dashboardService.getOverview();
        return this.getSuccessResponseVO(overviewVO);
    }

    @PostMapping({"/diagnosis-statistics"})
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO diagnosisStatistics(@RequestBody DiagnosisStatisticsDTO diagnosisStatisticsDTO) {
        DiagnosisStatisticsVO diagnosisStatistics = this.dashboardService.getDiagnosisStatistics(diagnosisStatisticsDTO);
        return this.getSuccessResponseVO(diagnosisStatistics);
    }

    @PostMapping({"/patient-statistics"})
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO patientStatistics(@RequestBody PatientStatisticsDTO patientStatisticsDTO) {
        String[] split = patientStatisticsDTO.getAgeRange().split("-");
        Integer startAge = Integer.parseInt(split[0]);
        Integer endAge = Integer.parseInt(split[1]);
        PatientStatisticsVO patientStatistics = dashboardService.getPatientStatistics(startAge, endAge, patientStatisticsDTO.getProvince());
        return this.getSuccessResponseVO(patientStatistics);
    }

    @PostMapping("/activities")
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO activities(@RequestBody OperationLogQuery operationLogQuery) {
        PaginationResultVO<OperationLog> listByPage = operationLogService.findListByPage(operationLogQuery);
        return this.getSuccessResponseVO(listByPage);
    }

    @GetMapping("/image-statistics")
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO imageStatistics() {
        List<EyeImagesPositionVO> eyeImagesPositionVOList =eyeImagesService.findCountByEyePosition();
        return this.getSuccessResponseVO(eyeImagesPositionVOList);
    }

    @GetMapping("/model-performance")
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO modelPerformance() {
        List<ModelPerformanceVO> modelPerformanceVOList = diagnosisReportService.modelPerformance();
        return this.getSuccessResponseVO(modelPerformanceVOList);
    }

    @GetMapping("/doctor-confirmed-count")
    @Log(title = "控制台", businessType = BusinessType.SELECT)
    public ResponseVO getDoctorConfirmedCount() {
        List<DoctorDiagnosisCountVO> doctorDiagnosisCountVOList = diagnosisReportService.getDoctorConfirmedCount();
        return this.getSuccessResponseVO(doctorDiagnosisCountVOList);
    }
}
