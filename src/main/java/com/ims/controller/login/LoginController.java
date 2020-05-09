package com.ims.controller.login;



import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ims.beans.Response;
import com.ims.beans.UserDetails;
import com.ims.constant.CommonConstants;
import com.ims.constant.MessageConstants;
import com.ims.controller.RestMappingProvider;
import com.ims.helper.RandomNumberGenerator;
import com.ims.service.login.LoginService;

@RestController
public class LoginController {
	//private  final Logger LOG = Logger.getLogger(LoginController.class.getName());
	private static final Logger LOG = LogManager.getFormatterLogger();

	@Autowired
	public LoginService loginService;
	
	/**
	 * This Method used to show information about whether license server is up
	 * and running.
	 * 
	 * @return ResponseEntity
	 */
	@RequestMapping(RestMappingProvider.LOGIN_CONTROLLER_CHECK)
	public ResponseEntity<String> info() {
		LOG.info(MessageConstants.LOGIN_CONTROLLER_CHECK);
		return new ResponseEntity<String>(MessageConstants.LOGIN_CONTROLLER_CHECK, HttpStatus.OK);
	}
	
	@RequestMapping(path=RestMappingProvider.LOGIN_VALIDATE)
	@Produces(MediaType.APPLICATION_JSON)
    @CrossOrigin
    public UserDetails validateLogin(@Context HttpServletRequest httpRequest,@PathVariable("loginId") String userId, @PathVariable("password") String password) {
            long startTime = System.currentTimeMillis();
            String logID =String.valueOf(RandomNumberGenerator.generateRandomNumber(5));
            LOG.info(logID + MessageConstants.NEW_REQUEST);
            LOG.info(logID + CommonConstants.INPUT_START);
       
             /*PRINT INPUT PARAMETER*/
            LOG.info(logID + CommonConstants.INPUT_END);
            Response responseBean = new Response();

        /*--------------BUSINESS LOGIC------------------------------*/
        
            UserDetails userdetails  = loginService.validateUser("111", userId, password);
            
               /*---SERVICE CALL--DAO CALL-----------*/
            //commonService.getApplicationMaster(type, logId)
            long endTime = System.currentTimeMillis();
            LOG.info(logID + CommonConstants.EXEC_TIME + (endTime - startTime));
            LOG.info(logID + MessageConstants.SENDING_RESPONSE);
            return userdetails;
    }
	
}
	 

	

