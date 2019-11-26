//
//package acme.features.employer;
//
//import javax.annotation.PostConstruct;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import acme.components.CustomCommand;
//import acme.entities.jobs.Job;
//import acme.entities.roles.Employer;
//import acme.framework.components.BasicCommand;
//import acme.framework.controllers.AbstractController;
//
//@Controller
//@RequestMapping("/employer/job/")
//public class EmployerJobController extends AbstractController<Employer, Job> {
//
//	@Autowired
//	private EmployerJobListMineService	listService;
//
//	@Autowired
//	private EmployerJobShowService		showService;
//
//
//	@PostConstruct
//	private void initialise() {
//		super.addCustomCommand(CustomCommand.LIST_MINE, BasicCommand.LIST, this.listService);
//		super.addBasicCommand(BasicCommand.SHOW, this.showService);
//	}
//
//}
