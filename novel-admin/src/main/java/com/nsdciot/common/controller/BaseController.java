package com.nsdciot.common.controller;

import org.springframework.stereotype.Controller;
import com.nsdciot.common.utils.ShiroUtils;
import com.nsdciot.system.domain.UserDO;

@Controller
public class BaseController {
	public UserDO getUser() {
		return ShiroUtils.getUser();
	}

	public Long getUserId() {
		return getUser().getUserId();
	}

	public String getUsername() {
		return getUser().getUsername();
	}
}