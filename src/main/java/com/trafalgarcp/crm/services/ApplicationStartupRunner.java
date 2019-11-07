package com.trafalgarcp.crm.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.CategorizedCompany;
import com.trafalgarcp.crm.domain.Category;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.Industry;
import com.trafalgarcp.crm.domain.Professional;
import com.trafalgarcp.crm.repository.AddressRepository;
import com.trafalgarcp.crm.repository.CategorizedCompanyRepository;
import com.trafalgarcp.crm.repository.CategoryRepository;
import com.trafalgarcp.crm.repository.CompanyRepository;
import com.trafalgarcp.crm.repository.IndustryRepository;
import com.trafalgarcp.crm.repository.ProfessionalRepository;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {
   // protected final Log logger = LogFactory.getLog(getClass());
 
    private static final String COMMA_DELIMITER = ",";
    File file_company = new File("./src//main/java/com/trafalgarcp/crm/services/us_agencies.csv");
    
    @Autowired
    private IndustryRepository industryRepository;
    
    @Autowired
    private CategorizedCompanyRepository categorizedCompanyRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private AddressRepository addressRepository;
    
    @Autowired
    private ProfessionalRepository professionalRepository;
    
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
		
		Category category = new Category("Finance","Investment");this.categoryRepository.save(category);
		this.categoryRepository.save(new Category("Finance","Loan"));
		this.categoryRepository.save(new Category("Finance","House loan"));
		this.categoryRepository.save(new Category("Finance","healthcare loan"));
		this.categoryRepository.save(new Category("Finance","construction loan"));
		
		this.categoryRepository.save(new Category("Information technology","Artificial Intelligence"));
		this.categoryRepository.save(new Category("Information technology","Data base"));
		this.categoryRepository.save(new Category("Information technology","web development"));
		this.categoryRepository.save(new Category("Information technology","Analytics"));
		this.categoryRepository.save(new Category("Information technology","Operating system"));
		this.categoryRepository.save(new Category("Information technology","Oracle Operations"));
		
		this.categoryRepository.save(new Category("Restauratnts","Fast Foods"));
		this.categoryRepository.save(new Category("Restauratnts","Carry out"));
		
		
		this.categoryRepository.save(new Category("Healthcare","Walgreen"));
		this.categoryRepository.save(new Category("Healthcare","CVS"));
		
		
		Company company = new Company("LeapByCodes","https://www.leapbycodes.com",2019,5000,"240-239-2332","254-345-3454","new services",(java.sql.Date) new Date(2000, 11, 21),
				"yen",new BigDecimal("124567890.0987654321"),new BigDecimal("124567890.0987654321"));
		 
		
		
		
		Address address = new Address(2002,"MD","Silver Spring","9829 eastlight dr","US");
		
		
		
		
		Professional professional = new Professional("Georgy","Louis","CEO",
				"lgeorgy@leapbycodes.com",
				"234-234-2343","234-234-2343","234-234-2343",
				"https://www.linkedin/georgy","No");
		
		
		
		
		address.setCompany(company);
		professional.setCompany(company);
		
		this.companyRepository.save(company);
		this.addressRepository.save(address);
		this.professionalRepository.save(professional);
		
		CategorizedCompany categorizedCompany = new CategorizedCompany(category,company);
		this.categorizedCompanyRepository.save(categorizedCompany);
		
		
		
	 
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