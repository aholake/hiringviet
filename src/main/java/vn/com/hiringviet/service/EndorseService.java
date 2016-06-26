package vn.com.hiringviet.service;

import org.springframework.stereotype.Service;

import vn.com.hiringviet.dto.EndorseDTO;

@Service("endorseService")
public interface EndorseService {

	public Integer create(EndorseDTO endorseDTO);

	public boolean deleteByAccountId(Integer accountId, Integer skillResumeId);
}
