package th.example.thailifetest.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import th.example.thailifetest.iservice.IProfileService;
import th.example.thailifetest.models.DepartmentEmployeeModel;
import th.example.thailifetest.models.DepartmentModel;
import th.example.thailifetest.models.EmployeeDetailModel;
import th.example.thailifetest.models.EmployeeModel;
import th.example.thailifetest.models.PositionModel;
import th.example.thailifetest.request.NewEmployeeRequest;
import th.example.thailifetest.response.ApiResponse;

@RestController
//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/profile")
public class ProfileController {

	@Autowired
	IProfileService profileService; 
	
	@GetMapping("/searchEmp")
	@ResponseBody
	public ApiResponse<List<EmployeeModel>> searchEmp( @RequestParam  String empName, @RequestParam  String empLastname) {
		ApiResponse<List<EmployeeModel>> res = new  ApiResponse<List<EmployeeModel>>();
		if( (empName == null || empName.length() == 0) && (empLastname == null || empLastname.length() == 0)) {
			res.setData(profileService.searchAllEmployee());
		}else {
			res.setData(profileService.searchEmployeeByName(empName, empLastname));
		}
		return res;
	}
	
	@GetMapping("/searchEmployeeByDept")
	@ResponseBody
	public ApiResponse<List<EmployeeDetailModel>> searchEmployeeByDept( @RequestParam  String deptId) {
		ApiResponse<List<EmployeeDetailModel>> res = new  ApiResponse<List<EmployeeDetailModel>>();
		res.setData(profileService.searchEmployeeByDept(deptId));
		return res;
	}

	@GetMapping("/searchEmployeeById")
	@ResponseBody
	public ApiResponse<EmployeeDetailModel> searchEmployeeById( @RequestParam  String empId) {
		ApiResponse<EmployeeDetailModel> res = new  ApiResponse<EmployeeDetailModel>();
		res.setData(profileService.searchEmployeeById(empId));
		return res;
	}
	
	@GetMapping("/searchDeptHir")
	@ResponseBody
	public ApiResponse<DepartmentEmployeeModel> searchDeptHir() {
		ApiResponse<DepartmentEmployeeModel> res = new  ApiResponse<DepartmentEmployeeModel>();
		res.setData(profileService.searchDeptHir());
		return res;
	}
	

	@PostMapping("/addNewEmp")
	@ResponseBody
	public ApiResponse<String> addNewEmp(@RequestBody NewEmployeeRequest req) {
		ApiResponse<String> res = new  ApiResponse<String>();
		profileService.newEmployee(req);
		return res;
	}
	
	@PostMapping("/updateEmp")
	@ResponseBody
	public ApiResponse<String> updateEmp(@RequestBody NewEmployeeRequest req) {
		ApiResponse<String> res = new  ApiResponse<String>();
		profileService.saveEmployee(req);
		return res;
	}
	
	@GetMapping("/department")
	@ResponseBody
	public ApiResponse<List<DepartmentModel>> getDepartment() {
		ApiResponse<List<DepartmentModel>> res = new  ApiResponse<List<DepartmentModel>>();
		res.setData(profileService.getDepartmentAll());
		return res;
	}
	

	@GetMapping("/position")
	@ResponseBody
	public ApiResponse<List<PositionModel>> getPositionByDept( @RequestParam  String deptId) {
		ApiResponse<List<PositionModel>> res = new  ApiResponse<List<PositionModel>>();
		res.setData(profileService.getPositionByDept( deptId));
		return res;
	}
	
	@GetMapping("/positionHist")
	@ResponseBody
	public ApiResponse<List<PositionModel>> getPositionHistByEmpId( @RequestParam  String empId) {
		ApiResponse<List<PositionModel>> res = new  ApiResponse<List<PositionModel>>();
		res.setData(profileService.getAllPositionByEmpId( empId));
		return res;
	}
	
	@GetMapping("/export")
	public void export(@RequestParam  String type, @RequestParam  String deptId, HttpServletResponse response ) 
		    throws IOException {
		List<EmployeeDetailModel> listData = profileService.searchEmployeeByDept(deptId);
	    StringBuilder content = new StringBuilder();
	    DateFormat dateFormatter = new SimpleDateFormat("dd/MM/YYYY");
	    for(EmployeeDetailModel emp : listData) {
	    	content.append(emp.getEmployeeId());
	    	content.append(",");
	    	content.append(emp.getEmployeeName());
	    	content.append(",");
	    	content.append(emp.getMobileNo());
	    	content.append(",");
	    	content.append(dateFormatter.format(emp.getStartDate()));
	    	content.append(",");
	    	content.append(emp.getDeptName());
	    	content.append(",");
	    	content.append(emp.getHeadEmployeeName());
	    	content.append("\n");
	    	
	    }
	    dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
	    String currentDateTime = dateFormatter.format(new Date());
	    String fileName = currentDateTime + "." + type;
	    if(type == "csv") {
		    response.setContentType("text/csv; charset=UTF-8");
	    }else {
		    response.setContentType("text/plain; charset=UTF-8");
	    }
	    response.setHeader("Content-Disposition","attachment;filename="+fileName);
	    response.setCharacterEncoding("UTF-8");
	    ServletOutputStream out = response.getOutputStream();
	    out.write(content.toString().getBytes("UTF-8"));
	    out.flush();
	    out.close();
	}
	
//	@GetMapping("/users/export")
//    public void exportToCSV(HttpServletResponse response) throws IOException {
//        response.setContentType("text/csv");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//        String currentDateTime = dateFormatter.format(new Date());
//         
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
//        response.setHeader(headerKey, headerValue);
//         
//        List<User> listUsers = service.listAll();
// 
//        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//        String[] csvHeader = {"User ID", "E-mail", "Full Name", "Roles", "Enabled"};
//        String[] nameMapping = {"id", "email", "fullName", "roles", "enabled"};
//         
//        csvWriter.writeHeader(csvHeader);
//         
//        for (User user : listUsers) {
//            csvWriter.write(user, nameMapping);
//        }
//         
//        csvWriter.close();
//         
//    }
	
//	@GetMapping("/users/export")
//	public ResponseEntity<byte[]> downloadTextFileExample4(@RequestParam  String type) throws IOException {
//		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//		String currentDateTime = dateFormatter.format(new Date());
//		String fileName = currentDateTime + ".txt";
//		String fileContent = "Simple Solution \nDownload Example 4";
//			
//		// Create text file
//		Path exportedPath = fileExporter.export(fileContent, fileName);
//			
//		// Download file with byte[]
//		byte[] expotedFileData = Files.readAllBytes(exportedPath);
//		
//		if(type.toLowerCase().equals("csv")) {
//			return ResponseEntity.ok()
//			.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
//			.contentType(MediaType.TEXT_PLAIN)
//			.contentLength(expotedFileData.length)
//			.body(expotedFileData);
//		}
//			
//		return ResponseEntity.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + fileName)
//				.contentType(MediaType.TEXT_PLAIN)
//				.contentLength(expotedFileData.length)
//				.body(expotedFileData);
//	}
//	
//	public Path export(String fileContent, String fileName) {
//		Path filePath = Paths.
//		try {
//			Path exportedFilePath = Files.write(filePath, fileContent.getBytes(), StandardOpenOption.CREATE);
//			return exportedFilePath;
//		} catch (IOException e) {
//			logger.error(e.getMessage(), e);
//		}	
//		return null;
//	}
}
