package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.CheckLogMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CheckLogSer;

@Service("checkLogSer")
public class CheckLogSerImpl implements CheckLogSer{

	@Resource
	private CheckLogMapper checkLogMapper;
	@Resource
	private StaffUserMapper userMapper;
	private final Gson gson=new Gson();
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=checkLogMapper.queryFenye(accept);
			for(int i = 0 ; i < list.size() ; i ++){
				CheckLog cl = (CheckLog) list.get(i);
				StaffUser user = userMapper.selectByPrimaryKey(cl.getUserNumber());
				cl.setUserNumber(user.getStuName());
			}
			int rows=checkLogMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(CheckLog obj) {
		return checkLogMapper.insertSelective(obj);
	}

	public Integer update(CheckLog obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CheckLog get(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**张顺，2017-6-27
	 * 异步存储方法,之所以要异步，因为存储导入，导出，查询的日志时，gson会转很大的数据，会非常耗时，故采用异步
	 */
	public void saveOfAsyn(final CheckLog log,final Object oldData,final Object bigData) {
		new Thread(){
			@Override
			public void run() {
				try {
					log.setOlddata(gson.toJson(oldData));
					log.setBigdata(gson.toJson(bigData));
					checkLogMapper.insertSelective(log);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
}
