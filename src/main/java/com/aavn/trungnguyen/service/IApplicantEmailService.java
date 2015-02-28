package com.aavn.trungnguyen.service;

import java.util.List;

import org.springframework.ui.Model;

import com.aavn.trungnguyen.domain.ApplicantEmail;

public interface IApplicantEmailService {
	public String showAddPage(Model model);
	
	public Integer add(ApplicantEmail applicantEmail);
	
	public boolean update(Model model, ApplicantEmail applicantEmail);
	
	public void saveOrUpdate(ApplicantEmail applicantEmail);
	
	void delete(ApplicantEmail applicantEmail);

	void deleteById(Integer id);
	
	public ApplicantEmail getById(Integer applicantEmailId);

	public String showUpdatePage(Model model, int applicantEmailId);
	
	public List<ApplicantEmail> getAllActive();

	public void showListPage(Model model);

	public boolean delete(String[] ids);
}
