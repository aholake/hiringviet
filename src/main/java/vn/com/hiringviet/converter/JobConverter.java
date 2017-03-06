package vn.com.hiringviet.converter;

import vn.com.hiringviet.dto.JobAdminTableDTO;
import vn.com.hiringviet.model.Job;

// TODO: Auto-generated Javadoc
/**
 * The Class JobConverter.
 */
public class JobConverter {
	
	/**
	 * Convert.
	 *
	 * @param job the job
	 * @return the job admin table dto
	 */
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
