package com.ljw.service;

import com.ljw.entity.dto.DiagnosisStatisticsDTO;
import com.ljw.entity.vo.DiagnosisStatisticsVO;
import com.ljw.entity.vo.OverviewVO;
import com.ljw.entity.vo.PatientStatisticsVO;

public interface DashboardService {
    OverviewVO getOverview();

    DiagnosisStatisticsVO getDiagnosisStatistics(DiagnosisStatisticsDTO diagnosisStatisticsDTO);

    PatientStatisticsVO getPatientStatistics(Integer startAge, Integer endAge, String province);
}
