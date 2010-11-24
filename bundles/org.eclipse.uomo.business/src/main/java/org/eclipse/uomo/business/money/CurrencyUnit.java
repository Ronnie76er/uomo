/**
 * Copyright (c) 2005, 2010, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil - initial API and implementation
 */
package org.eclipse.uomo.business.money;

import java.math.BigInteger;
import java.util.Map;

import org.eclipse.uomo.units.AbstractConverter;
import org.eclipse.uomo.units.AbstractUnit;
import org.eclipse.uomo.units.impl.AddConverter;
import org.eclipse.uomo.units.impl.AlternateUnit;
import org.eclipse.uomo.units.impl.MultiplyConverter;
import org.eclipse.uomo.units.impl.ProductUnit;
import org.eclipse.uomo.units.impl.RationalConverter;
import org.eclipse.uomo.units.impl.TransformedUnit;
import org.eclipse.uomo.core.IName;
import org.unitsofmeasurement.quantity.Quantity;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

import com.ibm.icu.util.Currency;
import com.ibm.icu.util.ULocale;


/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.2.2, $Date: 2010-09-13 23:54:08 +0200 (Mo, 13 Sep 2010) $
 * @param <Q>
 */
public class CurrencyUnit<Q extends Money> extends Currency implements
		Unit<Money>, IName {

	/**
     * 
     */
	private static final long serialVersionUID = 8524573975644908457L;

	protected CurrencyUnit(String theISOCode) {
		super(theISOCode);
	}

	/**
	 * The Australian Dollar currency unit.
	 */
	public static final CurrencyUnit<Money> AUD = new CurrencyUnit<Money>("AUD"); //$NON-NLS-1$

	/**
	 * The Canadian Dollar currency unit.
	 */
	public static final CurrencyUnit<Money> CAD = new CurrencyUnit<Money>("CAD"); //$NON-NLS-1$

	/**
	 * The China Yan currency.
	 */
	public static final CurrencyUnit<Money> CNY = new CurrencyUnit<Money>("CNY"); //$NON-NLS-1$

	/**
	 * The Euro currency.
	 */
	@SuppressWarnings("rawtypes")
	public static final CurrencyUnit EUR = new CurrencyUnit<Money>("EUR"); //$NON-NLS-1$

	/**
	 * The British Pound currency.
	 */
	public static final CurrencyUnit<Money> GBP = new CurrencyUnit<Money>("GBP"); //$NON-NLS-1$

	/**
	 * The Japanese Yen currency.
	 */
	public static final CurrencyUnit<Money> JPY = new CurrencyUnit<Money>("JPY"); //$NON-NLS-1$

	/**
	 * The Korean Republic Won currency.
	 */
	public static final CurrencyUnit<Money> KRW = new CurrencyUnit<Money>("KRW"); //$NON-NLS-1$

	/**
	 * The Taiwanese dollar currency.
	 */
	@SuppressWarnings("rawtypes")
	public static final CurrencyUnit TWD = new CurrencyUnit<Money>("TWD"); //$NON-NLS-1$

	/**
	 * Holds the dimensionless unit <code>ONE</code>.
	 */
	public static final ProductUnit<Money> ONE = new ProductUnit<Money>();

	/**
	 * The United State dollar currency.
	 */
	@SuppressWarnings("rawtypes")
	public static final CurrencyUnit USD = new CurrencyUnit<Money>("USD"); //$NON-NLS-1$

	/**
	 * Returns the result of adding an offset to this unit. The returned unit is
	 * convertible with all units that are convertible with this unit.
	 * 
	 * @param offset
	 *            the offset added (expressed in this unit, e.g.
	 *            <code>CELSIUS = KELVIN.add(273.15)</code>).
	 * @return <code>this.transform(new AddConverter(offset))</code>
	 */
	public final Unit<Money> add(double offset) {
		if (offset == 0)
			return this;
		return transform(new AddConverter(offset));
	}

	/**
	 * Returns a metric unit equivalent to this unscaled metric unit but used in
	 * expressions to distinguish between quantities of a different nature but
	 * of the same dimensions.
	 * 
	 * <p>
	 * Examples of alternate units:[code] Unit<Angle> RADIAN =
	 * ONE.alternate("rad"); Unit<Force> NEWTON =
	 * METRE.times(KILOGRAM).divide(SECOND.pow(2)).alternate("N");
	 * Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2)).alternate("Pa");
	 * [/code]
	 * </p>
	 * 
	 * @param <Q>
	 *            the type of the quantity measured by the new alternate unit.
	 * 
	 * @param symbol
	 *            the new symbol for the alternate unit.
	 * @return the alternate unit.
	 * @throws UnsupportedOperationException
	 *             if this unit is not an unscaled metric unit.
	 * @throws IllegalArgumentException
	 *             if the specified symbol is already associated to a different
	 *             unit.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Unit<Money> alternate(String symbol) {
		return new AlternateUnit(symbol, this);
	}

	public <T extends Quantity<T>> Unit<T> asType(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the result of dividing this unit by an approximate divisor.
	 * 
	 * @param divisor
	 *            the approximate divisor.
	 * @return <code>this.transform(new MultiplyConverter(1.0 / divisor))</code>
	 */
	public final Unit<Money> divide(double divisor) {
		if (divisor == 1)
			return this;
		return transform(new MultiplyConverter(1.0 / divisor));
	}

	/**
	 * Returns the result of dividing this unit by an exact divisor.
	 * 
	 * @param divisor
	 *            the exact divisor. (e.g.
	 *            <code>QUART = GALLON_LIQUID_US.divide(4)</code>).
	 * @return <code>this.transform(new RationalConverter(1 , divisor))</code>
	 */
	public final Unit<?> divide(long divisor) {
		if (divisor == 1)
			return this;
		return (Unit<?>) transform(new RationalConverter(BigInteger.ONE,
				BigInteger.valueOf(divisor)));
	}

	public UnitConverter getConverterTo(Unit<Money> that)
			throws UnconvertibleException {
		return new CurrencyConverter(this, that, 1);
	}

	public UnitConverter getConverterToAny(Unit<?> that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	public Dimension getDimension() {
		return Money.DIMENSION;
	}

	public Map<Unit<?>, Integer> getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	private boolean isRationalFactor() {
		// if (!(this instanceof TransformedUnit<?>))
		// return false;
		// TransformedUnit<Q> tu = (TransformedUnit<Q>) this;
		// return tu.getParentUnit().equals(ONE) &&
		// (tu.getConverterTo(tu.toMetric()) instanceof RationalConverter);
		return true;
	}

	/**
	 * Returns the inverse of this unit.
	 * 
	 * @return <code>1 / this</code>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Unit<?> inverse() {
		if (this.equals(ONE))
			return this;
		if (this.isRationalFactor())
			return this.transform(this.getConverterTo((Unit) ONE).inverse());
		return ProductUnit.getQuotientInstance(ONE, this);
	}

	public boolean isCompatible(Unit<?> that) {
		return (this == that)
				|| this.toMetric().equals(that.getSystemUnit())
				|| (!"".equals(this.getDimension().toString()) && this.getDimension().equals(that.getDimension())); //$NON-NLS-1$
	}

	/**
	 * Returns the result of multiplying this unit by an exact factor.
	 * 
	 * @param factor
	 *            the exact scale factor (e.g.
	 *            <code>KILOMETRE = METRE.multiply(1000)</code>).
	 * @return <code>this.transform(new RationalConverter(factor, 1))</code>
	 */
	final Unit<Money> multiply(long factor) {
		if (factor == 1)
			return this;
		return transform(new RationalConverter(BigInteger.valueOf(factor),
				BigInteger.ONE));
	}

	/**
	 * Returns the result of multiplying this unit by a an approximate factor.
	 * 
	 * @param factor
	 *            the approximate factor (e.g.
	 *            <code>ELECTRON_MASS = KILOGRAM.multiply(9.10938188e-31)</code>
	 *            ).
	 * @return <code>this.transform(new MultiplyConverter(factor))</code>
	 */
	public final Unit<Money> multiply(double factor) {
		if (factor == 1)
			return this;
		return transform(new MultiplyConverter(factor));
	}

	/**
	 * Returns the product of this unit with the one specified.
	 * 
	 * @param that
	 *            the unit multiplicand.
	 * @return <code>this * that</code>
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public final Unit<?> multiply(Unit<?> that) {
		if (this.equals(ONE))
			return that;
		if (that.equals(ONE))
			return this;
		if (this.isRationalFactor())
			return that.transform(this.getConverterTo(ONE));
		if (((CurrencyUnit<?>) that).isRationalFactor())
			return this.transform(that.getConverterTo((Unit) ONE));
		return ProductUnit.getProductInstance(this, (AbstractUnit<?>) that);
	}

	/**
	 * Returns a unit equals to this unit raised to an exponent.
	 * 
	 * @param n
	 *            the exponent.
	 * @return the result of raising this unit to the exponent.
	 */
	public final Unit<?> pow(int n) {
		if (n > 0)
			return this.multiply(this.pow(n - 1));
		else if (n == 0)
			return ONE;
		else
			// n < 0
			return ONE.divide(this.pow(-n));
	}

	/**
	 * Returns a unit equals to the given root of this unit.
	 * 
	 * @param n
	 *            the root's order.
	 * @return the result of taking the given root of this unit.
	 * @throws ArithmeticException
	 *             if <code>n == 0</code> or if this operation would result in
	 *             an unit with a fractional exponent.
	 */
	public final Unit<?> root(int n) {
		if (n > 0)
			return ProductUnit.getRootInstance(this, n);
		else if (n == 0)
			throw new ArithmeticException("Root's order of zero"); //$NON-NLS-1$
		else
			// n < 0
			return ONE.divide(this.root(-n));
	}

	protected Unit<Money> toMetric() {
		return this;
	}

	/**
	 * Returns the unit derived from this unit using the specified converter.
	 * The converter does not need to be linear. For example:[code]
	 * Unit<Dimensionless> DECIBEL = Unit.ONE.transform( new
	 * LogConverter(10).inverse().concatenate( new RationalConverter(1, 10)));
	 * [/code]
	 * 
	 * @param operation
	 *            the converter from the transformed unit to this unit.
	 * @return the unit after the specified transformation.
	 */
	@SuppressWarnings("unchecked")
	public final Unit<Money> transform(UnitConverter operation) {
		if (this instanceof Unit<?>) {
			Unit<Money> tf = this;
			Unit<?> parent = (Unit<?>) ((TransformedUnit<?>) tf)
					.getParentUnit();
			UnitConverter toParent = ((TransformedUnit<?>) tf).toParentUnit();
			if (toParent == null)
				return (Unit<Money>) parent;
			UnitConverter toParentConcat = toParent.concatenate(operation);
			if (toParentConcat == AbstractConverter.IDENTITY)
				return (Unit<Money>) parent;
			return new TransformedUnit<Money>((Unit<Money>) parent,
					(AbstractConverter) toParentConcat);
		}
		if (operation == AbstractConverter.IDENTITY)
			return this;
		return new TransformedUnit<Money>(this, (AbstractConverter) operation);
	}

	/**
	 * Returns the quotient of this unit with the one specified.
	 * 
	 * @param that
	 *            the unit divisor.
	 * @return <code>this / that</code>
	 */
	public final Unit<?> divide(Unit<?> that) {
		return (Unit<?>) this.multiply(that.inverse());
	}

	public String getName() {
		return getName(ULocale.getDefault(), LONG_NAME, new boolean[] { false });
	}

	public Unit<Money> getSystemUnit() {
		return toMetric();
	}

}
