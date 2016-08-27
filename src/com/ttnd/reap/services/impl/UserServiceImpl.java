package com.ttnd.reap.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ttnd.reap.data.dao.impl.InsertDAOImpl;
import com.ttnd.reap.data.dao.impl.ValidateDAOImpl;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.LoginDTO;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.service.DataConvertService;
import com.ttnd.reap.service.UserService;
import com.ttnd.reap.user.role.UserRole;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ValidateDAOImpl validateDao;

	@Autowired
	private InsertDAOImpl insertDao;

	@Autowired
	private DataConvertService dataConvertService;

	@Override
	public boolean registerUser(EmployeeDTO employeeDto) {
		try {

			employeeDto.setRole("User");
			Employee employee = dataConvertService.convertToEmployee(employeeDto);
			/*String imagePath = null;
			if (employeeDto.getProfilePicture().getSize() > 0) {
				imagePath = saveProfileImage(employeeDto);
				employee.setImageFile(imagePath);
			} else {

				imagePath = "/home/shefali/UserImages/Default.jpg";
				employee.setImageFile(imagePath);
			}
*/
			insertDao.RegisterUser(employee);

			EarningKitty earningKitty = new EarningKitty();
			earningKitty.setEmployeeDetail(employee);

			insertDao.CreateEarningKitty(earningKitty);

			GivingKitty givingKitty = new GivingKitty();
			givingKitty.setBronze(UserRole.user.getBronze());
			givingKitty.setGold(UserRole.user.getGold());
			givingKitty.setSilver(UserRole.user.getSilver());
			givingKitty.setEmployee(employee);

			insertDao.CreateGivingKitty(givingKitty);

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	private String saveProfileImage(EmployeeDTO employeeDto) throws IOException {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		MultipartFile file = employeeDto.getProfilePicture();
		String fileName = employeeDto.getEmployeeEmailId();
		try {
			inputStream = file.getInputStream();

			String directory = "/home/shefali/UserImages/";
			String imagePath = directory + fileName + ".jpg";

			File newFile = new File(imagePath);

			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
			return imagePath;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			outputStream.flush();
			outputStream.close();
		}

	}

	@Override
	public EmployeeDTO authenticateUser(LoginDTO loginCredentials) {
		try {

			Employee employee = validateDao.ValidateUser(loginCredentials);
			EmployeeDTO employeeDto = dataConvertService.convertToEmployeeDto(employee);

			/*Path path = Paths.get(employee.getImageFile());
			byte[] imgArr = Files.readAllBytes(path);

			employeeDto.setProfilePic(new Base64().encodeToString(imgArr));
*/
			return employeeDto;
		} catch (Exception e) {
			return null;
		}
	}

}
