package com.vam.task;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vam.mapper.AdminMapper;
import com.vam.model.AttachImageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TaskTest {

	@Autowired
	private AdminMapper mapper;
	
	private String getFolderYesterDay() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.DATE, -1);
		
		String str = sdf.format(cal.getTime());
		
		return str.replace("-", File.separator);
		
	}
	
	@Test
	public void taskTest1() {
		
		List<AttachImageVO> fileList = mapper.getOldFiles();
		System.out.println("fileList : " + fileList);
		
		List<Path> fileListPaths = fileList.stream().map(vo -> Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName())).collect(Collectors.toList());
		System.out.println("fileListPaths : " + fileListPaths);
		
		fileList.stream().map(vo -> Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid()+"_" + vo.getFileName())).forEach(p -> fileListPaths.add(p));
		System.out.println("fileListPaths2 : " + fileListPaths);
		
		System.out.println("-----------------------------");
		fileListPaths.forEach(p -> System.out.println(p));
		System.out.println("-----------------------------");
		File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
		System.out.println(targetDir);
		File[] removeFiles = targetDir.listFiles();
		System.out.println(removeFiles);
		for(int i = 0; i < removeFiles.length; i++) {
			File file = removeFiles[i];
			System.out.println(file);
		}
		File[] removeFiles2 = targetDir.listFiles(file -> fileListPaths.contains(file.toPath()) == false);
		for(int i = 0; i < removeFiles2.length; i++) {
			File file = removeFiles2[i];
			System.out.println(file);
		}
		System.out.println("----------------------------");
		for(File file : removeFiles) {
			System.out.println(file);
			file.delete();
		}
		
		
	}
	
	
	
	
}
