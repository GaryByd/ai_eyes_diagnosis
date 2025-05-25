package com.ljw.service.impl;


import java.util.List;
import com.ljw.entity.dao.SimplePage;
import com.ljw.enums.PageSize;
import com.ljw.mapper.OperationLogMapper;
import com.ljw.service.OperationLogService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.OperationLog;
import com.ljw.entity.dao.OperationLogQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("OperationLogMapper")
public class OperationLogServiceImpl implements OperationLogService{

	@Resource
	private OperationLogMapper<OperationLog, OperationLogQuery> operationLogMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<OperationLog> findListByParam(OperationLogQuery query) {
		return this.operationLogMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(OperationLogQuery query) {
		return this.operationLogMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<OperationLog> findListByPage(OperationLogQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<OperationLog> list = this.findListByParam(query);
		PaginationResultVO<OperationLog> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(OperationLog bean) {
		return this.operationLogMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<OperationLog> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.operationLogMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<OperationLog> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.operationLogMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public OperationLog getOperationLogById(Integer id) {
		return this.operationLogMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateOperationLogById(OperationLog bean, Integer id) {
		return this.operationLogMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteOperationLogById(Integer id) {
		return this.operationLogMapper.deleteById(id);}
}