package com.ljw.service.impl;

import com.ljw.client.FastApiAiDoctorClient;
import com.ljw.entity.dao.*;
import com.ljw.entity.po.*;
import com.ljw.entity.vo.AiRecommendationRequest;
import com.ljw.entity.vo.AiRecommendationResponse;
import com.ljw.entity.vo.AiRecommendationResponse.Medication;
import com.ljw.entity.vo.AiRecommendationResponse.TreatmentPlan;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.enums.PageSize;
import com.ljw.mapper.*;
import com.ljw.service.AimodelService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("AimodelMapper")
public class AimodelServiceImpl implements AimodelService {

    @Resource
    private AimodelMapper<Aimodel, AimodelQuery> aimodelMapper;
    @Resource
    private PatientMapper<Patient, PatientQuery> patientMapper;

    @Resource
    private DiagnosisReportMapper<DiagnosisReport, DiagnosisReportQuery> diagnosisReportMapper;

    @Resource
    private MedicationRecommendationsMapper<MedicationRecommendations, MedicationRecommendationsQuery> medicationRecommendationsMapper;

    @Resource
    private TreatmentPlansMapper<TreatmentPlans, TreatmentPlansQuery> treatmentPlansMapper;

    @Resource
    private FastApiAiDoctorClient fastApiAiDoctorClient;

    /**
     * 根据条件查询列表
     */
    @Override
    public List<Aimodel> findListByParam(AimodelQuery query) {
        return this.aimodelMapper.selectList(query);
    }

    /**
     * 根据条件查询数量
     */
    @Override
    public Integer findCountByParam(AimodelQuery query) {
        return this.aimodelMapper.selectCount(query);
    }

    /**
     * 分页查询
     */
    @Override
    public PaginationResultVO<Aimodel> findListByPage(AimodelQuery query) {
        Integer count = this.findCountByParam(query);
        Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
        SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
        query.setSimplePage(page);
        List<Aimodel> list = this.findListByParam(query);
        PaginationResultVO<Aimodel> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
        return result;
    }

    /**
     * 新增
     */
    @Override
    public Integer add(Aimodel bean) {
        return this.aimodelMapper.insert(bean);
    }

    /**
     * 批量新增
     */
    @Override
    public Integer addBatch(List<Aimodel> listBean) {
        if ((listBean == null) || listBean.isEmpty()) {
            return 0;
        }
        return this.aimodelMapper.insertBatch(listBean);
    }

    /**
     * 批量新增或修改
     */
    @Override
    public Integer addOrUpdateBatch(List<Aimodel> listBean) {
        if ((listBean == null) || listBean.isEmpty()) {
            return 0;
        }
        return this.aimodelMapper.insertOrUpdateBatch(listBean);
    }

    /**
     * 根据 Id 查询
     */
    @Override
    public Aimodel getAimodelById(Integer id) {
        return this.aimodelMapper.selectById(id);
    }

    /**
     * 根据 Id 更新
     */
    @Override
    public Integer updateAimodelById(Aimodel bean, Integer id) {
        return this.aimodelMapper.updateById(bean, id);
    }

    /**
     * 根据 Id 删除
     */
    @Override
    public Integer deleteAimodelById(Integer id) {
        return this.aimodelMapper.deleteById(id);
    }

    @Override
    public AiRecommendationResponse getRecommendations(Integer diagnosisReportId) {
        DiagnosisReport diagnosisReport = diagnosisReportMapper.selectById(diagnosisReportId);
        if (diagnosisReport == null) {

            throw new RuntimeException("Diagnosis report not found");
        }

        // Extract patient_id from diagnosis report
        Integer patientId = diagnosisReport.getPatientId();
        if (patientId == null) {
            throw new RuntimeException("Patient ID not found in diagnosis report");
        }

        // Query patient information using patient_id
        Patient patient = patientMapper.selectById(patientId);
        if (patient == null) {
            throw new RuntimeException("Patient not found");
        }

        // Prepare request
        AiRecommendationRequest request = new AiRecommendationRequest();
        request.setResult(diagnosisReport.getResult()+"(返回的结果请帮我写好换行符)");
        request.setDisease_category(diagnosisReport.getResult()+"(返回的结果请帮我写好换行符)");
        request.setDisease_name(diagnosisReport.getResult()+"(返回的结果请帮我写好换行符)");
        AiRecommendationRequest.PatientInfo patientInfo = new AiRecommendationRequest.PatientInfo();
        patientInfo.setName(patient.getName());
        patientInfo.setSex(patient.getSex());
        patientInfo.setAge(patient.getAge());
        request.setPatient_info(patientInfo);
        request.setStream(false);
        AiRecommendationResponse response = fastApiAiDoctorClient.getRecommendations(request);
        // Insert medications into database
        List<MedicationRecommendations> medications = new ArrayList<>();
        for (Medication medication : response.getMedications()) {
            MedicationRecommendations medRec = new MedicationRecommendations();
            medRec.setDiagnosisId(diagnosisReportId);
            medRec.setMedicationName(medication.getMedication_name());
            medRec.setDosage(medication.getDosage());
            medRec.setFrequency(medication.getFrequency());
            medRec.setSideEffects(medication.getSide_effects());
            medRec.setDoctorId(diagnosisReport.getDoctorId());
            medRec.setCreatedTime(new Date());
            medRec.setUpdatedTime(new Date());
            medications.add(medRec);
        }
        medicationRecommendationsMapper.insertBatch(medications);
        // Insert treatment plan into database
        TreatmentPlan treatmentPlan = response.getTreatment_plan();
        TreatmentPlans treatPlan = new TreatmentPlans();
        treatPlan.setDiagnosisId(diagnosisReportId);
        treatPlan.setTreatmentType(treatmentPlan.getTreatment_type());
        treatPlan.setTreatmentDetail(treatmentPlan.getTreatment_detail());
        treatPlan.setDoctorId(diagnosisReport.getDoctorId());
        treatPlan.setCreatedTime(new Date());
        treatPlan.setUpdatedTime(new Date());
        treatmentPlansMapper.insert(treatPlan);
        return response;
    }

    @Override
    public Aimodel selectMaxId() {
        return this.aimodelMapper.selectMaxId();
    }
}