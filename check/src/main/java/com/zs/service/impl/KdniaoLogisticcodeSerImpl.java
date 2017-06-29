package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.KdniaoLogisticcodeMapper;
import com.zs.entity.other.EasyUIAccept;
import com.zs.service.KdniaoLogisticcodeSer;

@Service("kdniaoLogisticcodeSer")
public class KdniaoLogisticcodeSerImpl implements KdniaoLogisticcodeSer{

	@Resource
	private KdniaoLogisticcodeMapper kdniaoLogisticcodeMapper;
	public List<String> query9000logisticcode() {
		return kdniaoLogisticcodeMapper.query9000logisticcode();
	}

	public void UpdateLogisticcode(EasyUIAccept accept) {
		kdniaoLogisticcodeMapper.UpdateLogisticcode(accept);
	}

	
}
