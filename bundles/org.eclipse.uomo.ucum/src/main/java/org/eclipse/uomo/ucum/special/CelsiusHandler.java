/*******************************************************************************
 * Crown Copyright (c) 2006, 2011, Copyright (c) 2006, 2008 Kestral Computing P/L.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Kestral Computing P/L - initial implementation
 *    Werner Keil - adjusted to Unit-API
 *******************************************************************************/

package org.eclipse.uomo.ucum.special;

import java.math.BigDecimal;

import org.eclipse.uomo.units.SI;
import org.unitsofmeasurement.quantity.Temperature;
import org.unitsofmeasurement.unit.Unit;

public class CelsiusHandler extends SpecialUnitHandler<Temperature> {

	@Override
	public String getCode() {
		return "Cel";
	}

	@Override
	public String getUnits() {
		return "K";
	}

	/* (non-Javadoc)
	 * @see org.unitsofmeasurement.quantity.Quantity#unit()
	 */
	@Override
	public Unit<Temperature> unit() {
		return SI.KELVIN;
	}
	
	/* (non-Javadoc)
	 * @see org.unitsofmeasurement.quantity.Quantity#value()
	 */
	@Override
	public BigDecimal value() {
		return new BigDecimal(1);
	}
}
