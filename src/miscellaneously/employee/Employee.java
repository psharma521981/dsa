package src.miscellaneously.employee;

@RestController("/employee")
public class Employee {

    // Get operation - get the employee detail

    @Autowired EmployeeService employeeService;

    @GetMapping(consume="application/json",produce="application/json")
    public  Response getEmployeeDetails(@ReqeuestParam employeeId, @HeadersParam) {
        try {
            Employee employee employeeService.getEmployee(employeeId)
            
           return employee 
        } catch(EmployeeException e) {
            
        }
        
    }

}
