package com.msds.km.service.Impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msds.base.service.impl.BaseServiceImpl;
import com.msds.km.mapper.MemberTicketMapper;
import com.msds.km.entity.MemberTicketEntity;
import com.msds.km.service.MemberTicketService;

/**
 * 
 * <br>
 * <b>功能：</b>MemberTicketService<br>
 * <b>作者：</b>lilong<br>
 * <b>日期：</b> 2015-10-22 15:44:56 <br>
 * <b>版权所有：<b>版权所有(C) 2014，wwww.minshengec.com<br>
 * <b>此类为自动生成<br>
 */
@Service("memberTicketService")
public class MemberTicketServiceImpl extends BaseServiceImpl<MemberTicketEntity> implements MemberTicketService{
	private final static Logger log= Logger.getLogger(MemberTicketService.class);

	@Autowired
    private MemberTicketMapper memberTicketMapper;
		
	public MemberTicketMapper baseMapper() {
		return memberTicketMapper;
	}

}
