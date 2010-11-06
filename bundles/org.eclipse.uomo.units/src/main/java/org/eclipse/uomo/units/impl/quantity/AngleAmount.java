/**
 * Copyright (c) 2005, 2010, Werner Keil, Ikayzo and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Werner Keil, Ikayzo and others - initial API and implementation
 */
package org.eclipse.uomo.units.impl.quantity;

import org.eclipse.uomo.units.impl.BaseAmount;
import org.unitsofmeasurement.quantity.Angle;
import org.unitsofmeasurement.unit.Unit;


/**
 * Represents the figure formed by two lines diverging from a common point.
 * The metric system unit for this quantity is "rad" (radian).
 *
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author  <a href="mailto:jcp@catmedia.us">Werner Keil</a>
 * @version 1.2, $Date: 2010-09-13 23:50:44 +0200 (Mo, 13 Sep 2010) $
 */
public class AngleAmount extends BaseAmount<Angle> {
	
	public AngleAmount(Number number, Unit<Angle> unit) {
		super(number, unit);
	}
}
