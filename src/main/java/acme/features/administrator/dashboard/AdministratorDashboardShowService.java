
package acme.features.administrator.dashboard;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.dashboard.Dashboard;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, Dashboard> {

	@Autowired
	private AdministratorDashboardRepository repository;


	@Override
	public boolean authorise(final Request<Dashboard> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Dashboard> request, final Dashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "countAnnouncement", "countCompanyRecords", "countInvestorRecords");
		request.unbind(entity, model, "minActiveRequest", "maxActiveRequest", "avgActiveRequest", "stDerivationActiveRequest");
		request.unbind(entity, model, "minRangeMinActiveOffer", "maxRangeMinActiveOffer", "avgRangeMinActiveOffer", "stDerivationRangeMinActiveOffer");
		request.unbind(entity, model, "minRangeMaxActiveOffer", "maxRangeMaxActiveOffer", "avgRangeMaxActiveOffer", "stDerivationRangeMaxActiveOffer");
		request.unbind(entity, model, "numSectorbyCompany", "sectorsbyCompany", "numSectorbyInvestor", "sectorsbyInvestor");
		request.unbind(entity, model, "avgJobPerEmployer", "avgApplicationPerEmployer", "avgApplicationPerWorker");
		request.unbind(entity, model, "ratioJobsGroupedStatusPublished", "ratioJobsGroupedStatusDraft", "ratioApplicationsGroupedStatusPending");
		request.unbind(entity, model, "ratioApplicationsGroupedStatusAccepted", "ratioApplicationsGroupedStatusRejected");
		request.unbind(entity, model, "numberApplicationsStatusPendingByDay", "numberApplicationsStatusAcceptedByDay", "numberApplicationsStatusRejectedByDay");
		request.unbind(entity, model, "daysApplicationsStatusPendingByDay", "daysApplicationsStatusAcceptedByDay", "daysApplicationsStatusRejectedByDay");
		//TODO: Cambiar
		request.unbind(entity, model, "ratioJobWithWotela", "ratioWotelaWithTicker", "ratioAplicationsWithTickerAndPass");

	}

	@Override
	public Dashboard findOne(final Request<Dashboard> request) {
		assert request != null;

		Dashboard result = new Dashboard();

		//TODO: Cambiar

		result.setRatioJobWithWotela(this.repository.ratioJobWithWotela());
		result.setRatioWotelaWithTicker(this.repository.ratioWotelaWithTicker());
		result.setRatioAplicationsWithTickerAndPass(this.repository.ratioAplicationsWithTicker());

		result.setCountAnnouncement(this.repository.countAnnouncement());
		result.setCountCompanyRecords(this.repository.countCompanyRecord());
		result.setCountInvestorRecords(this.repository.countInvestorRecords());

		result.setMinActiveRequest(this.repository.queryActiveRequest(new Date())[0][0]);
		result.setMaxActiveRequest(this.repository.queryActiveRequest(new Date())[0][1]);
		result.setAvgActiveRequest(this.repository.queryActiveRequest(new Date())[0][2]);
		result.setStDerivationActiveRequest(this.repository.queryActiveRequest(new Date())[0][3]);

		result.setMinRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][0]);
		result.setMaxRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][1]);
		result.setAvgRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][2]);
		result.setStDerivationRangeMinActiveOffer(this.repository.queryRangeMinActiveOffer(new Date())[0][3]);

		result.setMinRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][0]);
		result.setMaxRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][1]);
		result.setAvgRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][2]);
		result.setStDerivationRangeMaxActiveOffer(this.repository.queryRangeMaxActiveOffer(new Date())[0][3]);

		result.setAvgJobPerEmployer(this.repository.queryAVGJobPerEmployer());
		result.setAvgApplicationPerEmployer(this.repository.queryAVGApplicationPerEmployer());
		result.setAvgApplicationPerWorker(this.repository.queryAVGApplicationPerWorker());

		Object[] sectorescompany = this.repository.sectorspercompany();

		List<Integer> nc = new ArrayList<Integer>();
		List<String> sc = new ArrayList<String>();

		int ic = 0;
		while (ic < sectorescompany.length) {
			Object[] x = (Object[]) sectorescompany[ic];
			nc.add(Integer.parseInt(x[1].toString()));
			sc.add(x[0].toString());
			ic++;
		}

		result.setNumSectorbyCompany(nc);
		result.setSectorsbyCompany(sc);

		Object[] sectoresinvestor = this.repository.sectorsperinvestor();

		List<Integer> ni = new ArrayList<Integer>();
		List<String> si = new ArrayList<String>();

		int ii = 0;
		while (ii < sectoresinvestor.length) {
			Object[] x = (Object[]) sectoresinvestor[ii];
			ni.add(Integer.parseInt(x[1].toString()));
			si.add(x[0].toString());
			ii++;
		}

		result.setNumSectorbyInvestor(ni);
		result.setSectorsbyInvestor(si);

		result.setRatioJobsGroupedStatusPublished(this.repository.ratioJobsGroupedStatusPublished());
		result.setRatioJobsGroupedStatusDraft(this.repository.ratioJobsGroupedStatusDraft());

		result.setRatioApplicationsGroupedStatusPending(this.repository.ratioApplicationsGroupedStatusPending());
		result.setRatioApplicationsGroupedStatusAccepted(this.repository.ratioApplicationsGroupedStatusAccepted());
		result.setRatioApplicationsGroupedStatusRejected(this.repository.ratioApplicationsGroupedStatusRejected());

		Date to = new Date();

		Calendar c = Calendar.getInstance();
		c.setTime(to);
		c.add(Calendar.WEEK_OF_MONTH, -4);

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date from = c.getTime();

		Object[] numberApplicationsStatusAcceptedByDay = this.repository.numberApplicationsStatusAcceptedByDay(from, to);

		List<Integer> naa = new ArrayList<Integer>();
		List<String> daa = new ArrayList<String>();

		do {
			int j = 0;
			while (j < numberApplicationsStatusAcceptedByDay.length) {
				Object[] x = (Object[]) numberApplicationsStatusAcceptedByDay[j];

				Date d1 = c.getTime();
				Date d2 = new Date(((Date) x[0]).getTime());
				if (formatter.format(d1).equals(formatter.format(d2))) {
					naa.add(Integer.parseInt(x[1].toString()));
					daa.add(formatter.format(d1));
				} else {
					naa.add(0);
					daa.add(formatter.format(d1));
				}
				j++;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
		} while (!c.after(calendar));

		result.setNumberApplicationsStatusAcceptedByDay(naa);
		result.setDaysApplicationsStatusAcceptedByDay(daa);

		Object[] numberApplicationsStatusPendingByDay = this.repository.numberApplicationsStatusPendingByDay(from, to);

		List<Integer> nap = new ArrayList<Integer>();
		List<String> dap = new ArrayList<String>();

		c = Calendar.getInstance();
		c.setTime(to);
		c.add(Calendar.WEEK_OF_MONTH, -4);

		do {
			int k = 0;
			while (k < numberApplicationsStatusPendingByDay.length) {
				Object[] x = (Object[]) numberApplicationsStatusPendingByDay[k];

				Date d1 = c.getTime();
				Date d2 = new Date(((Date) x[0]).getTime());
				if (formatter.format(d1).equals(formatter.format(d2))) {
					nap.add(Integer.parseInt(x[1].toString()));
					dap.add(formatter.format(d1));
				} else {
					nap.add(0);
					dap.add(formatter.format(d1));
				}
				k++;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
		} while (!c.after(calendar));

		result.setNumberApplicationsStatusPendingByDay(nap);
		result.setDaysApplicationsStatusPendingByDay(dap);

		Object[] numberApplicationsStatusRejectedByDay = this.repository.numberApplicationsStatusRejectedByDay(from, to);

		List<Integer> nar = new ArrayList<Integer>();
		List<String> dar = new ArrayList<String>();

		c = Calendar.getInstance();
		c.setTime(to);
		c.add(Calendar.WEEK_OF_MONTH, -4);

		do {
			int z = 0;
			while (z < numberApplicationsStatusRejectedByDay.length) {
				Object[] x = (Object[]) numberApplicationsStatusRejectedByDay[z];

				Date d1 = c.getTime();
				Date d2 = new Date(((Date) x[0]).getTime());
				if (formatter.format(d1).equals(formatter.format(d2))) {
					nar.add(Integer.parseInt(x[1].toString()));
					dar.add(formatter.format(d1));
				} else {
					nar.add(0);
					dar.add(formatter.format(d1));
				}
				z++;
			}
			c.add(Calendar.DAY_OF_YEAR, 1);
		} while (!c.after(calendar));

		result.setNumberApplicationsStatusRejectedByDay(nar);
		result.setDaysApplicationsStatusRejectedByDay(dar);

		return result;
	}
}
