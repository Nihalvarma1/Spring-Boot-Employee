package com.ust.Employee_info;

import com.ust.Employee_info.model.EmployeeModel;
import com.ust.Employee_info.repository.EmployeeRepository;
import com.ust.Employee_info.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeInfoApplicationTests {
	@Autowired
	private EmployeeService service;

	@MockBean
	private EmployeeRepository repository;

	@Test
	public void addEmployeeTest() {
		EmployeeModel emp = new EmployeeModel(101,"Alice Johnson",55000,'A');
		when(repository.save(emp)).thenReturn(emp);
		assertEquals(emp, service.addEmployee(emp));
	}

	@Test
	public void addEmployeesTest(){
		List<EmployeeModel> employees = Arrays.asList(
				new EmployeeModel(102,"Bob Smith",48000,'B'),
				new EmployeeModel(103,"Carol Davis",62000, 'A'),
				new EmployeeModel(104, "David Brown", 53000, 'B'),
				new EmployeeModel(105,"Eve Wilson", 50000,'C'),
				new EmployeeModel(106, "Frank Miller", 47000, 'C'));
		when(repository.saveAll(employees)).thenReturn(employees);
		assertEquals(employees,service.addEmployees(employees));
	}

	@Test
	public void listEmployeesTest(){
		when(repository.findAll()).thenReturn(Stream
				.of(new EmployeeModel(102,"Bob Smith",48000,'B'),
						new EmployeeModel(103,"Carol Davis",62000, 'A')).collect(Collectors.toList()));
		assertEquals(2, service.listEmployees().size());
	}

	@Test
	public void getEmployeeTest() {
			int id = 4;
			EmployeeModel emp =new EmployeeModel(376, "Danile", 31000, 'A');
			when(repository.findById(id)).thenReturn(Optional.of(emp));
			assertEquals(emp, service.getEmployee(id));
	}

//	@Test
//	public void deleteEmployeeTest(){
//		EmployeeModel emp = new EmployeeModel(11, "Pranya", 33, 'A');
//		String s =service.deleteEmployee(emp);
//		verify(repository, times(1)).delete(emp);
//	}
}
