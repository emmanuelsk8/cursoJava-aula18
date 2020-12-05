package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	private Date addMonths(Date date, int monthAmount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, monthAmount);
		return calendar.getTime();
	}
	
	public void processContract(Contract contract, int months) {
		double basicInstallment = contract.getTotalValue() / months;
		for(int i = 1; i <= months; i++) {
			double installmentInterest 	= basicInstallment + onlinePaymentService.interest(basicInstallment, i);
			double amount = installmentInterest + onlinePaymentService.paymentFee(installmentInterest);
			Date dueDate = addMonths(contract.getDate(), i);
			contract.installments.add(new Installment(dueDate, amount));
		}
	}
}
