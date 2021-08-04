package Session18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car {

	int speed;
	int price;
	String company;
	int mileage;

	public Car(int speed, int price, String company, int mileage) {
		this.speed = speed;
		this.price = price;
		this.company = company;
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.speed + " " + this.price + " " + this.company + " " + this.mileage;
	}

	public static void main(String[] args) {
		Car c1 = new Car(120, 20000, "Maruti", 20);
		Car c2 = new Car(300, 200000000, "Audi", 5);
		Car c3 = new Car(200, 5000000, "Merc", 8);
		Car c4 = new Car(90, 5000, "Nano", 24);

		List<Car> carList = new ArrayList<>();
		carList.add(c1);
		carList.add(c2);
		carList.add(c3);
		carList.add(c4);

		System.out.println(carList);

		// on the basis of speed
		Collections.sort(carList, new Comparator<Car>() {

			@Override
			public int compare(Car curr, Car next) {
				// TODO Auto-generated method stub
				return curr.speed - next.speed; // >0 to swap, == 0, < 0 -> no swap
			}
		});

		System.out.println(carList);

		// on the basis of mileage
		Collections.sort(carList, new Comparator<Car>() {

			@Override
			public int compare(Car curr, Car next) {
				// TODO Auto-generated method stub
				return curr.mileage - next.mileage; // >0 to swap, == 0, < 0 -> no swap
			}
		});
		
		System.out.println(carList);
	}
}
