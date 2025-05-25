package com.ljw.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.ljw.entity.dao.*;
import com.ljw.entity.po.*;
import com.ljw.entity.vo.*;
import com.ljw.enums.PageSize;
import com.ljw.mapper.*;
import com.ljw.service.DiagnosisReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("DiagnosisReportMapper")
public class DiagnosisReportServiceImpl implements DiagnosisReportService {

    @Resource
    private DiagnosisReportMapper<DiagnosisReport, DiagnosisReportQuery> diagnosisReportMapper;

    @Resource
    private PatientMapper<Patient, PatientQuery> patientMapper;
    @Resource
    private DoctorMapper<Doctor, DoctorQuery> doctorMapper;
    @Resource
    private EyeImagesMapper<EyeImages, EyeImagesQuery> eyeImagesMapper;
    @Resource
    private TreatmentPlansMapper<TreatmentPlans, TreatmentPlansQuery> treatmentPlansMapper;
    @Resource
    private MedicationRecommendationsMapper<MedicationRecommendations, MedicationRecommendationsQuery> medicationRecommendationsMapper;
    @Resource
    private AimodelMapper<Aimodel, AimodelQuery> aimodelMapper;

    @Resource
    private CasesMapper<Cases, CasesQuery> casesMapper;

    /**
     * 根据 Id 查询
     */
    @Override
    public AllVO getAllById(Integer id) {
        DiagnosisReport diagnosisReport = this.diagnosisReportMapper.selectById(id);
        Patient patient = patientMapper.selectById(diagnosisReport.getPatientId());
        Doctor doctor = doctorMapper.selectById(diagnosisReport.getDoctorId());
        List<EyeImages> eyeImagesList = eyeImagesMapper.selectByDiagnosisById(diagnosisReport.getId());

        List<TreatmentPlans> treatmentPlansList = treatmentPlansMapper.selectByDiagnosisById(diagnosisReport.getId());
        List<MedicationRecommendations> medicationRecommendationsList = medicationRecommendationsMapper.selectByDiagnosisById(diagnosisReport.getId());

        Aimodel aimodel = aimodelMapper.selectById(diagnosisReport.getAimodelId());
        AllVO allVO = new AllVO();
        allVO.setDiagnosisReport(diagnosisReport);
        allVO.setPatient(patient);
        allVO.setDoctor(doctor);
        allVO.setEyeImagesList(eyeImagesList);
        allVO.setTreatmentPlansList(treatmentPlansList);
        allVO.setMedicationRecommendationsList(medicationRecommendationsList);
        allVO.setAimodel(aimodel);
        return allVO;
    }

    /**
     * 根据 Id 查询
     */
    @Override
    public DiagnosisReport getDiagnosisReportById(Integer id) {
        DiagnosisReport diagnosisReport = this.diagnosisReportMapper.selectById(id);
        return diagnosisReport;
    }

    /**
     * 根据条件查询列表
     */
    @Override
    public List<DiagnosisReport> findListByParam(DiagnosisReportQuery query) {
        return this.diagnosisReportMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    @Override
    public Integer findCountByParam(DiagnosisReportQuery query) {
        return this.diagnosisReportMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    @Override
    public PaginationResultVO<DiagnosisReport> findListByPage(DiagnosisReportQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<DiagnosisReport> list = this.findListByParam(query);
        PaginationResultVO<DiagnosisReport> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(DiagnosisReport bean) {
        //获取当前系统时间
        bean.setCreateTime(new Date());
        // 查询是否存在相同的病例
        Cases cases = this.casesMapper.selectByPatinetId(bean.getPatientId());

        Integer insertResult = this.diagnosisReportMapper.insert(bean);
        if (cases != null && !Objects.equals(cases.getStatus(), "archived")) {
            String diseaseIds = cases.getDignosisReports();
            if (diseaseIds == null) diseaseIds = "";
            diseaseIds += (bean.getId().toString() + ";");
            cases.setDignosisReports(diseaseIds);
            this.casesMapper.updateById(cases, cases.getId());
        } else {
            // 获取治疗方案（确保列表不为空）
            List<TreatmentPlans> treatmentPlansList = this.treatmentPlansMapper.selectByDiagnosisById(bean.getId());
            TreatmentPlans treatmentPlan = null;
            if (!treatmentPlansList.isEmpty()) {
                treatmentPlan = treatmentPlansList.get(0);
            }
            // 查询病人信息
            Patient patient = this.patientMapper.selectById(bean.getPatientId());
            if (patient == null) {
                throw new RuntimeException("病人信息不存在");
            }
            // 创建新的病例
            Cases caseRecord = new Cases();
            caseRecord.setPatientName(patient.getName());
            caseRecord.setDignosisReports(bean.getId().toString());
            caseRecord.setStatus("active");
            caseRecord.setPatientId(bean.getPatientId());
            caseRecord.setCreatedTime(bean.getCreateTime());
            caseRecord.setIdCard(patient.getIdCard());
            // 插入病例数据
            this.casesMapper.insert(caseRecord);
        }
        //查询医生信息
        return insertResult;
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<DiagnosisReport> listBean) {
        if ((listBean == null) || listBean.isEmpty()) {
            return 0;
        }
        return this.diagnosisReportMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    @Override
    public Integer addOrUpdateBatch(List<DiagnosisReport> listBean) {
        return this.diagnosisReportMapper.insertOrUpdateBatch(listBean);
    }


    /**
     * 根据 Id 更新
     */
    @Override
    public Integer updateDiagnosisReportById(DiagnosisReport bean, Integer id) {
        return this.diagnosisReportMapper.updateById(bean, id);
    }

    /**
     * 根据 Id 删除
     */
    @Override
    public Integer deleteDiagnosisReportById(Integer id) {
        return this.diagnosisReportMapper.deleteById(id);
    }

    @Override
    public List<DiseaseCountVO> findDiseaseCount(String startDate, String endDate, String diseaseCategory, String status) {
        return this.diagnosisReportMapper.findDiseaseCount(startDate, endDate, diseaseCategory, status);
    }

    @Override
    public List<StatusCountVO> findStatusCount(String startDate, String endDate, String diseaseCategory, String status) {
        return this.diagnosisReportMapper.findStatusCount(startDate, endDate, diseaseCategory, status);
    }

    @Override
    public List<DateCountVO> findDateCount(String startDate, String endDate, String diseaseCategory, String status) {
        return this.diagnosisReportMapper.findDateCount(startDate, endDate, diseaseCategory, status);
    }

    public void updateDiagnosisReportWithRelations(AllVO allVO, Integer id) {
        ExecutorService executor = Executors.newFixedThreadPool(6);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        DiagnosisReport diagnosisReport = this.diagnosisReportMapper.selectById(id);
        //更新病例
        Cases cases = this.casesMapper.selectByPatinetId(diagnosisReport.getPatientId());

        // 更新诊断报告
        futures.add(CompletableFuture.runAsync(() -> {
            DiagnosisReport report = allVO.getDiagnosisReport();
            if (report != null) {
                this.updateDiagnosisReportById(report, diagnosisReport.getId());
                cases.setDignosisReports(report.getId().toString());
                cases.setStatus("active");
            }
        }, executor));

        // 更新患者信息
        futures.add(CompletableFuture.runAsync(() -> {
            Patient patient = allVO.getPatient();
            if (patient != null) {
                patientMapper.updateById(patient, diagnosisReport.getPatientId());
                // 更新病例表中的患者信息
                cases.setPatientName(patient.getName());
                cases.setIdCard(patient.getIdCard());
                cases.setPatientId(diagnosisReport.getPatientId());
                cases.setCreatedTime(diagnosisReport.getCreateTime());
            }
        }, executor));

        // 更新医生信息
        futures.add(CompletableFuture.runAsync(() -> {
            Doctor doctor = allVO.getDoctor();
            if (doctor != null) {
                doctorMapper.updateById(doctor, diagnosisReport.getDoctorId());
            }
        }, executor));

        // 更新眼图
        futures.add(CompletableFuture.runAsync(() -> {
            List<EyeImages> eyeList = allVO.getEyeImagesList();
            if (eyeList != null) {
                eyeList.forEach(eye -> eye.setDignosisReportId(diagnosisReport.getId()));
                // 删除旧的逐条删除和插入操作，改为批量更新或插入
                eyeImagesMapper.insertOrUpdateBatch(eyeList); // 使用批量操作
            }
        }, executor));

        // 更新治疗方案
        futures.add(CompletableFuture.runAsync(() -> {
            List<TreatmentPlans> treatList = allVO.getTreatmentPlansList();
            if (treatList != null) {
                treatList.forEach(treat -> treat.setDiagnosisId(diagnosisReport.getId()));
                treatmentPlansMapper.insertOrUpdateBatch(treatList); // 使用批量操作
            }
            if(treatList != null) {
                cases.setTreatmentPlanId(diagnosisReport.getId());
                cases.setDiagnosisMethod(treatList.get(0).getTreatmentType());
            }
        }, executor));

        // 更新药物推荐
        futures.add(CompletableFuture.runAsync(() -> {
            List<MedicationRecommendations> medList = allVO.getMedicationRecommendationsList();
            if (medList != null) {
                medList.forEach(med -> med.setDiagnosisId(diagnosisReport.getId()));
                medicationRecommendationsMapper.insertOrUpdateBatch(medList); // 使用批量操作
            }
        }, executor));

        CompletableFuture<Void>[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture.allOf(futuresArray).join();
        // 更新病例表
        if (cases != null) {
            this.casesMapper.updateById(cases, cases.getId());
        }
        executor.shutdown();

    }

    @Override
    public void scoreById(Integer id, Integer score) {
        diagnosisReportMapper.updateScoreById(id, score);
    }

    @Override
    public List<ModelPerformanceVO> modelPerformance() {
        List<AimodelCountAndAvgScore> list = diagnosisReportMapper.countByAimodelIdAndAvgByScore();
        List<ModelPerformanceVO> modelPerformanceVOList = new ArrayList<>();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        list.parallelStream().forEach(item -> {
            Integer modelId = item.getId();
            ModelPerformanceVO modelPerformanceVO = new ModelPerformanceVO();
            Aimodel aimodel = aimodelMapper.selectById(modelId);
            if (aimodel != null) {
                modelPerformanceVO.setId(aimodel.getId());
                modelPerformanceVO.setVersion(aimodel.getVersion());
                modelPerformanceVO.setDeployTime(simpleDateFormat.format(aimodel.getDeployTime()));
                modelPerformanceVO.setTotalDiagnosis(item.getTotalDiagnosis());
                modelPerformanceVO.setAccuracy(aimodel.getAccuracy());
                modelPerformanceVO.setAverageScore(item.getAverageScore());
            }
            modelPerformanceVOList.add(modelPerformanceVO);
        });
        return modelPerformanceVOList;
    }

    @Override
    public List<DoctorDiagnosisCountVO> getDoctorConfirmedCount() {
        List<DoctorDiagnosisCountVO> list = diagnosisReportMapper.getDoctorConfirmedCount();
        return list;
    }


}