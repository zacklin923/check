package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.KdniaoLogisticcodeMapper;
import com.zs.dao.KdniaoReturnMapper;
import com.zs.dao.KdniaoTranceMapper;
import com.zs.entity.KdniaoLogisticcode;
import com.zs.entity.KdniaoReturn;
import com.zs.entity.KdniaoTrance;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.KdniaoReturnInteface;
import com.zs.entity.other.Traces;
import com.zs.service.KdniaoLogisticcodeSer;
import com.zs.tools.Trans;

@Service("kdniaoLogisticcodeSer")
public class KdniaoLogisticcodeSerImpl implements KdniaoLogisticcodeSer{

	@Resource
	private KdniaoLogisticcodeMapper kdniaoLogisticcodeMapper;
	@Resource
	private KdniaoReturnMapper kdniaoReturnMapper;
	@Resource
	private KdniaoTranceMapper kdniaoTranceMapper;
	
	public List<KdniaoLogisticcode> query9000logisticcode() {
		return kdniaoLogisticcodeMapper.querylogisticcode();
	}

	public void UpdateLogisticcode(EasyUIAccept accept) {
		kdniaoLogisticcodeMapper.UpdateLogisticcode(accept);
	}

	public void insertKdniaoReturn(KdniaoReturnInteface okdniaoReturn) {
		KdniaoReturn kr = new KdniaoReturn(okdniaoReturn.getLogisticCode(),okdniaoReturn.getState(),null,"0");
		kdniaoReturnMapper.insertSelective(kr);
		for (int i = 0; i < okdniaoReturn.getTraces().size(); i++) {
			KdniaoTrance t = new KdniaoTrance(okdniaoReturn.getTraces().get(i).getAcceptTime(), okdniaoReturn.getTraces().get(i).getAcceptStation(),okdniaoReturn.getLogisticCode());
			kdniaoTranceMapper.insertSelective(t);
		}
	}

	public void drawKdniaoSign() {
		kdniaoLogisticcodeMapper.drawKdniaoSign();
	}

	
}
