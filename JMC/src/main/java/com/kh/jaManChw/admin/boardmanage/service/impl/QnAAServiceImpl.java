package com.kh.jaManChw.admin.boardmanage.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.jaManChw.admin.boardmanage.dao.face.QnAADao;
import com.kh.jaManChw.admin.boardmanage.service.face.QnAAService;

@Service
public class QnAAServiceImpl implements QnAAService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired private QnAADao qnAADao;
}
