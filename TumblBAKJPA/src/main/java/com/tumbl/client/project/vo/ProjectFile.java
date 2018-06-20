package com.tumbl.client.project.vo;

import org.springframework.web.multipart.MultipartFile;

public class ProjectFile {
	
	private MultipartFile p_file;
	private MultipartFile pm_file;
	private MultipartFile ps_file;
	
	
	public ProjectFile() {
		super();
	}


	public ProjectFile(MultipartFile p_file, MultipartFile pm_file, MultipartFile ps_file) {
		super();
		this.p_file = p_file;
		this.pm_file = pm_file;
		this.ps_file = ps_file;
	}


	public MultipartFile getP_file() {
		return p_file;
	}


	public void setP_file(MultipartFile p_file) {
		this.p_file = p_file;
	}


	public MultipartFile getPm_file() {
		return pm_file;
	}


	public void setPm_file(MultipartFile pm_file) {
		this.pm_file = pm_file;
	}


	public MultipartFile getPs_file() {
		return ps_file;
	}


	public void setPs_file(MultipartFile ps_file) {
		this.ps_file = ps_file;
	}
	
	

}
