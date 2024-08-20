package oracle.java.emsapp.entities;

public class Hr extends Employee {

	private double gratuityPayment;

	public Hr() {

	}

	public Hr(String name, int id, double basicPayment, double daPayment, double hraPayment, double gratuityPayment) {
		super(name, id, basicPayment, daPayment, hraPayment);
		this.gratuityPayment = gratuityPayment;
	}

	public double getGratuityPayment() {
		return gratuityPayment;
	}

	public void setGratuityPayment(double gratuityPayment) {
		this.gratuityPayment = gratuityPayment;
	}

	@Override
	public void calculateSalary() {
		super.calculateSalary();
		this.setTotalPayment(gratuityPayment + this.getTotalPayment());
	}
}
