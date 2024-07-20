package src.miscellaneously.employee;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDao;

    public Employee getEmployee(Long employeeId) {

        return employeeDao.getEmployee(employeeId);

        String abc = "sss";
        String s = new String("sss");


    }

}
