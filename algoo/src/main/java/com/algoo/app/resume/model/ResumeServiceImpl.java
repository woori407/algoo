package com.algoo.app.resume.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.algoo.app.career.model.CareerService;
import com.algoo.app.career.model.CareerVO;
import com.algoo.app.computerability.model.ComputerAbilityService;
import com.algoo.app.computerability.model.ComputerAbilityVO;
import com.algoo.app.hope.model.HopeService;
import com.algoo.app.hope.model.HopeVO;
import com.algoo.app.language.model.LanguageService;
import com.algoo.app.language.model.LanguageVO;
import com.algoo.app.license.model.LicenseService;
import com.algoo.app.license.model.LicenseVO;
import com.algoo.app.personalInfo.model.PersonalInfoService;
import com.algoo.app.personalInfo.model.PersonalInfoVO;

@Service
public class ResumeServiceImpl implements ResumeService{
	private static final Logger logger
		= LoggerFactory.getLogger(ResumeServiceImpl.class);
	
	@Autowired
	private ResumeDAO resumeDao;
	@Autowired
	private HopeService hopeService;
	@Autowired
	private CareerService careerService;
	@Autowired
	private LanguageService languageService;
	@Autowired
	private LicenseService licenseService;
	@Autowired
	private ComputerAbilityService computerAbilityService;
	@Autowired
	private PersonalInfoService personalInfoService;
	
	@Override
	@Transactional
	public int insertResume(ResumeVO resumeVo, HopeVO hopeVo, CareerVO careerVo
			, LanguageVO languageVo, LicenseVO licenseVo, ComputerAbilityVO computerAbilityVo
			, PersonalInfoVO personalInfoVo) {
		
		
		int cnt = hopeService.insertHope(hopeVo);
		
		if(cnt > 0){
			resumeVo.setHopeCode(hopeVo.getHopeCode());
		}
		
		if(careerVo.getCareerB().equals("Y")){
			cnt = careerService.insertCareer(careerVo);
			if(cnt > 0){
				resumeVo.setCareerCode(careerVo.getCareerCode());
			}
		}
		
		if(languageVo.getLanguageB().equals("Y")){
			cnt = languageService.insertLanguage(languageVo);
			
			if(cnt > 0){
				resumeVo.setLanguageCode(languageVo.getLanguageCode());
			}
		}
		
		if(licenseVo.getLicenseB().equals("Y")){
			cnt = licenseService.insertLicense(licenseVo);
			if(cnt > 0){
				resumeVo.setLicenseCode(licenseVo.getLicenseCode());
			}
		}
		
		
		if(computerAbilityVo.getComputerAbilityB().equals("Y")){
			cnt = computerAbilityService.insertComputerAbility(computerAbilityVo);
			
			if(cnt > 0){
				resumeVo.setComAbilityCode(computerAbilityVo.getComAbilityCode());
			}
		}
		if(personalInfoVo.getPersonalInfoB().equals("Y")){
			cnt = personalInfoService.insertPersonalInfo(personalInfoVo);
			
			if(cnt > 0){
				resumeVo.setPersonalInfoCode(personalInfoVo.getPersonalInfoCode());
			}
		}
		logger.info("resumeVo = {}", resumeVo);
		
		return resumeDao.insertResume(resumeVo);
	}

	@Override
	public List<ResumeVO> selectResume() {
		return resumeDao.selectResume();
	}

}
