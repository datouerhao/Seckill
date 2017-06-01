package com.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dto.Exposer;
import com.dto.SeckillExecution;
import com.entity.Seckill;
import com.exception.RepeatKillException;
import com.exception.SeckillCloseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-dao.xml",
		"classpath:spring-service.xml" })
public class SeckillServiceTest {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;

	@Test
	public void testGetSeckillList() throws Exception {
		List<Seckill> list = seckillService.getSeckillList();
		// logger.info("list={}", list);
		System.out.println(list);
	}

	@Test
	public void testGetById() throws Exception {
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}", seckill);
		// System.out.println(seckill);
	}

	// 测试代码完整逻辑，可重复执行
	@Test
	public void testExportSeckillUrl() throws Exception {
		long id = 1000;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if (exposer.isExposed()) {
			logger.info("exposer={}", exposer);

			long phone = 1234526789;
			String md5 = exposer.getMd5();
			try {
				SeckillExecution execution = seckillService.executeSeckill(id,
						phone, md5);
				System.out.println(execution);
				// logger.info("result={}", execution);
			} catch (RepeatKillException e) {
				logger.error(e.getMessage());
			} catch (SeckillCloseException e) {
				logger.error(e.getMessage());
			}

		} else {
			// 秒杀未开启
			logger.warn("exposer={}", exposer);
		}

	}

	@Test
	public void testExecuteSeckillUrl() throws Exception {
		long id = 1000;
		long phone = 123452678;
		String md5 = "6bf0f43222f78bf1b4b5e7ffede326b6";
		SeckillExecution execution = seckillService.executeSeckill(id, phone,
				md5);
		System.out.println(execution);
		// logger.info("result={}", execution);
	}
}
