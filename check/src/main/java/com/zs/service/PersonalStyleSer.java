package com.zs.service;

import java.util.List;

import com.zs.entity.personalStyle;
import com.zs.entity.other.EasyUIAccept;

public interface PersonalStyleSer extends BaseService<personalStyle,String>{
	List<personalStyle> queryStyle(EasyUIAccept accept);
}
