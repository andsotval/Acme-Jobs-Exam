
package acme.features.worker.wotela;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import acme.components.CustomCommand;
import acme.entities.roles.Worker;
import acme.entities.wotelas.Wotela;
import acme.framework.components.BasicCommand;
import acme.framework.controllers.AbstractController;

@Controller
@RequestMapping("worker/wotela")
public class WorkerWotelaController extends AbstractController<Worker, Wotela> {

	@Autowired
	private WorkerWotelaShowByJobService showService;


	@PostConstruct
	private void initialise() {
		super.addCustomCommand(CustomCommand.SHOW_BY_JOB, BasicCommand.SHOW, this.showService);
	}
}
