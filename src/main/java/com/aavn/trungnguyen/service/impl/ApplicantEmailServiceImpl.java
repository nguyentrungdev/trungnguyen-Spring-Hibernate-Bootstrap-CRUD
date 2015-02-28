package com.aavn.trungnguyen.service.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.aavn.trungnguyen.domain.ApplicantEmail;
import com.aavn.trungnguyen.dao.IApplicantEmailDAO;
import com.aavn.trungnguyen.service.IApplicantEmailService;

@Service
public class ApplicantEmailServiceImpl implements IApplicantEmailService {

	@Autowired
	private IApplicantEmailDAO applicantEmailDAO;
	
	@Override
	public String showAddPage(Model model) {
		ApplicantEmail ae = new ApplicantEmail();
		model.addAttribute("applicantEmail", ae);
		Map<String, String> statusList = new LinkedHashMap<String, String>();
		statusList.put("junk", "junk");
		statusList.put("inbox", "inbox");
		statusList.put("archive", "archive");
		model.addAttribute("statusList", statusList);
		model.addAttribute("pageAction", "add");
		model.addAttribute("formAction", "/applicantEmail");
		return "applicantEmail/update";
	}

	@Override
	public Integer add(ApplicantEmail applicantEmail) {
		return applicantEmailDAO.add(applicantEmail);
	}

	@Override
	public boolean update(Model model, ApplicantEmail applicantEmail) {
		return applicantEmailDAO.update(applicantEmail);
	}

	@Override
	public void saveOrUpdate(ApplicantEmail applicantEmail) {
		applicantEmailDAO.saveOrUpdate(applicantEmail);
	}

	@Override
	public void delete(ApplicantEmail applicantEmail) {
		applicantEmailDAO.delete(applicantEmail);
	}

	@Override
	public void deleteById(Integer id) {
		applicantEmailDAO.deleteById(id);
	}

	@Override
	public ApplicantEmail getById(Integer applicantEmailId) {
		return applicantEmailDAO.getById(applicantEmailId);
	}

	@Override
	public String showUpdatePage(Model model, int applicantEmailId) {
		ApplicantEmail applicantEmail = getById(applicantEmailId);
		if (applicantEmail != null) {
			Map<String, String> statusList = new LinkedHashMap<String, String>();
			statusList.put("junk", "junk");
			statusList.put("inbox", "inbox");
			statusList.put("archive", "archive");
			model.addAttribute("statusList", statusList);
			model.addAttribute("applicantEmail", applicantEmail);
			model.addAttribute("pageAction", "update");
			model.addAttribute("formAction", "/applicantEmail/" + applicantEmailId);
			return "applicantEmail/update";
		} else {
			return "";
		}
	}

	@Override
	public List<ApplicantEmail> getAllActive() {
		return applicantEmailDAO.getAllActive();
	}
	
	@Override
	public void showListPage(Model model) {
		List<ApplicantEmail> applicantEmailList = applicantEmailDAO.getAllActive();
		model.addAttribute("applicantEmailList", applicantEmailList);
	}
	
	@Override
	public boolean delete(String[] ids) {
		return applicantEmailDAO.delete(ids);
	}
	
	
}
