package com.zs.service;

import java.util.List;

import com.zs.entity.KdniaoLogisticcode;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.KdniaoReturnInteface;

public interface KdniaoLogisticcodeSer{
	
	List<KdniaoLogisticcode> query9000logisticcode();
	
	void UpdateLogisticcode(EasyUIAccept accept);
	
	void insertKdniaoReturn(KdniaoReturnInteface  okdniaoReturn);
	
	void drawKdniaoSign();
}
