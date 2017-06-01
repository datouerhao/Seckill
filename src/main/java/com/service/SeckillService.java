package com.service;

import java.util.List;

import com.dto.Exposer;
import com.dto.SeckillExecution;
import com.entity.Seckill;
import com.exception.RepeatKillException;
import com.exception.SeckillCloseException;

public interface SeckillService {
	List<Seckill> getSeckillList();// 查询所有秒杀记录

	Seckill getById(long seckillId);// 查询单个秒杀记录

	Exposer exportSeckillUrl(long seckillId);// 秒杀开始时输出秒杀接口地址，否则输出系统时间和秒杀时间

	SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillCloseException, RepeatKillException,
			SeckillCloseException;// 执行秒杀操作

}
