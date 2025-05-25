/*
 Navicat Premium Dump SQL

 Source Server         : 矿山安全项目
 Source Server Type    : MySQL
 Source Server Version : 80039 (8.0.39-0ubuntu0.22.04.1)
 Source Host           : 111.230.32.147:3306
 Source Schema         : ai_eyes_diagnosis

 Target Server Type    : MySQL
 Target Server Version : 80039 (8.0.39-0ubuntu0.22.04.1)
 File Encoding         : 65001

 Date: 18/03/2025 10:55:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ai_model
-- ----------------------------
DROP TABLE IF EXISTS `ai_model`;
CREATE TABLE `ai_model`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `version` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '模型版本',
  `deploy_time` datetime NULL DEFAULT NULL COMMENT '部署时间',
  `accuracy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '准确率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of ai_model
-- ----------------------------
INSERT INTO `ai_model` VALUES (1, 'v1.0', '2025-01-01 10:00:00', '95%');
INSERT INTO `ai_model` VALUES (2, 'v1.1', '2025-02-01 10:00:00', '96%');
INSERT INTO `ai_model` VALUES (3, 'v1.3', '2025-04-01 10:00:00', '98%');
INSERT INTO `ai_model` VALUES (4, 'v1.4', '2025-05-01 10:00:00', '99%');
INSERT INTO `ai_model` VALUES (5, 'v1.5', '2025-06-01 10:00:00', '99.5%');
INSERT INTO `ai_model` VALUES (6, 'v1.6', '2025-07-01 10:00:00', '99.7%');

-- ----------------------------
-- Table structure for cases
-- ----------------------------
DROP TABLE IF EXISTS `cases`;
CREATE TABLE `cases`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `dignosis_reports` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '关联多个dignosisReport（;分隔）',
  `treatment_plan_id` int NULL DEFAULT NULL COMMENT '治疗方案id',
  `patient_id` int NULL DEFAULT NULL COMMENT '关联医院患者表',
  `symptoms` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '症状描述（JSON格式，如视力模糊、眼痛等）',
  `diagnosis_method` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '诊断方法（如眼底检查、眼压测量等）',
  `recovery_time` datetime NULL DEFAULT NULL COMMENT '恢复时长（单位：天）',
  `created_time` datetime NULL DEFAULT NULL COMMENT '记录创建时间',
  `patient_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '病人名称',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '病人身份证号',
  `status` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态: confirmed/archived',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of cases
-- ----------------------------
INSERT INTO `cases` VALUES (1, '1;2', 1, 1, '{\"视力模糊\": \"严重\", \"眼痛\": \"轻微\"}', '眼底检查', '2025-03-25 09:00:00', '2025-03-01 09:00:00', '张三', '123456789012345678', 'confirmed');
INSERT INTO `cases` VALUES (2, '3;4', 2, 2, '{\"眼痛\": \"严重\"}', '眼压测量', '2025-03-30 10:00:00', '2025-03-02 10:00:00', '李四', '234567890123456789', 'archived');
INSERT INTO `cases` VALUES (3, '5;6', 3, 3, '{\"视力模糊\": \"中等\", \"眼痛\": \"无\"}', '视力检查', '2025-04-15 09:00:00', '2025-04-01 09:00:00', '王五', '345678901234567890', 'confirmed');
INSERT INTO `cases` VALUES (4, '7;8', 4, 4, '{\"眼干\": \"严重\"}', '角膜检查', '2025-04-20 10:00:00', '2025-04-02 10:00:00', '赵六', '456789012345678901', 'archived');
INSERT INTO `cases` VALUES (5, '13;14', 7, 7, '{\"视力模糊\": \"重度\", \"眼痛\": \"中等\"}', '角膜检查', '2025-06-15 09:00:00', '2025-06-01 09:00:00', '吴九', '789012345678901234', 'confirmed');
INSERT INTO `cases` VALUES (6, '15;16', 8, 8, '{\"红眼\": \"轻微\"}', '视力检查', '2025-06-20 10:00:00', '2025-06-02 10:00:00', '郑十', '890123456789012345', 'archived');
INSERT INTO `cases` VALUES (7, '17;18', 9, 9, '{\"流泪\": \"频繁\", \"眼干\": \"重度\"}', '眼压测量', '2025-07-01 09:00:00', '2025-06-05 09:00:00', '王十一', '901234567890123456', 'confirmed');
INSERT INTO `cases` VALUES (8, '19;20', 10, 10, '{\"视力下降\": \"中等\", \"眼痛\": \"轻微\"}', '眼底检查', '2025-07-10 10:00:00', '2025-06-10 10:00:00', '李十二', '012345678901234567', 'archived');

-- ----------------------------
-- Table structure for data_analysis
-- ----------------------------
DROP TABLE IF EXISTS `data_analysis`;
CREATE TABLE `data_analysis`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `statistics` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '统计数据',
  `generate_time` datetime NULL DEFAULT NULL COMMENT '生成时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of data_analysis
-- ----------------------------
INSERT INTO `data_analysis` VALUES (1, '{\"total_cases\": 100, \"successful_cases\": 95}', '2025-03-12 09:30:00');
INSERT INTO `data_analysis` VALUES (2, '{\"total_cases\": 50, \"successful_cases\": 45}', '2025-03-11 09:30:00');
INSERT INTO `data_analysis` VALUES (3, '{\"total_cases\": 200, \"successful_cases\": 190}', '2025-04-12 09:30:00');
INSERT INTO `data_analysis` VALUES (4, '{\"total_cases\": 150, \"successful_cases\": 140}', '2025-04-11 09:30:00');
INSERT INTO `data_analysis` VALUES (5, '{\"total_cases\": 350, \"successful_cases\": 340}', '2025-06-12 09:30:00');
INSERT INTO `data_analysis` VALUES (6, '{\"total_cases\": 400, \"successful_cases\": 390}', '2025-07-01 09:30:00');

-- ----------------------------
-- Table structure for diagnosis_report
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis_report`;
CREATE TABLE `diagnosis_report`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `patient_id` int NULL DEFAULT NULL COMMENT '患者ID',
  `doctor_id` int NULL DEFAULT NULL COMMENT '医生ID',
  `disease_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '眼疾名称',
  `disease_category` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '眼疾分类',
  `aimodel_id` int NULL DEFAULT NULL COMMENT 'AI模型版本ID',
  `result` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT 'AI诊断结果',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'confirmed/archived',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '病人身份证号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '病人名称',
  `score` int NULL DEFAULT NULL COMMENT '医生打分',
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医生备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of diagnosis_report
-- ----------------------------
INSERT INTO `diagnosis_report` VALUES (1, 1, 1, '青光眼', '眼部疾病', 1, '诊断结果A', '2025-03-12 09:00:00', 'confirmed', '123456789012345678', '张三', 90, '备注A');
INSERT INTO `diagnosis_report` VALUES (2, 2, 2, '白内障', '眼部疾病', 2, '诊断结果B', '2025-03-11 09:00:00', 'archived', '234567890123456789', '李四', 85, '备注B');
INSERT INTO `diagnosis_report` VALUES (3, 3, 3, '视网膜脱落', '眼部疾病', 3, '诊断结果C', '2025-04-12 09:00:00', 'confirmed', '345678901234567890', '王五', 92, '备注C');
INSERT INTO `diagnosis_report` VALUES (4, 4, 4, '黄斑变性', '眼部疾病', 4, '诊断结果D', '2025-04-11 09:00:00', 'archived', '456789012345678901', '赵六', 88, '备注D');
INSERT INTO `diagnosis_report` VALUES (5, 7, 5, '角膜炎', '眼部疾病', 5, '诊断结果G', '2025-06-12 09:00:00', 'confirmed', '789012345678901234', '吴九', 93, '患者角膜炎，建议药物治疗');
INSERT INTO `diagnosis_report` VALUES (6, 8, 6, '视神经炎', '眼部疾病', 6, '诊断结果H', '2025-06-11 09:00:00', 'archived', '890123456789012345', '郑十', 87, '患者视神经炎，建议手术治疗');
INSERT INTO `diagnosis_report` VALUES (7, 9, 7, '结膜炎', '眼部疾病', 7, '诊断结果I', '2025-07-01 09:00:00', 'confirmed', '901234567890123456', '王十一', 91, '患者结膜炎，建议定期复查');
INSERT INTO `diagnosis_report` VALUES (8, 10, 8, '玻璃体混浊', '眼部疾病', 8, '诊断结果J', '2025-07-10 09:00:00', 'archived', '012345678901234567', '李十二', 89, '患者玻璃体混浊，建议手术治疗');

-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `verified` tinyint(1) NULL DEFAULT NULL COMMENT '是否实名认证(0:否,1:是)',
  `verified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核人',
  `verified_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `license` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '执业编号',
  `department` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '科室',
  `hospital_pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医院医生编号',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone_index`(`phone` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES (1, '1234567890', '123456789012345678', 'lifugui', 1, '管理员', '2023-10-01 12:00:00', 'A123456', '内科', '1');
INSERT INTO `doctor` VALUES (3, '13600000000', '234567890123456789', '医生B', 0, NULL, NULL, 'LICENSE_B', '内科', 'HOSPITAL_B');
INSERT INTO `doctor` VALUES (4, '13700000000', '345678901234567890', '医生C', 1, '审核人B', '2025-04-10 10:00:00', 'LICENSE_C', '眼科', 'HOSPITAL_C');
INSERT INTO `doctor` VALUES (5, '13800000000', '456789012345678901', '医生D', 0, NULL, NULL, 'LICENSE_D', '内科', 'HOSPITAL_D');
INSERT INTO `doctor` VALUES (6, '13900000000', '567890123456789012', '医生E', 1, '审核人C', '2025-05-10 10:00:00', 'LICENSE_E', '眼科', 'HOSPITAL_E');
INSERT INTO `doctor` VALUES (7, '14000000000', '678901234567890123', '医生F', 0, NULL, NULL, 'LICENSE_F', '内科', 'HOSPITAL_F');
INSERT INTO `doctor` VALUES (8, '15779607583', '789012345678901234', '李医生', 1, NULL, NULL, 'LICENSE_G', '眼科', 'HOSPITAL_G');
INSERT INTO `doctor` VALUES (9, '19870799390', '360313200403224022', '骆医生', 1, '', NULL, 'LICENSE_H', '眼科', 'HOSPITAL_H');

-- ----------------------------
-- Table structure for eye_images
-- ----------------------------
DROP TABLE IF EXISTS `eye_images`;
CREATE TABLE `eye_images`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '图片路径',
  `dignosis_report_id` int NULL DEFAULT NULL COMMENT '关联报告ID',
  `eye_position` char(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '眼别 OD/OS',
  `dicom_data` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'DICOM元数据',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of eye_images
-- ----------------------------
INSERT INTO `eye_images` VALUES (1, 'https://www.tsu.tw/tnb/img/image01012.jpg', 1, 'OD', 'DICOM_DATA_A');
INSERT INTO `eye_images` VALUES (2, 'https://www.tsu.tw/tnb/img/image01012.jpg', 2, 'OS', 'DICOM_DATA_B');
INSERT INTO `eye_images` VALUES (3, 'https://www.tsu.tw/tnb/img/image01012.jpg', 3, 'OD', 'DICOM_DATA_C');
INSERT INTO `eye_images` VALUES (4, 'https://www.tsu.tw/tnb/img/image01012.jpg', 4, 'OS', 'DICOM_DATA_D');
INSERT INTO `eye_images` VALUES (5, 'https://www.tsu.tw/tnb/img/image01012.jpg', 5, 'OD', 'DICOM_DATA_E');
INSERT INTO `eye_images` VALUES (6, 'https://www.tsu.tw/tnb/img/image01012.jpg', 6, 'OS', 'DICOM_DATA_F');
INSERT INTO `eye_images` VALUES (7, 'https://www.tsu.tw/tnb/img/image01012.jpg', 7, 'OD', 'DICOM_DATA_G');
INSERT INTO `eye_images` VALUES (8, 'https://www.tsu.tw/tnb/img/image01012.jpg', 8, 'OS', 'DICOM_DATA_H');

-- ----------------------------
-- Table structure for medication_recommendations
-- ----------------------------
DROP TABLE IF EXISTS `medication_recommendations`;
CREATE TABLE `medication_recommendations`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `diagnosis_id` int NULL DEFAULT NULL COMMENT '关联diagnoses表',
  `medication_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药物名称',
  `dosage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '药物剂量',
  `frequency` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用药频率',
  `side_effects` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '药物副作用',
  `start_time` datetime NOT NULL COMMENT '开始用药时间\r\n',
  `end_time` datetime NULL DEFAULT NULL COMMENT '停止用药时间\r\n',
  `doctor_id` int NULL DEFAULT NULL COMMENT '关联docker表，指向医生',
  `created_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updated_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of medication_recommendations
-- ----------------------------
INSERT INTO `medication_recommendations` VALUES (1, 1, '药物A', '10mg', '一天两次', '无', '2025-03-01 09:00:00', '2025-03-10 09:00:00', 1, '2025-03-01 09:00:00', '2025-03-01 09:00:00');
INSERT INTO `medication_recommendations` VALUES (2, 2, '药物B', '5mg', '一天三次', '轻微头痛', '2025-03-02 10:00:00', '2025-03-12 10:00:00', 2, '2025-03-02 10:00:00', '2025-03-02 10:00:00');
INSERT INTO `medication_recommendations` VALUES (3, 3, '药物C', '15mg', '一天一次', '无', '2025-04-01 09:00:00', '2025-04-10 09:00:00', 3, '2025-04-01 09:00:00', '2025-04-01 09:00:00');
INSERT INTO `medication_recommendations` VALUES (4, 4, '药物D', '20mg', '一天四次', '轻微头晕', '2025-04-02 10:00:00', '2025-04-12 10:00:00', 4, '2025-04-02 10:00:00', '2025-04-02 10:00:00');
INSERT INTO `medication_recommendations` VALUES (5, 5, '药物E', '25mg', '一天一次', '无', '2025-05-01 09:00:00', '2025-05-10 09:00:00', 5, '2025-05-01 09:00:00', '2025-05-01 09:00:00');
INSERT INTO `medication_recommendations` VALUES (6, 6, '药物F', '30mg', '一天两次', '轻微头晕', '2025-05-02 10:00:00', '2025-05-12 10:00:00', 6, '2025-05-02 10:00:00', '2025-05-02 10:00:00');

-- ----------------------------
-- Table structure for operation_log
-- ----------------------------
DROP TABLE IF EXISTS `operation_log`;
CREATE TABLE `operation_log`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `user_id` int NULL DEFAULT NULL COMMENT '操作用户ID',
  `role` tinyint NULL DEFAULT NULL COMMENT '操作用户角色',
  `actiont_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作类型',
  `details` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作详情',
  `create_time` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `target_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作对象类型',
  `target_id` int NULL DEFAULT NULL COMMENT '操作对象ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of operation_log
-- ----------------------------
INSERT INTO `operation_log` VALUES (1, 1, 1, '新增', '新增病例', '2025-03-12 09:00:00', '病例', 1);
INSERT INTO `operation_log` VALUES (2, 2, 2, '修改', '修改病例', '2025-03-11 09:00:00', '病例', 2);
INSERT INTO `operation_log` VALUES (3, 3, 3, '删除', '删除病例', '2025-04-12 09:00:00', '病例', 3);
INSERT INTO `operation_log` VALUES (4, 4, 4, '查看', '查看病例', '2025-04-11 09:00:00', '病例', 4);
INSERT INTO `operation_log` VALUES (5, 5, 5, '新增', '新增病例', '2025-06-12 09:00:00', '病例', 5);
INSERT INTO `operation_log` VALUES (6, 6, 6, '修改', '修改病例', '2025-06-11 09:00:00', '病例', 6);
INSERT INTO `operation_log` VALUES (7, 7, 7, '删除', '删除病例', '2025-07-01 09:00:00', '病例', 7);
INSERT INTO `operation_log` VALUES (8, 8, 8, '查看', '查看病例', '2025-07-10 09:00:00', '病例', 8);

-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `id_card` varchar(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '身份证号',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '姓名',
  `verified` tinyint(1) NULL DEFAULT NULL COMMENT '是否实名认证(0:否,1:是)',
  `verified_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核人',
  `verified_time` datetime NULL DEFAULT NULL COMMENT '审核时间',
  `open_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'openid',
  `hospital_pid` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '医院患者编号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES (1, '17379948860', '111111111111111111', '患者A', 1, '审核人A', '2025-03-10 10:00:00', 'OPENID_A', 'HOSPITAL_A');
INSERT INTO `patient` VALUES (2, '13611111111', '222222222222222222', '患者B', 0, NULL, NULL, 'OPENID_B', 'HOSPITAL_B');
INSERT INTO `patient` VALUES (3, '13711111111', '333333333333333333', '患者C', 1, '审核人B', '2025-04-10 10:00:00', 'OPENID_C', 'HOSPITAL_C');
INSERT INTO `patient` VALUES (4, '13811111111', '444444444444444444', '患者D', 0, NULL, NULL, 'OPENID_D', 'HOSPITAL_D');
INSERT INTO `patient` VALUES (5, '14011111111', '555555555555555555', '患者E', 1, '审核人D', '2025-06-10 10:00:00', 'OPENID_E', 'HOSPITAL_E');
INSERT INTO `patient` VALUES (6, '14111111111', '666666666666666666', '患者F', 0, NULL, NULL, 'OPENID_F', 'HOSPITAL_F');
INSERT INTO `patient` VALUES (7, NULL, NULL, '用户20250312182405', 1, NULL, NULL, 'owhoa7fITbB2gA1N4dxwWmjN8Xsw', NULL);

-- ----------------------------
-- Table structure for treatment_plans
-- ----------------------------
DROP TABLE IF EXISTS `treatment_plans`;
CREATE TABLE `treatment_plans`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `diagnosis_id` int NULL DEFAULT NULL COMMENT '关联DiagnosisReport表',
  `treatment_type` tinyint NULL DEFAULT NULL COMMENT '治疗类型（药物、手术、激光治疗等）',
  `treatment_detail` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '治疗方案详细信息',
  `start_time` datetime NULL DEFAULT NULL COMMENT '治疗开始时间',
  `end_date` datetime NULL DEFAULT NULL COMMENT '治疗结束时间',
  `doctor_id` int NULL DEFAULT NULL COMMENT '关联Docker表',
  `created_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `updated_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of treatment_plans
-- ----------------------------
INSERT INTO `treatment_plans` VALUES (1, 1, 1, '药物治疗', '2025-03-01 09:00:00', '2025-03-10 09:00:00', 1, '2025-03-01 09:00:00', '2025-03-01 09:00:00');
INSERT INTO `treatment_plans` VALUES (2, 2, 2, '手术治疗', '2025-03-02 10:00:00', '2025-03-12 10:00:00', 2, '2025-03-02 10:00:00', '2025-03-02 10:00:00');
INSERT INTO `treatment_plans` VALUES (3, 3, 3, '激光治疗', '2025-04-01 09:00:00', '2025-04-10 09:00:00', 3, '2025-04-01 09:00:00', '2025-04-01 09:00:00');
INSERT INTO `treatment_plans` VALUES (4, 4, 4, '物理治疗', '2025-04-02 10:00:00', '2025-04-12 10:00:00', 4, '2025-04-02 10:00:00', '2025-04-02 10:00:00');
INSERT INTO `treatment_plans` VALUES (5, 7, 5, '中药治疗', '2025-06-01 09:00:00', '2025-06-10 09:00:00', 5, '2025-06-01 09:00:00', '2025-06-01 09:00:00');
INSERT INTO `treatment_plans` VALUES (6, 8, 6, '理疗', '2025-06-02 10:00:00', '2025-06-12 10:00:00', 6, '2025-06-02 10:00:00', '2025-06-02 10:00:00');
INSERT INTO `treatment_plans` VALUES (7, 9, 7, '化疗', '2025-07-01 09:00:00', '2025-07-10 09:00:00', 7, '2025-07-01 09:00:00', '2025-07-01 09:00:00');
INSERT INTO `treatment_plans` VALUES (8, 10, 8, '放疗', '2025-07-02 10:00:00', '2025-07-12 10:00:00', 8, '2025-07-02 10:00:00', '2025-07-02 10:00:00');

SET FOREIGN_KEY_CHECKS = 1;
