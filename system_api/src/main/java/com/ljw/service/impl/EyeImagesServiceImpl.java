package com.ljw.service.impl;


import java.util.List;
import com.ljw.entity.dao.SimplePage;
import com.ljw.entity.vo.EyeImagesPositionVO;
import com.ljw.enums.PageSize;
import com.ljw.mapper.EyeImagesMapper;
import com.ljw.service.EyeImagesService;
import com.ljw.entity.vo.PaginationResultVO;
import com.ljw.entity.po.EyeImages;
import com.ljw.entity.dao.EyeImagesQuery;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
/**
 * @Description:  业务接口实现
 * @Author: false
 * @Date: 2025/02/27 12:55:52
 */
@Service("EyeImagesMapper")
public class EyeImagesServiceImpl implements EyeImagesService{

	@Resource
	private EyeImagesMapper<EyeImages, EyeImagesQuery> eyeImagesMapper;

	/**
 	 * 根据条件查询列表
 	 */
	@Override
	public List<EyeImages> findListByParam(EyeImagesQuery query) {
		return this.eyeImagesMapper.selectList(query);	}

	/**
 	 * 根据条件查询数量
 	 */
	@Override
	public Integer findCountByParam(EyeImagesQuery query) {
		return this.eyeImagesMapper.selectCount(query);	}

	/**
 	 * 分页查询
 	 */
	@Override
	public PaginationResultVO<EyeImages> findListByPage(EyeImagesQuery query) {
		Integer count = this.findCountByParam(query);
		Integer pageSize = query.getPageSize() == null ? PageSize.SIZE15.getSize() : query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(), count, pageSize);
		query.setSimplePage(page);
		List<EyeImages> list = this.findListByParam(query);
		PaginationResultVO<EyeImages> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
 	 * 新增
 	 */
	@Override
	public Integer add(EyeImages bean) {
		return this.eyeImagesMapper.insert(bean);
	}

	/**
 	 * 批量新增
 	 */
	@Override
	public Integer addBatch(List<EyeImages> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.eyeImagesMapper.insertBatch(listBean);
	}

	/**
 	 * 批量新增或修改
 	 */
	@Override
	public Integer addOrUpdateBatch(List<EyeImages> listBean) {
		if ((listBean == null) || listBean.isEmpty()) {
			return 0;
		}
			return this.eyeImagesMapper.insertOrUpdateBatch(listBean);
	}

	/**
 	 * 根据 Id 查询
 	 */
	@Override
	public EyeImages getEyeImagesById(Integer id) {
		return this.eyeImagesMapper.selectById(id);}

	/**
 	 * 根据 Id 更新
 	 */
	@Override
	public Integer updateEyeImagesById(EyeImages bean, Integer id) {
		return this.eyeImagesMapper.updateById(bean, id);}

	/**
 	 * 根据 Id 删除
 	 */
	@Override
	public Integer deleteEyeImagesById(Integer id) {
		return this.eyeImagesMapper.deleteById(id);}

	@Override
	public List<EyeImagesPositionVO> findCountByEyePosition() {
		List<EyeImagesPositionVO> eyeImagesPositionVOList = this.eyeImagesMapper.selectCountByEyePosition();
		int total = 0;
		for (EyeImagesPositionVO eyeImagesPositionVO : eyeImagesPositionVOList) {
			total += eyeImagesPositionVO.getCount();
		}
		for (EyeImagesPositionVO eyeImagesPositionVO : eyeImagesPositionVOList) {
			eyeImagesPositionVO.setPercentage(String.format("%.2f", (double) eyeImagesPositionVO.getCount() / total * 100) + "%");
		}
		return eyeImagesPositionVOList;
	}
}