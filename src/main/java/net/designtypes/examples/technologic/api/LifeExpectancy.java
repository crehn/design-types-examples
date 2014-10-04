package net.designtypes.examples.technologic.api;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@XmlRootElement
@AllArgsConstructor
public class LifeExpectancy {
	private double residualLifeExpectancy;
}
