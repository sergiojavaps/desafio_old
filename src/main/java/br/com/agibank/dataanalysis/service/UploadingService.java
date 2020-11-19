package br.com.agibank.dataanalysis.service;

import java.io.File;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.agibank.dataanalysis.constants.AppConstants;
import br.com.agibank.dataanalysis.exception.FileInvalidException;
import br.com.agibank.dataanalysis.exception.InvalidFileDirectoryException;

/**
 * 
 * Uploading service class
 * 
 * @author sergio.melo
 *
 */
@Service
public class UploadingService {

	/**
	 * 
	 * Validate file extension
	 * 
	 * @param file
	 * @return
	 * @throws FileInvalidException
	 */
	public boolean isValideFileExtension(String file) throws FileInvalidException {
		if(Objects.nonNull(file)) {
			String fileExtension= StringUtils.getFilenameExtension(file);
			fileExtension = Objects.isNull(fileExtension) ? "none" : fileExtension;
			if(fileExtension.equalsIgnoreCase(AppConstants.FILE_EXTENSION)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void validateFileDirectory(String dir) throws InvalidFileDirectoryException {
		File file = new File(dir);
		if(!file.exists()) {
			new File(dir).mkdirs();
		}
	}
	
	public void validateFileDirectory(List<String> dirList) throws InvalidFileDirectoryException {
		for(String dir : dirList) {
			File file = new File(dir);
			if(!file.exists()) {
				new File(dir).mkdirs();
			}
		}
	}
	
}
