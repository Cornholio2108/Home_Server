package com.home_server.ui.info;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Component;

import com.home_server.Globals;

@Component
@Scope("view")
public class CalendarController implements Serializable {
	private Date selectedDate = new Date();

	@PostConstruct
	public void init() {
		selectedDate = new Date();
	}

	public Date getSelectedDate() {
		return selectedDate;
	}

	public void setSelectedDate(Date selectedDate) {
		this.selectedDate = selectedDate;
	}
}
