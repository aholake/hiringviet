package vn.com.hiringviet.testdao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import vn.com.hiringviet.dao.JobDAO;
import vn.com.hiringviet.model.Job;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
@Transactional
public class JobDAOTest {
	@Autowired
	private JobDAO jobDAO;

	@Test
	public void should_return_jobs_by_ids() {
		int[] ids = { 4, 5, 6 };
		Job job =jobDAO.getJobByID(4);
		System.out.println(job.getDescription());
	}

}
