package com.ljw.service.impl;


import java.util.List;
import com.ljw.entity.dao.SimplePage;
import com.ljw.enums.PageSize;
import com.ljw.mapper.DataAnalysisMapper;
import com.ljw.service.DataAnalysisService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.DataAnalysis;
import com.ljw.entity.dao.DataAnalysisQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("DataAnalysisMapper")
public class DataAnalysisServiceImpl implements DataAnalysisService{

	@Resource
	private DataAnalysisMapper<DataAnalysis, DataAnalysisQuery> dataAnalysisMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<DataAnalysis> findListByParam(DataAnalysisQuery query) {
		return this.dataAnalysisMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(DataAnalysisQuery query) {
		return this.dataAnalysisMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<DataAnalysis> findListByPage(DataAnalysisQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<DataAnalysis> list = this.findListByParam(query);
		PaginationResultVO<DataAnalysis> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(DataAnalysis bean) {
		return this.dataAnalysisMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<DataAnalysis> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataAnalysisMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<DataAnalysis> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.dataAnalysisMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public DataAnalysis getDataAnalysisById(Integer id) {
		return this.dataAnalysisMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateDataAnalysisById(DataAnalysis bean, Integer id) {
		return this.dataAnalysisMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteDataAnalysisById(Integer id) {
		return this.dataAnalysisMapper.deleteById(id);}
}