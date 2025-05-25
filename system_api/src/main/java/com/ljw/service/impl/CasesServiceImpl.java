package com.ljw.service.impl;


import java.util.List;
import com.ljw.entity.dao.SimplePage;
import com.ljw.enums.PageSize;
import com.ljw.mapper.CasesMapper;
import com.ljw.service.CasesService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.Cases;
import com.ljw.entity.dao.CasesQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("CasesMapper")
public class CasesServiceImpl implements CasesService{

	@Resource
	private CasesMapper<Cases, CasesQuery> casesMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<Cases> findListByParam(CasesQuery query) {
		return this.casesMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(CasesQuery query) {
		return this.casesMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<Cases> findListByPage(CasesQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<Cases> list = this.findListByParam(query);
		PaginationResultVO<Cases> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(Cases bean) {
		return this.casesMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<Cases> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.casesMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<Cases> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.casesMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public Cases getCasesById(Integer id) {
		return this.casesMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateCasesById(Cases bean, Integer id) {
		return this.casesMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteCasesById(Integer id) {
		return this.casesMapper.deleteById(id);}
}