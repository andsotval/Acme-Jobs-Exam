
package acme.features.employer.xxxrequest;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Employer;
import acme.entities.xxxrequests.Xxxrequest;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("/employer/xxxrequest/")
public class EmployerXxxrequestController extends AbstractController<Employer, Xxxrequest> {

	@Autowired
	private EmployerXxxrequestShowService	showService;

	@Autowired
	private EmployerXxxrequestCreateService	createService;

	@Autowired
	private EmployerXxxrequestDeleteService	deleteService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
		super.addBasicCommand(BasicCommand.DELETE, this.deleteService);
	}

}
