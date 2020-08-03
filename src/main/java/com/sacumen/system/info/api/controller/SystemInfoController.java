package com.sacumen.system.info.api.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sacumen.system.info.api.dao.SystemInfoDAO;
import com.sacumen.system.info.api.dto.SystemInfoDTO;
import com.sacumen.system.info.api.util.SystemSerialNumberUtil;

@RestController
@RequestMapping(value = { "/api" })
public class SystemInfoController {

	static Logger logger = Logger.getLogger(SystemInfoController.class);
	
	@Autowired
	private SystemInfoDAO systemInfoDAO;

	@RequestMapping(value = "/createSystemInfo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public SystemInfoDTO createSystemInfo(@RequestBody SystemInfoDTO systemInfo) {
		systemInfo.setOsName(SystemSerialNumberUtil.GetOSName());
		systemInfo.setSerialNumber(SystemSerialNumberUtil.GetSystemMotherBoard_SerialNumber());
		return systemInfoDAO.createSystemInfo(systemInfo);
	}
	
	@RequestMapping(value = "/loadAllSystemInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<SystemInfoDTO> loadAllSystemInfo() {
		return systemInfoDAO.loadAllSystemInfo();
	}

}
