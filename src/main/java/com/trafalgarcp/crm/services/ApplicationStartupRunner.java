package com.trafalgarcp.crm.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trafalgarcp.crm.domain.Industry;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.repository.IndustryRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
   // protected final Log logger = LogFactory.getLog(getClass());
 
    private static final String COMMA_DELIMITER = ",";
    File file_company = new File("./src//main/java/com/trafalgarcp/crm/services/us_agencies.csv");
    
    @Autowired
    private IndustryRepository industryRepository;
    
    @Autowired
    private CompanyRepository companyRepository;
    private Industry industry = new Industry();

	@Override
    public void run(String... args) throws Exception {
		System.out.println("\n\n"+"TESTED ++++++++++++++++++++++++++++++++++++++++"+"\n\n");
		
		industry = new Industry("Finance","Investment"); this.industryRepository.save(industry);
		industry = new Industry("Finance","Loan"); this.industryRepository.save(industry);
		industry = new Industry("Finance","House loan"); this.industryRepository.save(industry);
		industry = new Industry("Finance","healthcare loan"); this.industryRepository.save(industry);
		industry = new Industry("Finance","construction loan"); this.industryRepository.save(industry);
		
		
		industry = new Industry("Information technology","Artificial Intelligence"); this.industryRepository.save(industry);
		industry = new Industry("Information technology","Data base"); this.industryRepository.save(industry);
		industry = new Industry("Information technology","web development"); this.industryRepository.save(industry);
		industry = new Industry("Information technology","Analytics"); this.industryRepository.save(industry);
		industry = new Industry("Information technology","Operating system"); this.industryRepository.save(industry);
		industry = new Industry("Information technology","Oracle Operations"); this.industryRepository.save(industry);
		
		industry = new Industry("Restauratnts","Fast Foods"); this.industryRepository.save(industry);
		industry = new Industry("Restauratnts","Carry out"); this.industryRepository.save(industry);
		
		industry = new Industry("Healthcare","Walgreen"); this.industryRepository.save(industry);
		industry = new Industry("Healthcare","CVS"); this.industryRepository.save(industry);

		//this.companyRepository.save(new Company )
		

		
	  this.industryRepository.save(industry);
	  /**  
	   *   WILL BE NEEDED WHEN READ DATA FROM FILE
	   * 
		Files.list(Paths.get(".")).forEach(System.out::println);
		List<List<String>> record=  readfile(file_company);
	      record.stream()
	      .flatMap(List::stream)
	      .map(String::valueOf)
	      .forEach(System.out::println);*/
	   
	  
    }
    
    public List<List<String>> readfile(File file) throws FileNotFoundException, IOException {
    	List<List<String>> records = new ArrayList<>();
    	try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    	    String line;
    	    while ((line = br.readLine()) != null) {
    	        String[] values = line.split(COMMA_DELIMITER);
    	        records.add(Arrays.asList(values));
    	    }
    	}
		return records;
    }
}