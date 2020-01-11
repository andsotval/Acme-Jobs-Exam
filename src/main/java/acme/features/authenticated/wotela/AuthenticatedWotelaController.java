
package acme.features.authenticated.wotela;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.wotelas.Wotela;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;
import acme.framework.entities.Authenticated;

@Controller
@RequestMapping("authenticated/wotela")
public class AuthenticatedWotelaController extends AbstractController<Authenticated, Wotela> {

	@Autowired
	private AuthenticatedWotelaShowByJobService showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.SHOW_BY_JOB, BasicCommand.SHOW, this.showService);
	}
}
