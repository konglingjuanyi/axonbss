package com.ai.bss.webui.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class BaseController {
	 @Autowired
	 public RestTemplate client;
}
