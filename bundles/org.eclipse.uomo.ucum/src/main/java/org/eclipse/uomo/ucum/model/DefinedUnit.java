/*******************************************************************************
 * Crown Copyright (c) 2006, 2013, Copyright (c) 2006, 2008 Kestral Computing P/L.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Kestral Computing P/L - initial implementation
 *    Werner Keil - Refactoring and improvements
 *******************************************************************************/

package org.eclipse.uomo.ucum.model;

import java.util.Map;

import org.eclipse.uomo.units.impl.DimensionImpl;
import org.unitsofmeasurement.unit.Dimension;
import org.unitsofmeasurement.unit.IncommensurableException;
import org.unitsofmeasurement.unit.UnconvertibleException;
import org.unitsofmeasurement.unit.Unit;
import org.unitsofmeasurement.unit.UnitConverter;

/**
 * @author Werner Keil
 * @version 1.1
 */
public class DefinedUnit extends UcumUnit {

	/**
	 * whether this is a metric unit or not
	 */
	private boolean metric;

	/**
	 * special means?
	 */
	private boolean isSpecial;

	/**
	 * The class of this unit
	 */
	private String class_;

	/**
	 * Value details
	 */
	private Value<?> value;

	/**
	 * @param code
	 * @param codeUC
	 */
	public DefinedUnit(String code, String codeUC) {
		super(ConceptKind.UNIT, code, codeUC);
	}

	/**
	 * @return the metric
	 */
	public boolean isMetric() {
		return metric;
	}

	/**
	 * @param metric
	 *            the metric to set
	 */
	public void setMetric(boolean metric) {
		this.metric = metric;
	}

	/**
	 * @return the isSpecial
	 */
	public boolean isSpecial() {
		return isSpecial;
	}

	/**
	 * @param isSpecial
	 *            the isSpecial to set
	 */
	public void setSpecial(boolean isSpecial) {
		this.isSpecial = isSpecial;
	}

	/**
	 * @return the class_
	 */
	public String getClass_() {
		return class_;
	}

	/**
	 * @param class_
	 *            the class_ to set
	 */
	public void setClass_(String class_) {
		this.class_ = class_;
	}

	/**
	 * @return the value
	 */
	public Value<?> getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(Value<?> value) {
		this.value = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ohf.ucum.model.BaseUnit#getDescription()
	 */
	@Override
	public String getDescription() {
		return super.getDescription() + " = " + value.getDescription();
	}

	@Override
	public Unit add(double arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Unit alternate(String arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Unit asType(Class arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Unit divide(Unit arg0) {
		throw new UnsupportedOperationException();
	}

	@Override
	public UnitConverter getConverterTo(Unit arg0)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(Unit arg0)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dimension getDimension() {
		return DimensionImpl.NONE;
	}

	@Override
	public Map getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit getSystemUnit() {
		return (metric ? this : null);
	}

	@Override
	public Unit inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(double arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit multiply(Unit arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit transform(UnitConverter arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
