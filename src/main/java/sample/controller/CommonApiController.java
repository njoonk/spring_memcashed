package sample.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import sample.bean.CommonPara;
import sample.service.TokenService;
import sample.utility.DateUtility;

import org.apache.commons.configuration.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/***
 * The <code>CommonSampleApiController</code> class represents action controller.
 * This class is indicating the common controller
 * 1. Get the server time.
 * 2. Set logs in the server from a client.
 * 3. Get a one token.
 * 4. Check For health.
 * 
 * @author  Woong-joon Kim
 * @version 0.1, 11/08/29
 * @see     sample.sp.api.controller.CommonApiController#nowTime()
 * @see     sample.sp.api.controller.CommonApiController#behavior()
 * @see     sample.sp.api.controller.CommonApiController#oneToken()
 * @see     sample.sp.api.controller.CommonApiController#okApi()
 * @since   JDK1.6
 */
@Controller
public class CommonApiController {

	final Logger logger = LoggerFactory.getLogger(CommonApiController.class);
	final Logger spPatriotLog = LoggerFactory.getLogger("spPatriot");

	@Autowired
    private Configuration configuration;
	@Autowired
	private MessageSource message;
	@Autowired
	private TokenService tokenService;

    /**
     * Get a token from the Api server.
     * @param  ModelMap 
     *         model
     * @param  HttpServletRequest 
     *         request
     *         
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.6
     */
	@RequestMapping(value = {"api/oneToken.sp"}, method=RequestMethod.POST)
	public String oneToken(@ModelAttribute("commonPara")CommonPara commonPara, 
							ModelMap model, 
							HttpServletRequest request) throws Exception {

		String id = (String) request.getAttribute("amebaId");
		
		if (id == null) {
			id = commonPara.getUserUuId();
		}

		Date afterOneHourDate = DateUtility.getMinuteOfHourMoveTime(DateUtility.getNowTime(), 10);
		// tokened digit number is 12
		String oneToken = tokenService.saveToken(id, afterOneHourDate);

		model.addAttribute("oneToken", oneToken);

		return "spApi/oneToken";
	}

    /**
     * For the health check from the Mon.
     * 
     * @param  ModelMap
     *         model
     * 
     * @throws  Exception
     *          If a error occur, ...
     *
     * @return String
     * 		   a file name of FTL.
     * 
     * @since  1.6
     */
	@RequestMapping(value = {"checkOk.sp"}, method=RequestMethod.GET)
	public String okApi(ModelMap model) throws Exception {

		return "spApi/okApi";
	}

}