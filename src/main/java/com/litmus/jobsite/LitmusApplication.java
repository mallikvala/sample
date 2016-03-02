package com.litmus.jobsite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.litmus.jobsite.models.Candidate;
import com.litmus.jobsite.services.CandidateService;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
@RestController
@RequestMapping("/profile")
public class LitmusApplication {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	

    public static final String ACCEPT_HEADER = "Accept=application/json";
    public static final String CONTENT_HEADER = "Content-Type";
    public static final String CONTENT_HEADER_VALUE = "application/json; charset=utf-8";
    

	@Autowired
	private Jackson2ObjectMapperBuilder builder;



	@Autowired
	private CandidateService candidateService;

	public static void main(String[] args) {
		SpringApplication.run(LitmusApplication.class, args);
	}

	@RequestMapping(value="/name")
	public String getString(){
		return "{name:'vala'}";
	}
	
	
	@RequestMapping(value = "/get/{firstName}", method = RequestMethod.GET, headers = ACCEPT_HEADER)
    @ResponseBody
    public ResponseEntity<String> home(@PathVariable("firstName") String firstName) {
        HttpHeaders headers = new HttpHeaders();
        addContentHeaders(headers);
        try {
            Candidate findOne = candidateService.findByFirstName(firstName);
            ObjectMapper mapper = builder.build();
            return new ResponseEntity<String>(mapper.writeValueAsString(findOne), headers, HttpStatus.OK);
        }
        catch (JsonProcessingException e) {
            log.error(this.getClass().getName(), e);
            return new ResponseEntity<String>(e.getMessage(), headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


	@RequestMapping(value="/mock")
	public String mock(){

		Candidate c = new Candidate();
		c.setEmailAddress("ex@ex.com");
		c.setFirstName("firstName");
		c.setLastName("lastName");
		c.setMiddleName("middleName");
		c.setPhoneNumber("23232");
		candidateService.save(c);

		return "saved";
	}
	

    public static void addContentHeaders(HttpHeaders headers){
        headers.add(CONTENT_HEADER, CONTENT_HEADER_VALUE);
    }


}
