package oracle.java.emsapp.entities;

public class Developer extends Employee {

	private double incentivePayment;

	public Developer() {

	}

	public Developer(String name, int id, double basicPayment, double daPayment, double hraPayment,
			double incentivePayment) {
		super(name, id, basicPayment, daPayment, hraPayment);
		this.incentivePayment = incentivePayment;
	}

	public double getIncentivePayment() {
		return incentivePayment;
	}

	public void setIncentivePayment(double incentivePayment) {
		this.incentivePayment = incentivePayment;
	}

	@Override
	public void calculateSalary() {
		super.calculateSalary();
		this.setTotalPayment(this.getTotalPayment() + this.incentivePayment);
	}
}
