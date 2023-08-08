package com.project.staragile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MedicureController {

	@Autowired
	MedicureService doctorService;

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello from Doctor Shubham";
	}

	@GetMapping("/createDoctor")
	public Doctor createDoctor() {
		return doctorService.createDoctor();
	}

	@PostMapping("/registerDoctor")
	public Doctor registerDoctor(@RequestBody Doctor doctor) {
		return doctorService.registerDoctor(doctor);
	}

	@GetMapping("/getDoctor/{doctorRegistrationId}")
	public Doctor getDoctor(@PathVariable String doctorRegistrationId) {
		return doctorService.getDoctorDetails(doctorRegistrationId);
	}

	@PutMapping("/updateDoctor/{doctorRegistrationId}")
	public Doctor UpdateDoctor(@RequestBody Doctor doctor,
			@PathVariable(value = "doctorRegistrationId") String doctorRegistrationId) {
		return doctorService.updateDoctor(doctor, doctorRegistrationId);
	}

	@GetMapping("/searchDoctor/{doctorRegistrationId}")
	public Doctor searchDoctorDetails(@PathVariable(value = "doctorRegistrationId") String doctorRegistrationId) {
		return doctorService.searchDoctorbyName(doctorRegistrationId);
	}

	@DeleteMapping("/deleteDoctor/{doctorRegistrationId}")
	public String deleteDoctorDetails(@PathVariable(value = "doctorRegistrationId") String doctorRegistrationId) {
		return doctorService.deleteDoctorDetails(doctorRegistrationId);
	}

}
