package com.sacumen.system.info.api.dao;

import java.util.List;

import javax.sql.DataSource;

import com.sacumen.system.info.api.dto.SystemInfoDTO;

public interface SystemInfoDAO {
	
	public void setJdbcTemplate(final DataSource dataSource);

    
    public List<SystemInfoDTO> loadAllSystemInfo();

    SystemInfoDTO createSystemInfo(SystemInfoDTO systemInfo);

}
