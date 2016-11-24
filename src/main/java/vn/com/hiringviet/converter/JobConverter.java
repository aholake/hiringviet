package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.model.Job;

public class JobConverter {
	public static JobAdminTableDTO convert(Job job) {
		JobAdminTableDTO jobAdminTableDTO = new JobAdminTableDTO();
		jobAdminTableDTO.setId(job.getId());
		jobAdminTableDTO.setCompany(job.getCompany());
		jobAdminTableDTO.setPostDate(job.getPostDate());
		jobAdminTableDTO.setTitle(job.getTitle());
		jobAdminTableDTO.setProvince(job.getWorkAddress().getDistrict().getProvince());
		jobAdminTableDTO.setJobCategory(job.getJobCategory().getCategoryName());
		return jobAdminTableDTO;
	}
}
