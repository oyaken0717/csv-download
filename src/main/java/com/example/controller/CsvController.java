package com.example.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Demo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Controller
@RequestMapping("csv")
public class CsvController {

	@GetMapping(value = "*.csv",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE + "; charset=Shift_JIS; Content-Disposition: attachment")
	@ResponseBody
	public Object getCsv() throws JsonProcessingException {
		List<Demo> demos = new ArrayList<Demo>() {
//			/**
//			 * 
//			 */
//			private static final long serialVersionUID = 1L;

			{
				add(new Demo(1001L, "aaa", "xxx", new Date()));
				add(new Demo(1002L, "bbb", "yyy", new Date()));
				add(new Demo(1003L, "ccc", "zzz", new Date()));
			}
		};

		CsvMapper mapper = new CsvMapper();
		CsvSchema schema = mapper.schemaFor(Demo.class).withHeader();
		return mapper.writer(schema).writeValueAsString(demos);
	}
}