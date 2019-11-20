package com.trafalgarcp.crm.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
//import java.util.Date;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.trafalgarcp.crm.domain.Address;
import com.trafalgarcp.crm.domain.CategorizedCompany;
import com.trafalgarcp.crm.domain.Category;
import com.trafalgarcp.crm.domain.Company;
import com.trafalgarcp.crm.domain.Industry;
import com.trafalgarcp.crm.domain.Professional;
import com.trafalgarcp.crm.dto.Userdto;
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
	File file_company = new File("./src//main/java/com/trafalgarcp/crm/services/us_companies.xlsx");
	DecimalFormat decimalFormat = new DecimalFormat("0.#####");
	
	@Autowired
	private Userservice userservice;

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
		System.out.println("\n\n" + "TESTED ++++++++++++++++++++++++++++++++++++++++" + "\n\n");
		
		createNewUser();
		
		

		industry = new Industry("Finance", "Investment");
		this.industryRepository.save(industry);
		industry = new Industry("Finance", "Loan");
		this.industryRepository.save(industry);
		industry = new Industry("Finance", "House loan");
		this.industryRepository.save(industry);
		industry = new Industry("Finance", "healthcare loan");
		this.industryRepository.save(industry);
		industry = new Industry("Finance", "construction loan");
		this.industryRepository.save(industry);

		industry = new Industry("Information technology", "Artificial Intelligence");
		this.industryRepository.save(industry);
		industry = new Industry("Information technology", "Data base");
		this.industryRepository.save(industry);
		industry = new Industry("Information technology", "web development");
		this.industryRepository.save(industry);
		industry = new Industry("Information technology", "Analytics");
		this.industryRepository.save(industry);
		industry = new Industry("Information technology", "Operating system");
		this.industryRepository.save(industry);
		industry = new Industry("Information technology", "Oracle Operations");
		this.industryRepository.save(industry);

		industry = new Industry("Restauratnts", "Fast Foods");
		this.industryRepository.save(industry);
		industry = new Industry("Restauratnts", "Carry out");
		this.industryRepository.save(industry);

		industry = new Industry("Healthcare", "Walgreen");
		this.industryRepository.save(industry);
		industry = new Industry("Healthcare", "CVS");
		this.industryRepository.save(industry);

		Category category = new Category("Finance", "Investment");
		this.categoryRepository.save(category);
		this.categoryRepository.save(new Category("Finance", "Loan"));
		this.categoryRepository.save(new Category("Finance", "House loan"));
		this.categoryRepository.save(new Category("Finance", "healthcare loan"));
		this.categoryRepository.save(new Category("Finance", "construction loan"));

		this.categoryRepository.save(new Category("Information technology", "Artificial Intelligence"));
		this.categoryRepository.save(new Category("Information technology", "Data base"));
		this.categoryRepository.save(new Category("Information technology", "web development"));
		this.categoryRepository.save(new Category("Information technology", "Analytics"));
		this.categoryRepository.save(new Category("Information technology", "Operating system"));
		this.categoryRepository.save(new Category("Information technology", "Oracle Operations"));

		this.categoryRepository.save(new Category("Restauratnts", "Fast Foods"));
		this.categoryRepository.save(new Category("Restauratnts", "Carry out"));

		this.categoryRepository.save(new Category("Healthcare", "Walgreen"));
		this.categoryRepository.save(new Category("Healthcare", "CVS"));

		Company company = new Company("LeapByCodes", "https://www.leapbycodes.com", 2019, 5000, "240-239-2332",
				"254-345-3454", "new services", (java.sql.Date) new Date(2000, 11, 21), "yen",
				new BigDecimal("124567890.0987654321"), new BigDecimal("124567890.0987654321"));

		Address address = new Address(2002, "MD", "Silver Spring", "9829 eastlight dr", "US");

		Professional professional = new Professional("Job", "Duna", "CEO", "jduna@gmail.com", "234-234-2343",
				"234-234-2343", "234-234-2343", "https://www.linkedin/jduna", "No");

		address.setCompany(company);
		professional.setCompany(company);

		this.companyRepository.save(company);
		this.addressRepository.save(address);
		this.professionalRepository.save(professional);

		CategorizedCompany categorizedCompany = new CategorizedCompany(category, company);
		this.categorizedCompanyRepository.save(categorizedCompany);

		readExcel();

		/**
		 * WILL BE NEEDED WHEN READ DATA FROM FILE
		 */
//		Files.list(Paths.get(".")).forEach(System.out::println);
//		List<List<String>> record=  readfile(file_company);
//	      record.stream()
//	      .flatMap(List::stream)
//	      .map(String::valueOf)
//	      .forEach(System.out::println);

		// readExcel();

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
	
	
	public void createNewUser() {
		
		Userdto user = new Userdto("David","Tebo","jdoe","dtebo@gmail.com","$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi","$2a$11$dp4wMyuqYE3KSwIyQmWZFeUb7jCsHAdk7ZhFc0qGw6i5J124imQBi");
		userservice.signupUser(user);
	}
	

	public void readExcel() throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(file_company);
		// Finds the workbook instance for XLSX file
		XSSFWorkbook myWorkBook = new XSSFWorkbook(fis);

		// Return first sheet from the XLSX workbook
		XSSFSheet mySheet = myWorkBook.getSheetAt(0);

		// Get iterator to all the rows in current sheet
		Iterator<Row> rowIterator = mySheet.iterator();

		List<String> data = new ArrayList<>();

		// Traversing over each row of XLSX file
		while (rowIterator.hasNext()) {

			Company company1 = new Company();
			company1.setFiscalYear((java.sql.Date) new Date(2000, 11, 21));
			Address address1 = new Address();
			Category category1 = new Category();
			category1.setCategorie("category-test");
			category1.setSubcategorie("subcategory-test");

			Professional professional1 = new Professional("Job", "Duna", "CEO", "jduna@gmail.com", "234-234-2343",
					"234-234-2343", "234-234-2343", "https://www.linkedin/jduna", "No");
			Row row = rowIterator.next();

			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();

			// Exit if the last row in the excel sheet reaches 529. Beyond 529 there is no
			// data
			if (cellIterator.next().getRowIndex() == 529)
				break;

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				if (cell.getColumnIndex() == 1)
					company1.setName(cell.getStringCellValue());
				if (cell.getColumnIndex() == 2)
					company1.setWebsite(cell.getStringCellValue());
				if (cell.getColumnIndex() == 3)
					company1.setYearFounded(Integer.parseInt(decimalFormat.format(cell.getNumericCellValue())));
				if (cell.getColumnIndex() == 14)
					company1.setDescription(cell.getStringCellValue());

				if (cell.getColumnIndex() == 4)
					address1.setCity(cell.getStringCellValue());
				if (cell.getColumnIndex() == 5)
					address1.setState(cell.getStringCellValue());
				if (cell.getColumnIndex() == 7)
					address1.setZipcode(Integer.parseInt(decimalFormat.format(cell.getNumericCellValue())));

				if (cell.getColumnIndex() == 17) {
					if (!cell.getStringCellValue().isEmpty())
						category1.setCategorie(cell.getStringCellValue());
					else
						category1.setCategorie("NA");
				}
				if (cell.getColumnIndex() == 10)
					if (!cell.getStringCellValue().isEmpty())
						category1.setSubcategorie(cell.getStringCellValue());

//				switch (cell.getCellType()) {
//				case STRING:
//					//data.add(cell.getStringCellValue());
//					System.out.println(cell.getColumnIndex()+" : STRING : "+cell.getStringCellValue());
//					break;
//                case NUMERIC:
//                   // data.add(cell.getNumericCellValue());
//                	System.out.println(cell.getColumnIndex()+" : NUMERIC : "+cell.getNumericCellValue());
//                    break;
//                case BOOLEAN:
//                   // data.add(cell.getBooleanCellValue());
//                	System.out.println(cell.getColumnIndex()+" : BOOLEAN : "+cell.getBooleanCellValue());
//                    break;
//				}   // End switch

			} // End inner while
			
			
//			this.categoryRepository.save(category1);
//			address1.setCompany(company1);
//			professional1.setCompany(company1);
//
//			this.companyRepository.save(company1);
//			this.addressRepository.save(address1);
//			this.professionalRepository.save(professional1);
//
//			CategorizedCompany categorizedCompany = new CategorizedCompany(category1, company1);
//			this.categorizedCompanyRepository.save(categorizedCompany);

		} // End outer while
		// System.out.println("\n"+"***************** ");
		//data.forEach(System.out::println);
		
		
		
	}
}