/**
 * Copyright (c) 2005, 2010, Werner Keil, JScience and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil - initial API and implementation
 */
package org.eclipse.uomo.business.money;

// Constants (Java 5 static import)
import static org.eclipse.uomo.units.IndianPrefix.LAKH;
import static org.eclipse.uomo.units.impl.system.USCustomary.GALLON_LIQUID;
import static org.eclipse.uomo.units.impl.system.USCustomary.LITER;
import static org.eclipse.uomo.units.impl.system.USCustomary.MILE;
import static org.eclipse.uomo.units.SI.Prefix.KILO;
import static org.eclipse.uomo.units.SI.METRE;
import static org.eclipse.uomo.business.money.CurrencyUnit.EUR;
import static org.eclipse.uomo.business.money.CurrencyUnit.GBP;
import static org.eclipse.uomo.business.money.CurrencyUnit.USD;

import org.eclipse.uomo.business.money.CurrencyConverter;
import org.eclipse.uomo.business.types.IMoney;
import org.eclipse.uomo.units.IMeasure;
import org.eclipse.uomo.units.impl.BaseAmount;
import org.eclipse.uomo.units.impl.quantity.LengthAmount;
import org.unitsofmeasurement.quantity.Length;
import org.unitsofmeasurement.unit.Unit;

/**
 * @author Werner Keil
 * @version 0.9.6, $Date: 2010-09-11 23:59:41 +0200 (Sa, 11 Sep 2010) $
 */
public class MoneyDemo {

	/**
	 * @param args
	 *            The application arguments if required.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		// /////////////////////////////////////////////////////////////////////
		// Calculates the cost of a car trip in Europe for an American tourist.
		// /////////////////////////////////////////////////////////////////////

		@SuppressWarnings("unused")
		CurrencyConverter converter = new CurrencyConverter(USD, EUR, 1.4);

		// Calculates trip cost.
		BaseAmount carMileage = new BaseAmount(20,
				MILE.divide(GALLON_LIQUID)); // 20 mi/gal.
		IMeasure<?> gazPrice = new BaseAmount(1.2, EUR.divide(LITER));
		// // 1.2 EUR/L
		LengthAmount tripDistance = new LengthAmount(400, KILO(METRE)); // 400 km
//		IMeasure<Length> tripDistance2 = new LengthAmount(400, KILO(METRE));
//		LengthAmount tripDistance = new LengthAmount(4, (Unit<Length>) LAKH(METRE)); // 400 km 
		
		
		// km
		IMeasure<IMoney> tripCost = (IMeasure<IMoney>) tripDistance.divide(
				carMileage).multiply(gazPrice); // .to(USD);

		// Display trip.
		System.out.println(DemoMessages.MoneyDemo_Car_mileage + carMileage);
		System.out.println(DemoMessages.MoneyDemo_Trip_distance + tripDistance);

		// Display cost.
		System.out.print(DemoMessages.MoneyDemo_Gas_price);
		System.out.println(gazPrice); // FIXME format for CurrencyConverter
		// UFormat format = MeasureFormat.getCurrencyFormat();
		// System.out.println(format.format(gazPrice));
		// MoneyAmount mo = MoneyAmount.valueOf(100, EUR);
		// System.out.println(currFormat.format(mo));
		System.out.println(DemoMessages.MoneyDemo_Trip_cost + tripCost); // + " (" +

//		System.out.println(gazPrice.doubleValue(USD));
//		System.out.println(TestMessages.MoneyDemo_Trip_cost
//				+ ((BaseAmount) tripCost).to(USD)); //$NON-NLS-1$
		System.out.println(DemoMessages.MoneyDemo_Trip_cost + tripCost.to(EUR));
//		System.out.println(Messages.MoneyDemo_Trip_cost
//				+ ((BaseAmount) tripCost).to(EUR)); //$NON-NLS-1$
		// System.out.println("Trip cost = " + tripCost + " (" +
		// tripCost.to(GBP) + ")");
		// System.out.println("Trip cost = " + tripCost + " (" +
		// tripCost.to(INR) + ")");
	}
}
