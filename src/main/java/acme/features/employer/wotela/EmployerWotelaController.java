
package acme.features.employer.wotela;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.entities.roles.Employer;
import acme.entities.wotelas.Wotela;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

// TODO: Cambiar
@Controller
@RequestMapping("/employer/wotela/")
public class EmployerWotelaController extends AbstractController<Employer, Wotela> {

	@Autowired
	private EmployerWotelaShowService	showService;

	@Autowired
	private EmployerWotelaCreateService	createService;


	@PostConstruct
	private void initialise() {
		super.addBasicCommand(BasicCommand.CREATE, this.createService);
		super.addBasicCommand(BasicCommand.SHOW, this.showService);
	}

}
