package com.aavn.trungnguyen.dao;

import java.util.List;

import com.aavn.trungnguyen.domain.ApplicantEmail;

public interface IApplicantEmailDAO {
	public Integer add(ApplicantEmail applicantEmail);

	public boolean update(ApplicantEmail applicantEmail);

	void saveOrUpdate(ApplicantEmail applicantEmail);

	void delete(ApplicantEmail applicantEmail);

	void deleteById(Integer id);

	ApplicantEmail getById(Integer applicantEmailId);

	List<ApplicantEmail> getAllActive();

	boolean delete(String[] ids);
}
