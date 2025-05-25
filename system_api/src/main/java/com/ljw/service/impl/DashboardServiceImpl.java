package com.ljw.service.impl;

import com.ljw.entity.dao.CasesQuery;
import com.ljw.entity.dao.DiagnosisReportQuery;
import com.ljw.entity.dao.DoctorQuery;
import com.ljw.entity.dao.PatientQuery;
import com.ljw.entity.dto.DiagnosisStatisticsDTO;
import com.ljw.entity.po.Aimodel;
import com.ljw.entity.vo.*;
import com.ljw.service.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Resource
    private CasesService casesService;
    @Resource
    private PatientService patientService;
    @Resource
    private DoctorService doctorService;
    @Resource
    private AimodelService aimodelService;

    @Resource
    private DiagnosisReportService diagnosisReportService;

    public DashboardServiceImpl() {
    }

    public OverviewVO getOverview() {
        OverviewVO overviewVO = new OverviewVO();
        CasesQuery casesQuery = new CasesQuery();
        overviewVO.setTotal_diagnoses(this.casesService.findCountByParam(casesQuery));
        LocalDate now = LocalDate.now();
        LocalDate oneMonthAgo = now.minusMonths(1L);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        casesQuery.setCreatedTimeStart(oneMonthAgo.format(formatter));
        casesQuery.setCreatedTimeEnd(now.format(formatter));
        overviewVO.setRecent_diagnoses(this.casesService.findCountByParam(casesQuery));
        overviewVO.setTotal_patients(this.patientService.findCountByParam(new PatientQuery()));
        overviewVO.setTotal_doctors(this.doctorService.findCountByParam(new DoctorQuery()));
        Aimodel aimodel = this.aimodelService.selectMaxId();
        overviewVO.setDiagnosis_accuracy(aimodel.getAccuracy());
        overviewVO.setAi_model_version(aimodel.getVersion());
        return overviewVO;
    }

    @Override
    public DiagnosisStatisticsVO getDiagnosisStatistics(DiagnosisStatisticsDTO diagnosisStatisticsDTO) {

        DiagnosisReportQuery diagnosisReportQuery = new DiagnosisReportQuery();
        diagnosisReportQuery.setCreateTimeStart(diagnosisStatisticsDTO.getStartDate());
        diagnosisReportQuery.setCreateTimeEnd(diagnosisStatisticsDTO.getEndDate());
        diagnosisReportQuery.setDiseaseCategory(diagnosisStatisticsDTO.getDiseaseCategory());
        diagnosisReportQuery.setStatus(diagnosisStatisticsDTO.getStatus());
        //查询表中数据总数
        Integer diagnosisReportCount = diagnosisReportService.findCountByParam(diagnosisReportQuery);
//        System.out.println(diagnosisReportCount);
        //查询每种疾病的数量
        List<DiseaseCountVO> diseaseCountVOList = diagnosisReportService.findDiseaseCount(diagnosisStatisticsDTO.getStartDate(), diagnosisStatisticsDTO.getEndDate(), diagnosisStatisticsDTO.getDiseaseCategory(),diagnosisStatisticsDTO.getStatus());
        diseaseCountVOList.stream().forEach(diseaseCountVO -> {
            diseaseCountVO.setPercentage(String.format("%.2f", (double) diseaseCountVO.getCount() / (double) diagnosisReportCount));
        });
//        diseaseCountVOList.stream().forEach(System.out::println);
        //查询每种状态的数量
        List<StatusCountVO> statusCountVOList = diagnosisReportService.findStatusCount(diagnosisStatisticsDTO.getStartDate(), diagnosisStatisticsDTO.getEndDate(), diagnosisStatisticsDTO.getDiseaseCategory(),diagnosisStatisticsDTO.getStatus());
        statusCountVOList.stream().forEach(statusCountVO -> {
            statusCountVO.setPercentage(String.format("%.2f", (double) statusCountVO.getCount() / (double) diagnosisReportCount));
        });
//        statusCountVOList.stream().forEach(System.out::println);
        List<DateCountVO> dateCountVOList = diagnosisReportService.findDateCount(diagnosisStatisticsDTO.getStartDate(), diagnosisStatisticsDTO.getEndDate(), diagnosisStatisticsDTO.getDiseaseCategory(), diagnosisStatisticsDTO.getStatus());
//        dateCountVOList.stream().forEach(System.out::println);

        DiagnosisStatisticsVO diagnosisStatisticsVO = new DiagnosisStatisticsVO();
        diagnosisStatisticsVO.setTotal_count(diagnosisReportCount);
        diagnosisStatisticsVO.setBy_disease(diseaseCountVOList);
        diagnosisStatisticsVO.setBy_status(statusCountVOList);
        diagnosisStatisticsVO.setBy_date(dateCountVOList);
        return diagnosisStatisticsVO;
    }

    @Override
    public PatientStatisticsVO getPatientStatistics(Integer startAge, Integer endAge, String province) {
        PatientQuery patientQuery = new PatientQuery();
        Integer totalCount = patientService.findCountByParam(patientQuery);
        patientQuery.setStartAge(startAge);
        patientQuery.setEndAge(endAge);
        Integer ageRangeCount = patientService.findCountByParam(patientQuery);
        String percentage = String.format("%.2f", (double) ageRangeCount / (double) totalCount);
        AgeRangeCountVO ageRangeCountVO = new AgeRangeCountVO();
        ageRangeCountVO.setAgeRange(startAge + "-" + endAge);
        ageRangeCountVO.setCount(ageRangeCount);
        ageRangeCountVO.setPercentage(percentage);

        patientQuery = new PatientQuery();
        patientQuery.setStartAge(startAge);
        patientQuery.setEndAge(endAge);
        patientQuery.setSex("男");
        Integer manCount = patientService.findCountByParam(patientQuery);
        percentage = String.format("%.2f", (double) manCount / (double) totalCount);
        GenderCountVO manCountVO = new GenderCountVO();
        manCountVO.setGender("男");
        manCountVO.setCount(manCount);
        manCountVO.setPercentage(percentage);
        GenderCountVO womanCountVO = new GenderCountVO();
        womanCountVO.setGender("女");
        womanCountVO.setCount(ageRangeCount - manCount);
        percentage = String.format("%.2f", (double) womanCountVO.getCount() / (double) totalCount);
        womanCountVO.setPercentage(percentage);
        List<GenderCountVO> genderCountVOList = new ArrayList<>();
        genderCountVOList.add(manCountVO);
        genderCountVOList.add(womanCountVO);

        patientQuery = new PatientQuery();
        patientQuery.setProvince(province);
        Integer regionCount = patientService.findCountByParam(patientQuery);
        percentage = String.format("%.2f", (double) regionCount / (double) totalCount);
        RegionCountVO regionCountVO = new RegionCountVO();
        regionCountVO.setProvince(province);
        regionCountVO.setCount(regionCount);
        regionCountVO.setPercentage(percentage);

        Integer newPatientsCount = patientService.recentMonthPatientsCount();

        PatientStatisticsVO patientStatisticsVO = new PatientStatisticsVO();
        patientStatisticsVO.setTotalCount(totalCount);
        patientStatisticsVO.setNewPatientsCount(newPatientsCount);
        patientStatisticsVO.setAgeRangeCountVO(ageRangeCountVO);
        patientStatisticsVO.setGenderCountVO(genderCountVOList);
        patientStatisticsVO.setRegionCountVO(regionCountVO);
        return patientStatisticsVO;
/**
 * "data": {
 *     "total_count": 1250,
 *     "new_patients": 85,
 *     "by_age": [
 *       {
 *         "age_range": "30-40",
 *         "count": 320,
 *         "percentage": 0.256
 *       }
 *     ],
 *     "by_gender": [
 *       {
 *         "gender": "男",
 *         "count": 650,
 *         "percentage": 0.52
 *       }
 *     ],
 *     "by_region": [
 *       {
 *         "province": "北京市",
 *         "count": 180,
 *         "percentage": 0.144
 *       }
 *     ]
 *   }
 */
    }
}