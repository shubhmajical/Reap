package com.ttnd.reap.services.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttnd.reap.data.dao.IFetchDAO;
import com.ttnd.reap.data.dao.IInsertDAO;
import com.ttnd.reap.data.dao.IUpdateDAO;
import com.ttnd.reap.dto.BindDTO;
import com.ttnd.reap.dto.ChangeUserRoleDto;
import com.ttnd.reap.dto.EarningKittyDTO;
import com.ttnd.reap.dto.EmployeeDTO;
import com.ttnd.reap.dto.GivingKittyDTO;
import com.ttnd.reap.dto.KarmaReasonDTO;
import com.ttnd.reap.pojo.EarningKitty;
import com.ttnd.reap.pojo.Employee;
import com.ttnd.reap.pojo.GivingKitty;
import com.ttnd.reap.pojo.KarmaReason;
import com.ttnd.reap.service.DashboardService;
import com.ttnd.reap.service.DataConvertService;
import com.ttnd.reap.user.role.UserRole;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private IFetchDAO fetchdaos;

	@Autowired
	private IInsertDAO insertdaos;

	@Autowired
	private IUpdateDAO updatedaos;

	@Autowired
	private DataConvertService dataConvertService;

	@Override
	public List<EarningKittyDTO> getNewerBoard() {

		List<EarningKitty> list = fetchdaos.getNewerBoard();
		List<EarningKittyDTO> earningKittydtaos = new ArrayList<>();
		for (int count = 0; count < list.size(); count++) {
			EarningKittyDTO earningKittyDto = new EarningKittyDTO();
			earningKittyDto = dataConvertService.convertToEarningKittyDto(list.get(count));
			earningKittydtaos.add(earningKittyDto);
		}
		return earningKittydtaos;
	}

	@Override
	public List<KarmaReasonDTO> getWallOfTheFame() {
		List<KarmaReason> karmaReasons = fetchdaos.getWallOfFame();
		List<KarmaReasonDTO> karmaReasonDTOs = new ArrayList<>();

		for (int count = 0; count < karmaReasons.size(); count++) {
			KarmaReasonDTO karmaReasonDTO = dataConvertService.convertToKarmaReasonDTO(karmaReasons.get(count));
			karmaReasonDTOs.add(karmaReasonDTO);
		}
		return karmaReasonDTOs;
	}

	@Override
	public List<EmployeeDTO> searchNewer(String query, EmployeeDTO loggedInEmployee) {

		List<EmployeeDTO> employeeDtos = new ArrayList<>();
		List<Employee> employee = fetchdaos.FetchNewerlist(query);

		for (int count = 0; count < employee.size(); count++) {
			EmployeeDTO employeeDTO = new EmployeeDTO();
			employeeDTO = dataConvertService.convertToEmployeeDto(employee.get(count));
			if (!loggedInEmployee.getEmployeeEmailId().equals(employeeDTO.getEmployeeEmailId())) {
				employeeDtos.add(employeeDTO);
			}

		}
		return employeeDtos;
	}

	private void mailService(String mailTo, String msg ){
		
		//String to="shefali.sharma@tothenew.com";//change accordingly

		//Get the session object
		  Properties props = new Properties();
		  props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication("reap.dashboard@gmail.com","sh@123456");//change accordingly
		   }
		  });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress("reap.dashboard@gmail.com"));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(mailTo));
		   message.setSubject("Congratulations!!!");
		   message.setText(msg);
		   
		   //send message
		   Transport.send(message);

		   System.out.println("message sent successfully");
		 
		  } catch (MessagingException e) {throw new RuntimeException(e);}
		 
		 }
	

	@Override
	public GivingKittyDTO getEmployeeGivingKitty(Employee employee) {
		GivingKitty givingKitty = fetchdaos.getGivingKitty(employee);
		GivingKittyDTO givingKittyDTO = dataConvertService.convertTOGivingKittyDto(givingKitty);
		return givingKittyDTO;
	}

	@Override
	public EarningKittyDTO getEmployeeEarningKitty(Employee employee) {
		EarningKitty earningKitty = fetchdaos.getEarningKitty(employee);
		EarningKittyDTO earningKittyDTO = dataConvertService.convertToEarningKittyDto(earningKitty);
		return earningKittyDTO;
	}

	@Override
	public BindDTO binddata(EmployeeDTO employeeDto) {
		Employee employee = dataConvertService.convertToEmployee(employeeDto);

		GivingKittyDTO givingkittydtao = getEmployeeGivingKitty(employee);
		EarningKittyDTO earningKittydtao = getEmployeeEarningKitty(employee);

		BindDTO bindDtaos = new BindDTO();
		bindDtaos.setEarningKitty(earningKittydtao);
		bindDtaos.setGivingKitty(givingkittydtao);
		bindDtaos.setEmployee(employeeDto);
		bindDtaos.setNewerBoard(getNewerBoard());
		bindDtaos.setWallOfthefamedtao(getWallOfTheFame());
		return bindDtaos;
	}

	@Override
	public EmployeeDTO fetchEmployees(int employeeId) {

		Employee employee = new Employee();
		employee = fetchdaos.FetchEmployees(employeeId);
		EmployeeDTO employeeDTO = dataConvertService.convertToEmployeeDto(employee);
		return employeeDTO;
	}

	@Override
	public boolean sendKarma(KarmaReasonDTO karmaReasonDTO) {
		EarningKitty earningKitty = fetchdaos
				.getEarningKitty(dataConvertService.convertToEmployee(karmaReasonDTO.getReceiverId()));
		GivingKitty givingKitty = fetchdaos
				.getGivingKitty(dataConvertService.convertToEmployee(karmaReasonDTO.getSenderId()));

		if (karmaReasonDTO.getBadgeReceived().equalsIgnoreCase("gold")) {
			earningKitty.setGold(earningKitty.getGold() + 1);
			earningKitty.setPoints(earningKitty.getPoints() + 30);
			givingKitty.setGold(givingKitty.getGold() - 1);
		} else if (karmaReasonDTO.getBadgeReceived().equalsIgnoreCase("silver")) {
			earningKitty.setSilver(earningKitty.getSilver() + 1);
			earningKitty.setPoints(earningKitty.getPoints() + 20);
			givingKitty.setSilver(givingKitty.getSilver() - 1);
		} else {
			earningKitty.setBronze(earningKitty.getBronze() + 1);
			earningKitty.setPoints(earningKitty.getPoints() + 10);
			givingKitty.setBronze(givingKitty.getBronze() - 1);
		}

		if (insertdaos.EnterRecognization(dataConvertService.convertToKarmaReason(karmaReasonDTO))) {
			updatedaos.updateEarningKitty(earningKitty);
			updatedaos.updateGivingKitty(givingKitty);
			
			String msg="Congratulations!!!"+karmaReasonDTO.getReceiverId().getEmployeeName()+" have been recognized by "+karmaReasonDTO.getSenderId().getEmployeeName()+".";
			
			new Thread(new Runnable(){
				@Override
				public void run(){
			mailService(karmaReasonDTO.getReceiverId().getEmployeeEmailId(),msg);
				}
			}).start();
			return true;
		}
		return false;

	}
	
	private void SmsHorizon(String Mobile, String message) {

		String user = "shefalisharma123456";

		String apikey = "jB7zjO8J2buOkpLcliGL";

		String mobile = Mobile;

		String senderid = "MYTEXT";

		String type="txt";

		URLConnection myURLConnection=null;
		URL myURL=null;
		BufferedReader reader=null;

		@SuppressWarnings("deprecation")
		String encoded_message=URLEncoder.encode(message);

		String mainUrl="http://smshorizon.co.in/api/sendsms.php?";

		StringBuilder sbPostData= new StringBuilder(mainUrl);
		sbPostData.append("user="+user); 
		sbPostData.append("&apikey="+apikey);
		sbPostData.append("&message="+encoded_message);
		sbPostData.append("&mobile="+mobile);
		sbPostData.append("&senderid="+senderid);
		sbPostData.append("&type="+type);

		mainUrl = sbPostData.toString();
		try
		{
		    myURL = new URL(mainUrl);
		    myURLConnection = myURL.openConnection();
		    myURLConnection.connect();
		    reader= new BufferedReader(new InputStreamReader(myURLConnection.getInputStream())); 
		    String response1;
		    while ((response1 = reader.readLine()) != null) 

		    System.out.println(response1);
		    System.out.println("<h1>Message Sent Successfully");
		    

		    reader.close();
		} 
		catch (IOException e) 
		{ 
			e.printStackTrace();
		} 

	}

	@Override
	public boolean changeUserRole(ChangeUserRoleDto changeUserRole) {

		Employee employee = dataConvertService.convertToEmployee(changeUserRole.getNewer());
		employee.setRole(changeUserRole.getChangeRole());
		
		String name=employee.getEmployeeName();
		String role=changeUserRole.getChangeRole();
		String msg=name+" your role have been changed to "+role;

		GivingKitty givingKitty = fetchdaos.getGivingKitty(employee);

		if (changeUserRole.getChangeRole().equalsIgnoreCase("SuperVisor")) {
			givingKitty.setBronze(UserRole.Supervisor.getBronze());
			givingKitty.setGold(UserRole.Supervisor.getGold());
			givingKitty.setSilver(UserRole.Supervisor.getSilver());

		} else if (changeUserRole.getChangeRole().equalsIgnoreCase("PracticeHead")) {
			givingKitty.setBronze(UserRole.PracticeHead.getBronze());
			givingKitty.setGold(UserRole.PracticeHead.getGold());
			givingKitty.setSilver(UserRole.PracticeHead.getSilver());

		} else {
			givingKitty.setBronze(UserRole.user.getBronze());
			givingKitty.setGold(UserRole.user.getGold());
			givingKitty.setSilver(UserRole.user.getSilver());
		}

		if (updatedaos.updateEmployee(employee)) {
			updatedaos.updateGivingKitty(givingKitty);
			return true;
		}
		
		new Thread(new Runnable(){
			@Override
			public void run(){
		SmsHorizon(changeUserRole.getNewer().getMobileNumber(), msg);
			}
		}).start();
		
		return false;

	}

	@Override
	public boolean revokeKarma(String karmaReason) {

		KarmaReason karmaReasonRevoke = new KarmaReason();

		karmaReasonRevoke.setRevokedReason(karmaReason);
		karmaReasonRevoke.setStatus(false);

		if (updatedaos.updateKarmaReason(karmaReasonRevoke)) {
			return true;
		}

		return false;
	}

}