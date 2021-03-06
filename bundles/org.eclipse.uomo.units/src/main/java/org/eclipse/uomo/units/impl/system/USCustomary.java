/**
 * Copyright (c) 2005, 2011, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil, Ikayzo and others - initial API and implementation
 */
package org.eclipse.uomo.units.impl.system;

import static org.eclipse.uomo.units.SI.*;
import static org.eclipse.uomo.units.SI.Prefix.MICRO;

import org.eclipse.uomo.units.AbstractSystemOfUnits;
import org.eclipse.uomo.units.AbstractUnit;
import org.eclipse.uomo.units.Messages;
import org.eclipse.uomo.units.SI;
import org.eclipse.uomo.units.impl.ProductUnit;
import org.unitsofmeasurement.quantity.Angle;
import org.unitsofmeasurement.quantity.Area;
import org.unitsofmeasurement.quantity.Information;
import org.unitsofmeasurement.quantity.Energy;
import org.unitsofmeasurement.quantity.Length;
import org.unitsofmeasurement.quantity.Mass;
import org.unitsofmeasurement.quantity.Power;
import org.unitsofmeasurement.quantity.Temperature;
import org.unitsofmeasurement.quantity.Time;
import org.unitsofmeasurement.quantity.Velocity;
import org.unitsofmeasurement.quantity.Volume;
import org.unitsofmeasurement.unit.SystemOfUnits;
import org.unitsofmeasurement.unit.Unit;

/**
 * <p>
 * This class contains units from the United States customary system.
 * </p>
 * <p>
 * 
 * @noextend This class is not intended to be extended by clients.
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:uomo@catmedia.us">Werner Keil</a>
 * @version 1.15 ($Revision: 332 $), $Date: 2011-09-11 14:52:11 +0200 $
 * @see <a
 *      href="http://en.wikipedia.org/wiki/United_States_customary_units">Wikipedia:
 *      United State Customary Units</a>
 */
public final class USCustomary extends AbstractSystemOfUnits {

	/**
	 * Default constructor (prevents this class from being instantiated).
	 */
	private USCustomary() {
	}

	/**
	 * Returns the unique instance of this class.
	 * 
	 * @return the USCustomary instance.
	 */
	public static SystemOfUnits getInstance() {
		return INSTANCE;
	}

	private static final USCustomary INSTANCE = new USCustomary();

	// //////////
	// Length //
	// //////////
	/**
	 * US name for {@link SI#METRE}.
	 */
	public static final Unit<Length> METER = METRE;

	/**
	 * A unit of length equal to <code>0.3048 m</code> (standard name
	 * <code>ft</code>).
	 */
	public static final Unit<Length> FOOT = addUnit(METER.multiply(3048)
			.divide(10000));

	/**
	 * A unit of length equal to <code>1200/3937 m</code> (standard name
	 * <code>foot_survey_us</code>). See also: <a
	 * href="http://www.sizes.com/units/foot.htm">foot</a>
	 */
	public static final Unit<Length> FOOT_SURVEY = addUnit(METER.multiply(1200)
			.divide(3937));

	/**
	 * A unit of length equal to <code>0.9144 m</code> (standard name
	 * <code>yd</code>).
	 */
	public static final Unit<Length> YARD = addUnit(FOOT.multiply(3));

	/**
	 * A unit of length equal to <code>0.0254 m</code> (standard name
	 * <code>in</code>).
	 */
	public static final Unit<Length> INCH = addUnit(FOOT.divide(12));

	/**
	 * A unit of length equal to <code>1609.344 m</code> (standard name
	 * <code>mi</code>).
	 */
	public static final Unit<Length> MILE = addUnit(METER.multiply(1609344)
			.divide(1000));

	/**
	 * A unit of length equal to the distance that light travels in one year
	 * through a vacuum (standard name <code>ly</code>).
	 */
	public static final Unit<Length> LIGHT_YEAR = addUnit(METRE
			.multiply(9.460528405e15));
	
	/**
	 * A unit of length equal to <code>1852.0 m</code> (standard name
	 * <code>nmi</code>).
	 */
	public static final Unit<Length> NAUTICAL_MILE = addUnit(METER
			.multiply(1852));

	// ////////
	// Mass //
	// ////////

	/**
	 * A unit of mass equal to <code>453.59237 grams</code> (avoirdupois pound,
	 * standard name <code>lb</code>).
	 */
	public static final Unit<Mass> POUND = addUnit(KILOGRAM.multiply(45359237)
			.divide(100000000), Messages.US_lb_name);

	/**
	 * A unit of mass equal to <code>1 / 16 {@link #POUND}</code> (standard name
	 * <code>oz</code>).
	 */
	public static final Unit<Mass> OUNCE = addUnit(POUND.divide(16));

	/**
	 * A unit of mass equal to <code>2000 {@link #POUND}</code> (short ton,
	 * standard name <code>ton</code>).
	 */
	public static final Unit<Mass> TON = addUnit(POUND.multiply(2000));

	// ///////////////
	// Temperature //
	// ///////////////

	/**
	 * A unit of temperature equal to <code>5/9 °K</code> (standard name
	 * <code>°R</code>).
	 */
	public static final Unit<Temperature> RANKINE = addUnit(KELVIN.multiply(5)
			.divide(9));

	/**
	 * A unit of temperature equal to degree Rankine minus
	 * <code>459.67 °R</code> (standard name <code>°F</code>).
	 * 
	 * @see #RANKINE
	 */
	public static final Unit<Temperature> FAHRENHEIT = addUnit(RANKINE
			.add(459.67));

	// /////////
	// Angle //
	// /////////

	/**
	 * A unit of angle equal to a full circle or <code>2<i>&pi;</i>
	 * {@link SI#RADIAN}</code> (standard name <code>rev</code>).
	 */
	public static final Unit<Angle> REVOLUTION = addUnit(RADIAN.multiply(2)
			.multiply(Math.PI).asType(Angle.class));

	/**
	 * A unit of angle equal to <code>1/360 {@link #REVOLUTION}</code> (standard
	 * name <code>deg</code>).
	 */
	public static final Unit<Angle> DEGREE_ANGLE = addUnit(REVOLUTION
			.divide(360));

	/**
	 * A unit of angle equal to <code>1/60 {@link #DEGREE_ANGLE}</code>
	 * (standard name <code>'</code>).
	 */
	public static final Unit<Angle> MINUTE_ANGLE = addUnit(DEGREE_ANGLE
			.divide(60));

	/**
	 * A unit of angle equal to <code>1/60 {@link #MINUTE_ANGLE}</code>
	 * (standard name <code>"</code>).
	 */
	public static final Unit<Angle> SECOND_ANGLE = addUnit(MINUTE_ANGLE
			.divide(60));

	/**
	 * A unit of angle equal to <code>0.01 {@link SI#RADIAN}</code> (standard
	 * name <code>centiradian</code>).
	 */
	public static final Unit<Angle> CENTIRADIAN = addUnit(RADIAN.divide(100));

	/**
	 * A unit of angle measure equal to <code>1/400 {@link #REVOLUTION}</code>
	 * (standard name <code>grade</code> ).
	 */
	public static final Unit<Angle> GRADE = addUnit(REVOLUTION.divide(400));
	
	// ////////////
	// TimeUnit //
	// ////////////
	/**
	 * A unit of time equal to <code>60 s</code> (standard name <code>min</code>
	 * ).
	 */
	public static final Unit<Time> MINUTE = addUnit(SECOND.multiply(60));

	/**
	 * A unit of duration equal to <code>60 {@link #MINUTE}</code> (standard
	 * name <code>h</code>).
	 */
	public static final Unit<Time> HOUR = addUnit(MINUTE.multiply(60));

	// ////////////
	// Velocity //
	// ////////////
	/**
	 * A unit of velocity expressing the number of {@link #FOOT feet} per
	 * {@link SI#SECOND second}.
	 */
	public static final Unit<Velocity> FEET_PER_SECOND = addUnit(
			FOOT.divide(SECOND)).asType(Velocity.class);

	/**
	 * A unit of velocity expressing the number of international {@link #MILE
	 * miles} per {@link #HOUR hour} (abbreviation <code>mph</code>).
	 */
	public static final Unit<Velocity> MILES_PER_HOUR = addUnit(
			MILE.divide(HOUR)).asType(Velocity.class);

	/**
	 * A unit of velocity expressing the number of {@link #NAUTICAL_MILE
	 * nautical miles} per {@link #HOUR hour} (abbreviation <code>kn</code>).
	 */
	public static final Unit<Velocity> KNOT = addUnit(
			NAUTICAL_MILE.divide(HOUR)).asType(Velocity.class);

	// ////////
	// Area //
	// ////////

	/**
	 * A unit of area (standard name <code>sft</code>
	 * ).
	 */
	public static final Unit<Area> SQUARE_FOOT = addUnit(new ProductUnit<Area>(
			(AbstractUnit<?>) FOOT.multiply(FOOT)));

	/**
	 * A unit of area equal to <code>100 m²</code> (standard name <code>a</code>
	 * ).
	 */
	public static final Unit<Area> ARE = addUnit(SQUARE_METRE.multiply(100));
	
	/**
	 * A unit of area equal to <code>100 {@link #ARE}</code> (standard name
	 * <code>ha</code>).
	 */
	static final Unit<Area> HECTARE = addUnit(ARE.multiply(100)); // Exact.
	
	// ///////////////
	// Data Amount //
	// ///////////////
	/**
	 * A unit of data amount equal to <code>8 {@link SI#BIT}</code> (BinarY
	 * TErm, standard name <code>byte</code>).
	 */
	public static final Unit<Information> BYTE = addUnit(BIT.multiply(8));

	/**
	 * Equivalent {@link #BYTE}
	 */
	public static final Unit<Information> OCTET = BYTE;

	// //////////
	// Energy //
	// //////////

	/**
	 * A unit of energy equal to one electron-volt (standard name
	 * <code>eV</code>, also recognized <code>keV, MeV, GeV</code>).
	 */
	public static final Unit<Energy> ELECTRON_VOLT = addUnit(JOULE
			.multiply(1.602176462e-19));
	
	// //////////
	// Power   //
	// //////////
	
	/**
	 * Horsepower (HP) is the name of several units of measurement of power.
	 * The most common definitions equal between 735.5 and 750 watts.
	 * Horsepower was originally defined to compare the output of steam engines with the power of draft horses. 
	 * The unit was widely adopted to measure the output of piston engines, turbines, electric motors, and other machinery. The definition of the unit varied between geographical regions. Most countries now use the SI unit watt for measurement of power. With the implementation of the EU Directive 80/181/EEC on January 1, 2010, the use of horsepower in the EU is only permitted as supplementary unit.
	 */
	public static final Unit<Power> HORSEPOWER = addUnit(WATT.multiply(735.499));

	// //////////
	// Volume //
	// //////////
	/**
	 * A unit of volume equal to one cubic decimeter (default label
	 * <code>L</code>, also recognized <code>µL, mL, cL, dL</code>).
	 */
	public static final Unit<Volume> LITER = addUnit(CUBIC_METRE.divide(1000));

	/**
	 * A unit of volume equal to one cubic inch (<code>in³</code>).
	 */
	public static final Unit<Volume> CUBIC_INCH = addUnit(INCH.pow(3).asType(
			Volume.class));

	/**
	 * A unit of volume equal to one US dry gallon. (standard name
	 * <code>gallon_dry_us</code>).
	 */
	public static final Unit<Volume> GALLON_DRY = addUnit(CUBIC_INCH.multiply(
			2688025).divide(10000));

	/**
	 * A unit of volume equal to one US gallon, Liquid Unit. The U.S. liquid
	 * gallon is based on the Queen Anne or Wine gallon occupying 231 cubic
	 * inches (standard name <code>gal</code>).
	 */
	public static final Unit<Volume> GALLON_LIQUID = addUnit(CUBIC_INCH
			.multiply(231));

	/**
	 * A unit of volume equal to <code>1 / 128 {@link #GALLON_LIQUID}</code>
	 * (standard name <code>oz_fl</code>).
	 */
	public static final Unit<Volume> OUNCE_LIQUID = addUnit(GALLON_LIQUID
			.divide(128));

	/**
	 * A unit of volume <code>~ 1 drop or 0.95 grain of water </code> (standard
	 * name <code>min</code>).
	 */
	public static final Unit<Volume> MINIM = addUnit(MICRO(LITER).multiply(
			61.61152d));

	/**
	 * A unit of volume equal to <code>60 {@link #MINIM}</code> (standard name
	 * <code>fl dr</code>).
	 */
	public static final Unit<Volume> FLUID_DRAM = addUnit(MINIM.multiply(60));

	/**
	 * A unit of volume equal to <code>80 {@link #MINIM}</code> (standard name
	 * <code>tsp</code>).
	 */
	public static final Unit<Volume> TEASPOON = addUnit(MINIM.multiply(80));

	/**
	 * A unit of volume equal to <code>3 {@link #TEASPOON}</code> (standard name
	 * <code>Tbsp</code>).
	 */
	public static final Unit<Volume> TABLESPOON = addUnit(TEASPOON.multiply(3));

	/**
	 * A unit of volume equal to <code>238.4810 {@link #LITER}</code> (standard
	 * name <code>bbl</code>).
	 */
	public static final Unit<Volume> OIL_BARREL = addUnit(LITER
			.multiply(238.4810d));

	/**
	 * Holds the international foot: 0.3048 m exact.
	 */
	// private static final int INTERNATIONAL_FOOT_DIVIDEND = 3048;

	// private static final int INTERNATIONAL_FOOT_DIViSOR = 10000;



	@Override
	public String getName() {
		return getClass().getSimpleName();
	}
}
